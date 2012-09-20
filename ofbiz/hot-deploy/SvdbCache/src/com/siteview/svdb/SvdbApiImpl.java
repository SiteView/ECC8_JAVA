package com.siteview.svdb;

import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.ofbiz.entity.Delegator;
//import org.ofbiz.entity.DelegatorFactory;
//import org.ofbiz.service.GenericDispatcher;
//import org.ofbiz.service.LocalDispatcher;

import com.siteview.svdb.dao.DaoFactory;
import com.siteview.svdb.queue.EccLogQueue;

public class SvdbApiImpl implements SvdbApi {
	private static final Log log = LogFactory.getLog(SvdbApiImpl.class);
//	private static Delegator delegator = DelegatorFactory.getDelegator("default");
//	private static LocalDispatcher dispatcher = GenericDispatcher.getLocalDispatcher(delegator.getDelegatorName(), delegator);

	@Override
	public void appendRecord(String id, String text) {
		try {
			String decodeId = URLDecoder.decode(id, "UTF-8");
			// System.out.println("decodeId : "+ decodeId);
			String decodeText = URLDecoder.decode(text, "UTF-8");
			// System.out.println("decodeText : "+ decodeText);
			Object url = ConfigReader.getConfig("CenterWebServiceUrl");
			// System.out.println("url : "+ url);
			if (url == null || "".equals(url)) {
				// log.info("CenterAdress 没有设置");
			} else if (url instanceof String) {
				if (((String) url).contains("localhost")
						|| ((String) url).contains("127.0.0.1")) {
					log.info("CenterAdress 不能指向本机");
				} else {
					try {
						boolean flag = DaoFactory.getTelebackupDataDao().query(
								decodeId);
						if (decodeId != null)
							decodeId = decodeId.trim();
						if (flag) {
							// if (proxy==null) proxy = new
							// SvdbApiImplProxy((String)url);
							// SvdbApiImplProxy proxy = new
							// SvdbApiImplProxy((String)url);
							// proxy.appendRecord(id, text);
							// if (service==null)
							com.siteview.cxf.client.SvdbApiImplService service = new com.siteview.cxf.client.SvdbApiImplService(
									new URL((String) ConfigReader
											.getConfig("CenterWebServiceUrl")));
							service.getSvdbApiImpl().appendRecord(id, text);
						}
					} catch (Exception e) {
						log.error(e);
					}
				}
			}
			//--------------------数据解析-----------------------------
			  decodeText = decodeText.substring(0, decodeText.length() - 1);
		      String[] retArray = decodeText.split("#");
		      Map<String,String> dataMap = new HashMap<String,String>();
		      for (String indexStr : retArray) {
		        String key = indexStr.substring(0, indexStr.indexOf("="));
		        String value = indexStr.substring(indexStr.indexOf("=") + 1, indexStr.length());
		        dataMap.put(key, value);
		      }
		      EccLogQueue.insertLast(dataMap);//add into queue
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
