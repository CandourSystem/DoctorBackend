package org.cs.jwt.controller;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.MakeDTO;
import org.cs.jwt.dto.MakeModelDTO;
import org.cs.jwt.model.MakeModel;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.services.MakeModelServices;
import org.cs.jwt.services.MakeService;
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
public class MakeModelController {

  @Autowired
  MakeService makeService;

  @Autowired
  MakeModelServices  makeModelService;

 

 
  ModelMapper modelMapper = null;

  public MakeModelController() {
    modelMapper = new ModelMapper();
  }

  @CrossOrigin
  @PostMapping("/makemodel/save")
  @ResponseBody
  public ResponseStatus save(@Valid @RequestBody final MakeModelDTO makeModelDTO) {
    final ResponseStatus responseStatus = new ResponseStatus();

    try {
      makeModelService.save(makeModelDTO);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("Model created /updated successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/makemodel/new/{makeid}/{makename}")
  @ResponseBody
public MakeModelDTO getNewMakeModel(@PathVariable(required = true) final Integer makeid,
      @PathVariable(required = true) final String makename) {
    final MakeModelDTO makeModelDTO = new MakeModelDTO();
    makeModelDTO.setMakeid(makeid);
    makeModelDTO.setMakename(makename);
   
    return makeModelDTO;
  }

  @CrossOrigin
  @PostMapping("/makemodel/all")
  @ResponseBody
  public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, MakeModel.class, "makemodel");
    final Page<MakeModel> returnList = makeModelService.findAll(predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/makemodel/all/{makeid}")
  @ResponseBody
  public DataTableOutput findAllByOrganizationId(@PathVariable(required = true) final Integer makeid,
      @RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, MakeModel.class, "makemodel");
    final Page<MakeModel> returnList = makeModelService.findAllByMakeId(makeid, predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/makemodel/delete/{modelid}")
  @ResponseBody
  public ResponseStatus getDeleteModel(@PathVariable(required = true) final Integer modelid) {
    final ResponseStatus responseStatus = new ResponseStatus();
    responseStatus.setMessage("Model Deletion Failed");
    try {

      makeModelService.delete(modelid);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("Model Deleted successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/makemodel/existing/{modelid}")
  @ResponseBody
  public MakeModelDTO getExistingModel(@PathVariable(required = true) final Integer modelid) {
    return makeModelService.findByModelId(modelid);
  }

  @CrossOrigin
  @PostMapping("/makemodel/existingornew/{makeid}/{modelid}")
  @ResponseBody
  public MakeModelDTO getExistingOrNew(@PathVariable(required = true) final Integer makeid,@PathVariable(required = true) final Integer modelid) {
    MakeModelDTO makeModelDTO = makeModelService.findByModelId(modelid);

    if (makeModelDTO == null) {
      makeModelDTO = new MakeModelDTO();
    }

    
    MakeDTO makeDTO = makeService.findByMakeid(makeid);
    makeModelService.populateMakeModelObject(makeModelDTO, makeDTO);

    return makeModelDTO;
  }

}
