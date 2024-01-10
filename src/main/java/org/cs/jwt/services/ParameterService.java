package org.cs.jwt.services;

import org.cs.jwt.dto.ParameterTypeDTO;
import org.cs.jwt.model.ParameterType;
import org.cs.jwt.repository.ParameterTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;

@Service
public class ParameterService {
    @Autowired
    ParameterTypeRepository parameterTypeRepository;
    ModelMapper modelMapper = null;
    public ParameterService(){
        modelMapper = new ModelMapper();
    }
    
    public void save(final ParameterType functionType) {
        parameterTypeRepository.save(functionType);
    }
    public Page<ParameterType> findAll(final Predicate predicate, final Pageable pageable) {
        return parameterTypeRepository.findAll(predicate, pageable);
    }
    
    public ParameterTypeDTO findByUsertypeCode(final Integer usertypeid) {
		ParameterType userType =  parameterTypeRepository.findByUsertypeCode(usertypeid);
        ParameterTypeDTO userTypeDTO = modelMapper.map(userType, ParameterTypeDTO.class);
        return userTypeDTO;
	}
    public void delete(ParameterTypeDTO selectedObject) {
        selectedObject.setValidflag("Del");
        ParameterType userType = modelMapper.map(selectedObject, ParameterType.class);
        parameterTypeRepository.save(userType);
    }
    
}
