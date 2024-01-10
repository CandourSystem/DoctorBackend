package org.cs.jwt.controller;

import org.cs.jwt.dto.MakeDTO;
import org.cs.jwt.model.Make;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.services.MakeService;
import org.cs.jwt.utility.RequestUtility;
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
import org.cs.jwt.valueobject.DataTableOutput;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;


    @RestController
    public class MakeController {
    
       @Autowired
       MakeService MakeService;
       ModelMapper modelMapper = null;
       public MakeController(){
         modelMapper = new ModelMapper();
       }
    
    
       @CrossOrigin
       @PostMapping("/make/save")
       @ResponseBody
      public ResponseStatus save(@Valid @RequestBody final MakeDTO MakeDTO) {
        final ResponseStatus responseStatus = new ResponseStatus();
        Make Make = modelMapper.map(MakeDTO, Make.class);
    
        try {
            MakeService.save(Make);
          responseStatus.setMessageCode("SUCCESS");
          responseStatus.setMessage("MAke Created inserted/updated successfully");
        } catch (final Exception ex) {
          ex.printStackTrace();
        }
        return responseStatus;
      }
      
      @CrossOrigin
      @PostMapping("/make/new")
      @ResponseBody
      public Make getNewFeeHead() {
        final Make newUserType = new Make();
        return newUserType;
      }
    
      @CrossOrigin
      @PostMapping("/make/all")
      @ResponseBody
      public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
        final Pageable pageable = RequestUtility.createPageable(parameters);
        final Predicate predicate = RequestUtility.createPredicate(parameters, Make.class, "Make");
        final Page<Make> returnList = MakeService.findAll(predicate, pageable);
    
        return RequestUtility.populate(parameters, returnList);
      }
    
      @CrossOrigin
      @PostMapping("/make/delete/{makeid}")
      @ResponseBody
      public ResponseStatus getDeleteUserType(
      @PathVariable(required = true) final Integer makeid) {
        final ResponseStatus responseStatus=new ResponseStatus();
        responseStatus.setMessage("MAke Deletion Failed");
       try{
        final MakeDTO selectedObject=MakeService.findByMakeid(makeid);
        MakeService.delete(selectedObject);
        responseStatus.setMessageCode("SUCCESS");
        responseStatus.setMessage("Make Deleted successfully");
       }
       catch(final Exception ex){
        ex.printStackTrace();
       }
        return responseStatus;
      }
    
      @CrossOrigin
      @PostMapping("/make/existing/{makeid}")
      @ResponseBody
      public MakeDTO getExistingUserType(
        @PathVariable(required = true) final Integer makeid) {
        return MakeService.findByMakeid(makeid);
      }

    }
    
        

