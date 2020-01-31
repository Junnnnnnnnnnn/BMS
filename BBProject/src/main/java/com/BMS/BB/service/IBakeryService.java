package com.BMS.BB.service;

import java.util.ArrayList;
import java.util.List;

import com.BMS.BB.view.BakeryVO;

public interface IBakeryService {
	boolean updateBakery(int amount,String breadName);  //빵을 예약했을 때 수량 감소
	
	void outBakery(int amount, String breadName); //빵 출품시간 시 수량 증가
	void insertBakery(BakeryVO bakeryVO); //새로운 제품 출시 DB에 넣어줌
	ArrayList<BakeryVO> getBMSamount();
	
	List<BakeryVO> getBakeryList();
	
}
