package com.nhom13.service.impl;

import java.util.List;

import com.nhom13.dto.BookDTO;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.payload.response.ListWithPagingResponse;

public interface IBookService {

	public List<BookDTO> getListBook();

	public BookDTO getBookByID(Long id);

	public DataResponse<?> insert(BookDTO request);

	public DataResponse<?> update(BookDTO request, Long id);

	public ListWithPagingResponse<BookDTO> searchBook(String name, String authorName, Long category, Long minPrice,
			Long maxPrice,
			Integer page, Integer limit, Integer sortBy, Boolean sortDescending);
}
