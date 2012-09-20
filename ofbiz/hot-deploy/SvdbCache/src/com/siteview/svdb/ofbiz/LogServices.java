package com.siteview.svdb.ofbiz;

import com.siteview.ecc.util.ArrayTool;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javolution.util.FastList;
import javolution.util.FastMap;
import org.ofbiz.base.util.Debug;
import org.ofbiz.base.util.UtilMisc;
import org.ofbiz.entity.Delegator;
import org.ofbiz.entity.GenericValue;
import org.ofbiz.entity.condition.EntityCondition;
import org.ofbiz.entity.condition.EntityOperator;
import org.ofbiz.entity.model.DynamicViewEntity;
import org.ofbiz.entity.util.EntityListIterator;
import org.ofbiz.service.DispatchContext;
import org.ofbiz.service.ServiceUtil;

public class LogServices
{
  public static final String module = LogServices.class.getName();

  public static Map<String, Object> queryReportData(DispatchContext dctx, Map<String, ?> context)
    throws Exception
  {
    Map response = ServiceUtil.returnSuccess();
    String tablename = (String)context.get("tablename");
    String monitorIds = (String)context.get("operationId");
    int from = ((Integer)context.get("from")).intValue();
    int to = ((Integer)context.get("to")).intValue();
    String startTime = (String)context.get("starttime");
    String endTime = (String)context.get("endtime");
    Timestamp startdate = Timestamp.valueOf(startTime);
    Timestamp enddate = Timestamp.valueOf(endTime);
    String[] Ids = monitorIds.split(",");
    Map fmap = new FastMap();
    for (String monitorId : Ids) {
      List entityConditionList = FastList.newInstance();
      entityConditionList.add(EntityCondition.makeCondition("operationId", EntityOperator.EQUALS, monitorId));
      entityConditionList.add(EntityCondition.makeCondition("logTime", EntityOperator.BETWEEN, UtilMisc.toList(startdate, enddate)));
      EntityCondition condition = EntityCondition.makeCondition(entityConditionList, EntityOperator.AND);

      DynamicViewEntity dve = new DynamicViewEntity();
      Collection fieldsToSelect = FastList.newInstance();
      fieldsToSelect.add("operationId");
      fieldsToSelect.add("name");
      fieldsToSelect.add("logTime");
      fieldsToSelect.add("category");
      fieldsToSelect.add("description");
      dve.addMemberEntity("OperLog", tablename);
      dve.addAliasAll("OperLog", "");
      List orderBy = UtilMisc.toList("logTime DESC");
      Delegator delegator = dctx.getDelegator();
      EntityListIterator resultiterator = delegator.findListIteratorByCondition(dve, condition, null, fieldsToSelect, orderBy, null);

      List result = resultiterator.getPartialList(from, to);

      String[] str = new String[20];
      String[] str2 = new String[20];
      String[] descArray = new String[result.size()];
      int goodCount = 0;
      int errorCount = 0;
      int warnCount = 0;
      String latestCreateTime = "";
      String latestDstr = "";
      String latestStatus = "";
      Debug.logInfo(">>>>监测器ID: " + monitorId + " 查询出 " + result.size() + " 条数据", module);
      String monitorName = "";

      for (int j = 0; j < result.size(); ++j) {
        GenericValue genericValue = (GenericValue)result.get(j);
        String category = genericValue.get("category").toString();
        monitorName = genericValue.get("name").toString();
        if (category.equals("ok"))
          ++goodCount;
        else if ((category.equals("error")) || (category.equals("bad")))
          ++errorCount;
        else if (category.equals("warning")) {
          ++warnCount;
        }
        String reportDataValue = genericValue.get("description").toString();

        String logTime = genericValue.get("logTime").toString();
        logTime = logTime.substring(0, logTime.lastIndexOf("."));
        if (latestCreateTime.equals("")) {
          latestCreateTime = logTime;
          latestStatus = category;
          latestDstr = reportDataValue;
        }
        descArray[j] = (logTime + "&" + reportDataValue + "#" + category);
        if (category.equals("BAD")) {
          continue;
        }
        String[] dataValue = null;
        reportDataValue = reportDataValue.substring(0, reportDataValue.length() - 1);
        if (reportDataValue.contains(",")) {
          dataValue = reportDataValue.split(",");
        }
        if (dataValue != null) {
          for (int g = 0; g < dataValue.length; ++g) {
            String indexDataValue = dataValue[g];
            String returnName = indexDataValue.substring(0, indexDataValue.indexOf("="));

            String returnValue = indexDataValue.substring(indexDataValue.indexOf("=") + 1, indexDataValue.length());

            String timeValueStr = logTime + "=" + returnValue + ",";
            if (str[g] != null) {
              str[g] = (str[g] + timeValueStr);
            } else {
              str2[g] = returnName;
              str[g] = timeValueStr;
            }
          }
        }
      }

      for (int strSize = 0; (strSize < str.length) && 
        (str[strSize] != null); ++strSize)
      {
        String dataStrArrayStr = str[strSize];
        String[] dataStrArray = dataStrArrayStr.split(",");
        double[] dArray = new double[result.size()];
        String whenMax = "";
        String latest = "";
        for (int i = 0; i < dataStrArray.length; ++i) {
          String dValue = dataStrArray[i];
          String val = dValue.substring(dValue.indexOf("=") + 1, dValue.length());
          if (latest.equals("")) {
            latest = val;
          }
          dArray[i] = Double.parseDouble(val);
        }
        double max = ArrayTool.getDoubleArrayMax(dArray);
        double average = ArrayTool.getDoubleArrayAvg(dArray);
        double min = ArrayTool.getDoubleArrayMin(dArray);
        for (String indexstr : dataStrArray) {
          String val = indexstr.substring(indexstr.indexOf("=") + 1, indexstr.length());
          if ((whenMax.equals("")) && (val.equals(String.valueOf(max) + "0"))) {
            whenMax = indexstr.substring(0, indexstr.indexOf("="));
          }
        }

        Map returnMap = new FastMap();
        String returnKey = "(Return_" + strSize + ")" + monitorId;
        returnMap.put("MonitorName", monitorName);
        returnMap.put("ReturnName", str2[strSize]);
        returnMap.put("average", String.valueOf(average));
        returnMap.put("latest", latest);
        returnMap.put("max", String.valueOf(max));
        returnMap.put("min", String.valueOf(min));
        returnMap.put("detail", dataStrArrayStr);
        returnMap.put("sv_baseline", "1");
        returnMap.put("sv_drawimage", "1");
        returnMap.put("sv_drawmeasure", "1");
        returnMap.put("sv_drawtable", "1");
        returnMap.put("sv_primary", "1");
        returnMap.put("when_max", whenMax);
        fmap.put(returnKey, returnMap);
      }

      Map descMap = new FastMap();
      String descKey = "(dstr)" + monitorId;
      for (String desc : descArray) {
        String logTime = desc.substring(0, desc.indexOf("&"));
        String descValue = desc.substring(desc.indexOf("&") + 1, desc.indexOf("#"));
        String category = desc.substring(desc.indexOf("#") + 1, desc.length());
        if ((category.equals("ERROR")) || (category.equals("BAD")))
          category = "error";
        else if (category.equals("WARNING"))
          category = "warning";
        else if (category.equals("OK")) {
          category = "ok";
        }
        descMap.put(logTime, category + " " + descValue);
      }
      descMap.put("MonitorName", monitorName);
      fmap.put(descKey, descMap);

      Map endMap = new FastMap();
      for (int strSize = 0; strSize < str.length; ++strSize) {
        String threeKey = "(Return_" + strSize + ")";
        if (str[strSize] == null) continue; endMap.put(threeKey, "ReturnValue");
      }

      endMap.put("MonitorName", monitorName);

      endMap.put("errorPercent", ArrayTool.percent(errorCount, result.size()));
      endMap.put("latestCreateTime", latestCreateTime);
      endMap.put("latestDstr", latestDstr);
      endMap.put("latestStatus", latestStatus);
      endMap.put("okPercent", ArrayTool.percent(goodCount, result.size()));
      endMap.put("warnPercent", ArrayTool.percent(warnCount, result.size()));
      fmap.put(monitorId, endMap);
      if (result.size() == 0) {
        fmap.clear();
        Map nodataMap = new FastMap();
        nodataMap.put("return", "true");
        fmap.put("return", nodataMap);
      }
    }

    response.put("logvalues", fmap);
    return response;
  }
}