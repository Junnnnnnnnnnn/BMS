package com.BMS.BB.repository;

import java.util.ArrayList;
import java.util.List;

import com.BMS.BB.view.BakeryVO;


public interface IBakeryRepository {
	boolean updateBakery(int amount,String breadName);
	List<BakeryVO> getBakeryList();
	void outBakery(int amount, String breadName);
	void insertBakery(BakeryVO bakeryVO);
	ArrayList<BakeryVO> getBMSamount();

}
