package com.demomodel.mybatis.callBackFunction.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

//-----------------------ok---------------------
//public class TemporaryPopulationThredQuery3 implements Callable<List<TemporaryPopulationWhiteList>> {
//
//	private int beganPage;
//	private int pageSize;
//	@Autowired
//	GaZzrkjbxxNewMapper gaZzrkjbxxNewMapper;
//	@Autowired
//	TemporaryPopulationWhiteListMapper temporaryPopulationWhiteListMapper;
//
//	public TemporaryPopulationThredQuery3(int beganPage, int pageSize, GaZzrkjbxxNewMapper gaZzrkjbxxNewMapper,
//			TemporaryPopulationWhiteListMapper temporaryPopulationWhiteListMapper) {
//		this.beganPage = beganPage;
//		this.pageSize = pageSize;
//		this.gaZzrkjbxxNewMapper = gaZzrkjbxxNewMapper;
//		this.temporaryPopulationWhiteListMapper = temporaryPopulationWhiteListMapper;
//	}
//
//	@Override
//	public List<TemporaryPopulationWhiteList> call() throws Exception {
////		System.out.println("分页"+beganPage+pageSize);  
////		List<TemporaryPopulationWhiteList> listColunt = gaZzrkjbxxNewMapper.selectByPage(beganPage, pageSize);
////		if(listColunt==null){
////			listColunt= new ArrayList<TemporaryPopulationWhiteList>();
////		}
////		temporaryPopulationWhiteListMapper.insertSave(listColunt);
//		// 批量插入 foreach
//
//		
//		  
//		/*
//		 * // for (TemporaryPopulationWhiteList temporaryPopulationWhiteList :
//		 * listColunt) { // // // if(
//		 * StringUtils.isNotBlank(temporaryPopulationWhiteList.getXmname()) &&
//		 * StringUtils.isNotBlank(temporaryPopulationWhiteList.getIdNum())){ //
//		 * TemporaryPopulationWhiteList tempWlist = temporaryPopulationWhiteListMapper
//		 * // .selectByIdNum(temporaryPopulationWhiteList.getIdNum()); // if (tempWlist
//		 * == null) { // // insert new // temporaryPopulationWhiteList.setIsUpdate(0);
//		 * // temporaryPopulationWhiteList.setCreateDate(new Date()); //
//		 * temporaryPopulationWhiteListMapper.save(temporaryPopulationWhiteList); //
//		 * System.out.println("白名单插入完成 "); //第一次1001 // } else { // if
//		 * (!temporaryPopulationWhiteList.equals(tempWlist)) { //
//		 * tempWlist.setLatestIssueDate(temporaryPopulationWhiteList.getLatestIssueDate(
//		 * )); // tempWlist.setExpDate(temporaryPopulationWhiteList.getExpDate()); //
//		 * tempWlist.setRenewCount(temporaryPopulationWhiteList.getRenewCount()); //
//		 * tempWlist.setUpdateDate(new Date()); // tempWlist.setIsUpdate(1); //
//		 * temporaryPopulationWhiteListMapper.update(tempWlist); //
//		 * System.out.println("白名单更新完成 "); // } // } // } // }
//		 */
//		return null;
//	}
//
//}
