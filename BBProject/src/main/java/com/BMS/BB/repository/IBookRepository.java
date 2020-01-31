package com.BMS.BB.repository;

import java.util.ArrayList;

import com.BMS.BB.view.BookVO;

public interface IBookRepository {
	void insertBook(String phoneNumber,String breadName,int amount);
	void deleteBook(int index);
	ArrayList<BookVO> readBook(String phoneNum);
}
