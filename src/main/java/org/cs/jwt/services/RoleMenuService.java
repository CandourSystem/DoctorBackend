package org.cs.jwt.services;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.RoleMenuDTO;
import org.cs.jwt.model.RoleMenuModel;
import org.cs.jwt.repository.RoleMenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuService {

    @Autowired
    RoleMenuRepository roleMenuRepository;
    ModelMapper modelMapper = null;

    public RoleMenuService() {
        modelMapper = new ModelMapper();
    }

    public void save(final RoleMenuDTO roleMenuDTO) {
        RoleMenuModel roleMenuModel = modelMapper.map(roleMenuDTO, RoleMenuModel.class);
        roleMenuRepository.save(roleMenuModel);
    }

    public Page<RoleMenuModel> findAll(final Predicate predicate, final Pageable pageable) {
        return roleMenuRepository.findAll(predicate, pageable);
    }

    public RoleMenuDTO findByRoleMenuCode(final Integer roleid, final Integer menuid) {
        RoleMenuModel roleMenu = roleMenuRepository.findByRoleMenuId(roleid, menuid);
        RoleMenuDTO roleMenuDTO = null;
        if (roleMenu != null) {
            roleMenuDTO = modelMapper.map(roleMenu, RoleMenuDTO.class);
        }
        return roleMenuDTO;
    }

    public void delete(final Integer roleid, final Integer menuid) {
        RoleMenuModel roleMenu = roleMenuRepository.findByRoleMenuId(roleid, menuid);
        roleMenu.setValidflag("Del");
        roleMenuRepository.save(roleMenu);
    }

    public Page<RoleMenuModel> findAllByRoleId(Integer roleid, Predicate predicate, Pageable pageable) {
        return roleMenuRepository.findAllByRoleId(roleid, pageable);
    }

}
