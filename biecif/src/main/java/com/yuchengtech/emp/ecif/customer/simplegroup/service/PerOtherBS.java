package com.yuchengtech.emp.ecif.customer.simplegroup.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yuchengtech.emp.biappframe.base.service.BaseBS;
import com.yuchengtech.emp.bione.dao.SearchResult;
import com.yuchengtech.emp.ecif.customer.entity.customerother.ConsInfo;
import com.yuchengtech.emp.ecif.customer.entity.customerother.CustOtherBankActivity;
import com.yuchengtech.emp.ecif.customer.entity.customerother.PersonInHabInfo;
import com.yuchengtech.emp.ecif.customer.entity.customerother.PersonOtherInfo;
import com.yuchengtech.emp.ecif.customer.entity.customerother.Vipcardinfo;

@Service
@Transactional(readOnly = true)
public class PerOtherBS extends BaseBS<Object> {

	/**
	 * 获取列表数据, 支持查询
	 * 
	 * @param firstResult
	 *            分页的开始索引
	 * @param pageSize
	 *            页面大小
	 * @param orderBy
	 *            排序字段
	 * @param orderType
	 *            排序方式
	 * @param conditionMap
	 *            搜索条件
	 * @return
	 */
	// 展示PersonInHabInfo的页面
	@SuppressWarnings("unchecked")
	public SearchResult<PersonInHabInfo> getPersonInHabInfoList(int firstResult, int pageSize,
			String orderBy, String orderType, Map<String, Object> conditionMap,
			long custId) {
		StringBuffer jql = new StringBuffer("");
		jql.append("select obj from PersonInHabInfo obj where 1=1");
		if (!conditionMap.get("jql").equals("")) {
			jql.append(" and " + conditionMap.get("jql"));
		}
		if (!"".equals(custId)) {
			jql.append(" and obj.custId = " + custId + "");
		}
		if (!StringUtils.isEmpty(orderBy)) {
			jql.append(" order by obj." + orderBy + " " + orderType);
		}
		Map<String, ?> values = (Map<String, ?>) conditionMap.get("params");
		return this.baseDAO.findPageWithNameParam(firstResult, pageSize,
				jql.toString(), values);
	}

	// 展示PersonOtherInfo的页面
	@SuppressWarnings("unchecked")
	public SearchResult<PersonOtherInfo> getPersonOtherInfoList(int firstResult,
			int pageSize, String orderBy, String orderType,
			Map<String, Object> conditionMap, long custId) {
		StringBuffer jql = new StringBuffer("");
		jql.append("select obj from PersonOtherInfo obj where 1=1");
		if (!conditionMap.get("jql").equals("")) {
			jql.append(" and " + conditionMap.get("jql"));
		}
		if (!"".equals(custId)) {
			jql.append(" and obj.custId = " + custId + "");
		}
		if (!StringUtils.isEmpty(orderBy)) {
			jql.append(" order by obj." + orderBy + " " + orderType);
		}
		Map<String, ?> values = (Map<String, ?>) conditionMap.get("params");
		return this.baseDAO.findPageWithNameParam(firstResult, pageSize,
				jql.toString(), values);
	}

	// 展示ConsInfo的页面
	@SuppressWarnings("unchecked")
	public SearchResult<ConsInfo> getConsInfoList(int firstResult,
			int pageSize, String orderBy, String orderType,
			Map<String, Object> conditionMap, long custId) {
		StringBuffer jql = new StringBuffer("");
		jql.append("select obj from ConsInfo obj where 1=1");
		if (!conditionMap.get("jql").equals("")) {
			jql.append(" and " + conditionMap.get("jql"));
		}
		if (!"".equals(custId)) {
			jql.append(" and obj.custId = " + custId + "");
		}
		if (!StringUtils.isEmpty(orderBy)) {
			jql.append(" order by obj." + orderBy + " " + orderType);
		}
		Map<String, ?> values = (Map<String, ?>) conditionMap.get("params");
		return this.baseDAO.findPageWithNameParam(firstResult, pageSize,
				jql.toString(), values);
	}

	// 展示CustOtherBankActivity的页面
	@SuppressWarnings("unchecked")
	public SearchResult<CustOtherBankActivity> getCustOtherBankActivityList(int firstResult,
			int pageSize, String orderBy, String orderType,
			Map<String, Object> conditionMap, long custId) {
		StringBuffer jql = new StringBuffer("");
		jql.append("select obj from CustOtherBankActivity obj where 1=1");
		if (!conditionMap.get("jql").equals("")) {
			jql.append(" and " + conditionMap.get("jql"));
		}
		if (!"".equals(custId)) {
			jql.append(" and obj.custId = " + custId + "");
		}
		if (!StringUtils.isEmpty(orderBy)) {
			jql.append(" order by obj." + orderBy + " " + orderType);
		}
		Map<String, ?> values = (Map<String, ?>) conditionMap.get("params");
		return this.baseDAO.findPageWithNameParam(firstResult, pageSize,
				jql.toString(), values);
	}

	
	/**
	 * 获取信息, 用于生成下拉框
	 * 
	 * @return
	 */
	public List<Map<String, String>> getComBoBox() {
		StringBuffer jql = new StringBuffer(
				"select t.typeId, t.typeName from Ttype t");

		List<Object[]> objList = this.baseDAO.findWithNameParm(jql.toString(),
				null);
		List<Map<String, String>> harvComboList = Lists.newArrayList();
		Map<String, String> harvMap;
		for (Object[] obj : objList) {
			harvMap = Maps.newHashMap();
			harvMap.put("id", obj[0] != null ? obj[0].toString() : "");
			harvMap.put("text", obj[1] != null ? obj[1].toString() : "");
			harvComboList.add(harvMap);
		}
		return harvComboList;
	}
	
	// 展示vipcardinfo 客户贵宾卡信息的页面
	@SuppressWarnings("unchecked")
	public SearchResult<Vipcardinfo> getVipCardInfos(int firstResult,
			int pageSize, String orderBy, String orderType,
			Map<String, Object> conditionMap, long custId) {
		StringBuffer jql = new StringBuffer("");
		jql.append("select obj from Vipcardinfo obj where 1=1");
		if (!conditionMap.get("jql").equals("")) {
			jql.append(" and " + conditionMap.get("jql"));
		}
		if (!"".equals(custId)) {
			jql.append(" and obj.custId = " + custId + "");
		}
		if (!StringUtils.isEmpty(orderBy)) {
			jql.append(" order by obj." + orderBy + " " + orderType);
		}
		Map<String, ?> values = (Map<String, ?>) conditionMap.get("params");
		return this.baseDAO.findPageWithNameParam(firstResult, pageSize,
				jql.toString(), values);
	}
}
