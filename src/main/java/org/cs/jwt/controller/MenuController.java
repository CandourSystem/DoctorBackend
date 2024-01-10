package org.cs.jwt.controller;

import javax.validation.Valid;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.MenuDTO;
import org.cs.jwt.model.Menu;
import org.cs.jwt.model.ResponseStatus;
import org.cs.jwt.model.Role;
import org.cs.jwt.services.MenuService;
import org.cs.jwt.utility.RequestUtility;
import org.cs.jwt.valueobject.DataTableOutput;
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
public class MenuController {

   @Autowired
   MenuService menuService;
 
   public MenuController(){
  
   }
  

   @CrossOrigin
   @PostMapping("/menu/save")
   @ResponseBody
  public ResponseStatus save(@Valid @RequestBody final MenuDTO menuDTO) {
    final ResponseStatus responseStatus = new ResponseStatus();

    try {
      
      menuService.save(menuDTO);
      responseStatus.setMessageCode("SUCCESS");
      responseStatus.setMessage("Menu created/updated successfully");
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
    return responseStatus;
  }
  
  @CrossOrigin
  @PostMapping("/menu/new")
  @ResponseBody
  public Menu getNewFeeHead() {
    final Menu newMenu = new Menu();
    return newMenu;
  }

  @CrossOrigin
  @PostMapping("/menu/all")
  @ResponseBody
  public DataTableOutput findAll(@RequestParam final MultiValueMap<String, String> parameters) {
    final Pageable pageable = RequestUtility.createPageable(parameters);
    final Predicate predicate = RequestUtility.createPredicate(parameters, Role.class, "Role");
    final Page<Menu> returnList = menuService.findAll(predicate, pageable);

    return RequestUtility.populate(parameters, returnList);
  }

  @CrossOrigin
  @PostMapping("/menu/delete/{menuid}")
  @ResponseBody
  public ResponseStatus getDeleteRole(
  @PathVariable(required = true) final Integer menuid) {
    final ResponseStatus responseStatus=new ResponseStatus();
    responseStatus.setMessage("Menu Deletion Failed");
   try{
  
    menuService.delete(menuid);
    responseStatus.setMessageCode("SUCCESS");
    responseStatus.setMessage("Menu deleted successfully");
   }
   catch(final Exception ex){
    ex.printStackTrace();
   }
    return responseStatus;
  }

  @CrossOrigin
  @PostMapping("/menu/existing/{menuid}")
  @ResponseBody
  public MenuDTO getExistingFeeHead(
    @PathVariable(required = true) final Integer menuid) {
    return menuService.findByMenuCode(menuid);
  }

    
}
