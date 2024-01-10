package org.cs.jwt.services;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.MakeDTO;
import org.cs.jwt.dto.MakeModelDTO;
import org.cs.jwt.model.MakeModel;
import org.cs.jwt.repository.MakeModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MakeModelServices {

    @Autowired
    MakeModelRepository makeModelRepository;
    ModelMapper modelMapper = null;

    public MakeModelServices() {
        modelMapper = new ModelMapper();
    }

    public void save(final MakeModelDTO makeModelDTO) {
        MakeModel makeModel = modelMapper.map(makeModelDTO, MakeModel.class);
        makeModelRepository.save(makeModel);
    }

    public Page<MakeModel> findAll(final Predicate predicate, final Pageable pageable) {
        return makeModelRepository.findAll(predicate, pageable);
    }

    public MakeModelDTO findByModelId( final Integer modelid) {
        
        MakeModel makeModel= makeModelRepository.findByModelId(modelid);
        MakeModelDTO    makeModelDTO = null;
        if(makeModel!=null){
            makeModelDTO=modelMapper.map(makeModel, MakeModelDTO.class);
        }
        return makeModelDTO;
    }

    public void delete( final Integer modelid) {
        MakeModel makeModel= makeModelRepository.findByModelId(modelid);
        makeModel.setValidflag("Del");
        makeModelRepository.save(makeModel);
    }

    public Page<MakeModel> findAllByMakeId(Integer makeid, Predicate predicate, Pageable pageable) {
        return makeModelRepository.findAllByMakeId(makeid,pageable);
    }
    public void populateMakeModelObject(MakeModelDTO makeModelDTO,
    MakeDTO makeDTO) {
        this.modelMapper.map(makeDTO, makeModelDTO);
     
        makeModelDTO.setValidflag("Yes");  
        makeModelDTO.setRemarks("");
}
}
