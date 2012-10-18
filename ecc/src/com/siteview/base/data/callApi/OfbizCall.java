package com.siteview.base.data.callApi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javolution.util.FastMap;
import org.ofbiz.service.GenericServiceException;
import org.ofbiz.service.rmi.RemoteDispatcher;

import com.siteview.jsvapi.Jsvapi;

public class OfbizCall {
	private static OfbizCall c_intance = null;
	private static String rmiCallUrl = "rmi://127.0.0.1:1099/RMIDispatcher";
	private static SimpleDateFormat simpledf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

	/**
	 * @updated by zhongping.wang singleton
	 * */
	synchronized public static OfbizCall getInstance() {
		if (c_intance == null) {
			c_intance = new OfbizCall();
		}
		return c_intance;
	}

	protected static RemoteDispatcher rd = null;

	public OfbizCall() {
		try {
			rd = (RemoteDispatcher) Naming.lookup(rmiCallUrl);
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 加载报表数据方法
	 * 
	 * @throws RemoteException
	 * @throws GenericServiceException
	 * 
	 **/
	public Map<String, Object> queryReportData(String nodeids, Integer byCount,
			Date begin, Date end) throws GenericServiceException,
			RemoteException {

		Map<String, Object> context = FastMap.newInstance();
		String entityIndex = sdf.format(new Date());// table index
		context.put("tablename", "OperationAttributeLog" + entityIndex);
		context.put("operationId", nodeids);
		context.put("from", 1);
		if (byCount == null) {
			byCount = 10000;
		}
		context.put("to", byCount);
		if (begin == null || end == null) {
			context.put("starttime", getOneHoursAgoTime());
			end = new Date();
		} else {
			context.put("starttime", simpledf.format(begin));
		}
		context.put("endtime", simpledf.format(end));
		return rd.runSync("QueryMonitorDataService", context);
	}

	/**
	 * 获取监测器阀值
	 * 
	 * @param monitorid
	 * @return
	 */
	public static String getMonitorNameAndCondition(String monitorid) {
		Map<String, Map<String, String>> fmap = new FastMap<String, Map<String, String>>();
		Map<String, String> ndata = new FastMap<String, String>();
		StringBuilder estr = new StringBuilder();

		ndata.put("dowhat", "QueryReportData");
		ndata.put("id", monitorid);
		ndata.put("compress", "false");
		ndata.put("dstrNeed", "false");
		ndata.put("byCount", "1");

		// Calendar cal = Calendar.getInstance();
		// ndata.put("begin_year","" + cal.get(Calendar.YEAR));
		// ndata.put("begin_month","" + (cal.get(Calendar.MONTH) + 1));
		// ndata.put("begin_day","" + cal.get(Calendar.DAY_OF_MONTH));
		// ndata.put("begin_hour","" + cal.get(Calendar.HOUR_OF_DAY));
		// ndata.put("begin_minute","" + cal.get(Calendar.MINUTE));
		// ndata.put("begin_second","" + cal.get(Calendar.SECOND));
		//        
		// ndata.put("end_year","" + cal.get(Calendar.YEAR));
		// ndata.put("end_month","" + (cal.get(Calendar.MONTH) + 1));
		// ndata.put("end_day","" + cal.get(Calendar.DAY_OF_MONTH));
		// ndata.put("end_hour","" + cal.get(Calendar.HOUR_OF_DAY));
		// ndata.put("end_minute","" + cal.get(Calendar.MINUTE));
		// ndata.put("end_second","" + cal.get(Calendar.SECOND));

		Jsvapi.getInstance().GetUnivData(fmap, ndata, estr);
		String condition = "";
		String monitorName = "";
		try {
			Map<String, String> descMap = fmap.get(monitorid);
			condition = descMap.get("errorCondition");
			monitorName = descMap.get("MonitorName");
		} catch (Exception e) {
			// TODO: handle exception
			monitorName = "";
			condition = "";
		}
		return monitorName + "#" + condition;
//		return "MonitorName#未取得阀值条件";
	}

	public static void main(String[] args) throws Exception {
		OfbizCall call = OfbizCall.getInstance();
		Map<String, Object> returnmap = call.testInsertMonitorLog();
		System.out.println(returnmap.get("logvalues"));

	}

	/**
	 * test insert method
	 * 
	 * @author zhongping.wang
	 * @throws RemoteException
	 * @throws GenericServiceException
	 * 
	 **/
	public Map<String, Object> testInsertMonitorLog()
			throws GenericServiceException, RemoteException {
		Map<String, Object> context = FastMap.newInstance();
		return rd.runSync("InsertMonitorLogService", context);
	}

	/**
	 * query data test method
	 * 
	 * @author zhongping.wang
	 * @throws RemoteException
	 * @throws GenericServiceException
	 * 
	 **/
	public Map<String, Object> testQueryData() throws GenericServiceException,
			RemoteException {
		Map<String, Object> context = FastMap.newInstance();
		String entityIndex = sdf.format(new Date());// table index
		context.put("tablename", "OperationAttributeLog" + entityIndex);
		context.put("from", 1);
		context.put("operationId", "1.27.1.1");
		context.put("to", 100000);
		context.put("starttime", "1999-07-05 09:54:54");
		context.put("endtime", "2012-07-16 15:00:54");
		return rd.runSync("QueryMonitorDataService", context);
	}

	/**
	 * Get oneHoursAgoTime<br>
	 * 
	 * @return oneHoursAgoTime
	 */
	public static String getOneHoursAgoTime() {
		String oneHoursAgoTime = "";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -8);
		oneHoursAgoTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(cal.getTime());

		return oneHoursAgoTime;
	}
}
