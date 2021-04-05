package com.hit.open.api.utils;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

@Data
public class FilterField {
	private String operator;
	private String value;
	private String field;

	public Predicate generateCriteria(CriteriaBuilder builder, Path field) {
		try {
			switch (operator) {
			case "lt": return builder.lt(field, Integer.parseInt(value));
			case "le": return builder.le(field, Integer.parseInt(value));
			case "gt": return builder.gt(field, Integer.parseInt(value));
			case "ge": return builder.ge(field, Integer.parseInt(value));
			case "neq": return builder.notEqual(field, Integer.parseInt(value));
			case "eq": return builder.equal(field, Integer.parseInt(value));
			case "bwt":
				String[] split = value.split("-");
				if (split.length!=2){
					System.err.println(split.length);
				}
				System.err.println(split.toString());
				int from = Integer.parseInt(split[0]);
				int to = Integer.parseInt(split[1]);
				System.err.println(from+" "+ to);
				return builder.between(field, from,to);
			}
		} catch (NumberFormatException e) {
			switch (operator) {
			case "endsWith": return builder.like(field, "%" + value);
			case "startsWith": return builder.like(field, value + "%");
			case "contains": return builder.like(field, "%" + value + "%");
			case "eq": return builder.equal(field, value);
			}
		}

		return null;
	}
}