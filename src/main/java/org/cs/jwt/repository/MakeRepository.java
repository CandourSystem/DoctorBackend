package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QMake;
import org.cs.jwt.model.Make;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;


public interface MakeRepository extends JpaRepository<Make, Long>, QuerydslPredicateExecutor<Make>,
        QuerydslBinderCustomizer<QMake> {

    @Override
    default void customize(QuerydslBindings bindings, QMake qMake) {
        bindings.excluding(
                // excluding some fields from filter
                qMake.makeid, qMake.validflag);

    }

    Page<Make> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.makeid,fh.makename) from Make fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();
    
    @Query(nativeQuery = true, value = "select * from m_make where makeid=:makeid")
    Make findByMakeid(@Param("makeid") Integer makeid);

}
