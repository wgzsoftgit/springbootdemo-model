$(function() {

	// table切换栏开始
	apiready = function() {
		api.parseTapmode();
	}
	var tab = new auiTab({
		element : document.getElementById("tab"),
	}, function(ret) {
		console.log(ret)
	});

	// 影藏切换 -----------------
	$(".the-details-info-net").hide();
	$(".the-details-info-guiji").hide();
	$("#tab").find("div").eq(1).click(function() {
		$(".the-details-info-net").show();
		$(".the-details-info").hide();
		$(".the-details-info-guiji").hide()

	})

	$("#tab").find("div").eq(0).click(function() {
		$(".the-details-info-net").hide();
		$(".the-details-info-guiji").hide()
		$(".the-details-info").show();
	})
	$("#tab").find("div").eq(2).click(function() {
		$(".the-details-info-guiji").show();
		$(".the-details-info-net").hide();
		$(".the-details-info").hide();
	})

	// table切换栏结束

	

	// 下拉框js开始----------------------自定义下拉
	$(function() {
		function dropDownCk(selectId, hiddenId) {
			var boxId = "#" + boxId, selectId = "#" + selectId, hiddenId = "#"
					+ hiddenId;

			$(selectId).click(function() { // 切换显示与隐藏

				$(hiddenId).toggle();

			});
			$(selectId).html(
					"<option checked='true' style='display:none;'>"
							+ "---请选择---" + "</option>");
		}

		var tag1 = dropDownCk("lang1", "ck1");
	})

	$("#check-all").click(
			function() {
				if ($("#check-all").is(':checked') == true) {
					$("#ck1").find("li").find("label").find(
							"input[type='checkbox']").prop("checked", true);
				} else {
					$("#ck1").find("li").find("label").find(
							"input[type='checkbox']").prop("checked", false);
				}
			})

	$(".check").click(
			function() {
				var checkFlag;
				for (var i = 1; i < 4; i++) {
					checkFlag = $("#ck1").find("li").eq(i).find("label").find(
							"input[type='checkbox']").is(':checked');
					if (checkFlag == false) {
						break;
					}
				}
				if (checkFlag == true) {
					$("#check-all").prop("checked", true);
				} else {
					$("#check-all").prop("checked", false);
				}

			})

	$("#check-all").prop("checked", false);
	for (var i = 1; i < 4; i++) {
		checkFlag = $("#ck1").find("li").eq(i).find("label").find(
				"input[type='checkbox']").prop("checked", false);
	}
	// 下拉框js结束

	var totalPage = 0;
	function getByParam(page, pageSize) {
		// 开始时间
		var startimeStr = $("[name='starTime']").val();
		// 结束时间
		var endtimeStr = $("[name='endingTime']").val();
		// 姓名
		var name = $("[name='name']").val();
		// 身份证号
		var idNum = $("[name='idNum']").val();
		// 未办证类型
		var typeArr = [];// 定义一个空数组
		$("input[name='checked']:checked").each(function(i) {// 把所有被选中的复选框的值存入数组
			typeArr[i] = $(this).val();
		});

		$.ajax({
					type : "post",
					url : "/sxxl-analysis/unregisteredPeople/getByParam",
					dataType : "json",
					traditional : true,
					async : false,
					data : {
						"startimeStr" : startimeStr,
						"endtimeStr" : endtimeStr,
						"name" : name,
						"idNum" : idNum,
						"typeArr" : typeArr,
						"page" : page,
						"pageSize" : pageSize
					},
					success : function(result) {
						totalPage = result.totalPage;
						var arr = result.unregisteredPeopleList;
						$("#total-count").text(result.totalCount);
						if (arr != null && arr.length > 0) {

							var str = "";
							var id = null;
							var type = null;
							var name = null;
							var faceImageUrl = null;
							var creationDateStr = null;
							var style = "";

							for (var i = 0; i < arr.length; i++) {
								id = arr[i].id;
								name = arr[i].name;
								faceImageUrl = arr[i].faceImageUrl;
								creationDateStr = arr[i].creationDateStr;
								var idNum = arr[i].idNum;
								if (arr[i].type == 1) {
									type = "前科未办证";
									style = "background:#F44F27;opacity:0.75;";
								} else if (arr[i].type == 2) {
									type = "涉案未办证";
									style = "background:#782F8E;opacity:0.75;";
								} else if (arr[i].type == 3) {
									type = "网吧未办证";
									style = "background:#1495E7;opacity:0.75;";
								}
								str = str
										+ "<li class='product_display' style='position: relative;'>"
										+ "<div style='width:138px;height: 178px;background-color:rgba(0,0,0,0.4);display:flex;align-items:center;justify-content:center'><img class='faceImg' width='29' height='5' src='/sxxl-analysis/resources/images/loading.gif' data-idnum='"+idNum+"'></img></div><div class='positionfix' style="
										+ style
										+ ">"
										+ type
										+ "</div> <input type='checkbox' class='singleAndDoubleselect hides' />"
										+ "<div class='display'>"
										+ "<div class='displayflex' style='justify-content: space-between; height: 20px;'>"
										+ "<span>"
										+ name
										+ "</span></div><span>"
										+ creationDateStr
										+ "</span></div><input type='hidden' value="
										+ id + " /><input type='hidden' value="
										+ idNum + " /></li>";
								
							}
						} else {
							// 如查询无数据则删除之前显示出的数据节点
							$("#warning-lists").empty();
							alert("没有符合条件的数据")

						}
						$("#warning-lists").html(str);
						
						$(".product_display").find("img").each(function(e){
							var img = $(this);
							$.ajax({
						        type : "GET",
						        url :  "http://41.220.15.37:8080/GetZdryzpWeb/fetchImage?idNum="+img.data('idnum'),
						        dataType: "json", // 预期服务器返回的数据类型
						        success : function(jsonData) { 
						        	img.removeAttr('width').removeAttr('height');
						            img.attr("src","data:image/png;base64,"+jsonData.content);//window.URL.createObjectURL(jsonData.content);
						        },error:function(a,b,c){
						        }
							});
						})
						
						$('#warning-lists li')
								.click(
										function() {
											$("#the-hotel-info").empty();
											$("#the-internet-info").empty();
											console.log('第' + $(this).index()
													+ JSON.stringify($(this))
													+ '个li被点击');
											/* $("#myModalLabel").text("新增"); */
											var uid = $(this).find("input").eq(
													1).val();
											var idNum = $(this).find("input")
													.eq(2).val();
											$
													.ajax({
														type : "post",
														url : "/sxxl-analysis/unregisteredPeople/getById",
														dataType : "json",
														data : {
															"idStr" : uid,
															"idNum" : idNum
														},
														success : function(
																result) {
															var type = null;
															var unregisteredPeople = result.unregisteredPeople;
															$("#name").text(unregisteredPeople.name);
															$("#age").text(unregisteredPeople.dateOfBirthStr);
															$("#sex").text(unregisteredPeople.gender)

															$("#id-card").text(unregisteredPeople.idNum);
															$("#address").text(unregisteredPeople.site)
//															$("#big-images").attr("src",unregisteredPeople.faceImageUrl);

															if (unregisteredPeople.type == 1) {
																type = "前科未办证";
																$(
																		".positionfix-big")
																		.css(
																				"background",
																				"#F44F27")
															} else if (unregisteredPeople.type == 2) {
																type = "涉案未办证";
																$(
																		".positionfix-big")
																		.css(
																				"background",
																				"#782F8E")
															} else if (unregisteredPeople.type == 3) {
																type = "网吧未办证";
																$(
																		".positionfix-big")
																		.css(
																				"background",
																				"#1495E7")
															}
															$("#type-big")
																	.text(type);
															
															$("#big-images").attr("src",'/sxxl-analysis/resources/images/loading.gif').attr('width',29).attr('height',5);
															// get face image
															$.ajax({
														        type : "GET",
														        url :  "http://41.220.15.37:8080/GetZdryzpWeb/fetchImage?idNum="+idNum,
														        dataType: "json", // 预期服务器返回的数据类型
														        success : function(jsonData) { 
														        	$("#big-images").removeAttr('width').removeAttr('height').attr("src","data:image/png;base64,"+jsonData.content);//window.URL.createObjectURL(jsonData.content);
														        },error:function(a,b,c){
														        }
															});

															var hotelActicities = "";
															var internetActicities = "";
															var hotelActivitiesList = result.hotelActivitiesList;
															var internetActivitiesList = result.internetActivitiesList;
															
															if (hotelActivitiesList.length > 0) {
																var count=0;
																for (var i = 0; i < hotelActivitiesList.length; i++) {
																	count=count+hotelActivitiesList[i].totalCount;
																	var poiName = hotelActivitiesList[i].poiName == null ? '' :hotelActivitiesList[i].poiName;
																	var poiAddress = hotelActivitiesList[i].poiAddress;
																	var totalCount = hotelActivitiesList[i].totalCount;
																	var maxCheckOutDate = hotelActivitiesList[i].maxCheckOutDate == null ? ' ': "退房时间 : "+hotelActivitiesList[i].maxCheckOutDate;
																	hotelActicities = hotelActicities
																			+ "<div style='width: 100%; height: 90px; display: flex; align-items: center; padding: 10px;justify-content: space-between;'>"
																			/*+ "<div style='width: 62px; height: 65px;'>"
																			+ "<img th:src='@{/resources/images/hotel1.jpg}'style='width: 100%; height: 100%;' />"
																			+ "</div>" */
																			+"<div style='display: flex; flex-direction: column; height: 80px; justify-content: center; margin: 10px'>"
																			+ "<span style='line-height: 30px;font-size:16px;'>"
																			+ poiName
																			+ "</span>"
																			+ " <span class='bottom-text'>"
																			
																			+ "</span></div>"
																			+ "<div class='count' style='width: 60px; height: 30px; display: flex; justify-content: center; align-items: center;'>"
																			+ "<span>"
																			+ totalCount
																			+ "次</span></div><div style='margin: 20px'>"
																			+ "<span class='bottom-text'>"
																			+ maxCheckOutDate
																			+ "</span></div></div>"
																}
																$("#hotel-count").text(count);
															} else {
																$("#hotel-count").text(0);
																hotelActicities="<div style='width: 100%; height: 90px; display: flex; align-items: center;justify-content: center; padding: 10px;'><span>暂无数据</span></div>"
															}
															$("#the-hotel-info").html(hotelActicities);
															
															if(internetActivitiesList.length>0){
																
																var count=0;
															for (var i = 0; i < internetActivitiesList.length; i++) {
																count=count+internetActivitiesList[i].totalCount;
																var poiName = internetActivitiesList[i].poiName== null ? ' ':internetActivitiesList[i].poiName;
																var poiAddress = internetActivitiesList[i].poiAddress;
																var totalCount = internetActivitiesList[i].totalCount;
																var maxCheckOutDate = internetActivitiesList[i].maxCheckOutDate == null ? ' ': "下机时间: "+internetActivitiesList[i].maxCheckOutDate;
																internetActicities = internetActicities
																		+ "<div style='width: 100%; height: 90px; display: flex; align-items: center; padding: 10px;justify-content: space-between;'>"
																		/*+ "<div style='width: 62px; height: 65px;'>"
																		+ "<img th:src='@{/resources/images/hotel1.jpg}'style='width: 100%; height: 100%;' />"
																		+ "</div>"*/
																		+"<div style='display: flex; flex-direction: column; height: 80px; justify-content: center; margin: 10px'>"
																		+ "<span style='line-height: 30px;font-size:16px;'>"
																		+ poiName
																		+ "</span>"
																		+ " <span class='bottom-text'>"
																		
																		+ "</span></div>"
																		+ "<div class='count' style='width: 60px; height: 30px; display: flex; justify-content: center; align-items: center;'>"
																		+ "<span>"
																		+ totalCount
																		+ "次</span></div><div style='margin: 20px'>"
																		+ "<span class='bottom-text'>"
																		+ maxCheckOutDate
																		+ "</span></div></div>"
															}
															$("#internet-count").text(count);
															}else{
																$("#internet-count").text(0);
																internetActicities="<div style='width: 100%; height: 90px; display: flex; align-items: center;justify-content: center; padding: 10px;'><span>暂无数据</span></div>"
															}
															$("#the-internet-info").html(internetActicities);
														}

													})

											$('#myModal').modal();
										});

					},
					error : function() {
						alert("异常")
					}
				});
		$("#emptyContainer").hide();
		$("#resultContainer").addClass("result-container").show();
	}

	$("#find").click(function() {
		getByParam(1,40);
		// 分页开始
		$('.M-box3').pagination({
			pageCount : totalPage,
			jump : true,
			coping : true,
			homePage : '首页',
			endPage : '末页',
			prevContent : '上页',
			nextContent : '下页',
			callback : function(api) {
				console.log(api.getCurrent())
				getByParam(api.getCurrent(), 40);
			}
		});
		// 分页结束
	})
	$('#warning-lists li').click(function() {
		$('#myModal').modal();
	});

})
