package com.yuchengtech.bcrm.trade.action;

import javax.sql.DataSource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.yuchengtech.bcrm.trade.model.TxLog;
import com.yuchengtech.bob.common.CommonAction;


/***
 * 交易日志  交易代码下拉框查询
 */
@Action("/txLogCodeAction")
public class TxLogCodeAction extends CommonAction {
	
    @Autowired
    @Qualifier("dsOracle")
    private DataSource ds;
        
    @Autowired
    public void init(){
    	model =new TxLog();
    }

    
    public void prepare() {
    	StringBuffer sb=new StringBuffer(" select distinct L.TX_CODE from  TX_LOG L"	);
    	for(String key : this.getJson().keySet()){
    		if(null!=this.getJson().get(key)&&!this.getJson().get(key).equals("")){
    			if("TX_LOG_ID".equals(key)){
    				sb.append("and L.TX_LOG_ID='"+this.getJson().get(key)+"'");
    			}
    		}
    	}
    	SQL=sb.toString();
    	datasource =ds;
    }
}