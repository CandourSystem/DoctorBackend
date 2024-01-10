package org.cs.jwt.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.cs.jwt.dto.MenuDTO;
import org.cs.jwt.dto.MenuModuleDTO;
import org.cs.jwt.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMenuService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    TokenProvider tokenProvider;

    public List<MenuModuleDTO> fetchUsermenus(final String token) {
        EntityManager newEntityManager = entityManager.getEntityManagerFactory().createEntityManager();

        newEntityManager.getTransaction().begin();
        final List<MenuModuleDTO> returnModuleList = new ArrayList<>();
        try {
            final StoredProcedureQuery query = newEntityManager.createStoredProcedureQuery("fetchusermenudetails");
            query.registerStoredProcedureParameter(1, Void.class, ParameterMode.REF_CURSOR);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);

            query.setParameter(2, Integer.parseInt(this.tokenProvider.getUsername(token)));

            final List<?> results = query.getResultList();
            final Map<Integer, MenuModuleDTO> mp = new LinkedHashMap<Integer, MenuModuleDTO>();
            for (int i = 0; i < results.size(); i++) {
                Object[] record = (Object[])results.get(i);
                // String moduleIcon=(rs.getString(7));
                Integer parentid = (Integer) record[2];

                MenuModuleDTO menuModule = null;
                // System.out.println(moduleName);
                if (parentid == 0) {
                    if (!mp.containsKey(parentid)) {
                        // System.out.println("New MenuModule Obj created::"+moduleName);
                        menuModule = new MenuModuleDTO();

                        // menuModule.setModuleIcon(moduleIcon);
                        menuModule.setModuleName((String) record[4]);
                        menuModule.setParentid((Integer) record[2]);
                        menuModule.setMenuname((String) record[4]);
                        menuModule.setMenuurl((String) record[5]);
                        menuModule.setMenuicon((String) record[6]);
                        menuModule.setIsleafnode(Integer.parseInt((String) record[7]));
                        menuModule.setRolename((String) record[8]);
                        menuModule.setChilds(new ArrayList<MenuDTO>());
                        menuModule.setChildsmap(new LinkedHashMap<String, MenuDTO>());

                        mp.put((Integer) record[3], menuModule);
                        returnModuleList.add(menuModule);
                    }
                } else {
                    menuModule = mp.get(parentid);
                    MenuDTO menuObj = new MenuDTO();
                    populateMenuObject(menuObj, record);
                    if (menuModule.getChilds() == null) {
                        menuModule.setChilds(new ArrayList<MenuDTO>());
                    }

                    menuModule.getChilds().add(menuObj);
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (entityManager != null) {
                newEntityManager.getTransaction().commit();
                newEntityManager.close();
            }

        }
        return returnModuleList;
    }

    private static void populateMenuObject(MenuDTO menuObj, Object[] rs) {
        menuObj.setLevel((Integer) rs[0]);
        menuObj.setPath((String) rs[1]);
        menuObj.setParentid((Integer) rs[2]);
        menuObj.setMenuid((Integer)rs[3]);
        menuObj.setMenuname((String) rs[4]);
        menuObj.setMenuurl((String) rs[5]);
        menuObj.setMenuicon((String) rs[6]);
        menuObj.setIsleafnode(Integer.parseInt((String) rs[7]));
        menuObj.setRolename((String) rs[8]);
    }

}
