package com.BMS.BB.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BMS.BB.repository.IBakeryRepository;
import com.BMS.BB.repository.IBookRepository;
import com.BMS.BB.view.BookVO;



@Service
public class BookService  implements IBookService{

	@Autowired
	IBookRepository bookRepository; 
	IBakeryRepository bakeryRepository;
	
	@Override
	public void insertBook(String phoneNumber,String breadName,int amount){
		bookRepository.insertBook(phoneNumber,breadName,amount);
		
	}

	@Override
	public void deleteBook(int index) {
		bookRepository.deleteBook(index);
		
	}

	@Override
	public ArrayList<BookVO> readBook(String phoneNum) {
		return bookRepository.readBook(phoneNum);
		
	}

}
