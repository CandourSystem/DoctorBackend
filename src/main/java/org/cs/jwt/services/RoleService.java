package org.cs.jwt.services;



import org.cs.jwt.dto.RoleDTO;
import org.cs.jwt.model.Role;
import org.cs.jwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;

@Service
public class RoleService {
    
    @Autowired
    RoleRepository RoleRepository;
    ModelMapper modelMapper = null;
    public RoleService(){
        modelMapper = new ModelMapper();
    }
    
    
    public void save(final Role Role) {
        RoleRepository.save(Role);
    }
    public Page<Role> findAll(final Predicate predicate, final Pageable pageable) {
        return RoleRepository.findAll(predicate, pageable);
    }
    
    public RoleDTO findByRoleCode(final Integer Roleid) {
		Role role = RoleRepository.findByRoleCode(Roleid);
        RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
        return roleDTO;
	}
    public void delete(RoleDTO selectedObject) {
        selectedObject.setValidflag("Del");
        Role role = modelMapper.map(selectedObject, Role.class);
        RoleRepository.save(role);
    }

}
