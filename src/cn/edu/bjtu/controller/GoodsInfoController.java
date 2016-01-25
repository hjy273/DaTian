package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.bean.search.CargoSearchBean;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

import com.alibaba.fastjson.JSONArray;

@Controller
public class GoodsInfoController {

	@Resource
	GoodsInfoService goodsInfoService;
	@Autowired
	FocusService focusService;
	ModelAndView mv = new ModelAndView();

	/**
	 * ��Դ������
	 * @param flag
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/goodsform",params="flag=0")
	public String getAllGoodsInfo() {
		return "resource_list6";
	}
	
	/**
	 * ��Դ��-����ɸѡ
	 * @param cargoBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getSelectedCargoAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedCargoAjax(CargoSearchBean cargoBean,PageUtil pageUtil,HttpSession session){
		JSONArray jsonArray = goodsInfoService.getSelectedCargoNew(cargoBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	/**
	 * ���ػ���ɸѡҳ���ܼ�¼��
	 * @param warehouseBean
	 * @return
	 */
	@RequestMapping("getSelectedCargoTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedCargoTotalRowsAjax(CargoSearchBean cargoBean){
		Integer count=goodsInfoService.getSelectedCargoTotalRows(cargoBean);
		return count;
	}
	
	/**
	 * �ҵ���Ϣ-������Ϣ
	 * @param flag
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/goodsform",params="flag=1")
	public String getMyInfoGoods() {
			return "mgmt_r_cargo";
	}

	@RequestMapping("/goodsdetail")
	/**
	 * ��Դ����������
	 * @param id
	 * @return
	 */
	public ModelAndView getAllGoodsDetail(@RequestParam String id) {
		GoodsClientView goodsformInfo = goodsInfoService.getAllGoodsDetail(id);
		mv.addObject("goodsformInfo", goodsformInfo);
		mv.setViewName("resource_detail6");

		return mv;
	}


	@RequestMapping(value = "insertGoods", method = RequestMethod.POST)
	public String insertNewGoods(Goodsform goods,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=goodsInfoService.insertNewGoods(goods,request,file);
		return "redirect:goodsform?flag=1";
	}

	@RequestMapping("mygoodsdetail")
	public ModelAndView myGoodsDetail(@RequestParam String id,
			@RequestParam int flag, HttpServletRequest request,
			HttpServletResponse response) {
		GoodsClientView goodsformInfo = goodsInfoService.getAllGoodsDetail(id);
		mv.addObject("goodsdetail", goodsformInfo);

		if (flag == 1) {
			mv.setViewName("mgmt_r_cargo4");//�鿴
		}

		else if (flag == 2) {
			mv.setViewName("mgmt_r_cargo3");//���²���
		}

		return mv;
	}

	
	@RequestMapping(value = "updategoods", method = RequestMethod.POST)
	public String updateNewGoods(Goodsform goods,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=goodsInfoService.updateNewGoods(goods,request,file);
		return "redirect:goodsform?flag=1";
	}

	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	@RequestMapping("deletegoods")
	public String deleteGoods(@RequestParam String id) {

		boolean flag = goodsInfoService.deleteGoods(id);
		return "redirect:goodsform?flag=1";
	}
	
	@RequestMapping(value = "downloadgoodsrelated", method = RequestMethod.GET)
	/**
	 * ɾ��
	 */
	public ModelAndView downloadGoodsRelated(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		GoodsClientView goodsformInfo = goodsInfoService.getAllGoodsDetail(id);
			String file = goodsformInfo.getRelatedMaterial();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	/**
	 * �ҵ���Ϣ=�ҵĻ���
	 * @Title: getUserCargoResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����4:56:10
	 */
	@ResponseBody
	@RequestMapping(value="getUserCargoResourceAjax",produces = "text/html;charset=UTF-8")
	public String getUserCargoResource(HttpSession session,PageUtil pageUtil){
		JSONArray jsonArray=goodsInfoService.getUserCargoResource(session,pageUtil);
		return jsonArray.toString();
	}
	
	/**
	 * �ҵ���Ϣ-������Ϣ-�ܼ�¼��
	 * @Title: getUserCargoResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����4:58:56
	 */
	@ResponseBody
	@RequestMapping("getUserCargoResourceTotalRowsAjax")
	public Integer getUserCargoResourceTotalRows(HttpSession session){
		return goodsInfoService.getUserCargoTotalRows(session);
	}

}
