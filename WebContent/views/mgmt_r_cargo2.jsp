<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>货物信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
<script type="text/javascript" src="js/dynamic_div1.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
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
                    <%-- <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span
							id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起"
							onclick="mgmt_nav_switch2a();"></span><span
							id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开"
							onclick="mgmt_nav_switch2b();"></span>我的资源</span>
						<div id="mgmt_nav2">
                       <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="linetransport?flag=1&Display=10&PageNow=1" class="a_mgmt_leftnav" hidefocus="true">干线运输线路信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">城市配送网络信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库信息</a>
						<a href="driver?flag=1" class="a_mgmt_leftnav" hidefocus="true">司机信息</a>
                        <%} %>
                        <% if((Integer)session.getAttribute("userKind") ==2) {%><!-- 个人用户 -->
                        <a href="client" class="a_mgmt_leftnav" hidefocus="true">客户信息</a>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav1" hidefocus="true">货物信息</a>
                        <a href="contract" class="a_mgmt_leftnav" hidefocus="true">合同信息</a>
                        <%} %>
                        
                    </div> --%>
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
                            <span class="span_mgmt_right2_text1">添加货物信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br />   	          
                            <form action="insertGoods"  method="post" id="insertGoods" name="insertGoods" enctype="multipart/form-data"> 
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">货物名称：</td>
                                    <td><input type="text" class="input_mgmt1" id="name" name="name" style="width:300px;" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">类型：</td>
                                    <td>
                                        <input type="radio" name="type" checked="checked" value="医药" hidefocus="true" />医药&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="type" value="电子仪器" hidefocus="true" onclick="content_switch2();" />电子仪器&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="type" value="服装" hidefocus="true" onclick="content_switch3();" />服装
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">重量：</td>
                                    <td><input type="text" class="input_mgmt1" id="weight" name="weight" style="width:300px;" required/>
                                    (吨)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运输类型：</td>
                                    <td>
                                        <input type="radio" name="transportType" value="整车" checked="checked" hidefocus="true" />整车&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="transportType" value="零担" hidefocus="true" />零担
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">关于运输的要求：</td>
                                    <td><input type="text" class="input_mgmt1" id="transportReq" name="transportReq" style="width:300px;" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">线路起止：</td>
                                    <td id="cityselector">
                                        <input id="city1" type="text" value="" name="startPlace" class="input_city1" /><span class="span_mgmt_dynamic1" required>至</span><input id="city2" type="text" value="" name="endPlace" class="input_city1" required/>
                                        <!--<img src="images/btn_add2.png" hidefocus="true" style="cursor:pointer;" title="添加" onclick="addcity2();" />-->
                                    </td>
                                </tr>
                                <tr>
                                    <td height="1"></td>
                                    <td><div id="dym_citylist"></div></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">关于赔偿的要求：</td>
                                    <td><input type="text" class="input_mgmt1" id="damageReq" name="damageReq" style="width:300px;" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">增值服务：</td>
                                    <td>
                                        <select id="VIPService" style="width:110px;" name="vipservice" onchange="changeHasVIPService2();" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="需要">需要</option>
                                            <option value="不需要">不需要</option>
                                        </select>
                                        <div id="c_detail" style="display:none;">
                                            <input type="text" name="vipServiceDetail" class="input_mgmt1" style="width:186px;" placeholder="请输入内容..."/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">发送对象：</td>
                                    <td>
                                        <select id="valueadd" style="width:110px;" name="oriented" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="用户">用户</option>
                                            <option value="平台">平台</option>
                                        </select>
                                        <!-- <div id="v_detail" style="display:none;">
                                            <select style="width:93px;" name="user">
                                                <option name="orienteUser" value="" selected="selected">请选择</option>
                                                <option value="全体用户">全体用户</option>
                                                <option value="承运方">承运方</option>
                                                <option value="大田分公司">大田分公司</option>
                                            </select>
                                        </div> -->
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">有效期至：</td>
                                    <td><input type="text" class="input_date1" title="点击此处选择" id="limitDate" name="limitDate" onclick="SelectDate(this,'yyyy-MM-dd')" readonly="readonly" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">发票要求：</td>
                                    <td>
                                        <select style="width:110px;" id="invoice" name="invoice" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="需要">需要</option>
                                            <option value="不需要">不需要</option>
                                        </select>
                                    </td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">相关材料：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" name="relatedMaterial" style="width:230px;" value="" /><input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
      <input id="upload_btn4" type="file" name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0]" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" required/>
                                        </div>
                                    </td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
									<td>
                                    	<textarea class="textarea_rating" placeholder="请输入内容..." id="remarks" name="remarks" required></textarea>
                                    </td>
								</tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td>
                                    	<input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
                                    	<input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
                                    </td>
                                </tr>
                            </table>
                            </form>
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
		//validate
		formValidate();
	}
	
	function formValidate(){
		$("#insertGoods").validate({
			rules : {
				name : "required",
				transportReq : "required",
				damageReq : "required",
				city1 : "required",
				VIPService : "required",
				valueadd : "required",
				limitDate : "required",
				remarks : "required",
				weight : {
					required : true,
					number : true
				}

			}
		});
	}
	
	$(function(){
		$('reset:button').click(function(){
		   $('.input').val("");
		   $('.select').val("");
		});
    })
</script>
</html>