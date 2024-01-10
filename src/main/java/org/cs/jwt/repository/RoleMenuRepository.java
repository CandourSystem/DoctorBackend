package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QRoleMenuModel;
import org.cs.jwt.model.RoleMenuModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;

public interface RoleMenuRepository extends JpaRepository<RoleMenuModel, Long>,
        QuerydslPredicateExecutor<RoleMenuModel>, QuerydslBinderCustomizer<QRoleMenuModel> {

    @Override
    default void customize(QuerydslBindings bindings, QRoleMenuModel qRoleMenu) {
        bindings.excluding(
                // excluding some fields from filter
                qRoleMenu.roleid, qRoleMenu.validflag);

    }

    Page<RoleMenuModel> findAll(Predicate predicate, Pageable pageable);

    @Query(nativeQuery = true, value = "select rm.* from m_rolemenu rm where  rm.menuid=:menuid and rm.roleid = :roleid")
    RoleMenuModel findByRoleMenuId(@Param("roleid") Integer roleid, @Param("menuid") Integer menuid);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.menuid,fh.menuname) from RoleMenuModel fh where fh.validflag= 'Yes' and roleid = :roleid ")
   List<OptionDTO> getValidOptionListByRoleId(@Param("roleid") Integer roleid);

   @Query(nativeQuery = true, value = "select rm.* from m_rolemenu rm where rm.roleid=:roleid")
    Page<RoleMenuModel> findAllByRoleId(@Param("roleid") Integer roleid, Pageable pageable);

}
