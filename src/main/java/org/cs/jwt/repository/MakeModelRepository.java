package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.MakeModel;
import org.cs.jwt.model.QMakeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;


public interface MakeModelRepository extends JpaRepository<MakeModel, Long>, QuerydslPredicateExecutor<MakeModel>,
        QuerydslBinderCustomizer<QMakeModel> {

    @Override
    default void customize(QuerydslBindings bindings, QMakeModel qMakeModel) {
        bindings.excluding(
                // excluding some fields from filter
                qMakeModel.modelid, qMakeModel.validflag);

    }

    Page<MakeModel> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.modelid,fh.modelname) from MakeModel fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();
    
    @Query(nativeQuery = true, value = "select * from m_makemodel where modelid=:modelid")
    MakeModel findByModelId(@Param("modelid") Integer modelid);
    
    @Query(nativeQuery = true, value = "select * from m_makemodel where makeid=:makeid and validflag='Yes'")
    Page<MakeModel> findAllByMakeId(@Param("makeid")Integer makeid, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.modelid,fh.modelname) from MakeModel fh where fh.validflag= 'Yes' and makeid=:makeid")
    List<OptionDTO> getAllMakeModelOptions(@Param("makeid")Integer makeid);

}
