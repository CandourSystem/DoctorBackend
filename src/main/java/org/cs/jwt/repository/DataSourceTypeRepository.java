package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QDataSourceType;
import org.cs.jwt.model.DataSourceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;


public interface DataSourceTypeRepository extends JpaRepository<DataSourceType, Long>, QuerydslPredicateExecutor<DataSourceType>,
        QuerydslBinderCustomizer<QDataSourceType> {

    @Override
    default void customize(QuerydslBindings bindings, QDataSourceType qDataSourceType) {
        bindings.excluding(
                // excluding some fields from filter
                qDataSourceType.datasourcetypeid, qDataSourceType.validflag);

    }

    Page<DataSourceType> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.datasourcetypeid,fh.datasourcetypename) from DataSourceType fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();

    @Query(nativeQuery = true, value = "select * from m_datasourcetype where datasourcetypeid=:datasourcetypeid")
    DataSourceType findByUsertypeCode(@Param("datasourcetypeid") Integer datasourcetypeid);


}
