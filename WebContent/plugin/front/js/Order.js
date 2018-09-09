var flag = false;
// 默认页码
var default_pageNo = 1;
// 默认每页呈现的记录数
var default_pageSize = 20;
$(function() {
	// 初始化地区选择器
	var $citypicker1 = $('#SenderProCityAres');

	var $citypicker2 = $('#AcceptProCityArea');
	$('.praise_type label').click(function() {
		$(this).addClass('checked').siblings().removeClass('checked');
	});
	// 网点名称绑定打开网点信息框架
	$('.net_list a').on('click', function() {
		$('.net_cont').show().siblings().hide();
	});
	// 网点信息或者快递员信息返回查询结果页面;
	$(".layer-back").click(function() {
		$('.search_cont').show().siblings().hide();
	});

	// 初始化给日期文本框中添加时间.不添加的话日期选择会出bug
	if (parseInt((new Date).getHours()) > 19) {
		document.getElementById("FetchTime").value = (new Date).getFullYear()
				+ "-" + ((new Date).getMonth() + 1) + "-"
				+ ((new Date).getDate() + 1);
	} else {
		document.getElementById("FetchTime").value = (new Date).getFullYear()
				+ "-" + ((new Date).getMonth() + 1) + "-"
				+ (new Date).getDate();
	}
	// 判断邮箱格式
	$("#SenderEmail").on(
			"change",
			function() {
				var _Y_NEmail = document.getElementById("_Y_NEmail");
				if ($("#SenderEmail").val() != "") {

					var _Emailval = InputVCheck('SenderEmail', 4, $(
							"#SenderEmail").val())
					if (_Emailval) {
						_Y_NEmail.textContent = "✔邮箱验证已通过"
						_Y_NEmail.style = "color:green";
					} else if (!_Emailval) {
						_Y_NEmail.textContent = "✘邮箱格式不正确";
						_Y_NEmail.style = "color:Red";
					}
				} else {
					_Y_NEmail.textContent = "";
				}
			});

	// 判断重量
	$("#Articleweight").on(
			"change",
			function() {
				var _Y_N_Articleweight = document
						.getElementById("_Y_N_Articleweight");
				if ($("#Articleweight").val() != "") {
					debugger;
					var _Emailval = $("#Articleweight").val()
					if (_Emailval <= 50 && _Emailval >= 0
							&& parseInt(_Emailval) == _Emailval) {
						_Y_N_Articleweight.textContent = "✔"
						_Y_N_Articleweight.style = "color:green";
					} else {
						_Y_N_Articleweight.textContent = "✘,重量为整数";
						_Y_N_Articleweight.style = "color:Red";
					}
				} else {
					_Y_N_Articleweight.textContent = "";
				}
			});

	// 判断发件人/收件人手机号格式
	$("#SenderPhone,#AcceptPhone").on("change", function() {
		// 发件人手机号格式判断
		var senderPhone = $("#SenderPhone").val();
		var _Y_N_SenderPhone = document.getElementById("_Y_N_SenderPhone");
		if (senderPhone != "") {
			var senderPhoneResult = InputVCheck('SenderPhone', 0, senderPhone)
			if (senderPhoneResult) {
				_Y_N_SenderPhone.textContent = "✔"
				_Y_N_SenderPhone.style = "color:green;width:10px";
			} else if (!senderPhoneResult) {
				_Y_N_SenderPhone.textContent = "✘"
				_Y_N_SenderPhone.style = "color:Red;width:10px";
			}
			var mobile = senderPhone;
			$.ajax({
				url : "/Order/WeChat",
				data : {
					mobile : mobile
				},
				type : "POST",
				success : function(result) {
					debugger;
					if (!result.Status) {
						var mobile = $("#SenderPhone").val();
						layer.open({
							type : 2,
							title : '经检测，您的手机号未绑定微信',
							area : [ '1030px', '850px' ],
							content : '/Service/WeChat?mobile=' + mobile,
						});
					}
				}
			});
		} else {
			_Y_N_SenderPhone.textContent = "";
		}
		// 收件人手机号格式判断
		var acceptPhone = $("#AcceptPhone").val();
		var _Y_N_AcceptPhone = document.getElementById("_Y_N_AcceptPhone");
		if (acceptPhone != "") {
			var acceptPhoneResult = InputVCheck('AcceptPhone', 0, acceptPhone)
			if (acceptPhoneResult) {
				_Y_N_AcceptPhone.textContent = "✔"
				_Y_N_AcceptPhone.style = "color:green;width:10px";
			} else if (!acceptPhoneResult) {
				_Y_N_AcceptPhone.textContent = "✘"
				_Y_N_AcceptPhone.style = "color:Red;width:10px";
			}
		} else {
			_Y_N_AcceptPhone.textContent = "";
		}
	});
	// 发件人座机号,收件人座机号判断
	$("#SenderMobile,#AcceptMobile").on("change", function() {
		// 发件人座机号格式判断
		var senderPhone = $("#SenderMobile").val();
		var _Y_N_SenderPhone = document.getElementById("_Y_N_SenderMobile");
		if (senderPhone != "") {
			var senderPhoneResult = InputVCheck('SenderMobile', 1, senderPhone)
			if (senderPhoneResult) {
				_Y_N_SenderPhone.textContent = "✔"
				_Y_N_SenderPhone.style = "color:green;width:10px";
			} else if (!senderPhoneResult) {
				_Y_N_SenderPhone.textContent = "✘"
				_Y_N_SenderPhone.style = "color:Red;width:10px";
			}
		} else {
			_Y_N_SenderPhone.textContent = "";
		}
		// 收件人座机号格式判断
		var acceptPhone = $("#AcceptMobile").val();
		var _Y_N_AcceptPhone = document.getElementById("_Y_N_AcceptMobile");
		if (acceptPhone != "") {
			var acceptPhoneResult = InputVCheck('AcceptMobile', 1, acceptPhone)
			if (acceptPhoneResult) {
				_Y_N_AcceptPhone.textContent = "✔"
				_Y_N_AcceptPhone.style = "color:green;width:10px";
			} else if (!acceptPhoneResult) {
				_Y_N_AcceptPhone.textContent = "✘"
				_Y_N_AcceptPhone.style = "color:Red;width:10px";
			}
		} else {
			_Y_N_AcceptPhone.textContent = "";
		}
	})
	// 限制文本框输入字符长度
	$("#SenderPhone,#AcceptPhone").on('keyup', function() {
		var value = $(this).val();
		if (value.length > 11) {
			$(this).val(GetStrSub(value, 11));
		}
	});
	// 弹出违禁品须知界面
	$("#orderInstruction2").click(function() {
		layer.open({
			type : 2,
			title : '违禁品须知',
			area : [ '1000px', '800px' ],
			content : '/Service/OrderInstruction2'
		});
	})

	// 地区控件触发事件（绑定父元素，调用子元素，触发事件）
	$("#SenderProCityAres").parent('.area_box').on("click", '.district dd a',
			function() {
				LoadPageData();
			});

	$(".layer-close").click(function() {
		// 关闭弹出框并刷新页面
		showHide();
	});
})

