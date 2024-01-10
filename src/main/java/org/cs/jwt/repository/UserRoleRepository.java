package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QUserrole;
import org.cs.jwt.model.Userrole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;

public interface UserRoleRepository extends JpaRepository<Userrole, Long>, QuerydslPredicateExecutor<Userrole>,
QuerydslBinderCustomizer<QUserrole>{
    @Override
    default void customize(QuerydslBindings bindings, QUserrole qUserOrganization) {
        bindings.excluding(
                // excluding some fields from filter
                qUserOrganization.validflag);

    }
    List<Userrole> findByUserid(Long userid);
    
    Page<Userrole> findAll(Predicate predicate, Pageable pageable);

    @Query(nativeQuery = true, value = "select rm.* from m_userlogin_roles rm where  rm.roleid=:roleid and rm.userid = :userid")
    Userrole findByUserRoleId(@Param("userid") Integer userid, @Param("roleid") Integer roleid);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.id,fh.name) from Userrole fh where fh.validflag= 'Yes' and userid = :userid ")
    List<OptionDTO> getValidOptionListByUserId(@Param("userid") Integer roleid);

    @Query(nativeQuery = true, value = "select rm.* from m_userlogin_roles rm where rm.userid=:userid")
    Page<Userrole> findAllByUserid(@Param("userid") Integer userid, Pageable pageable);
   
    @Query(nativeQuery = true, value = "select count(userid) from m_userlogin_roles rm where  rm.validflag='Yes' and rolename='admin' and rm.userid = :userid")
    Integer isUserAdmin(Integer userid);
}
