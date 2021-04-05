package com.hit.open.api.utils;

import lombok.Data;

@Data
public class LaptopFilter {
	private FilterField id;
	private FilterField name;
	private FilterField price;
	private FilterField ram;
}
