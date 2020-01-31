package com.BMS.BB.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BMS.BB.repository.IBakeryRepository;
import com.BMS.BB.view.BakeryVO;


@Service
public class BakeryService implements IBakeryService{
	
	@Autowired
	IBakeryRepository bakeryRepository; 
	
	
	@Override
	public boolean updateBakery(int amount,String breadName) {
		return bakeryRepository.updateBakery(amount,breadName);
	}
	
	

	@Override
	public List<BakeryVO> getBakeryList() {
		return bakeryRepository.getBakeryList();
	}



	@Override
	public void outBakery(int amount, String breadName) {
		bakeryRepository.outBakery(amount,breadName);
	}



	@Override
	public void insertBakery(BakeryVO bakeryVO) {
		bakeryRepository.insertBakery(bakeryVO);
	}
	@Override
	public ArrayList<BakeryVO> getBMSamount() {
		return bakeryRepository.getBMSamount();
	}

	
}
