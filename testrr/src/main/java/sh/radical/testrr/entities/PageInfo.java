package sh.radical.testrr.entities;

import lombok.Data;

@Data
public class PageInfo {

	Long total;

	Integer limit;

	Integer offset;
}
