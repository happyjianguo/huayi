package com.yuchengtech.bcrm.customer.potentialMkt.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.yuchengtech.bcrm.customer.potentialMkt.model.OcrmFInterviewFixedasset;
import com.yuchengtech.bob.common.CommonService;
import com.yuchengtech.bob.common.JPABaseDAO;

@Service
public class OcrmFInterviewFixedassetService extends CommonService{
	 private HttpServletRequest request;
	 public OcrmFInterviewFixedassetService(){
		 JPABaseDAO<OcrmFInterviewFixedasset,String> baseDao = new JPABaseDAO<OcrmFInterviewFixedasset,String>(OcrmFInterviewFixedasset.class);
	 	 super.setBaseDAO(baseDao);
	 }
	public Object save(Object obj) {
		OcrmFInterviewFixedasset fixedasset = (OcrmFInterviewFixedasset)obj;
		 ActionContext ctx = ActionContext.getContext();
	     request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		 if("0".equals(request.getParameter("flag"))){//新增
			 fixedasset.setId(null);
		 }
			return super.save(fixedasset);
	    }
}
