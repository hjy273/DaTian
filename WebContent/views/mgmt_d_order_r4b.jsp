<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我收到的订单</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/rating2.js"></script>
<script type="text/javascript" src="js/jquery.raty.min.js"></script>
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
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的交易
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>我的交易</span>
                    <div id="mgmt_nav1">
                        <a href="getallfocus" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                       	<% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="getallresponse" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
                         <%} %>
                      <% if((Integer)session.getAttribute("userKind") ==2) {%> <!-- 普通用户 -->
                        <a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的订单</a>
                      <%} %>
                      <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="recieveorderinfo" class="a_mgmt_leftnav1" hidefocus="true">我收到的订单</a>
                       <%} %>
                        <a href="mysettlement" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <% if((Integer)session.getAttribute("userKind") ==2) {%>  <!-- 普通用户 -->
                        <a href="mycomplaint" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                       <%} %>
						</div>
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
                        	<span class="span_mgmt_right2_text1">我收到的订单</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                	</tr>
            	</table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a">
                        	<div class="span_mgmt_right3_text4">物流信息</div>
                            <!-- <div class="span_mgmt_right3_text2a"><a href="mgmt_d_order_s7.htm" hidefocus="true">切换到货物轨迹</a></div>
                            <table width="90%" border="0" cellspacing="0" cellpadding="0" style="clear:both; margin-left:24px;">
                                <tr>
                                    <td width="120" height="35" class="td_mgmt_right3_td1c">2014-03-11 12:29:33</td>
                                    <td class="td_mgmt_right3_td1c">货物已装车，车牌号：京E45785<img src="images/btn_map3a.png" alt="GPS定位" /></td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                                <tr>
                                    <td height="35" class="td_mgmt_right3_td1c">2014-03-11 18:40:30</td>
                                    <td class="td_mgmt_right3_td1c">货物已经达到济南</td>
                                </tr>
                            </table> -->
                            <br />
                        	<div class="span_mgmt_right3_text4">基本信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">订单编号：</td>
                                    <td>${orderInfo.orderNum }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">承运方：</td>
                                    <td>${orderInfo.carrierName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">承运方合同：</td>
                                    <td>${orderInfo.hasCarrierContract }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">资源分类：</td>
									<td>${orderInfo.resourceType }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">资源名称：</td>
									<td>${orderInfo.resourceName }</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">货物信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">货物名称：</td>
                                    <td>${orderInfo.goodsName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物重量：</td>
                                    <td>${orderInfo.goodsWeight } (公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物体积：</td>
                                    <td>${orderInfo.goodsVolume } (立方米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物声明价值：</td>
                                    <td>${orderInfo.declaredPrice } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">保险费：</td>
                                    <td>${orderInfo.insurance } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运费：</td>
                                    <td>${orderInfo.expectedPrice } (元)</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">地址信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">发货人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td width="250">&nbsp;</td>
                                    <td width="100" class="td_mgmt_right3_td1b">收货人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">姓名：</td>
                                    <td>${orderInfo.deliveryName }</td>
                                    <td class="td_mgmt_right3_td1b">姓名：</td>
                                    <td>${orderInfo.recieverName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">地址：</td>
                                    <td>${orderInfo.deliveryAddr }</td>
                                    <td class="td_mgmt_right3_td1b">地址：</td>
                                    <td>${orderInfo.recieverAddr }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">电话：</td>
                                    <td>${orderInfo.deliveryPhone }</td>
                                    <td class="td_mgmt_right3_td1b">电话：</td>
                                    <td>${orderInfo.recieverPhone }</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">备注信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">备注：</td>
                                    <td>${orderInfo.remarks }</td>
                                </tr>
                            </table>
                        
                        	<div class="span_mgmt_right3_text4">签收图像</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <!-- <td width="120" height="40" class="td_mgmt_right3_td1b">签收图像：</td> -->
                                    <td><a href="file/signBill/${orderInfo.acceptPicture }" target="_blank" hidefocus="true"><img src="file/signBill/${orderInfo.acceptPicture }" /></a></td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">最终运费</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">合同规定运费：</td>
                                    <td>${orderInfo.expectedPrice } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">订单运费：</td>
                                    <td>${orderInfo.expectedPrice } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">最终运费：</td>
                                    <td>${orderInfo.actualPrice } (元)</td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">说明：</td>
									<td>${orderInfo.explainReason }</td>
								</tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">评价信息</div>      	          
                            <div id="div_rating">
                                <div class="div_rating_sub">
                                    <div class="div_rating_left">服务态度</div>
                                    <div id="rating1" style="float:left;" data-score="0"></div>
                                    <%-- <c:choose>
                                    	<c:when test="${comment.serviceAttitude == '很好'}">
                                    		<div id="rating1" style="float:left;" data-score="5"></div>
                                    	</c:when>
                                    	<c:when test="${comment.serviceAttitude == '好'}">
                                    		<div id="rating1" style="float:left;" data-score="4"></div>
                                    	</c:when>
                                    	<c:when test="${comment.serviceAttitude == '一般'}">
                                    		<div id="rating1" style="float:left;" data-score="3"></div>
                                    	</c:when>
                                    	<c:when test="${comment.serviceAttitude == '差'}">
                                    		<div id="rating1" style="float:left;" data-score="2"></div>
                                    	</c:when>
                                    	<c:when test="${comment.serviceAttitude == '很差'}">
                                    		<div id="rating1" style="float:left;" data-score="1"></div>
                                    	</c:when>
                                    </c:choose> --%>
                                    <div class="div_rating_right"><input id="hint1" type="text" value="${comment.serviceAttitude }" class="input_rating" /></div>
                                </div>
                                <div class="div_rating_sub">
                                    <div class="div_rating_left">运输时效</div>
                                    <div id="rating2" style="float:left;" data-score="0"></div>
                                    <%-- <c:choose>
                                    	<c:when test="${comment.transportEfficiency == '很好'}">
                                    		<div id="rating2" style="float:left;" data-score="5"></div>
                                    	</c:when>
                                    	<c:when test="${comment.transportEfficiency == '好'}">
                                    		<div id="rating2" style="float:left;" data-score="4"></div>
                                    	</c:when>
                                    	<c:when test="${comment.transportEfficiency == '一般'}">
                                    		<div id="rating2" style="float:left;" data-score="3"></div>
                                    	</c:when>
                                    	<c:when test="${comment.transportEfficiency == '差'}">
                                    		<div id="rating2" style="float:left;" data-score="2"></div>
                                    	</c:when>
                                    	<c:when test="${comment.transportEfficiency == '很差'}">
                                    		<div id="rating2" style="float:left;" data-score="1"></div>
                                    	</c:when>
                                    </c:choose> --%>
                                    <div class="div_rating_right"><input id="hint2" type="text" value="${comment.transportEfficiency }" class="input_rating" /></div>
                                </div>
                                <div class="div_rating_sub">
                                    <div class="div_rating_left">货物安全</div>
                                    <div id="rating3" style="float:left;" data-score="0"></div>
                                    <%-- <c:choose>
                                    	<c:when test="${comment.cargoSafety == '很好'}">
                                    		<div id="rating3" style="float:left;" data-score="5"></div>
                                    	</c:when>
                                    	<c:when test="${comment.cargoSafety == '好'}">
                                    		<div id="rating3" style="float:left;" data-score="4"></div>
                                    	</c:when>
                                    	<c:when test="${comment.cargoSafety == '一般'}">
                                    		<div id="rating3" style="float:left;" data-score="3"></div>
                                    	</c:when>
                                    	<c:when test="${comment.cargoSafety == '差'}">
                                    		<div id="rating3" style="float:left;" data-score="2"></div>
                                    	</c:when>
                                    	<c:when test="${comment.cargoSafety == '很差'}">
                                    		<div id="rating3" style="float:left;" data-score="1"></div>
                                    	</c:when>
                                    </c:choose> --%>
                                    <div class="div_rating_right"><input id="hint3" type="text" value="${comment.cargoSafety }" class="input_rating" /></div>
                                </div>
                                <div class="div_rating_sub">
                                    <div class="div_rating_left">总体费用</div>
                                    <div id="rating4" style="float:left;" data-score="0"></div>
                                    <%-- <c:choose>
                                    	<c:when test="${comment.totalMoney == '很好'}">
                                    		<div id="rating4" style="float:left;" data-score="5"></div>
                                    	</c:when>
                                    	<c:when test="${comment.totalMoney == '好'}">
                                    		<div id="rating4" style="float:left;" data-score="4"></div>
                                    	</c:when>
                                    	<c:when test="${comment.totalMoney == '一般'}">
                                    		<div id="rating4" style="float:left;" data-score="3"></div>
                                    	</c:when>
                                    	<c:when test="${comment.totalMoney == '差'}">
                                    		<div id="rating4" style="float:left;" data-score="2"></div>
                                    	</c:when>
                                    	<c:when test="${comment.totalMoney == '很差'}">
                                    		<div id="rating4" style="float:left;" data-score="1"></div>
                                    	</c:when>
                                    </c:choose> --%>
                                    <div class="div_rating_right"><input id="hint4" type="text" value="${comment.totalMoney }" class="input_rating" /></div>
                                </div>
                                <div class="div_rating_sub">
                                	补充：${comment.comment }
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
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
		
		//set comment star
		setStar();
	}
	//设置评价星形效果
	function setStar(){
		var serviceAttitude="${comment.serviceAttitude}";
		var transportEfficiency="${comment.transportEfficiency}";
		var cargoSafety="${comment.cargoSafety}";
		var totalMoney="${comment.totalMoney}";
		debugger;
		if(serviceAttitude == '很好'){
			$("#rating1").attr("data-score","5");
		}else if(serviceAttitude =='好'){
			$("#rating1").attr("data-score","4");
		}else if(serviceAttitude == '一般'){
			$("#rating1").attr("data-score","3");
		}else if(serviceAttitude =='差'){
			$("#rating1").attr("data-score","2");
		}else{
			$("#rating1").attr("data-score","1");
		}
		
		if(transportEfficiency == '很好'){
			$("#rating2").attr("data-score","5");
		}else if(transportEfficiency =='好'){
			$("#rating2").attr("data-score","4");
		}else if(transportEfficiency == '一般'){
			$("#rating2").attr("data-score","3");
		}else if(transportEfficiency =='差'){
			$("#rating2").attr("data-score","2");
		}else{
			$("#rating2").attr("data-score","1");
		}
		alert($("#rating2").attr("data-score"));
		if(cargoSafety == '很好'){
			$("#rating3").attr("data-score","5");
		}else if(cargoSafety =='好'){
			$("#rating3").attr("data-score","4");
		}else if(cargoSafety == '一般'){
			$("#rating3").attr("data-score","3");
		}else if(cargoSafety =='差'){
			$("#rating3").attr("data-score","2");
		}else{
			$("#rating3").attr("data-score","1");
		}
		
		if(totalMoney == '很好'){
			$("#rating4").attr("data-score","5");
		}else if(totalMoney =='好'){
			$("#rating4").attr("data-score","4");
		}else if(totalMoney == '一般'){
			$("#rating4").attr("data-score","3");
		}else if(totalMoney =='差'){
			$("#rating4").attr("data-score","2");
		}else{
			$("#rating4").attr("data-score","1");
		}
	}
</script>
</html>