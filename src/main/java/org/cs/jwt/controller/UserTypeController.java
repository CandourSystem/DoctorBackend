package org.cs.jwt.controller;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.UserTypeDTO;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.model.UserType;
import org.cs.jwt.services.UserTypeService;
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
public class UserTypeController {

   @Autowired
   UserTypeService userTypeService;
   ModelMapper modelMapper = null;
   public UserTypeController(){
     modelMapper = new ModelMapper();
   }


   @CrossOrigin
   @PostMapping("/usertype/save")
   @ResponseBody
  public ResponseStatus save(@Valid @RequestBody final UserTypeDTO userTypeDTO) {
    final ResponseStatus responseStatus = new ResponseStatus();
    UserType userType = modelMapper.map(userTypeDTO, UserType.class);

    try {
        userTypeService.save(userType);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("User Type Created inserted/updated successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }
  
  @CrossOrigin
  @PostMapping("/usertype/new")
  @ResponseBody
  public UserType getNewFeeHead() {
    final UserType newUserType = new UserType();
    return newUserType;
  }

  @CrossOrigin
  @PostMapping("/usertype/all")
  @ResponseBody
  public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, UserType.class, "userType");
    final Page<UserType> returnList = userTypeService.findAll(predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/usertype/delete/{usertypeid}")
  @ResponseBody
  public ResponseStatus getDeleteUserType(
  @PathVariable(required = true) final Integer usertypeid) {
    final ResponseStatus responseStatus=new ResponseStatus();
    responseStatus.setMessage("User Type Deletion Failed");
   try{
    final UserTypeDTO selectedObject=userTypeService.findByUsertypeCode(usertypeid);
    userTypeService.delete(selectedObject);
    responseStatus.setMessageCode("SUCCESS");
    responseStatus.setMessage("User Type Deleted successfully");
   }
   catch(final Exception ex){
    ex.printStackTrace();
   }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/usertype/existing/{usertypeid}")
  @ResponseBody
  public UserTypeDTO getExistingUserType(
    @PathVariable(required = true) final Integer usertypeid) {
    return userTypeService.findByUsertypeCode(usertypeid);
  }

    
}
