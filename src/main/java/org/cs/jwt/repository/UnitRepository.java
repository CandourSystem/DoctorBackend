package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QUnit;
import org.cs.jwt.model.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;


public interface UnitRepository extends JpaRepository<Unit, Long>, QuerydslPredicateExecutor<Unit>,
        QuerydslBinderCustomizer<QUnit> {

    @Override
    default void customize(QuerydslBindings bindings, QUnit qUnit) {
        bindings.excluding(
                // excluding some fields from filter
                qUnit.unitid, qUnit.validflag);

    }

    Page<Unit> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.unitid,fh.unitname) from Unit fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();

}