// 关闭界面
function closeWindow(code, fullName) {
	// 关闭弹出框并给隐藏域赋值
	showHide();
	$("#companyName").show();
	$("#companyName").text("下单到 " + fullName + "(" + code + ")");
	$("#TakeCompanyCode").val(code)
}
// 打开界面
function showHide() {
	$(".layer-shade").toggle();
}
// 省市区分页数据
function LoadPageData() {
	debugger;
	var privance = ""; // 省份
	var city = "";// 城市
	var district = "";// 街道
	$(".city-picker-span").find("span.title").find("span.select-item").each(
			function(index, element) {
				var type = $(element).attr("data-count");
				var code = $(element).attr("data-code");
				if (type === "province") {
					privance = code;
				} else if (type === "city") {
					city = code;
				} else if (type === "district") {
					district = code;
				}
			});
	LoadDataByArea(privance, city, district);
	return false;
}

// 根据省市区获取网点数据
function LoadDataByArea(provice, city, district) {
	if (provice.length != 0 && city.length != 0) {
		debugger;
		var datas = {};// 参数集合
		datas["provinceId"] = provice;
		datas["cityId"] = city;
		datas["districtId"] = district;
		datas["from"] = (default_pageNo - 1) * default_pageSize;
		datas["size"] = default_pageSize;
		$.ajax({
			type : "POST",
			url : "/Site/GetOranizeByAreas",
			data : datas,
			success : function(result) {

				$("#organizeCount").text("");
				if (result.Status == true) {

					var conunt = 0;
					if (result.Data.length > 20) {
						result.RecordCount = result.Data.length;
					}

					if (result.RecordCount % default_pageSize == 0) {
						conunt = result.RecordCount / default_pageSize;
					} else {
						conunt = Math.floor(result.RecordCount
								/ default_pageSize) + 1;
					}
					if (conunt == 0) {
						conunt = 1;
					}
					// 绑定模板
					$('#organizeList').empty();
					$("#organizeTemplate").tmpl(result.Data).appendTo(
							'#organizeList');
					$("#organizeCount").text('(' + result.RecordCount + ')');
					$('.layer-shade').show();
				} else {
					layer.alert(result.StatusMessage);
				}
			}
		});
	} else {
		layer.msg("省市区必选");
	}

}

