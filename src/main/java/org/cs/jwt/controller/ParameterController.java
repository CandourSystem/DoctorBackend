package org.cs.jwt.controller;


import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.ParameterTypeDTO;
import org.cs.jwt.model.ParameterType;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.services.ParameterService;
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
public class ParameterController {
    @Autowired
    ParameterService parameterService;
    ModelMapper modelMapper = null;
    public ParameterController(){
      modelMapper = new ModelMapper();
    }
 
 
    @CrossOrigin
    @PostMapping("/parametertype/save")
    @ResponseBody
   public ResponseStatus save(@Valid @RequestBody final ParameterTypeDTO ParameterTypeDTO) {
     final ResponseStatus responseStatus = new ResponseStatus();
     ParameterType functionaltype = modelMapper.map(ParameterTypeDTO, ParameterType.class);
 
     try {
       parameterService.save(functionaltype);
       responseStatus.setMessageCode("SUCCESS");
       responseStatus.setMessage("Parameter Type Created inserted/updated successfully");
     } catch (final Exception ex) {
       ex.printStackTrace();
     }
     return responseStatus;
   }
   
   @CrossOrigin
   @PostMapping("/parametertype/new")
   @ResponseBody
   public ParameterType getNewFeeHead() {
     final ParameterType newUserType = new ParameterType();
     return newUserType;
   }
 
   @CrossOrigin
   @PostMapping("/parametertype/all")
   @ResponseBody
   public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
     final Pageable pageable = RequestUtility.createPageable(parameters);
     final Predicate predicate = RequestUtility.createPredicate(parameters, ParameterType.class, "ParameterType");
     final Page<ParameterType> returnList = parameterService.findAll(predicate, pageable);
 
     return RequestUtility.populate(parameters, returnList);
   }
 
   @CrossOrigin
   @PostMapping("/parametertype/delete/{usertypeid}")
   @ResponseBody
   public ResponseStatus getDeleteUserType(
   @PathVariable(required = true) final Integer usertypeid) {
     final ResponseStatus responseStatus=new ResponseStatus();
     responseStatus.setMessage("Parameter Type Deletion Failed");
    try{
     final ParameterTypeDTO selectedObject=parameterService.findByUsertypeCode(usertypeid);
     parameterService.delete(selectedObject);
     responseStatus.setMessageCode("SUCCESS");
     responseStatus.setMessage("Parameter Type Deleted successfully");
    }
    catch(final Exception ex){
     ex.printStackTrace();
    }
     return responseStatus;
   }
 
   @CrossOrigin
   @PostMapping("/parametertype/existing/{usertypeid}")
   @ResponseBody
   public ParameterTypeDTO getExistingUserType(
     @PathVariable(required = true) final Integer usertypeid) {
     return parameterService.findByUsertypeCode(usertypeid);
   }
 
}
