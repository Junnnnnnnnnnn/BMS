package com.BMS.BB.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.BMS.BB.view.BakeryVO;
import com.BMS.BB.view.BookVO;



@Repository
public class BookRepository implements IBookRepository{

	@Autowired
	JdbcTemplate  jdbc;
	
	private class BookMapper implements RowMapper<BookVO> {
	      @Override
	      public BookVO mapRow(ResultSet rs, int count) throws SQLException {
	    	  BookVO book = new BookVO();
	    	  
	    	  book.setBOOK_ID(rs.getInt("book_id"));
	    	  book.setPHONENUMBER(rs.getString("phonenumber"));
	    	  book.setBREAD_NAME(rs.getString("bread_name"));
	    	  book.setBOOK_AMOUNT(rs.getInt("book_amount"));
	    	  book.setBOOK_PRICE(rs.getInt("book_price"));
	         return book;
	      }
	   }
	
	
	
	
	
	
	@Override
	public void insertBook(String phoneNumber,String breadName,int amount) {
		String sql="select bread_price from bread where bread_name=?";
		int price = jdbc.queryForInt(sql, breadName);
		int total = price*amount;
		sql="insert into book values(book_sequence.NEXTVAL, ?,?,?,?)";
		
		jdbc.update(sql,phoneNumber,breadName,amount,total);
	}

	@Override
	public void deleteBook(int index) {
		String sql="delete from book where book_id=?";
		
		jdbc.update(sql,index);
	}

	@Override
	public ArrayList<BookVO> readBook(String phoneNum) {
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		String sql="select count(*) from book where phonenumber=?";
		int count = jdbc.queryForInt(sql,phoneNum);
		
		System.out.println(count);
		
		sql="select * from (select rownum as num,book_id,phonenumber,bread_name,book_amount,book_price  from book where phonenumber=?) a where a.num=?";
		BookVO bookVO= new BookVO();
		for(int i=1;i<=count;i++) {
			bookVO = jdbc.queryForObject(sql, new BookMapper(),phoneNum, i);
			bookList.add(bookVO);
		}
		 
		
		return bookList;
		
	}

}
