package org.cs.jwt.controller;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.MenuDTO;
import org.cs.jwt.dto.RoleDTO;
import org.cs.jwt.dto.RoleMenuDTO;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.model.RoleMenuModel;
import org.cs.jwt.services.MenuService;
import org.cs.jwt.services.RoleMenuService;
import org.cs.jwt.services.RoleService;
import org.cs.jwt.utility.RequestUtility;
import org.cs.jwt.valueobject.DataTableOutput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RoleMenuController {

   @Autowired
   RoleMenuService roleMenuService;

   @Autowired
   RoleService roleService;

   @Autowired
   MenuService menuService;

   ModelMapper modelMapper = null;
   public RoleMenuController(){
    modelMapper = new ModelMapper();
   }
  

   @CrossOrigin
   @PostMapping("/rolemenu/save")
   @ResponseBody
  public ResponseStatus save(@Valid  @RequestBody final RoleMenuDTO roleMenuDTO) {
    final ResponseStatus responseStatus = new ResponseStatus();

    try {
      roleMenuService.save(roleMenuDTO);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("Role Menu mapping created /updated successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }
  
  @CrossOrigin
  @PostMapping("/rolemenu/new/{roleid}/{rolename}")
  @ResponseBody
  public RoleMenuDTO getNewFeeHead(  @PathVariable(required = true) final Integer roleid,@PathVariable(required = true) final String rolename) {
    final RoleMenuDTO newRole = new RoleMenuDTO();
    newRole.setRoleid(roleid);
    newRole.setRolename(rolename);
    return newRole;
  }

  @CrossOrigin
  @PostMapping("/rolemenu/all")
  @ResponseBody
  public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, RoleMenuModel.class, "RoleMenu");
    final Page<RoleMenuModel> returnList = roleMenuService.findAll(predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/rolemenu/all/{roleid}")
  @ResponseBody
  public DataTableOutput findAllByRoleId( @PathVariable(required = true) final Integer roleid,@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, RoleMenuModel.class, "RoleMenu");
    final Page<RoleMenuModel> returnList = roleMenuService.findAllByRoleId(roleid,predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/rolemenu/delete/{roleid}/{menuid}")
  @ResponseBody
  public ResponseStatus getDeleteRole(
  @PathVariable(required = true) final Integer roleid,
  @PathVariable(required = true) final Integer menuid) {
    final ResponseStatus responseStatus=new ResponseStatus();
    responseStatus.setMessage("Role Menu Deletion Failed");
   try{
   
    roleMenuService.delete(roleid,menuid);
    responseStatus.setMessageCode("SUCCESS");
    responseStatus.setMessage("Role Menu mapping Deleted successfully");
   }
   catch(final Exception ex){
    ex.printStackTrace();
   }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/rolemenu/existing/{roleid}/{menuid}")
  @ResponseBody
  public RoleMenuDTO getExistingFeeHead(
    @PathVariable(required = true) final Integer roleid,
    @PathVariable(required = true) final Integer menuid) {
    return roleMenuService.findByRoleMenuCode(roleid,menuid);
  }
  @CrossOrigin
  @PostMapping("/rolemenu/existingornew/{roleid}/{menuid}")
  @ResponseBody
  public RoleMenuDTO getExistingOrNewFeeHead(
    @PathVariable(required = true) final Integer roleid,
    @PathVariable(required = true) final Integer menuid) {
      RoleMenuDTO roleMenuDTO= roleMenuService.findByRoleMenuCode(roleid,menuid);
      if(roleMenuDTO==null){
        roleMenuDTO=new RoleMenuDTO();
        RoleDTO role= roleService.findByRoleCode(roleid);
        roleMenuDTO.setRoleid(roleid);
        roleMenuDTO.setRolename(role.getRolename());
        MenuDTO menuDTO=menuService.findByMenuCode(menuid);
        roleMenuDTO.setMenuid(menuDTO.getMenuid());
        roleMenuDTO.setMenuname(menuDTO.getMenuname());
        roleMenuDTO.setMenuurl(menuDTO.getMenuurl());
        roleMenuDTO.setParentid(menuDTO.getParentid());
        roleMenuDTO.setIsleafnode(menuDTO.getIsleafnode());
      }
      
      return roleMenuDTO;
  }
  

    
}
