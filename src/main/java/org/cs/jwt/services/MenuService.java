package org.cs.jwt.services;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.MenuDTO;
import org.cs.jwt.model.Menu;
import org.cs.jwt.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;
    ModelMapper modelMapper = null;

    public MenuService() {
        modelMapper = new ModelMapper();
    }

    public void save(final MenuDTO menuDTO) {
       
        Menu menu = modelMapper.map(menuDTO, Menu.class);
        menuRepository.save(menu);
    }

    public Page<Menu> findAll(final Predicate predicate, final Pageable pageable) {
        return menuRepository.findAll(predicate, pageable);
    }

    public MenuDTO findByMenuCode(final Integer menuid) {
        Menu menu = menuRepository.findByMenuid(menuid);
        MenuDTO menuDTO = modelMapper.map(menu, MenuDTO.class);
        return menuDTO;
    }

    public void delete(final Integer menuid) {
        Menu menu = menuRepository.findByMenuid( menuid);
        menu.setValidflag("Del");
        menuRepository.save(menu);
    }

}