// 截取字符串
function GetStrSub(str, lth) {
	var resultStr = "";
	if (str == undefined || str == "") {
		resultStr = "";
	} else {
		if (str.length > lth) {
			resultStr = str.substring(0, lth);
		} else {
			resultStr = str;
		}
	}
	return resultStr;
}
// 日期选择插件绑定
$(function() {
	// 日期选择
	$("#FetchTime").on("click", function(e) {
		document.getElementById("Fetchstartdate").value = null;
		document.getElementById("Fetchenddate").value = null;
		e.stopPropagation();
		$(this).lqdatetimepicker({
			css : 'datetime-day',
			dateType : 'D',
			selectback : function() {
			}
		});
	});
	// 开始时间
	$("#Fetchstartdate")
			.on(
					"click",
					function(e) {
						document.getElementById("Fetchenddate").value = null;
						if (document.getElementById("FetchTime").value == "") {
							// alert( "抱歉您没有选择日期" )
							layer.alert('抱歉您没有选择日期', {
								icon : 6
							});
						} else {
							var _SenderTime = document
									.getElementById("Fetchstartdate").value;
							var s = parseInt((new Date).getFullYear() + ""
									+ ((new Date).getMonth() + 1) + ""
									+ (new Date).getDate())// 年月日,数值转int
							if (parseInt($("#FetchTime").val().replace('-', '')
									.replace('-', '')) == s) {
								e.stopPropagation();
								$(this).lqdatetimepicker({
									css : 'datetime-hour'
								}, "");
							} else if (parseInt($("#FetchTime").val().replace(
									'-', '').replace('-', '')) > s) {
								e.stopPropagation();
								$(this).lqdatetimepicker2({
									css : 'datetime-hour'
								}, "");
							} else {
								layer.alert('抱歉您选择的时间已经成为过去!')
							}
						}
					});
	// 结束时间
	$("#Fetchenddate").on(
			"click",
			function(e) {
				if (document.getElementById("FetchTime").value == "") {
					layer.alert("抱歉您没有选择日期")
				} else {
					var time = $("#Fetchstartdate").val();
					var times = time.split(':');
					var a = new Date(2017, 4, 19, parseInt(times[0]),
							parseInt(times[1]));
					var _SenderTime = addMinutes(90, a).getHours() + ":"
							+ addMinutes(90, a).getMinutes();
					var s = parseInt((new Date).getFullYear() + ""
							+ ((new Date).getMonth() + 1) + ""
							+ (new Date).getDate())
					if (parseInt($("#FetchTime").val().replace('-', '')
							.replace('-', '')) == s) {
						e.stopPropagation();
						$(this).lqdatetimepicker({
							css : 'datetime-hour'
						}, _SenderTime);
					} else if (parseInt($("#FetchTime").val().replace('-', '')
							.replace('-', '')) > s) {
						e.stopPropagation();
						$(this).lqdatetimepicker2({
							css : 'datetime-hour'
						}, _SenderTime);
					} else {
						layer.alert('抱歉您选择的时间已经成为过去!')
					}
				}
			});
});

