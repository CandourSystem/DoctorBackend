package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.QUserDetails;
import org.cs.jwt.model.UserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;



public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>, QuerydslPredicateExecutor<UserDetails>,
        QuerydslBinderCustomizer<QUserDetails> {

    @Override
    default void customize(QuerydslBindings bindings, QUserDetails qUserDetails) {
        bindings.excluding(
                // excluding some fields from filter
                qUserDetails.userid, qUserDetails.validflag);

    }

    Page<UserDetails> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.userid,fh.username) from UserDetails fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();

    UserDetails findByUserid(Integer userid);

}
