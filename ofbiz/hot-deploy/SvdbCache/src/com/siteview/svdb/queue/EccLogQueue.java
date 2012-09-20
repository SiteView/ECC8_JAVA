package com.siteview.svdb.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EccLogQueue {
	public static ArrayList<Map<String, String>> listMap;

	public EccLogQueue() {
		listMap = new ArrayList();
	}
	/**
	 * get the first data
	 * @return firstMap
	 */
	public Map<String, String> getFirst() {
		if (!listMap.isEmpty()) {
			Map firstMap = (Map) listMap.get(0);
			listMap.remove(0);
			return firstMap;
		}
		return null;
	}
	/**
	 * get batch data
	 * @param mapCount
	 * @return mapList
	 */
	public List<Map<String, String>> getBatchMap(int mapCount) {
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();

		if (!listMap.isEmpty()) {
			int listSize = listMap.size();
			if (listSize < mapCount) {
				mapCount = listSize;
			}
			for (int i = 0; i < mapCount; ++i) {
				Map<String, String> indexMap = listMap.get(0);
				mapList.add(indexMap);
				listMap.remove(0);
			}
			return mapList;
		}
		return null;
	}
	/**
	 * Add data to queue
	 * @param paramsmap
	 */
	public static void insertLast(Map<String, String> paramsmap) {
		listMap.add(paramsmap);
	}

	public static void main(String[] args) {
		EccLogQueue seq = new EccLogQueue();
		Map m1 = new HashMap();
		m1.put("1key", "1Val");
		Map m2 = new HashMap();
		m2.put("2key", "2Val");
		Map m3 = new HashMap();
		m3.put("3key", "3Val");
		seq.insertLast(m1);
		seq.insertLast(m2);
		seq.insertLast(m3);
		System.out.println(seq.getFirst());
		System.out.println(seq.getFirst());
		System.out.println(seq.getFirst());
	}
}