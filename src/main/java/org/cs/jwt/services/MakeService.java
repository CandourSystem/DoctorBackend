package org.cs.jwt.services;



import org.cs.jwt.dto.MakeDTO;
import org.cs.jwt.model.Make;
import org.cs.jwt.repository.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
@Service
public class MakeService {
    
    @Autowired
    MakeRepository makeRepository;
    ModelMapper modelMapper = null;
    public MakeService(){
        modelMapper = new ModelMapper();
    }
    
    public void save(final Make Make) {
        makeRepository.save(Make);
    }
    public Page<Make> findAll(final Predicate predicate, final Pageable pageable) {
        return makeRepository.findAll(predicate, pageable);
    }
    
    public MakeDTO findByMakeid(final Integer makeid) {
		Make make =  makeRepository.findByMakeid(makeid);
        MakeDTO makeDTO = modelMapper.map(make, MakeDTO.class);
        return makeDTO;
	}
    public void delete(MakeDTO selectedObject) {
        selectedObject.setValidflag("Del");
        Make userType = modelMapper.map(selectedObject, Make.class);
        makeRepository.save(userType);
    }

}
