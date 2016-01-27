<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <% String id=(String)request.getAttribute("id"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帐户信息</title>
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
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的帐户
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
                        	<span class="span_mgmt_right2_text1">查看附属帐户</span>
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
									<td width="120" height="40" class="td_mgmt_right3_td1b">帐户名称：</td>
									<td id="username"><%-- ${subAccount.hostAccountName }-${subAccount.username } --%></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">初始密码：</td>
									<td>·······</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">权限：</td>
									 <td id="privilege">
									<%--  <c:choose>
                                     <c:when test="${subAccount.resourceManagement == '有' }">
                       				资源管理&nbsp;
                                     </c:when>
                                     </c:choose>
                                     <c:choose>
                        			<c:when test="${subAccount.transactionManagement == '有' }">
                       				交易管理&nbsp;
                                     </c:when>
                                     </c:choose>
                                     <c:choose>
                                     <c:when test="${subAccount.schemaManagement == '有' }">
                       				方案管理&nbsp;
                                     </c:when>
                                     </c:choose>
                                     <c:choose>
                                     <c:when test="${subAccount.statisticsManagement == '有' }">
                       				统计分析&nbsp;
                                     </c:when>	
                                     </c:choose> --%>
									</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">备注：</td>
									<td id="remarks"><%-- ${subAccount.remarks } --%></td>
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

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		getSubAccountInfo();
	}
	
	//获取附属账户信息
	function getSubAccountInfo(){
		var url="getSubAccountInfoAjax";
		var id="<%=id %>"
		$.ajax({
			url:url,
			data:{id:id},
			cache:false,
			dataType:"json",
			success:function(data,status){
				var usernames=new Array();//前缀和后缀
				usernames=data["username"].split("-");
				$("#username").html(usernames[0]);
				$("#remarks").html(data.remarks);
				var pri=$("#privilege");
				if(data.resourceManagement == 'on'){
					pri.append("资源管理&nbsp;");
				}
				if(data.transactionManagement == 'on'){
					pri.append("交易管理&nbsp;");				
				}
				if(data.schemaManagement  == 'on'){
					pri.append("方案管理&nbsp;");
				}
				if(data.statisticsManagement == 'on'){
					pri.append("统计分析&nbsp;");
				}
				/* $("#username").val(usernames[1]);
				$("#remarks").text(data["remarks"]);
				if(data.resourceManagement =='on'){
					$("#resourceManagement").attr("checked","checked");
				}
				if(data.transactionManagement =='on'){
					$("#transactionManagement").attr("checked","checked");					
				}
				if(data.schemaManagement =='on'){
					$("#schemaManagement").attr("checked","checked");
				}
				if(data.statisticsManagement =='on'){
					$("#statisticsManagement").attr("checked","checked");
				} */
			}
			
		});
	}
</script>
</html>