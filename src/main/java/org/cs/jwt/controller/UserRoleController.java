package org.cs.jwt.controller;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.RoleDTO;
import org.cs.jwt.dto.UserDetailsDTO;
import org.cs.jwt.dto.UserroleDTO;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.model.Userrole;
import org.cs.jwt.services.RoleService;
import org.cs.jwt.services.UserDetailService;
import org.cs.jwt.services.UserRoleService;
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
public class UserRoleController {

   @Autowired
   UserRoleService userroleService;

  

   @Autowired
   UserDetailService userService;

   @Autowired
   RoleService roleService;

   ModelMapper modelMapper = null;
   public UserRoleController(){
    modelMapper = new ModelMapper();
   }
  

   @CrossOrigin
   @PostMapping("/userrole/save")
   @ResponseBody
  public ResponseStatus save(@Valid @RequestBody final UserroleDTO userroleDTO) {
    final ResponseStatus responseStatus = new ResponseStatus();

    try {
      userroleService.save(userroleDTO);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("User Role mapping created /updated successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }
  
  @CrossOrigin
  @PostMapping("/userrole/new/{userid}/{username}")
  @ResponseBody
  public UserroleDTO getNewFeeHead(  @PathVariable(required = true) final Integer userid,@PathVariable(required = true) final String username) {
    final UserroleDTO newUserrole = new UserroleDTO();
    newUserrole.setUserid(userid);
    newUserrole.setUsername(username);
    return newUserrole;
  }

  @CrossOrigin
  @PostMapping("/userrole/all")
  @ResponseBody
  public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, Userrole.class, "userrole");
    final Page<Userrole> returnList = userroleService.findAll(predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/userrole/all/{userid}")
  @ResponseBody
  public DataTableOutput findAllByRoleId( @PathVariable(required = true) final Integer userid,@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, Userrole.class, "userrole");
    final Page<Userrole> returnList = userroleService.findAllByUserId(userid,predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/userrole/delete/{userid}/{roleid}")
  @ResponseBody
  public ResponseStatus getDeleteRole(
  @PathVariable(required = true) final Integer userid,
  @PathVariable(required = true) final Integer roleid) {
    final ResponseStatus responseStatus=new ResponseStatus();
    responseStatus.setMessage("User Role mapping Deletion Failed");
   try{
   
    userroleService.delete(userid,roleid);
    responseStatus.setMessageCode("SUCCESS");
    responseStatus.setMessage("User Role mapping Deleted successfully");
   }
   catch(final Exception ex){
    ex.printStackTrace();
   }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/userrole/existing/{userid}/{roleid}")
  @ResponseBody
  public UserroleDTO getExistingFeeHead(
    @PathVariable(required = true) final Integer userid,
    @PathVariable(required = true) final Integer roleid) {
    return userroleService.findByUserroleCode(userid,roleid);
  }
  @CrossOrigin
  @PostMapping("/userrole/existingornew/{userid}/{roleid}")
  @ResponseBody
  public UserroleDTO getExistingOrNewFeeHead(
    @PathVariable(required = true) final Integer userid,
    @PathVariable(required = true) final Integer roleid) {
      UserroleDTO userroleDTO= userroleService.findByUserroleCode(userid,roleid);
      if(userroleDTO==null){
        userroleDTO=new UserroleDTO();
       }

       UserDetailsDTO userDTO= userService.findByUserid(userid);
       userroleDTO.setUserid(userDTO.getUserid());
       userroleDTO.setUsername(userDTO.getUsername());
       RoleDTO roleDTO=roleService.findByRoleCode(roleid);
       userroleDTO.setId(Long.parseLong(""+roleDTO.getRoleid()));
       userroleDTO.setName(roleDTO.getRolename());
      
      return userroleDTO;
  }
  

    
}
