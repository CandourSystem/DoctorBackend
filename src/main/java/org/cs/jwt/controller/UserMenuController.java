package org.cs.jwt.controller;

import java.util.List;

import org.cs.jwt.dto.MenuModuleDTO;
import org.cs.jwt.services.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMenuController {
    @Autowired
    UserMenuService userMenuService;

    @CrossOrigin
    @GetMapping("/getUserMenu")
    public List<MenuModuleDTO> getUserMenu(@RequestHeader("Authorization") String token) {
        return userMenuService.fetchUsermenus(token);
    }

}
