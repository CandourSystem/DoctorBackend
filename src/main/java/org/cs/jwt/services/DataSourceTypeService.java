package org.cs.jwt.services;

import org.cs.jwt.dto.DataSourceDTO;
import org.cs.jwt.model.DataSourceType;
import org.cs.jwt.repository.DataSourceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
@Service
public class DataSourceTypeService {
    
    @Autowired
    DataSourceTypeRepository dataSourceTypeRepository;
    
    ModelMapper modelMapper = null;
    public DataSourceTypeService(){
        modelMapper = new ModelMapper();
    }
    
    public void save(final DataSourceType DataSourceType) {
        dataSourceTypeRepository.save(DataSourceType);
    }
    public Page<DataSourceType> findAll(final Predicate predicate, final Pageable pageable) {
        return dataSourceTypeRepository.findAll(predicate, pageable);
    }
    
    public DataSourceDTO findByUsertypeCode(final Integer usertypeid) {
		DataSourceType userType =  dataSourceTypeRepository.findByUsertypeCode(usertypeid);
        DataSourceDTO userTypeDTO = modelMapper.map(userType, DataSourceDTO.class);
        return userTypeDTO;
	}
    public void delete(DataSourceDTO selectedObject) {
        selectedObject.setValidflag("Del");
        DataSourceType userType = modelMapper.map(selectedObject, DataSourceType.class);
        dataSourceTypeRepository.save(userType);
    }

}
