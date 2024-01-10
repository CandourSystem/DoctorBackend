package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QUserType;
import org.cs.jwt.model.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;


public interface UserTypeRepository extends JpaRepository<UserType, Long>, QuerydslPredicateExecutor<UserType>,
        QuerydslBinderCustomizer<QUserType> {

    @Override
    default void customize(QuerydslBindings bindings, QUserType qUserType) {
        bindings.excluding(
                // excluding some fields from filter
                qUserType.usertypeid, qUserType.validflag);

    }

    Page<UserType> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.usertypeid,fh.usertypename) from UserType fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();

    @Query(nativeQuery = true, value = "select * from m_usertype where usertypeid=:usertypeid ")
    UserType findByUsertypeCode(@Param("usertypeid") Integer usertypeid);


}