// 添加分钟
function addMinutes(dayNumber, date) {
	date = date ? date : new Date();
	var ms = dayNumber * (1000 * 60)
	var newDate = new Date(date.getTime() + ms);
	return newDate;
}
// Ajax查询时效路由
function selectTimePrice() {
	var senderProCityAres = $("#SenderProCityAres").val();
	var acceptProCityArea = $("#AcceptProCityArea").val();
	var articleweight = $("#Articleweight").val();
	debugger;
	if (parseInt(articleweight) != articleweight) {
		layer.alert("备注：重量为整数，且条例规定不足一公斤按一公斤计算。");
		return false;
	}
	if (senderProCityAres != "" && articleweight != ""
			&& acceptProCityArea != "") {
		if (senderProCityAres.split('/').length - 1 == 2) {
			if (acceptProCityArea.split('/').length - 1 == 2) {
				$.ajax({
					url : "/Service/GetPriceMessage",
					type : "Post",
					data : {
						startCity : senderProCityAres,
						endCity : acceptProCityArea,
						weight : articleweight,
					},
					success : function(result) {
						if (result.Status == true) {
							var time = document.getElementById("Time");
							var price = document.getElementById("Price");
							time.value = result.Data.Time;
							price.value = result.Data.Price + "元";
						} else {
							layer.alert("抱歉没有查到相关信息");
						}
					}
				})
			} else {
				layer.alert("抱歉,您的收件地址还没有选择完毕!")
			}
		} else {
			layer.alert("抱歉,您的发件地还没有选择完毕!");
		}
	} else {

		layer.alert("抱歉,发件区县,收件区县和物品重量不能为空");
	}
}
// 提交前校验
function submitForm(o) {
	var SenderProCityAres = $("#SenderProCityAres").val();
	var Articleweight = $("#Articleweight").val()
	var SenderAddress = $("#SenderAddress").val();
	var SenderName = $("#SenderName").val();
	var AcceptProCityArea = $("#AcceptProCityArea").val();
	var AcceptAddress = $("#AcceptAddress").val();
	var AcceptName = $("#AcceptName").val();
	var Email = $("#SenderEmail").val();
	// 判断选择的日期是否大于今天的日期
	var _date = new Date();
	var dateNow = _date.toLocaleDateString();
	dateNow = dateNow.replace('/', '');
	dateNow = parseInt(dateNow.replace('/', ''))// 日期选择结果为yyyy/MM/dd 的形式,所以替换2次/
	var FetchTime = parseInt($("#FetchTime").val().replace('-', '').replace(
			'-', ''));//
	if (FetchTime < dateNow) {
		layer.alert("抱歉,您选择的日期已成为过去!")
		return false;
	}
	if (Articleweight > 50 || Articleweight < 0) {
		layer.alert("重量不得大于50kg或小于0kg");
		return false;
	}
	// //校验所有的数据是否有值,如果有的话提示
	// if ( SenderProCityAres == "" || SenderEmail == "" || SenderAddress == ""
	// || SenderName == "" || AcceptProCityArea == "" || AcceptAddress == "" ||
	// AcceptName == "" )
	// {
	// layer.alert( "尊敬的客户,请补全信息!" )
	// return false;
	// }
	// 校验所有的数据是否有值,如果有的话提示
	if (SenderProCityAres == "" || SenderAddress == ""
			|| AcceptProCityArea == "" || AcceptAddress == "") {
		layer.alert("抱歉,收发件地址及详细地址必填")
		return false;
	}
	if (SenderName == "" || AcceptName == "") {
		layer.alert("抱歉,寄件人姓名及收件人姓名必填")
		return false;
	}
	// 校验手机号和座机号是否至少填写了一项
	if ($("#SenderPhone").val() == "" && $("#SenderMobile").val() == "") {
		layer.alert("抱歉,发件人手机号和座机号码至少填写一项")
		return false;
	}
	if ($("#AcceptPhone").val() == "" && $("#AcceptMobile").val() == "") {
		layer.alert("抱歉,收件人手机号和座机号至少填写一项");
		return false;
	}
	// 开始校验所有的内容格式是否正确
	// 校验城市列表是否已经全部选择完毕,是否存在xx省-xx市-?的情况.
	var Senderlen = SenderProCityAres.split('/').length - 1;
	var Acceptlen = AcceptProCityArea.split('/').length - 1;
	if (Senderlen != 2) {
		layer.alert("抱歉您的发件区域地址没有选择完毕")
		return false;
	}
	if (Acceptlen != 2) {
		layer.alert("抱歉您的区域地址没有选择完毕")
		return false;
	}
	// 提交前又一次校验手机号和邮箱的格式,用户可能存在修改
	if (!InputVCheck('SenderPhone', 0, $("#SenderPhone").val())) {
		layer.alert("抱歉发件人手机号格式不正确!")
		return false;
	}
	if (!InputVCheck('AcceptPhone', 0, $("#AcceptPhone").val())) {
		layer.alert("抱歉收件人手机号格式不正确!")
		return false;
	}
	if (!InputVCheck('SenderMobile', 1, $("#SenderMobile").val())) {
		layer.alert("抱歉发件人人座机号格式不正确!")
		return false;
	}
	if (!InputVCheck('AcceptMobile', 1, $("#AcceptMobile").val())) {
		layer.alert("抱歉收件人座机号格式不正确!")
		return false;
	}
	if (!InputVCheck('SenderEmail', 4, $("#SenderEmail").val())) {
		layer.alert("抱歉邮箱填写不正确!")
		return false;
	}
	// 开始检测上取件开始和结束时间是否合理
	var Fetchstartdate = parseInt($("#Fetchstartdate").val().replace(':', ''));
	var Fetchenddate = parseInt($("#Fetchenddate").val().replace(':', ''));
	if (Fetchstartdate > Fetchenddate || Fetchstartdate == Fetchenddate) {
		layer.alert("抱歉开始时间不能早等于结束时间")
		return false;
	}

	ajaxPostOrderCreate()
}

