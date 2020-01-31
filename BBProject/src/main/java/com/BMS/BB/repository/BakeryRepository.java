package com.BMS.BB.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.BMS.BB.view.BakeryVO;


@Repository
public class BakeryRepository implements IBakeryRepository{
	
	@Autowired
	JdbcTemplate  jdbc;
	
	
	 private class BakeryMapper implements RowMapper<BakeryVO> {
	      @Override
	      public BakeryVO mapRow(ResultSet rs, int count) throws SQLException {
	    	  BakeryVO bakery = new BakeryVO();
	    	  
	    	  bakery.setBREAD_ID(rs.getInt("bread_id"));
	    	  bakery.setBREAD_NAME(rs.getString("bread_name"));
	    	  bakery.setBREAD_PRICE(rs.getInt("bread_price"));
	    	  bakery.setBREAD_AMOUNT(rs.getInt("bread_amount"));
	    	  bakery.setBREAD_OUTPUTTIME(rs.getInt("bread_outputtime"));
	         return bakery;
	      }
	   }

	 //////////////////
//	 String sql = "select * from bread where bread_name=?";
//	 
//     return jdbc.query(sql,new RowMapper<BakeryVO>() {
//    	 @Override
//	      public BakeryVO mapRow(ResultSet rs, int count) throws SQLException {
//	    	  BakeryVO bakery = new BakeryVO();
//	    	  
//	    	  bakery.setBREAD_ID(rs.getInt("bread_id"));
//	    	  bakery.setBREAD_NAME(rs.getString("bread_name"));
//	    	  bakery.setBREAD_PRICE(rs.getInt("bread_price"));
//	    	  bakery.setBREAD_AMOUNT(rs.getInt("bread_amount"));
//	    	  bakery.setBREAD_OUTPUTTIME(rs.getInt("bread_outputtime"));
//	    	  
//	         return bakery;
//	      }
//     });  
	 
	 //////////////////
	
	 
	 // 빵 예약시
	@Override
	public boolean updateBakery(int amount,String breadName) {
		String sql ="select * from bread where bread_name=? ";
		BakeryVO bakeryVO = new BakeryVO();
		bakeryVO= jdbc.queryForObject(sql,new BakeryMapper(),breadName);
		
		if(bakeryVO.getBREAD_AMOUNT()-amount < 0) {
			return false;
		}
		else {
			sql ="update bread set bread_amount=(bread_amount-?) where bread_name=? ";
			
			jdbc.update(sql , amount , breadName);
			return true;
		}
	}
	
	//빵 출품
	@Override
	public void outBakery(int amount, String breadName) {
		String sql="update bread set bread_amount=bread_amount+? where bread_name=?";
		
		jdbc.update(sql,amount,breadName);
	}
	
	@Override
	public void insertBakery(BakeryVO bakeryVO) {
//		String sql="INSERT INTO bread VALUES(?,?,?,?,?)";
//		
//		bakeryVO.get
//		jdbc.update(sql, );
//		
	}
	
	@Override
	public List<BakeryVO> getBakeryList() {
		 String sql = "select * from bread";
	     return jdbc.query(sql,new RowMapper<BakeryVO>() {
	    	 @Override
		      public BakeryVO mapRow(ResultSet rs, int count) throws SQLException {
		    	  BakeryVO bakery = new BakeryVO();
		    	  
		    	  bakery.setBREAD_ID(rs.getInt("bread_id"));
		    	  bakery.setBREAD_NAME(rs.getString("bread_name"));
		    	  bakery.setBREAD_PRICE(rs.getInt("bread_price"));
		    	  bakery.setBREAD_AMOUNT(rs.getInt("bread_amount"));
		    	  bakery.setBREAD_OUTPUTTIME(rs.getInt("bread_outputtime"));
		    	  
		         return bakery;
		      }
	     });    	 
	}
	@Override
	public ArrayList<BakeryVO> getBMSamount() {
		ArrayList<BakeryVO> amountList = new ArrayList<BakeryVO>();
		
		String sql ="select * from bread where bread_id=?";
		BakeryVO bakeryVO = new BakeryVO();
		for(int i=1;i<6;i++) {
			bakeryVO= jdbc.queryForObject(sql,new BakeryMapper(), i );
			amountList.add(bakeryVO);
		}
		
		return amountList;
	}








}

