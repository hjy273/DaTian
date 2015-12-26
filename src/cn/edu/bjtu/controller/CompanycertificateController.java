package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanycertificateService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Companycertificate;

@Controller
public class CompanycertificateController {
	@Resource
	CompanycertificateService companycertificateService;
	ModelAndView mv = new ModelAndView();
	

	/**
	 * ��֤��˾��
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getcompanyvalidateform")
	public ModelAndView getCompanyValidateForm() {
		mv.setViewName("mgmt_a_info4");
		return mv;
	}
	
	
	/**
	 * ��֤��˾��Ϣ
	 */
	@RequestMapping("companycertificate")
	public ModelAndView companycertificate(
			@RequestParam(required = false) MultipartFile file,
			@RequestParam(required = false) String companyName, @RequestParam(required = false) String divisionCode,
			@RequestParam(required = false) String companyAddr, @RequestParam(required = false) String companyType,
			@RequestParam(required = false) String companyScale,  @RequestParam(required = false) String businessKind,
			@RequestParam(required = false) String companyContact, @RequestParam(required = false) String phone,
			HttpServletRequest request,	HttpServletResponse response) {
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		
				String path = null;
				String fileName = null;
				if (file.getSize() != 0)// ���ϴ��ļ������
				{
					path = UploadPath.getCompanyCertificatePath();// ��ͬ�ĵط�ȡ��ͬ���ϴ�·��
					fileName = file.getOriginalFilename();
					fileName = userId + "_" + fileName;// �ļ���
					File targetFile = new File(path, fileName);
					try { // ���� �ļ�
						file.transferTo(targetFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// û���ϴ��ļ������path �� filenNameĬ��Ϊnull

		boolean flag=companycertificateService.validateCompany(userId,companyName,divisionCode,companyAddr,companyType,companyScale,
				businessKind,companyContact,phone,path,fileName);
		if(flag==true){
			try {
				response.sendRedirect("accountinfo");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		else mv.setViewName("mgmt_a_info");
		return mv;
	}
	
	/**
	 * �鿴��˾��֤��Ϣ
	 */
	@RequestMapping("detailcompanycertificate")
	public ModelAndView detailCompanyCertificate(
			@RequestParam int flag,
			HttpServletRequest request, HttpServletResponse response) {

		String companyId = (String) request.getSession().getAttribute(Constant.USER_ID);
		Companycertificate companycertificate = companycertificateService.getCompanycertificate(companyId);
		mv.addObject("detailCompanyCertificate", companycertificate);
		if (flag == 0) {// ��Ӧ��˾��֤�鿴����
			mv.setViewName("mgmt_a_info6a");
		} else if (flag == 1)// ��Ӧ��˾��֤����
		{
			mv.setViewName("mgmt_a_info6");
		} 
		return mv;
	}
	
	/**
	 * ������֤��˾����ز���
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "downloadcompanycertificatematerial", method = RequestMethod.GET)
	public ModelAndView downloadCompanyCertificateMaterial(String id,
			HttpServletRequest request, HttpServletResponse response) {
			Companycertificate companycertificate = companycertificateService.getCompanycertificate(id);
			String file = companycertificate.getRelatedMaterial();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	/**
	 * ��֤��˾
	 */
	@RequestMapping("companycertificateupdate")
	public ModelAndView companycertificateUpdate(
			@RequestParam(required = false) MultipartFile file,
			@RequestParam(required = false) String companyName, @RequestParam(required = false) String divisionCode,
			@RequestParam(required = false) String legalName, @RequestParam(required = false) String legalIDCard,
			@RequestParam(required = false) String companyAddr, @RequestParam(required = false) String companyType,
			@RequestParam(required = false) String companyScale, @RequestParam(required = false) String invoiceKind,
			@RequestParam(required = false) String serviceIndustry, @RequestParam(required = false) String businessKind,
			@RequestParam(required = false) String companyContact, @RequestParam(required = false) String phone,
			@RequestParam(required = false) String basicSituation,
			HttpServletRequest request,	HttpServletResponse response) {
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		
		// ////////////////////////////////////////////
				String path = null;
				String fileName = null;
				if (file.getSize() != 0)// ���ϴ��ļ������
				{
					path = UploadPath.getCompanyCertificatePath();// ��ͬ�ĵط�ȡ��ͬ���ϴ�·��
					fileName = file.getOriginalFilename();
					fileName = userId + "_" + fileName;// �ļ���
					File targetFile = new File(path, fileName);
					try { // ���� �ļ�
						file.transferTo(targetFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// û���ϴ��ļ������path �� filenNameĬ��Ϊnull

				// ////////////////////////////////////////////
		
		boolean flag=companycertificateService.companycertificateUpdate(userId,companyName,divisionCode,
				companyAddr,companyType,companyScale,
				businessKind,companyContact,phone,path,fileName);
		if(flag==true){
			try {
				response.sendRedirect("accountinfo");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		else mv.setViewName("mgmt_a_info");
		return mv;
	}
}