// Ajax请求验证
function ajaxPostOrderCreate() {
	if (flag) {
		return;
	}
	flag = true;
	// 请求提交
	function dd() {
		debugger;
		// layer.alert( "正在提交中，请稍等~" );
		layer.msg('正在提交中，请稍等', {
			icon : 16,
			shade : 0.05
		});
		var sereach = {};
		// 下单给业务员
		sereach["TakeUserCode"] = $("#TakeUserCode").val();
		// 下单给网点
		sereach["TakeCompanyCode"] = $("#TakeCompanyCode").val();
		// 1.发件人信息
		sereach["SenderProCityAres"] = $("#SenderProCityAres").val().replace(
				'/', '-').replace('/', '-');
		sereach["SenderAddress"] = $("#SenderAddress").val();
		sereach["SenderName"] = $("#SenderName").val();
		sereach["SenderPhone"] = $("#SenderPhone").val();
		sereach["SenderEmail"] = $("#SenderEmail").val();
		sereach["SenderMobile"] = $("#SenderMobile").val();
		// 2.收件人信息
		sereach["AcceptProCityArea"] = $("#AcceptProCityArea").val().replace(
				'/', '-').replace('/', '-');
		sereach["AcceptAddress"] = $("#AcceptAddress").val();
		sereach["AcceptName"] = $("#AcceptName").val();
		sereach["AcceptPhone"] = $("#AcceptPhone").val();
		sereach["AcceptMobile"] = $("#AcceptMobile").val();
		// 3.其他
		sereach["hiddenItemType"] = $("#hiddenItemType").val();// 物品类型
		sereach["Articleweight"] = $("#Articleweight").val();// 物品重量
		sereach["Cusnote"] = $("#Cusnote").val();// 备注信息
		sereach["FetchTime"] = $("#FetchTime").val();// 取件日期
		sereach["Fetchstartdate"] = $("#Fetchstartdate").val();// 取件时间开始
		sereach["Fetchenddate"] = $("#Fetchenddate").val();// 取件时间结束
		// 请求
		$.ajax({
			url : "/exp/front/order/add.jhtml",
			type : "POST",
			data : sereach,
			success : function(data) {
				data = eval('('+data+')');
				if (data.code == "200") {
					layer.alert("您已下单成功！");
					//刷新或跳转
					var SenderProCityAres = $("#SenderProCityAres").val();
					var SenderAddress = $("#SenderAddress").val();
//					if (SenderProCityAres != null && SenderProCityAres != "" && SenderProCityAres != undefined) {
						window.location.href = "/exp/static/front/frontordersucess.jsp";
//						window.location.href = "/exp/static/front/frontordersucess.jsp?orderid="+data.details+"&sendaddid=" + SenderProCityAres + SenderAddress;
//					}

				} else {
					layer.alert(data.mess);
				}
				flag = false;
			},
			failed : function() {
				flag = false;
			}
		})
	}
	dd()
}
// 按钮选择情况
function ItemType(value) {
	debugger;
	$("#hiddenItemType").val(value);
}
// 按钮选择情况
function ItemType2(value) {
	debugger;
	var other = $('#other').val()
	if (other != null && other != "" && other != undefined) {
		debugger;
		if (other.length <= 10) {
			$("#hiddenItemType").val(value);
		} else {
			layer.alert("最多十个字段");
		}

	}

}