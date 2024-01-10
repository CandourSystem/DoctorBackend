package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QParameterType;
import org.cs.jwt.model.ParameterType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;


public interface ParameterTypeRepository extends JpaRepository<ParameterType, Long>, QuerydslPredicateExecutor<ParameterType>,
        QuerydslBinderCustomizer<QParameterType> {

    @Override
    default void customize(QuerydslBindings bindings, QParameterType qParameterType) {
        bindings.excluding(
                // excluding some fields from filter
                qParameterType.parametertypeid, qParameterType.validflag);

    }

    Page<ParameterType> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.parametertypeid,fh.parametertypename) from ParameterType fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();

    @Query(nativeQuery = true, value = "select * from m_parametertype where parametertypeid=:parametertypeid ")
    ParameterType findByUsertypeCode(@Param("parametertypeid") Integer parametertypeid);

}
