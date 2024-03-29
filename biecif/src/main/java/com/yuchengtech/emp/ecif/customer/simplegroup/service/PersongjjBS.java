package com.yuchengtech.emp.ecif.customer.simplegroup.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yuchengtech.emp.biappframe.base.service.BaseBS;
import com.yuchengtech.emp.bione.dao.SearchResult;
import com.yuchengtech.emp.ecif.customer.entity.perrisk.Persongjj;
@Service
@Transactional(readOnly = true)
public class PersongjjBS extends BaseBS<Object> {


@SuppressWarnings("unchecked")
public SearchResult<Persongjj> getPersongjjList(int firstResult,
		int pageSize, String orderBy, String orderType,
		Map<String, Object> conditionMap,long custId) {
	StringBuffer jql = new StringBuffer("");
	jql.append("select Persongjj from com.yuchengtech.emp.ecif.customer.entity.perrisk.Persongjj Persongjj where 1=1");
	if (!conditionMap.get("jql").equals("")) {
		jql.append(" and " + conditionMap.get("jql"));
	}
	if(!"".equals(custId)){
		jql.append(" and Persongjj.custId = " + custId + "");
	}
	if (!StringUtils.isEmpty(orderBy)) {
		jql.append(" order by Persongjj." + orderBy + " " + orderType);
	}
	Map<String, ?> values = (Map<String, ?>) conditionMap.get("params");
	return this.baseDAO.findPageWithNameParam(firstResult, pageSize,
			jql.toString(), values);
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public <X> X getEntityByProperty(final Class entityClass, String propertyName, Object value) {
	String jql = "select obj from " + entityClass.getName() 
			+ " obj where obj." + propertyName + "=?0";
	return (X) this.baseDAO.findUniqueWithIndexParam(jql, value);
}
}

