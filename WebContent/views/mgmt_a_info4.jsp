<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
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
<%@ include file="jsTool.jsp" %>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body onload="OnLoad();">

<%@ include file="qq.jsp"%>

<%@ include file="topFrame.jsp"%>

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
						<hr class="hr_2" />
						<span class="text_mgmt_leftnav1"><span
							id="mgmt_nav_switch5a" class="span_mgmt_nav1" title="收起"
							onclick="mgmt_nav_switch5a();"></span><span
							id="mgmt_nav_switch5b" class="span_mgmt_nav2" title="展开"
							onclick="mgmt_nav_switch5b();"></span>我的帐户</span>
						<div id="mgmt_nav5">
							<a href="accountinfo" class="a_mgmt_leftnav1" hidefocus="true">帐户信息</a>
                        <a href="getsubaccount" class="a_mgmt_leftnav" hidefocus="true">附属帐户</a>
                        <a href="getaddress" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mysecurity" class="a_mgmt_leftnav" hidefocus="true">安全设置</a>
						</div>
					</div>
				</td>
            <td class="td_leftnav_top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
					<tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">认证信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                	</tr>
            	</table>
            	<form action="companycertificate" method="post" name="companycertificate" id="companycertificate" enctype="multipart/form-data">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
					<tr>
						<td class="td_mgmt_right3_td1a"> 
						<br />   	          
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">用户名：</td>
									<td><%=request.getSession().getAttribute("username") %></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司名称：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="companyName" name="companyName" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">组织机构代码：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="divisionCode" name="divisionCode" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">法人姓名：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="legalName" name="legalName" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">法人身份证号：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="legalIDCard" name="legalIDCard" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司地址：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="companyAddr" name="companyAddr" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司性质：</td>
									<td>
										<select style="width:120px;" id="companyType" name="companyType" required>
											<option value="" selected="selected">请选择</option>
                                            <option value="国有企业">国有企业</option>
                                            <option value="外资企业">外资企业</option>
                                            <option value="合资企业">合资企业</option>
                                            <option value="私营企业">私营企业</option>
                                        </select>
									</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司规模：</td>
									<td>
										<select style="width:120px;" id="companyScale" name="companyScale" required>
											<option value="" selected="selected">请选择</option>
                                            <option value="1-50人">1-50人</option>
                                            <option value="50-200人">50-200人</option>
                                            <option value="200-500人">200-500人</option>
                                            <option value="500人以上">500人以上</option>
                                        </select>
									</td>
								</tr>

								<tr>
									<td height="40" class="td_mgmt_right3_td1b">发票种类：</td>
									<td>
										<select style="width:120px;" id="invoiceKind" name="invoiceKind" required>
											<option value="" selected="selected">请选择</option>
                                            <option value="增值税发票">增值税发票</option>
                                            <option value="非增值税发票">非增值税发票</option>
                                        </select>
									</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">服务行业：</td>
                                    <td>
                                        <input type="checkbox" name="serviceIndustry" id="serviceIndustry" value="医药"/>
                                        医药&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" name="serviceIndustry" id="serviceIndustry" value="电子"/>
                                        电子&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" name="serviceIndustry" id="serviceIndustry" value="汽车"/>
                                        汽车
                                    </td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">业务种类：</td>
									<td>
                                        <input type="checkbox" name="businessKind" id="businessKind" value="干线运输线路"/>
                                        干线运输线路&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" name="businessKind" id="businessKind" value="城市配送网络"/>
                                        城市配送网络&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" name="businessKind" id="businessKind" value="仓储"/>
                                        仓储
									</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">联系人：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="companyContact" name="companyContact" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">手机号：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="phone" name="phone" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司基本情况：</td>
									<td>
                                    	<textarea class="textarea_rating" placeholder="请输入内容..." id="basicSituation" name="basicSituation" required></textarea>
                                    </td>
								</tr>								
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">相关资质材料：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" style="width:230px;" value="" />
                                        	<input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
      										<input id="file" type="file" name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0]" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" required/>
                                        </div>
                                    </td>
								</tr>
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
									<td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
								</tr>
							</table>


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
	function OnLoad(){
		//validate
		validateForm();
	}
	
	//验证表单
	function validateForm(){
		$("#companycertificate").validate({
			rules : {
				companyName : "required",
				divisionCode : "required",
				legalName : "required",
				companyAddr : "required",
				companyType : "required",
				companyScale : "required",
				invoiceKind : "required",
				serviceIndustry : "required",
				businessKind : "required",
				companyContact : "required",
				phone : "required",
				basicSituation : "required",
				file : "required",
				legalIDCard : {
					required : true,
					number : true
				},
				legalIDCard : {
					required : true,
					number : true
				},
				legalIDCard : {
					required : true,
					number : true
				},
				file:"required"
				

			}
		});
	}


	 $(function(){
			$('reset:button').click(function(){
			   $('.input').val("");
			   $('.select').val("");
			   $('.checkbox').val("");
			});
	})
</script>
</html>