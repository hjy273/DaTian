﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>合同信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<%@ include file="jsTool.jsp" %>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body>

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
                            <span class="span_mgmt_right2_text1">查看合同信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                        <br />   	          
                        <table width="90%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="120" height="40" class="td_mgmt_right3_td1b">合同编号：</td>
                                <td>${contract.id }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">合同名称：</td>
                                <td>${contract.name }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">承运方帐户：</td>
                                <td>${contract.carrierAccount } (${carrierInfo.companyName })</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">合同开始日期：</td>
                                <td>${contract.startDate }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">合同截止日期：</td>
                                <td>${contract.endDate }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">结算方式：</td>
                                <td>${contract.caculateType } ${contract.monthlyStatementDays }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">联系人：</td>
                                <td> ${contract.contact }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">手机号：</td>
                                <td>${contract.phone }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">相关材料：</td>
                                <td><a href="downloadcontactrelated?id=${contract.id }" hidefocus="true"><img src="images/btn_filetype2.png" /></a></td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
                                <td>${contract.remarks }</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1f">合同终止原因：</td>
                                <td class="td_mgmt_right3_td1g">${contract.reason }</td>
                            </tr>
                        </table>
                    </td>
                    </tr>
                </table>
			</td>
		</tr>
    </table>
</div>

<%@ include  file="popup1.jsp"%>

<div id="popup2" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="510"><div class="div_popup_title1">终止合同的原因</div></td>
            <td>
                <div id="close2" style="cursor:pointer;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="540">
            	<textarea class="textarea_popup1" placeholder="请输入内容..."></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="button" id="btn1" value="提交" class="btn_mgmt1" onclick="window.location.href='mgmt_r_contact_r.htm'" hidefocus="true" /><input type="button" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
            </td>
        </tr>
    </table>
</div>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
</html>