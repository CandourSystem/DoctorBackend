package org.cs.jwt.services;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.UserDetailsDTO;
import org.cs.jwt.dto.UserOrganizationDTO;
import org.cs.jwt.model.UserOrganization;

import org.cs.jwt.repository.UserOrganizationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserOrganizationService {

    @Autowired
    UserOrganizationRepository userOrganizationRepository;
    ModelMapper modelMapper = null;

    public UserOrganizationService() {
        modelMapper = new ModelMapper();
    }

    public void save(final UserOrganizationDTO userOrganizationDTO) {
        UserOrganization userOrganization = modelMapper.map(userOrganizationDTO, UserOrganization.class);
        userOrganizationRepository.save(userOrganization);
    }

    public Page<UserOrganization> findAll(final Predicate predicate, final Pageable pageable) {
        return userOrganizationRepository.findAll(predicate, pageable);
    }

    public UserOrganizationDTO findByUserOrganizationId(final Integer userid, final Integer organizationId) {
        UserOrganization userOrganization = userOrganizationRepository.findByUserOrganizationId(userid, organizationId);
        UserOrganizationDTO UserOrganizationDTO = null;
        if(userOrganization!=null){
        UserOrganizationDTO=modelMapper.map(userOrganization, UserOrganizationDTO.class);
        }
        return UserOrganizationDTO;
    }

    public void delete(final Integer userid, final Integer organizationId) {
        UserOrganization roleMenu = userOrganizationRepository.findByUserOrganizationId(userid, organizationId);
        roleMenu.setValidflag("Del");
        userOrganizationRepository.save(roleMenu);
    }

    public Page<UserOrganization> findAllByUserId(Integer userid, Predicate predicate, Pageable pageable) {
        return userOrganizationRepository.findAllByUserid(userid,pageable);
    }

    
    public void populateUserOrganizationObject(UserOrganizationDTO userorganizationDTO,
    UserDetailsDTO userDetailsDTO) {
        this.modelMapper.map(userDetailsDTO, userorganizationDTO);
      /*  userorganizationDTO.setOrganizationid(organizationDTO.getOrganizationid());
        userorganizationDTO.setOrganizationName(organizationDTO.getOrganizationName());
        userorganizationDTO.setOrganizationtype(organizationDTO.getOrganizationtype()));
        userorganizationDTO.setOrganizationtypename(organizationDTO.getOrganizationtypename()));
        userorganizationDTO.setCountry(organizationDTO.getCountry());
        userorganizationDTO.setState(organizationDTO.getState());
        userorganizationDTO.set(organizationDTO.getOrganizationid());*/
        userorganizationDTO.setValidflag("Yes");  
        userorganizationDTO.setRemarks("");
}

    public List<UserOrganization> getUserPartnerOrganization(String username) {
        return userOrganizationRepository.getUserPartnerOrganization(username);
    }

    public List<UserOrganization> getUserNonPartnerOrganization(String username) {
        return userOrganizationRepository.getUserNonPartnerOrganization(username);
    }

    public List<UserOrganization> getIndustryOrganization(String username) {
        return userOrganizationRepository.getIndustryOrganization(username);
    }

}
