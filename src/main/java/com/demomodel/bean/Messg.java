package com.demomodel.bean;

public class Messg {
private String event;//标记为子系统日志消息，（必填）
private String regId;//平台子系统ID
private String userId;//平台用户UserId（必填）
private String userCode;//采用数字证书进行用户身份验证的应用系统，填写用户公民身份号码。未采用数字证书进行用户身份验证的应用系统/资源库，则填写警号   身份证>警号，
private String organization;//操作用户所属部门名称，orgName（必填）
private String organizationId;//操作用户所属部门名称编码，orgCode（必填）
private String organizationSn;//用户所属单位的公安机关机构代码，采用GA/T 543 DE00060 公安机关机构代码
private String userName;//平台用户UserName（必填）姓名
private String operateTime;//用户操作时的系统日期时间，采用格式YYYYMMDDThhmmssZ，24小时制格式（必填）时间采用0时区时间传输
private String terminalId;//操作终端的IP地址，例如客户端所在的PC机IP地址（必填）
private String macAddr;//Mac地址（选填）
private String operateType;//0：登录；1：查询；2：新增；3：修改；4：删除；5：布控；6：撤空；7:控制;8:登出；9：审核 其他操作类型由子系统提供，往后扩展（必填）日志子系统统一归档，不能由各服务自行编码
private String operateResult;//用户操作的结果，包括成功/失败。1:成功；0：失。操作结果，参照VSL日志目前的操作结果定义（必填）
private String errorCode;//当操作结果为失败时，可记录操作失败的原因代码，采用附录A：用户操作失败原因代码
private String operateName;//业务功能模块名称，参照VSL菜单字典表（必填）
private String operateCondition;//操作类型为0-登录时，置空；为其它类型时，可记录用户进行操作时的数据筛选条件，填写数据操作SQL语句的where子句内容，操作条件拼装成JSON格式返回，多个条件的拼装成一个对象转为JSON,多个对象拼装成list转成JSON
private String operateConditionOriginal;//原始操作条件，post请求的body或get请求的url参数。注：图片的base64数据请不要放到此字段中
private String functionCode;//模块功能名称编码，业务功能模块编码，参照VSL子系统字典表（必填）菜单编码
private String clientType;//1-桌面客户端2-Web客户端3-移动客户端4-Mac客户端 5-Android客户端6-Pad客户端7-其他客户端8-配置客户端如有需要，往下扩展（必填）
private String url;//图片信息，按业务需要入库 图片信息按照json方式传输，json中的字段暂定为imageUrl存放图片地址，memo存放图片说明。后续图片有更多信息可以增加字段。，
private String responseTime;//响应时间（毫秒数）
private String remark;//备注


}
