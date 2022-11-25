package com.nhom13.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class BookDTO extends BaseDTO {
	protected String name;
	protected Long price;
	protected String authorname;
	private String image;
	protected String description;
	protected Long id_category;

}
