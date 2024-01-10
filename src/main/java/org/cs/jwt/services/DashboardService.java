package org.cs.jwt.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.cs.jwt.dto.DetailsStatus;
import org.cs.jwt.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    TokenProvider tokenProvider;

    public List<Object[]> getOrganizationStationParameterValues(Integer organizationid, Integer stationid) {
        EntityManager newEntityManager = entityManager.getEntityManagerFactory().createEntityManager();

        newEntityManager.getTransaction().begin();
        final List<Object[]> returnModuleList = new ArrayList<>();
        try {
            final StoredProcedureQuery query = newEntityManager.createStoredProcedureQuery("fetchlast10parameterdata");
            query.registerStoredProcedureParameter(1, Void.class, ParameterMode.REF_CURSOR);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);

            query.setParameter(2, organizationid);
            query.setParameter(3, stationid);
            System.out.println("select fetchlast10parameterdata_debug("+ organizationid+","+stationid+")" );
            final List<?> results = query.getResultList();

            for (int i = 0; i < results.size(); i++) {
                Object[] record = (Object[]) results.get(i);
                returnModuleList.add(record);
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

    public List<String[]> getOrganizationStationParameterAverageValues(Integer organizationid, Integer stationid,
            String lastDayWeeklyMonthly) {
        EntityManager newEntityManager = entityManager.getEntityManagerFactory().createEntityManager();

        newEntityManager.getTransaction().begin();
        final List<String[]> returnModuleList = new ArrayList<>();
        try {
            final StoredProcedureQuery query = newEntityManager.createStoredProcedureQuery("fetchlastdataparameters");
            query.registerStoredProcedureParameter(1, Void.class, ParameterMode.REF_CURSOR);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

            query.setParameter(2, organizationid);
            query.setParameter(3, stationid);
            query.setParameter(4, lastDayWeeklyMonthly);
            System.out.println("select fetchlastdataparameters_debug("+ organizationid+","+stationid+"'"+lastDayWeeklyMonthly+"')" );
            final List<?> results = query.getResultList();

            for (int i = 0; i < results.size(); i++) {
                String[] record = (String[]) results.get(i);
                returnModuleList.add(record);
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

    public List<Object[]> getOrganizationStationParameterAverageValuesOverperiod(String lastDayWeeklyMonthly,
            Integer organizationid, Integer stationid) {
        EntityManager newEntityManager = entityManager.getEntityManagerFactory().createEntityManager();

        newEntityManager.getTransaction().begin();
        final List<Object[]> returnModuleList = new ArrayList<>();
        try {
            final StoredProcedureQuery query = newEntityManager
                    .createStoredProcedureQuery("fetchaverageofparameterdata");
            query.registerStoredProcedureParameter(1, Void.class, ParameterMode.REF_CURSOR);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

            query.setParameter(2, organizationid);
            query.setParameter(3, stationid);
            query.setParameter(4, lastDayWeeklyMonthly);
            System.out.println("select fetchaverageofparameterdata_debug("+ organizationid+"'',"+stationid+",'"+ lastDayWeeklyMonthly+"')" );
            final List<?> results = query.getResultList();

            for (int i = 0; i < results.size(); i++) {
                Object[] record = (Object[]) results.get(i);
                returnModuleList.add(record);
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

    public List<DetailsStatus> fetchindustrytypestatusdetails(String token) {
        EntityManager newEntityManager = entityManager.getEntityManagerFactory().createEntityManager();

        newEntityManager.getTransaction().begin();
        final List<DetailsStatus> returnModuleList = new ArrayList<>();
        try {
            final StoredProcedureQuery query = newEntityManager
                    .createStoredProcedureQuery("fetchindustrytypestatusdetails");
            query.registerStoredProcedureParameter(1, Void.class, ParameterMode.REF_CURSOR);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.setParameter(2, Integer.parseInt(tokenProvider.getUsername(token)));

            final List<?> results = query.getResultList();
            BigInteger total =new BigInteger("0");
            for (int i = 0; i < results.size(); i++) {
                Object[] record = (Object[]) results.get(i);

                DetailsStatus detailsStatus = new DetailsStatus();
                detailsStatus.setElementid(((String) record[0]));
                detailsStatus.setElementname((String) record[1]);
                BigInteger elementcount = (BigInteger) record[2];
                total=total.add(elementcount) ;
                detailsStatus.setElementcount(elementcount);
                returnModuleList.add(detailsStatus);
            }

            if (returnModuleList != null && returnModuleList.size() > 0) {
                for (int i = 0; i < returnModuleList.size(); i++){
                    Double pValue=Double.parseDouble(""+(returnModuleList.get(i).getElementcount().multiply(new BigInteger("100")).divide(total)));
                    returnModuleList.get(i).setPercentage(pValue);
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
    public List<DetailsStatus> fetchorganizationtypedetails(String token) {
        EntityManager newEntityManager = entityManager.getEntityManagerFactory().createEntityManager();

        newEntityManager.getTransaction().begin();
        final List<DetailsStatus> returnModuleList = new ArrayList<>();
        try {
            final StoredProcedureQuery query = newEntityManager
                    .createStoredProcedureQuery("fetchorganizationtypedetails");
            query.registerStoredProcedureParameter(1, Void.class, ParameterMode.REF_CURSOR);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.setParameter(2, Integer.parseInt(tokenProvider.getUsername(token)));

            final List<?> results = query.getResultList();
            BigInteger total =new BigInteger("0");
            for (int i = 0; i < results.size(); i++) {
                Object[] record = (Object[]) results.get(i);

                DetailsStatus detailsStatus = new DetailsStatus();
                detailsStatus.setElementid(""+((Integer) record[0]));
                detailsStatus.setElementname((String) record[1]);
                BigInteger elementcount = (BigInteger) record[2];
                total=total.add(elementcount) ;
                detailsStatus.setElementcount(elementcount);
                returnModuleList.add(detailsStatus);
            }

            if (returnModuleList != null && returnModuleList.size() > 0) {
                for (int i = 0; i < returnModuleList.size(); i++){
                    Double pValue=Double.parseDouble(""+(returnModuleList.get(i).getElementcount().multiply(new BigInteger("100")).divide(total)));
                    returnModuleList.get(i).setPercentage(pValue);
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

    public static float[] extractFloats(final String input){
        String[] parts = input.split(",");
        float[] numbers = new float[parts.length];
        for (int i = 0; i < parts.length; ++i) {
            float number = Float.parseFloat(parts[i]);
            float rounded = (int) Math.round(number * 1000) / 1000f;
            numbers[i] = rounded;
        }

        return numbers;
    }
   
}
