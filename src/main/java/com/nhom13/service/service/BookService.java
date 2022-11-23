package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nhom13.dto.BookDTO;
import com.nhom13.model.Book;
import com.nhom13.model.Category;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.payload.response.ListWithPagingResponse;
import com.nhom13.repository.BookRepository;
import com.nhom13.repository.CategoryRepository;
import com.nhom13.service.impl.IBookService;
import com.nhom13.utility.Page;
import com.nhom13.utility.sort.ModelSorting;

import antlr.TokenWithIndex;

@Service
@Component
public class BookService implements IBookService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	BookRepository bookRepo;
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired

	@Override
	public List<BookDTO> getListBook() {
		List<Book> books = bookRepo.findAll();
		List<BookDTO> listBooks = new ArrayList<>();
		for (Book book : books) {

			listBooks.add(modelMapper.map(book, BookDTO.class));
		}
		return listBooks;
	}

	@Override
	public BookDTO getBookByID(Long id) {
		Book findBook = bookRepo.findById(id).orElseThrow();
		BookDTO bookDTO = modelMapper.map(findBook, BookDTO.class);
		return bookDTO;
	}

	@Override
	public DataResponse<?> insert(BookDTO request) {
		DataResponse<?> response = new DataResponse<>();
		Category category = categoryRepository.findById(request.getId_category()).orElseThrow();
		Book book = modelMapper.map(request, Book.class);
		book.setCategory(category);
		bookRepo.save(book);
		response.setSuccess(true);
		response.setMessage("Insert success");
		return response;
	}

	@Override
	public DataResponse<?> update(BookDTO request, Long id) {
		DataResponse<?> response = new DataResponse<>();
		Book book = bookRepo.getById(id);
		book.setName(request.getName());
		book.setDescription(request.getDescription());
		book.setAuthorname(request.getAuthorname());
		book.setPrice(request.getPrice());
		book.setCategory(categoryRepository.getById(request.getId_category()));
		bookRepo.save(book);
		response.setSuccess(true);
		response.setMessage("Update success");
		return response;
	}

	public ListWithPagingResponse<BookDTO> searchBook(String name, String authorName, Long category, Long minPrice,
			Long maxPrice,
			Integer page, Integer limit, Integer sortBy, Boolean sortDescending) {
		Long count = bookRepo.getCountSearchBook(name, authorName, category, minPrice, maxPrice);
		Page paging = new Page(page, limit, count.intValue(), ModelSorting.getProductSort(sortBy, sortDescending));
		List<Book> books = bookRepo.getSearchBook(name, authorName, category, minPrice, maxPrice, paging);
		List<BookDTO> lstBooks = books.stream().map(book -> modelMapper.map(book, BookDTO.class)).toList();
		return new ListWithPagingResponse<>(paging.getPageNumber() + 1, paging.getTotalPage(), lstBooks);
	}
}
