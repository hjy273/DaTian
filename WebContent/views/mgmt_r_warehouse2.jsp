﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
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
                            <span class="span_mgmt_right2_text1">添加仓库信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br />   
                            <form action="insertWarehouse" id="insertWarehouse" method="post" enctype="multipart/form-data">      
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="120" height="40" class="td_mgmt_right3_td1b">仓库名称：</td>
                                <td><input type="text" class="input_mgmt1" style="width:300px;" id="name" name="name" required/></td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">所在城市：</td>
                                <td id="cityselector"><input id="city1" type="text" value="" id="city" class="input_city1" name="city" required/></td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">地址：</td>
                                <td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="address" name="address" required/></td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">仓库类型：</td>
                                <td>
                                    <select style="width:120px;" id="type" name="type" required>
                                        <option value="" selected="selected">请选择</option>
                                        <option value="保税">保税</option>
                                        <option value="非保税">非保税</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">所属性质：</td>
                                <td>
                                    <select style="width:120px;" id="kind" name="kind" required>
                                        <option value="" selected="selected">请选择</option>
                                        <option value="自有">自有</option>
                                        <option value="租用">租用</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">仓库面积：</td>
                                <td><input type="text" class="input_mgmt1" style="width:300px;" name="houseArea" id="houseArea" required/>
                                (平方米)</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">堆场面积：</td>
                                <td><input type="text" class="input_mgmt1" style="width:300px;" name="yardArea" id="yardArea" required/>
                                (平方米)</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">库层层高：</td>
                                <td><input type="text" class="input_mgmt1" style="width:300px;" name="height"  id="height" required/>
                                (米)</td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">消防等级：</td>
                                <td>
                                    <select style="width:120px;" id="fireRate" name="fireRate" required>
                                        <option value="" selected="selected">请选择</option>
                                        <option value="甲">甲</option>
                                        <option value="乙">乙</option>
                                        <option value="丙">丙</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">保管形态：</td>
                                <td>
                                    <input value="普通" type="checkbox" id="storageForm" name="storageForm"/>
                                    普通仓库&nbsp;&nbsp;&nbsp;
                                    <input value="冷藏" type="checkbox" id="storageForm" name="storageForm"/>
                                    冷藏仓库&nbsp;&nbsp;&nbsp;
                                    <input value="恒温" type="checkbox" id="storageForm" name="storageForm"/>
                                    恒温仓库&nbsp;&nbsp;&nbsp;
                                    <input value="露天" type="checkbox" id="storageForm" name="storageForm"/>
                                    露天仓库&nbsp;&nbsp;&nbsp;
                                    <input value="危险品" type="checkbox" id="storageFormx" name="storageForm"/>
                                    危险品仓库
                                    </td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">防火安保：</td>
                                <td>
                                    <input value=" 烟感" type="checkbox" id="fireSecurity" name="fireSecurity"/>
                                    烟感&nbsp;&nbsp;&nbsp;
                                    <input value="自动喷淋" type="checkbox" id="fireSecurity" name="fireSecurity"/>
                                    自动喷淋&nbsp;&nbsp;&nbsp;
                                    <input value=" 24小时摄像监控" type="checkbox" id="fireSecurity" name="fireSecurity"/>
                                    24小时摄像监控&nbsp;&nbsp;&nbsp;
                                    <input value="无" type="checkbox" id="fireSecurity" name="fireSecurity"/>
                                    无
                                </td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">IT环境：</td>
                                <td>
                                    <input value="Internet宽带接入" type="checkbox" id="environment" name="environment"/>
                                    Internet宽带接入&nbsp;&nbsp;&nbsp;
                                    <input value="仓库信息管理系统" type="checkbox" id="environment" name="environment"/>
                                    仓库信息管理系统&nbsp;&nbsp;&nbsp;
                                    <input value="无" type="checkbox" id="environment" name="environment"/>
                                    无
                                </td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">服务内容：</td>
                                <td>
                                    <input value="机械出入库搬运" type="checkbox" id="serviceContent" name="serviceContent"/>
                                    机械出入库搬运&nbsp;&nbsp;&nbsp;
                                    <input value="分拣" type="checkbox" id="serviceContent" name="serviceContent"/>
                                    分拣&nbsp;&nbsp;&nbsp;
                                    <input value=" 包装" type="checkbox" id="serviceContent" name="serviceContent"/>
                                    包装&nbsp;&nbsp;&nbsp;
                                    <input value="打托盘" type="checkbox" id="serviceContent" name="serviceContent"/>
                                    打托盘&nbsp;&nbsp;&nbsp;
                                    <input value="地面存储" type="checkbox" id="serviceContent" name="serviceContent"/>
                                    地面存储&nbsp;&nbsp;&nbsp;
                                    <input value="货架存储" type="checkbox" id="serviceContent" name="serviceContent"/>
                                    货架存储
                                    </td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">联系人：</td>
                                <td><input type="text" class="input_mgmt1" style="width:300px;" id="contact" name="contact" required/></td>
                            </tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">联系电话：</td>
                                <td><input type="text" class="input_mgmt1" style="width:300px;" name="phone" id="phone" required/></td>
                            </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">详细报价：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" style="width:230px;" value="请上传文件..." /><input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
      <input id="upload_btn4" type="file" name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0]" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" required/>
                                        </div>
                                    </td>
								</tr>
                                <!-- <tr>
                                    <td height="20" class="td_mgmt_right3_td1b"></td>
                                    <td><a href="javascript:;" hidefocus="true">报价模板&nbsp;<img src="images/btn_filetype2.png" /></a></td>
                                </tr> -->
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
									<td>
                                    	<textarea class="textarea_rating" placeholder="请输入内容..." id="remarks" name="remarks" required></textarea>
                                    </td>
								</tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" /><input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
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
		
		//validate form 
		formValidate();
	}
	
	
	function formValidate() {
		$("#insertWarehouse").validate({
			rules : {
				name : "required",
				city : "required",
				address : "required",
				type : "required",
				kind : "required",
				houseArea : {
					required : true,
					number : true
				},
				yardArea : {
					required : true,
					number : true
				},
				height : {
					required : true,
					number : true
				},
				fireRate : "required",
				storageForm : {
					required : true,
					minlength : 1
				},
				fireSecurity : {
					required : true,
					minlength : 1
				},
				serviceContent : {
					required : true,
					minlength : 1
				},
				environment : {
					required : true,
					minlength : 1
				},

				contact : "required",
				phone : "required",
				remarks : "required"

			}
		});
	}

	$(function() {
		$('reset:button').click(function() {
			$('.input').val("");
			$('.select').val("");
			$('.checkbox').val("");
		});
	})
</script>
</html>