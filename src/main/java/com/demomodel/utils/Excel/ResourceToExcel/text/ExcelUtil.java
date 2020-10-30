package com.demomodel.utils.Excel.ResourceToExcel.text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.star.drawing.Alignment;

public class ExcelUtil {

	public static void main(String[] args) throws Exception {
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet();
		// 创样式
		HSSFCellStyle cellStyle = workBook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		cellStyle.setWrapText(true);// 自动换行  
		
		 // 背景色
		cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
		cellStyle.setFillBackgroundColor(HSSFColor.YELLOW.index); 

		// 设置边框
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		
		// 生成一个字体
		HSSFFont font = workBook.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setColor(HSSFColor.RED.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");

		// 把字体 应用到当前样式
		cellStyle.setFont(font);

		String workBookTitle = "产地信息统计报表";
		String[] topNames = { "农户", "电话", "地址", "代办", "代办费", "今年种植规模（亩）", "今年产量（总产量）万斤", "采购时间", "创建时间", "修改日期" };
		setWorkBookTitle(workBookTitle, topNames, workBook, sheet, cellStyle);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 创建数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("supplierName", "sa");
		map.put("supplierPhone", "1432232232");
		map.put("area", "142");
		map.put("agent", "142");
		map.put("collectionFee", "142");//
		map.put("acreage", "142");//
		map.put("forecastProduction", "142");//
		map.put("purchaseDate", "142");
		map.put("createDate", "142");
		map.put("modifyDate", "142");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("supplierName", "sa");
		map2.put("supplierPhone", "1432232232");
		map2.put("area", "142");
		map2.put("agent", "142");
		map2.put("collectionFee", "142");//
		map2.put("acreage", "142");//
		map2.put("forecastProduction", "142");//
		map2.put("purchaseDate", "142");
		map2.put("createDate", "142");
		map2.put("modifyDate", "142");
		list.add(map);
		list.add(map2);
		// 创建数据结束

		HSSFRow row = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Map<String, Object> supplier = list.get(i);
			row = sheet.createRow(i + 2);
			row.createCell(0).setCellValue(supplier.get("supplierName").toString());
			row.createCell(1).setCellValue(supplier.get("supplierPhone").toString());
			row.createCell(2).setCellValue(supplier.get("area").toString());
			row.createCell(3).setCellValue(supplier.get("agent").toString());
			row.createCell(4).setCellValue(supplier.get("collectionFee").toString());
			row.createCell(5).setCellValue(supplier.get("acreage").toString());
			row.createCell(6).setCellValue(supplier.get("forecastProduction").toString());
			row.createCell(7).setCellValue(supplier.get("purchaseDate").toString());
			row.createCell(8).setCellValue(supplier.get("createDate").toString());
			row.createCell(9).setCellValue(supplier.get("modifyDate").toString());

		}

		List<Map<String, Object>> mapList = getListToMaps(list);
		if (mapList.size() > 0) {
			// 页脚汇总统计
			row = sheet.createRow(size + 2);
			row.createCell(0).setCellValue("汇总");
			row.createCell(4).setCellValue(getfootTotal(mapList, "collectionFee"));
			row.createCell(5).setCellValue(getfootTotal(mapList, "acreage"));
			row.createCell(6).setCellValue(getfootTotal(mapList, "forecastProduction"));

		}

		String filename = "workBookTitle.xls";
		colseWorkBook(filename, workBook);

	}

	/**
	 * @throws Exception 关闭表格 @param filename @param workBook @throws
	 */
	private static void colseWorkBook(String filename, HSSFWorkbook workBook) throws Exception {
		OutputStream out = null;
		try {
			out = new FileOutputStream(getAbsoluteFile(filename));
			workBook.write(out);
		} catch (Exception e) {
			throw new Exception("导出Excel失败，请联系网站管理员！");
		} finally {
			if (workBook != null) {
				try {
					workBook.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取下载路径
	 * 
	 * @param filename 文件名称
	 */
	public static String getAbsoluteFile(String filename) {
		String downloadPath = "D:\\text\\result/" + filename;
		File desc = new File(downloadPath);
		if (!desc.getParentFile().exists()) {
			desc.getParentFile().mkdirs();
		}
		return downloadPath;
	}

	/**
	 * 设置标题头部 设置第0行和1行
	 * 
	 * @param workBookTitle
	 * @param topNames
	 * @param workBook
	 * @param sheet
	 * @param cellStyle
	 */
	private static void setWorkBookTitle(String workBookTitle, String[] topNames, HSSFWorkbook workBook,
			HSSFSheet sheet, HSSFCellStyle cellStyle) {
		workBook.setSheetName(0, workBookTitle);
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(workBookTitle);
		CellRangeAddress cRangeAddress = new CellRangeAddress(0, 0, 0, topNames.length - 1);
		sheet.addMergedRegion(cRangeAddress);
		cell.setCellStyle(cellStyle);
		row = sheet.createRow(1);
		for (int i = 0; i < topNames.length; i++) {
			row.createCell(i).setCellValue(topNames[i]);
		}
	}

//统计总数
	private static String getfootTotal(List<Map<String, Object>> list, String customkey) {
		BigDecimal currentValue = BigDecimal.ZERO;
		for (Map<String, Object> map : list) {
			BigDecimal customVaule = BigDecimal.ZERO;
			for (String key : map.keySet()) {
				if (StringUtils.equals(customkey, key)) {
					customVaule = new BigDecimal(map.get(key).toString());
					break;
				}
			}
			currentValue = currentValue.add(customVaule);
		}
		return currentValue.stripTrailingZeros().toPlainString();
	}

	// 没什么用
	private static List<Map<String, Object>> getListToMaps(List<Map<String, Object>> list) {
		List<Map<String, Object>> mapList = new ArrayList<>();
		for (Map<String, Object> recordMain : list) {
			String json = JSONObject.toJSONString(recordMain); // com.alibaba.fastjson.JSONObject
			ObjectMapper mapper = new ObjectMapper();// com.fasterxml.jackson.databind.ObjectMapper.ObjectMapper()
			try {
				Map<String, Object> m = mapper.readValue(json, Map.class);
				mapList.add(m);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mapList;
	}

}
