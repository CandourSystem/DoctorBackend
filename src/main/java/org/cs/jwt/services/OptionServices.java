package org.cs.jwt.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cs.jwt.dto.OptionDTO;

import org.cs.jwt.repository.MakeModelRepository;
import org.cs.jwt.repository.MakeRepository;
import org.cs.jwt.repository.MenuRepository;

import org.cs.jwt.repository.RoleMenuRepository;
import org.cs.jwt.repository.RoleRepository;
import org.cs.jwt.repository.UnitRepository;
import org.cs.jwt.repository.UserDetailsRepository;
import org.cs.jwt.repository.UserOrganizationRepository;
import org.cs.jwt.repository.UserRoleRepository;
import org.cs.jwt.repository.UserTypeRepository;
import org.cs.jwt.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionServices {
  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  MenuRepository menuRepository;

  @Autowired
  RoleMenuRepository roleMenuRepository;

  @Autowired
  UserTypeRepository userTypeRepository;

  @Autowired
  UserRoleRepository userRoleRepository;


  @Autowired
  UserDetailsRepository userRepository;

  @Autowired
  MakeRepository makeRepository;



  @Autowired
  MakeModelRepository makeModelRepository;


  @Autowired
  UnitRepository unitRepository;


  @Autowired
  TokenProvider tokenProvider;

  @Autowired
  UserOrganizationRepository userOrganizationRepository;


  public OptionServices() {
    // empty constructor
  }

  public List<OptionDTO> getAllRoleOptions() {
    return roleRepository.getValidOptionList();
  }

  public List<OptionDTO> getAllMappedMenuByRoleOptions(Integer roleid) {
    return roleMenuRepository.getValidOptionListByRoleId(roleid);
  }

  public List<OptionDTO> getAllMenuOptions() {
    return menuRepository.getValidOptionList();
  }

  public List<OptionDTO> getAllParentMenuOptions() {
    return menuRepository.getParentValidOptionList();
  }

  public List<OptionDTO> getAllUserTypeOptions() {
    return userTypeRepository.getValidOptionList();
  }

  
  public List<OptionDTO> getAllUserOptions() {
    return userRepository.getValidOptionList();
  }

  public List<OptionDTO> getAllMakeOptions() {
    return makeRepository.getValidOptionList();
  }

  public List<OptionDTO> getAllMakeModelOptions(Integer makeid) {
    return makeModelRepository.getAllMakeModelOptions(makeid);
  }


  public List<OptionDTO> getAllUnitOptions() {
    return unitRepository.getValidOptionList();
  }

  
}