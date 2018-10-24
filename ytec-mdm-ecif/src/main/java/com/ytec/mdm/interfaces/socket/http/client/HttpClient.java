/**
 * @��Ŀ����ytec-mdm-ecif
 * @������com.ytec.mdm.interfaces.socket.http.client
 * @�ļ�����HttpClient.java
 * @�汾��Ϣ��1.0.0
 * @���ڣ�2013-12-17-11:47:53
 * @Copyright (c) 2013���������׳ϿƼ����޹�˾-��Ȩ����
 * 
 */
package com.ytec.mdm.interfaces.socket.http.client;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.ytec.mdm.interfaces.common.xmlcheck.RequestCheckSum;
import com.ytec.mdm.interfaces.socket.NioClient;

/**
 * @��Ŀ���ƣ�ytec-mdm-ecif 
 * @�����ƣ�HttpClient
 * @��������HTTP�ͻ���
 * @��������:
 * @�����ˣ�wangzy1@yuchengtech.com
 * @����ʱ�䣺2013-12-17 ����11:47:53   
 * @�޸��ˣ�wangzy1@yuchengtech.com
 * @�޸�ʱ�䣺2013-12-17 ����11:47:53
 * @�޸ı�ע��
 * @�޸�����		�޸���Ա		�޸�ԭ��
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2013���������׳ϿƼ����޹�˾-��Ȩ����
 * 
 */
@Component
@Scope("prototype")
public class HttpClient extends NioClient {
	private static Logger log = LoggerFactory.getLogger(HttpClient.class);
	/**
	 * @��������:decoder
	 * @��������:http������
	 * @since 1.0.0
	 */
	private ResponseDecoder decoder = new ResponseDecoder();
	/**
	 * @��������:url
	 * @��������:URL
	 * @since 1.0.0
	 */
	private String url;

	/**
	 */
	public HttpClient() {
	}

	/* (non-Javadoc)
	 * @see com.ytec.mdm.interfaces.socket.NioClient#init(java.util.Map)
	 */
	public void init(Map arg) throws Exception{
		// TODO Auto-generated method stub
		super.init(arg);
		this.url = (String) arg.get("url");
	}

	/* (non-Javadoc)
	 * @see com.ytec.mdm.interfaces.socket.NioClient#packing(java.lang.String)
	 */
	@Override
	protected String packing(String sendmsg) throws Exception {
		StringBuffer msg = new StringBuffer();
		msg.append("POST /" + url + " HTTP/1.1\r\n");
		msg.append("Accept: */*\r\n");
		msg.append("Accept-Language: zh-cn\r\n");
		msg.append("User-Agent: ecif\r\n");
		msg.append("Host: localhost\r\n");
		String checkSum = RequestCheckSum.CheckReponseSum(sendmsg);
		msg.append("Content-MD5: " + checkSum + "\r\n");
		msg.append("Connection: Keep-Alive\r\n");
		msg.append("Content-type: application/xml; charset="
				+ charset + "\r\n");
		msg.append("Content-Length: "+ sendmsg.getBytes(charset).length + "\r\n");
		msg.append("\r\n");
		msg.append(sendmsg);
		return msg.toString();
	}

	@Override
	protected boolean decode() throws Exception {
		// TODO Auto-generated method stub
		if(decoder.decode(receivebuffer)){
			log.info("���յ�:{}�ֽ�,http status {}",decoder.contentLength,decoder.getResStatus().getReasonPhrase());
			responseMsg = decoder.getBody(charset);
			return true;
		}else{
			return false;
		}
	}

}