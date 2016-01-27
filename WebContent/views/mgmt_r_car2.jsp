﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>车辆信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
<script type="text/javascript" src="js/dynamic_div1.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<%@ include file="jsTool.jsp" %>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body onload="OnLoad()">

<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>

<div id="main_frame">
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的资源
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <%@ include  file="mysource_leftnav_mytrade.jsp"%> 
                    <%@ include  file="mysource_leftnav_myresource.jsp"%>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
			<td class="td_leftnav_top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
                    <tr>
                        <td>
                            <span class="span_mgmt_right2_text1">添加车辆信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
				</table>
				<form action="insertCar" method="post" name="insertCar" id="insertCar">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a">
                            <br />
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">牌照：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" id="carNum" name="carNum" required/></td>
                                </tr>
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">所属车队：</td>
                                    <td>
                                        <select style="width:120px;" name="carTeam" id="carTeam" required>
                                            <option value="" selected="selected">请选择</option>
                                            <!-- <option value="北京车队">北京车队</option>
                                            <option value="天津车队">天津车队</option>
                                            <option value="上海车队">上海车队</option> -->
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">定位方式：</td>
                                    <td>
                                        <select id="locationType" style="width:120px;" onchange="change_position();" name="locationType" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="GPS">GPS</option>
                                            <option value="手机">手机</option>
                                            <option value="无">无</option>
                                        </select>
                                        <div id="pos_detail_1" style="display:none;">
                                            <input type="text" class="input_mgmt1" style="width:176px;" placeholder="请输入终端设备编码..." name="terminalId"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">车型：</td>
                                    <td>
                                        <select style="width:120px;" id="carType" name="carType" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="前四后四">前四后四</option>
                                            <option value="单桥">单桥</option>
                                            <option value="其他">其他</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">厢型：</td>
                                    <td>
                                        <select style="width:120px;" id="carBase" name="carBase" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="普通">普通</option>
                                            <option value="平板">平板</option>
                                            <option value="厢式">厢式</option>
                                            <option value="开顶厢">开顶厢</option>
                                            <option value="集装箱">集装厢</option>
                                            <option value="高栏">高栏</option>
                                            <option value="其他结构">其他结构</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">品牌：</td>
                                    <td>
                                        <select name="carBrand" id="carBrand" class="select_apply1" style="width:120px;" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="解放">解放</option>
                                            <option value="福田">福田</option>
                                            <option value="东风">东风</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">用途：</td>
                                    <td>
                                        <select style="width:120px;" id="carUse" name="carUse" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="普通运输">普通运输</option>
                                            <option value="特殊">特殊</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">规格：</td>
                                    <td>
                                    长&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" id="carLength"name="carLength" required/>
                                    (米)&nbsp;&nbsp;×&nbsp;&nbsp;宽&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" id="carWidth" name="carWidth" required/>
                                    (米)&nbsp;&nbsp;×&nbsp;&nbsp;高&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" id="carHeight" name="carHeight" required/>
                                    (米)
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">载重：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" id="carWeight" name="carWeight" required/>
                                    (吨)
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">购置日期：</td>
                                    <td><input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" readonly="readonly" title="点击此处选择" id="purchaseTime" name="purchaseTime" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b" >冷藏：</td>
                                    <td>
                                        <select style="width:120px;" name="storage" id="storage" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="冷藏">是</option>
                                            <option value="非冷藏">否</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">司机姓名：</td>
                                    <td>
                                        <select style="width:120px;" id="driverId" name="driverId" required>
                                            <option value="" selected="selected">请选择</option>
                                            <c:forEach var="driverList" items="${driverList }">
                                            <option value="${driverList.id }">${driverList.driverName }</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运营线路：</td>
                                    <td id="cityselector">
                                    <div>
                                        <input id="city1" type="text" value="" class="input_city1" name="startPlace" required/>
                                        &nbsp;&nbsp;至&nbsp;&nbsp;
                                        <input id="city2" type="text" value="" class="input_city1" name="endPlace" required/>
                                    </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">经停城市：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${carInfo.stopPlace }" id="stopPlace" name="stopPlace" required/>
                                </tr>
                                <tr>
                                    <td height="1"></td>
                                    <td><div id="dym_citylist"></div></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
                                    <input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
                                </tr>
                            </table>
                            </
                        </td>
                    </tr>
                </table>
                </form>
			</td>
		</tr>
    </table>
</div>

<%@ include  file="popup1.jsp"%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		//获取公司车队列表
		getCompanyCarteamList();
		
		//表单验证
		formValidation();
	}
	
	function formValidation(){
		$("#insertCar").validate({
			rules : {
				carNum : "required",
				carTeam : "required",
				locationType : "required",
				carBase : "required",
				carBrand : "required",
				carUse : "required",
				city1: "required",
				city2 : "required",
				storage : "required",
				driverId : "required",
				purchaseTime : "required",
				carLength : {
					required : true,
					number : true
				},
				carHeight : {
					required : true,
					number : true
				},
				carWidth : {
					required : true,
					number : true
				},
				carWeight : {
					required : true,
					number : true
				},

			}
		});
	}
	
	$(function(){
		$('reset:button').click(function(){
		   $('.input').val("");
		   $('.select').val("");
		});
    })
    
    //获取公司车队列表
	function getCompanyCarteamList(){
		var url="getCompanyCarteamList";
		
		$.ajax({
			url:url,
			cache:false,
			dataType:"json",
			success:function(data,status){
				//alert(data);
				var carteam=$("#carTeam");
				for(var i=0;i<data.length;i++){
					var option=$("<option>").text(data[i].teamName).val(data[i].teamName);
					carteam.append(option);
				}
			}
		});
	}
</script>
</html>