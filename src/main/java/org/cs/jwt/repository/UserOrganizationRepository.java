package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QUserOrganization;
import org.cs.jwt.model.UserOrganization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;

public interface UserOrganizationRepository extends JpaRepository<UserOrganization, Long>,
        QuerydslPredicateExecutor<UserOrganization>, QuerydslBinderCustomizer<QUserOrganization> {

    @Override
    default void customize(QuerydslBindings bindings, QUserOrganization qUserOrganization) {
        bindings.excluding(
                // excluding some fields from filter
                qUserOrganization.validflag);

    }

    Page<UserOrganization> findAll(Predicate predicate, Pageable pageable);

    @Query(nativeQuery = true, value = "select rm.* from m_userorganization rm where  rm.organizationid=:organizationid and rm.userid = :userid")
    UserOrganization findByUserOrganizationId(@Param("userid") Integer userid, @Param("organizationid") Integer menuid);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.organizationid,fh.organizationname) from UserOrganization fh where fh.validflag= 'Yes' and userid = :userid ")
    List<OptionDTO> getValidOptionListByUserId(@Param("userid") Integer userid);

    @Query(nativeQuery = true, value = "select rm.* from m_userorganization rm where rm.userid=:userid")
    Page<UserOrganization> findAllByUserid(@Param("userid") Integer userid, Pageable pageable);
    
    @Query(nativeQuery = true, value = "select rm.* from m_userorganization rm where partner='Yes' and rm.username=:username")
     List<UserOrganization> getUserPartnerOrganization(@Param("username")String username);
    
     @Query(nativeQuery = true, value = "select rm.* from m_userorganization rm where partner!='Yes' and rm.username=:username")
    List<UserOrganization> getUserNonPartnerOrganization(String username);

    @Query(nativeQuery = true, value = "select rm.* from m_userorganization rm where partner!='Yes' and rm.username=:username")
    List<UserOrganization> getIndustryOrganization(String username);
}