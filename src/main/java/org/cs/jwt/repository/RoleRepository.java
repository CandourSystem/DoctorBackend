package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QRole;
import org.cs.jwt.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;


public interface RoleRepository extends JpaRepository<Role, Long>, QuerydslPredicateExecutor<Role>,
        QuerydslBinderCustomizer<QRole> {

    @Override
    default void customize(QuerydslBindings bindings, QRole qRole) {
        bindings.excluding(
                // excluding some fields from filter
                qRole.roleid, qRole.validflag);

    }

    Page<Role> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.roleid,fh.rolename) from Role fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();
    
    @Query(nativeQuery = true, value = "select * from m_Role where Roleid=:Roleid ")
    Role findByRoleCode(@Param("Roleid") Integer Roleid);



}
