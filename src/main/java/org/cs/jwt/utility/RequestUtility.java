package org.cs.jwt.utility;

import java.util.Set;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;

import org.cs.jwt.valueobject.DataTableOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.MultiValueMap;

public class RequestUtility {
    public static final String COLUMNSTR = "columns[";
    public static final String BLANK = "";

    private RequestUtility() {
    }

    public static final Pageable createPageable(final MultiValueMap<String, String> parameters) {
        final Integer currentPageNo = Integer.parseInt(parameters.getFirst("start"));
        final Integer pageSize = Integer.parseInt(parameters.getFirst("length"));
        final String directionString = parameters.getFirst("order[0][dir]");
        final String sortColumnIndex = parameters.getFirst("order[0][column]");
        final String sortColummName = parameters.getFirst(COLUMNSTR + sortColumnIndex + "][name]");
        final Direction sortDirection = "desc".equals(directionString) ? Direction.DESC : Direction.ASC;

        return PageRequest.of(currentPageNo / pageSize, (pageSize < 0) ? Integer.MAX_VALUE : pageSize,
                Sort.by(sortDirection, sortColummName));
    }

    public static final DataTableOutput populate(final MultiValueMap<String, String> parameters,
            final Page pageObject) {
        DataTableOutput output = new DataTableOutput();
        output.setDraw(Integer.parseInt(parameters.getFirst("draw")));// explicit casting to remove xss attack
        output.setRecordsFiltered(pageObject.getTotalElements());
        output.setRecordsTotal(pageObject.getTotalElements());
        output.setData(pageObject.getContent());
        return output;
    }

    public static final Predicate createPredicate(final MultiValueMap<String, String> parameters,
            final Class<?> entityClass, final String entityName) {
        final PathBuilder<?> entityPath = new PathBuilder(entityClass, entityName);

        BooleanExpression predicateSearch = null;
        final String globalSearchValue = parameters.getFirst("search[value]");

        Integer noOfColumns = 0;

        final Set<String> parameterKeys = parameters.keySet();
        for (final String pk : parameterKeys) {
            if (pk.startsWith("columns")) {
                noOfColumns++;
            }
        }

        final Integer noOfFields = noOfColumns / 6;// 6 is no of properties of each column used by datatables

        for (int i = 0; i < noOfFields; i++) {
            final boolean isSearchable = Boolean.parseBoolean(parameters.getFirst(COLUMNSTR + i + "][searchable]"));
            final String searchParameter = parameters.getFirst(COLUMNSTR + i + "][name]");
            final String searchParameterValue = parameters.getFirst(COLUMNSTR + i + "][search][value]");
            System.out
                    .println("searchParameter::" + searchParameter + " searchParameterValue::" + searchParameterValue);
            if (!searchParameter.equalsIgnoreCase(BLANK) && isSearchable) {
                if (!globalSearchValue.equals(BLANK)) {
                    predicateSearch = (predicateSearch != null)
                            ? predicateSearch.or(entityPath.getString(searchParameter).contains(globalSearchValue))
                            : entityPath.getString(searchParameter).contains(globalSearchValue);
                } else {

                    if (!searchParameterValue.equals(BLANK)) {
                        predicateSearch = (predicateSearch != null)
                                ? predicateSearch.and(predicateSearch
                                        .and(entityPath.getString(searchParameter).contains(searchParameterValue)))
                                : entityPath.getString(searchParameter).contains(searchParameterValue);
                    }
                }

            }
        }

        return predicateSearch;
    }

    public static final Predicate createPredicate(final MultiValueMap<String, String> parameters,
            final Class<?> entityClass, final String entityName, String[] extraColumnnames,
            String[] extraColumnvalues) {
        final PathBuilder<?> entityPath = new PathBuilder(entityClass, entityName);

        BooleanExpression predicateSearch = null;
        final String globalSearchValue = parameters.getFirst("search[value]");

        Integer noOfColumns = 0;

        final Set<String> parameterKeys = parameters.keySet();
        for (final String pk : parameterKeys) {
            if (pk.startsWith("columns")) {
                noOfColumns++;
            }
        }

        final Integer noOfFields = noOfColumns / 6;// 6 is no of properties of each column used by datatables

        for (int i = 0; i < noOfFields; i++) {
            final boolean isSearchable = Boolean.parseBoolean(parameters.getFirst(COLUMNSTR + i + "][searchable]"));
            final String searchParameter = parameters.getFirst(COLUMNSTR + i + "][name]");
            final String searchParameterValue = parameters.getFirst(COLUMNSTR + i + "][search][value]");
            System.out
                    .println("searchParameter::" + searchParameter + " searchParameterValue::" + searchParameterValue);
            if (!searchParameter.equalsIgnoreCase(BLANK) && isSearchable) {
                if (!globalSearchValue.equals(BLANK)) {
                    predicateSearch = (predicateSearch != null)
                            ? predicateSearch.or(entityPath.getString(searchParameter).contains(globalSearchValue))
                            : entityPath.getString(searchParameter).eq(globalSearchValue);
                } else {

                    if (!searchParameterValue.equals(BLANK)) {
                        predicateSearch = (predicateSearch != null)
                                ? predicateSearch.and(predicateSearch
                                        .and(entityPath.getString(searchParameter).contains(searchParameterValue)))
                                : entityPath.getString(searchParameter).eq(searchParameterValue);
                    }
                }

            }
        }

        // adding extra condition
        for (int columnIndex = 0; columnIndex < extraColumnnames.length; columnIndex++) {
            final String searchParameter = extraColumnnames[columnIndex];
            final String searchParameterValue = extraColumnvalues[columnIndex];
            if (searchParameterValue != null && !searchParameterValue.trim().equals("")
                    && !searchParameterValue.trim().equals("null")
                    && !searchParameterValue.trim().equals("undefined")) {
                System.out.println(
                        "xtra searchParameter::" + searchParameter + " searchParameterValue::" + searchParameterValue);
                predicateSearch = (predicateSearch != null)
                        ? predicateSearch.and(entityPath.getString(searchParameter).contains(searchParameterValue))
                        : entityPath.getString(searchParameter).contains(searchParameterValue);
            }
        }

        return predicateSearch;
    }

}