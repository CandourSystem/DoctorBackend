package org.cs.jwt.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.cs.jwt.dto.OptionDTO;
import org.cs.jwt.model.Menu;
import org.cs.jwt.model.QMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;


public interface MenuRepository extends JpaRepository<Menu, Long>, QuerydslPredicateExecutor<Menu>,
        QuerydslBinderCustomizer<QMenu> {

    @Override
    default void customize(QuerydslBindings bindings, QMenu qMenu) {
        bindings.excluding(
                // excluding some fields from filter
                qMenu.menuid, qMenu.validflag);

    }

    Page<Menu> findAll(Predicate predicate, Pageable pageable);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.menuid,fh.menuname) from Menu fh where fh.validflag= 'Yes' ")
    List<OptionDTO> getValidOptionList();

    Menu findByMenuid(Integer menuid);

    @Query("select new org.cs.jwt.dto.OptionDTO(fh.menuid,fh.menuname) from Menu fh where fh.validflag= 'Yes' and isleafnode='0' and parentmenu_id=0 ")
    List<OptionDTO> getParentValidOptionList();

}
