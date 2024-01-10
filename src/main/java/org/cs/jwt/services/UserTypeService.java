package org.cs.jwt.services;



import org.cs.jwt.dto.UserTypeDTO;
import org.cs.jwt.model.UserType;
import org.cs.jwt.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
@Service
public class UserTypeService {
    
    @Autowired
    UserTypeRepository userTypeRepository;
    ModelMapper modelMapper = null;
    public UserTypeService(){
        modelMapper = new ModelMapper();
    }
    
    public void save(final UserType userType) {
        userTypeRepository.save(userType);
    }
    public Page<UserType> findAll(final Predicate predicate, final Pageable pageable) {
        return userTypeRepository.findAll(predicate, pageable);
    }
    
    public UserTypeDTO findByUsertypeCode(final Integer usertypeid) {
		UserType userType =  userTypeRepository.findByUsertypeCode(usertypeid);
        UserTypeDTO userTypeDTO = modelMapper.map(userType, UserTypeDTO.class);
        return userTypeDTO;
	}
    public void delete(UserTypeDTO selectedObject) {
        selectedObject.setValidflag("Del");
        UserType userType = modelMapper.map(selectedObject, UserType.class);
        userTypeRepository.save(userType);
    }

}
