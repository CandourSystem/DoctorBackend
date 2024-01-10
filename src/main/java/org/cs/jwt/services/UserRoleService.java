package org.cs.jwt.services;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.UserroleDTO;
import org.cs.jwt.model.Userrole;
import org.cs.jwt.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    

    ModelMapper modelMapper = null;

    public UserRoleService() {
        modelMapper = new ModelMapper();
    }

    public void save(final UserroleDTO userRoleDTO) {
        Userrole userrole = modelMapper.map(userRoleDTO, Userrole.class);
        //userrole.setId(userRoleDTO.getid());
        userRoleRepository.save(userrole);
    }

    public Page<Userrole> findAll(final Predicate predicate, final Pageable pageable) {
        return userRoleRepository.findAll(predicate, pageable);
    }

    public UserroleDTO findByUserroleCode(final Integer userid, final Integer roleid) {
        
        Userrole userrole= userRoleRepository.findByUserRoleId(userid, roleid);
        UserroleDTO    userroleDTO = null;
        if(userrole!=null){
         userroleDTO=modelMapper.map(userrole, UserroleDTO.class);
        }
        return userroleDTO;
    }

    public void delete(final Integer userid, final Integer roleid) {
        Userrole userrole = userRoleRepository.findByUserRoleId(userid, roleid);
        userrole.setValidflag("Del");
        userRoleRepository.save(userrole);
    }

    public Page<Userrole> findAllByUserId(Integer userid, Predicate predicate, Pageable pageable) {
        return userRoleRepository.findAllByUserid(userid,pageable);
    }

}
