package org.cs.jwt.controller;

import java.util.List;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.services.OptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionController {

  @Autowired
  OptionServices optionServices;

  public OptionController() {
    // empty constructor
  }

  @CrossOrigin
  @GetMapping("/option/role/all")
  @ResponseBody
  public List<OptionDTO> getAllRoleOptions() {
    List<OptionDTO> returnList = optionServices.getAllRoleOptions();
    returnList.add(0, new OptionDTO(" ", "All"));
    return returnList;
  }

  @CrossOrigin
  @GetMapping("/option/rolemenu/{roleid}")
  @ResponseBody
  public List<OptionDTO> getAllMappedMenuByRoleOptions(@PathVariable(required = true) final Integer roleid) {
    List<OptionDTO> returnList = optionServices.getAllMappedMenuByRoleOptions(roleid);
    returnList.add(0, new OptionDTO(" ", "All"));
    return returnList;
  }

  @CrossOrigin
  @GetMapping("/option/menu/all")
  @ResponseBody
  public List<OptionDTO> getAllMenuOptions() {
    List<OptionDTO> returnList = optionServices.getAllMenuOptions();
    return returnList;
  }

  @CrossOrigin
  @GetMapping("/option/parentmenu/all")
  @ResponseBody
  public List<OptionDTO> getAllParentMenuOptions() {
    List<OptionDTO> returnList = optionServices.getAllParentMenuOptions();
    returnList.add(0, new OptionDTO(" ", "None"));
    return returnList;
  }

  


  @CrossOrigin
  @GetMapping("/option/unit/all")
  @ResponseBody
  public List<OptionDTO> getAllUnitOptions() {
    List<OptionDTO> returnList = optionServices.getAllUnitOptions();
    returnList.add(0, new OptionDTO("", "Select Unit"));
    return returnList;
  }

  @CrossOrigin
  @GetMapping("/option/usertype/all")
  @ResponseBody
  public List<OptionDTO> getAllUsertype() {
    List<OptionDTO> returnList = optionServices.getAllUserTypeOptions();
    returnList.add(0, new OptionDTO("", "Select User Type"));
    return returnList;
  }

  @CrossOrigin
  @GetMapping("/option/user/all")
  @ResponseBody
  public List<OptionDTO> getAllUserOptions() {
    List<OptionDTO> returnList = optionServices.getAllUserOptions();
    returnList.add(0, new OptionDTO(" ", "All"));
    return returnList;
  }

  @CrossOrigin
  @GetMapping("/option/make/all")
  @ResponseBody
  public List<OptionDTO> getAllMakeOptions() {
    List<OptionDTO> returnList = optionServices.getAllMakeOptions();
    returnList.add(0, new OptionDTO(" ", "All"));
    return returnList;
  }





  @CrossOrigin
  @GetMapping("/option/makemodel/all/{makeid}")
  @ResponseBody
  public List<OptionDTO> getAllMakeModelOptions(@PathVariable(required = true) final Integer makeid) {
    List<OptionDTO> returnList = optionServices.getAllMakeModelOptions(makeid);
    returnList.add(0, new OptionDTO(" ", "All"));
    return returnList;
  }

}
