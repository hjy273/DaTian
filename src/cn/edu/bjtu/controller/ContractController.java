package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.ContractService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Contract;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
/**
 * ��ͬ������
 * @author RussWest0
 *
 */
public class ContractController {

	@Resource(name="contractServiceImpl")
	ContractService contractService;
	@Resource
	CompanyService companyService;
	private Logger logger=Logger.getLogger(ContractController.class);

	ModelAndView mv = new ModelAndView();

	/**
	 * ��ȡ���󷽺�ͬҳ��
	 * @return
	 */
	@RequestMapping("contract")
	public String getUserContractPage(){
		return "mgmt_r_contact_s";
	}
	
	/**
	 * ��ȡ���˷���ͬҳ�� 
	 * @return
	 */
	@RequestMapping("contract2")
	public String getCarrierContractPage(){
		return "mgmt_r_contact_r";
	}
	
	@RequestMapping("contractdetail")
	/**
	 * ��ͬ����
	 * @param contractId
	 * @param flag
	 * @return
	 */
	public ModelAndView getContractInfo(@RequestParam String contractId,
			@RequestParam int flag, HttpServletRequest request) {
		String carrierId=(String)request.getSession().getAttribute(Constant.USER_ID);
		//String carrierId = "C-0002";
		Contract contract = contractService.getContractInfo(contractId);
		mv.addObject("contract", contract);
		Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
		mv.addObject("carrierInfo", carrierInfo);
		//����
		if (flag == 1)// ����
		{
			mv.setViewName("mgmt_r_contact_s4");
		} else if (flag == 2)// ��ֹ
		{
			mv.setViewName("mgmt_r_contact_s3");
		}
		 else if (flag == 3)// ��ֹ��鿴��������ֹԭ��
		{
			mv.setViewName("mgmt_r_contact_s4a");
		}
		//���˷�
		 else if (flag == 11)// ȷ��
		{
			mv.setViewName("mgmt_r_contact_r2");
		} else if (flag == 22)// ��ֹ
		{
			mv.setViewName("mgmt_r_contact_r3");
		}
		 else if (flag == 33)// ��ֹ��鿴��������ֹԭ��
		{
			mv.setViewName("mgmt_r_contact_r4a");
		}
		 else if (flag == 44)// ��ͨ�鿴����
		{
			mv.setViewName("mgmt_r_contact_r4");
		}
		return mv;

	}

	/**
	 * ������ͬ
	 * @param contract
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insertContract", method = RequestMethod.POST)
	public String insertNewContract(Contract contract,MultipartFile file,
			HttpServletRequest request) {
		contractService.insertNewContract(contract,request,file);
		return "redirect:contract";
	}
	
	
	/**
	 * ��ֹ��ͬ
	 * @param contractId
	 * @param reason
	 * @param response
	 * @return
	 */
	@RequestMapping(value="shutdownContract",method = RequestMethod.POST)
	public String shutdownContract(@RequestParam String contractId,
			@RequestParam int rorsflag,//��ʶ�ǳ��˷���������
			@RequestParam String reason,HttpServletResponse response)
	{
		
		boolean flag=false;
		flag=contractService.shutdownContract(contractId, reason);
		if(flag==true&&rorsflag==1){
			return "redirect:contract";
		}else {
			return "redirect:contract2";
		}
			
	}
	

	/**
	 * ɾ��
	 */
	@RequestMapping(value = "downloadcontactrelated", method = RequestMethod.GET)
	public ModelAndView downloadContactRelated(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		Contract contract = contractService.getContractInfo(id);
		String file = contract.getRelatedMaterial();
		DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	
	@RequestMapping(value = "confirmcontract", method = RequestMethod.POST)
	public String confirmContract(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		boolean flag = contractService.changeStatus(id);
		return "redirect:contract2";
	}
	
	/**
	 * ��ȡ��ǰ�û��ĺ�ͬid
	 * @param currentUserId
	 * @return
	 */
	@RequestMapping("getUserContractIdAjax")
	@ResponseBody
	public String getUserContractId(HttpServletResponse response,HttpSession session){
		String userId=(String)session.getAttribute(Constant.USER_ID);
		List<Contract> contractList=contractService.getContractByClientId(userId);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<contractList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(contractList.get(i));
			jsonArray.add(jsonObject);
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		return jsonArray.toString();
		
	}
	
	/**
	 * �ҵ���Ϣ-��ͬ��Ϣ
	 * @Title: getUserContract 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����5:40:28
	 */
	@RequestMapping(value="getUserContractAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUserContract(HttpSession session,PageUtil pageUtil,Contract contract){
		JSONArray jsonArray=contractService.getUserContract(session,pageUtil,contract);
		return jsonArray.toString();
	}
	
	/**
	 * �ҵ���Ϣ-��ͬ��Ϣ-�ܼ�¼��
	 * @Title: getUserContractTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����5:42:46
	 */
	@RequestMapping("getUserContractTotalRowsAjax")
	@ResponseBody
	public Integer getUserContractTotalRows(HttpSession session,Contract contract){
		return contractService.getUserContractTotalRows(session,contract);
	}
	
	
	
}
