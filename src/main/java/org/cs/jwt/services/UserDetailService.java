package org.cs.jwt.services;

import javax.transaction.Transactional;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.UserDetailsDTO;
import org.cs.jwt.model.User;
import org.cs.jwt.model.UserDetails;
import org.cs.jwt.repository.UserDetailsRepository;
import org.cs.jwt.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    ModelMapper modelMapper = null;

    public UserDetailService() {
        modelMapper = new ModelMapper();
    }

    @Transactional
    public void save(final UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = modelMapper.map(userDetailsDTO, UserDetails.class);
        userDetailsRepository.save(userDetails);
        System.out.println(userDetails);
        User loginUser = userRepository.findByUsername(userDetails.getUsername());
        if (loginUser == null) {
            loginUser = new User();
            loginUser.setUsername(userDetails.getUsername());
            loginUser.setUserId(Long.valueOf(userDetails.getUserid()));
        }

        loginUser.setPassword(bCryptPasswordEncoder.encode(userDetailsDTO.getPassword()));
        userRepository.save(loginUser);
    }

    public Page<UserDetails> findAll(final Predicate predicate, final Pageable pageable) {
        return userDetailsRepository.findAll(predicate, pageable);
    }

    public UserDetailsDTO findByUserid(final Integer userid) {
        UserDetails userDetails = userDetailsRepository.findByUserid(userid);
        UserDetailsDTO userDetailsDTO = modelMapper.map(userDetails, UserDetailsDTO.class);
        return userDetailsDTO;
    }

    public void delete(Integer userid) {
        UserDetails userDetails = userDetailsRepository.findByUserid(userid);
        userDetails.setValidflag("Del");
        userDetailsRepository.save(userDetails);
    }

}
