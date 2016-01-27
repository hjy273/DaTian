<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>司机信息</title>
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
                        	<span class="span_mgmt_right2_text1">更新司机信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                	</tr>
            	</table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br />   	          
                              <form action="updateDriver?id=${driver.id }" method="post" name="insertDriver" enctype="multipart/form-data">      
                          <c var="driver" items="${driver }">
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">姓名：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${driver.driverName }" name="driverName" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">性别：</td>
                                     <td>
                                    <select style="width:120px;" name="sex" id="sex" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="男" >男</option>
                                            <option value="女">女</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">身份证号码：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${driver.IDCard }" name="IDCard" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">驾驶证档案编号：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${driver.licenceNum }" name="licenceNum" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">驾驶证等级：</td>
                                    <td>
                                    
                                    <c:choose>
                                    <c:when test="${driver.licenceRate == '' }">
                                    	<select style="width:120px;" name="licenceRate" id="licenceRate" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                        </select>
                                    </c:when>
                                    <c:when test="${driver.licenceRate == 'A' }">
                                    	<select style="width:120px;" name="licenceRate" required>
                                            <option value="">请选择</option>
                                            <option value="A" selected="selected">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                        </select>
                                    </c:when>
                                    <c:when test="${driver.licenceRate == 'B' }">
                                    	<select style="width:120px;" name="licenceRate" required>
                                            <option value="">请选择</option>
                                            <option value="A">A</option>
                                            <option value="B" selected="selected">B</option>
                                            <option value="C">C</option>
                                        </select>
                                    </c:when>
                                    <c:when test="${driver.licenceRate == 'C' }">
                                    	<select style="width:120px;" name="licenceRate" required>
                                            <option value="">请选择</option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C" selected="selected">C</option>
                                        </select>
                                    </c:when>
                                    </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">取得驾驶证时间：</td>
                                    <td><input type="text" class="input_date1" title="点击此处选择" onclick="SelectDate(this,'yyyy-MM-dd')" value="${driver.licenceTime }" readonly="readonly" name="licenceTime" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">联系电话：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${driver.phone }" name="phone" required/></td>
                                </tr>
                                <tr>
									<td height="40" class="td_mgmt_right3_td1b">证件扫描件：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" style="width:230px;" value="" />
                                        	<input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
     										<input id="upload_btn4" type="file" name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0]" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" required/>
                                        </div>
                                    </td>
								</tr>
                                <tr>
                                    <td height="20" class="td_mgmt_right3_td1b"></td>
                                    <td>（包括司机本人的身份证、驾驶证）</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
                                </tr>
                            </table>
                            </c>
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
		//设置数据
		setData();
	}
	
	function setData(){
		$("#licenceRate").attr("value","${driver.licenceRate}");
		$("#sex").attr("value","${driver.sex}");
		
	}
</script>
</html>