package org.cs.jwt.controller;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.UserDetailsDTO;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.model.UserDetails;
import org.cs.jwt.services.UserDetailService;
import org.cs.jwt.utility.RequestUtility;
import org.cs.jwt.valueobject.DataTableOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserDetailsController  extends ValidationController{

   @Autowired
   UserDetailService userDetailService;
 
   public UserDetailsController(){
  
   }
  

   @CrossOrigin
   @PostMapping("/userdetails/save")
   @ResponseBody
  public ResponseStatus save(@Valid @RequestBody final UserDetailsDTO userDetailsDTO) {
    final ResponseStatus responseStatus = new ResponseStatus();

    try {
      
      userDetailService.save(userDetailsDTO);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("User created/updated successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }
  
  @CrossOrigin
  @PostMapping("/userdetails/new")
  @GetMapping("/userdetails/new")
  @ResponseBody
  public UserDetailsDTO newUserDetailsDTO() {
    final UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
    return userDetailsDTO;
  }

  @CrossOrigin
  @PostMapping("/userdetails/all")
  @ResponseBody
  public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, UserDetails.class, "userDetails");
    final Page<UserDetails> returnList = userDetailService.findAll(predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/userdetails/delete/{userid}")
  @ResponseBody
  public ResponseStatus getDeleteRole(
  @PathVariable(required = true) final Integer userid) {
    final ResponseStatus responseStatus=new ResponseStatus();
    responseStatus.setMessage("User Deletion Failed");
   try{
  
    userDetailService.delete(userid);
    responseStatus.setMessageCode("SUCCESS");
    responseStatus.setMessage("User deleted successfully");
   }
   catch(final Exception ex){
    ex.printStackTrace();
   }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/userdetails/existing/{userid}")
  @ResponseBody
  public UserDetailsDTO getExistingFeeHead(
    @PathVariable(required = true) final Integer userid) {
    return userDetailService.findByUserid(userid);
  }

    
}
