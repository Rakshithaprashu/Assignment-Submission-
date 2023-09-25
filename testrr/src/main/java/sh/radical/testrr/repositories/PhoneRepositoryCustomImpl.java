package sh.radical.testrr.repositories;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.Expressions;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import sh.radical.testrr.entities.PageInfo;
import sh.radical.testrr.entities.PagedResponse;
import sh.radical.testrr.entities.SearchQuery;
import sh.radical.testrr.exceptions.PhoneNotFound;
import sh.radical.testrr.models.Phone;
import sh.radical.testrr.repositories.PhoneRepository;
import sh.radical.testrr.repositories.PhoneRepositoryCustom;
import sh.radical.testrr.utils.Parser;

@Repository
public class PhoneRepositoryCustomImpl implements PhoneRepositoryCustom {

	@Autowired
	Parser parser;

	@Value(value = "${default.limit}")
	private Integer defaultLimit;

	@Value(value = "${default.offset}")
	private Integer defaultOffSet;

	@Autowired
	@Lazy
	PhoneRepository phoneRepository;

	public PagedResponse<Phone> findAllPhones(
		String filters,
		String sort,
		Integer limit,
		Integer offset
	) {
		List<SearchQuery> searchQueries = parser.getFilters(filters, "phone");
		List<Sort.Order> sortorder = parser.getOrderByFields(sort, "phone");
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		for (SearchQuery query : searchQueries) {
			booleanBuilder.and(
				Expressions.predicate(
					query.getOperation(),
					Expressions.stringPath(query.getQueryObject()),
					Expressions.constant(query.getValue())
				)
			);
		}
		try {
			if (limit == null) {
				limit = defaultLimit;
			}
			if (offset == null) {
				offset = defaultOffSet;
			}
			var pageRequest = PageRequest.of(offset, limit, Sort.by(sortorder));
			var phones = phoneRepository.findAll(booleanBuilder, pageRequest);
			var pageResponse = new PagedResponse<Phone>();
			pageResponse.setResults(phones.get().collect(Collectors.toList()));
			var pageInfo = new PageInfo();
			pageInfo.setTotal(phones.getTotalElements());
			pageInfo.setLimit(limit);
			pageInfo.setOffset(offset);
			pageResponse.setPageInfo(pageInfo);
			return pageResponse;
		} catch (Exception e) {
			throw new PhoneNotFound(
				"failed to fetch orders with filters " +
				filters +
				" and order by: " +
				sort
			);
		}
	}
}
