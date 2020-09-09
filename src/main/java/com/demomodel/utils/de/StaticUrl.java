package com.demomodel.utils.de;

public interface StaticUrl {
	
   
	
	public final static String DATA_CENTER_3RD_HOST = "http://41.220.41.240:8888";

	public final static String URL_DATA_STANDARD = DATA_CENTER_3RD_HOST + "/SXDataStat";
	public final static String URL_DATA_RANKING = URL_DATA_STANDARD +"/sjfl"; //数据采集排名collectionRanking
	public final static String URL_STANDARD_DATA_ELEMENT = URL_DATA_STANDARD +"/sjbz"; //标准数据元dataElement
	public final static String URL_DATA_AGGREGATE_TREND=URL_DATA_STANDARD +"/sjzy";//总量趋势aggregateTrend
	public final static String URL_DATA_SERVICE=URL_DATA_STANDARD +"/sjfw";//sjfw  数据服务 dataService
	
	//ljh
	public final static String VEHICLE_FACE_PORT="http://41.220.41.31:8314";
	
	//通用设备信息请求路径
	public final static String DEVICE_INFO_URL ="/videoService/devicesManager/intelligent/channels?pageSize=512";
	
	// 当天车辆布控总数
	public final static String DEPLOY_CONTROL_URL = "/vehicleService/rest/daySurveyCount";
	
	// 车辆预警数
	public final static String WARNING_URL = "/vehicleService/rest/alarm/count";
	
	// 车辆通道预警数
	public final static String AISLE_WARNING_URL = "/vehicleService/rest/alarm";
		
	// 预警实时信息
	public final String REAL_TIME_URL = "/multiDataMiningService/rest/alarm/realTime?msgId=";

	// 防控圈url
	public final String PREVENT_CONTROLLER_URL = "/multiDataMiningService/rest/viewModel/models";

	// 当日预警总数url
	public final String TODAY_EARLY_WARNING_URL ="/multiDataMiningService/rest/alarm/todayCount";

	// 各类预警总数
	public final String RECORD_TYPES_URL ="/multiDataMiningService/rest/alarm/recordTypes";
	
	
	//测试接口
	public static  String RFIDANDMAC =VEHICLE_FACE_PORT+ "/videoService/devicesManager/intelligent/channels";
		
}
