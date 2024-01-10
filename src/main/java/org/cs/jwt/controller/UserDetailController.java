package org.cs.jwt.controller;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.UserDetailsDTO;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.model.Role;
import org.cs.jwt.model.UserDetails;
import org.cs.jwt.services.UserDetailService;
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
public class UserDetailController {

   @Autowired
   UserDetailService userDetailService;
   ModelMapper modelMapper = null;
   public UserDetailController(){
    modelMapper = new ModelMapper();
   }
  

   @CrossOrigin
   @PostMapping("/userdetail/save")
   @ResponseBody
  public ResponseStatus save(@Valid  @RequestBody final UserDetailsDTO userDetailsDTO) {
    final ResponseStatus responseStatus = new ResponseStatus();

    try {
      userDetailService.save(userDetailsDTO);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("User Detail created /updated successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }
  
  @CrossOrigin
  @PostMapping("/userdetail/new")
  @ResponseBody
  public UserDetails getNewFeeHead() {
    final UserDetails newRole = new UserDetails();
    return newRole;
  }

  @CrossOrigin
  @PostMapping("/userdetail/all")
  @ResponseBody
  public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, Role.class, "userdetails");
    final Page<UserDetails> returnList = userDetailService.findAll(predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/userdetail/delete/{userid}")
  @ResponseBody
  public ResponseStatus delete(
  @PathVariable(required = true) final Integer userid) {
    final ResponseStatus responseStatus=new ResponseStatus();
    responseStatus.setMessage("User detail deletion failed");
   try{
    
    userDetailService.delete(userid);
    responseStatus.setMessageCode("SUCCESS");
    responseStatus.setMessage("User detail deleted successfully");
   }
   catch(final Exception ex){
    ex.printStackTrace();
   }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/userdetail/existing/{userid}")
  @ResponseBody
  public UserDetailsDTO getExistingDTO(
    @PathVariable(required = true) final Integer userid) {
    return userDetailService.findByUserid(userid);
  }

    
}
