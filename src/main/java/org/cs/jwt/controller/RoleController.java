package org.cs.jwt.controller;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.RoleDTO;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.model.Role;
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
public class RoleController {

   @Autowired
   RoleService RoleService;
   ModelMapper modelMapper = null;
   public RoleController(){
    modelMapper = new ModelMapper();
   }
  

   @CrossOrigin
   @PostMapping("/Role/save")
   @ResponseBody
  public ResponseStatus save(@Valid @RequestBody final RoleDTO RoleDTO) {
    final ResponseStatus responseStatus = new ResponseStatus();

    try {
      Role roleModel = modelMapper.map(RoleDTO, Role.class);
      RoleService.save(roleModel);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("Role Created inserted/updated successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }
  
  @CrossOrigin
  @PostMapping("/Role/new")
  @ResponseBody
  public Role getNewFeeHead() {
    final Role newRole = new Role();
    return newRole;
  }

  @CrossOrigin
  @PostMapping("/Role/all")
  @ResponseBody
  public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, Role.class, "Role");
    final Page<Role> returnList = RoleService.findAll(predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/Role/delete/{Roleid}")
  @ResponseBody
  public ResponseStatus getDeleteRole(
  @PathVariable(required = true) final Integer Roleid) {
    final ResponseStatus responseStatus=new ResponseStatus();
    responseStatus.setMessage("Role Deletion Failed");
   try{
    final RoleDTO selectedObject=RoleService.findByRoleCode(Roleid);
    RoleService.delete(selectedObject);
    responseStatus.setMessageCode("SUCCESS");
    responseStatus.setMessage("Role Deleted successfully");
   }
   catch(final Exception ex){
    ex.printStackTrace();
   }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/Role/existing/{Roleid}")
  @ResponseBody
  public RoleDTO getExistingFeeHead(
    @PathVariable(required = true) final Integer Roleid) {
    return RoleService.findByRoleCode(Roleid);
  }

    
}
