package com.siteview.ecc.alert.dao.bean;


public class SnmpTrapAlert  extends BaseAlert{
	private String alertServer;
	private String snmpPort;
	private String deviceOid;
	private String deviceCommunity;
	private String alertPloy;
    public String getAlertServer() {
		return alertServer;
	}
	public void setAlertServer(String alertServer) {
		this.alertServer = alertServer;
	}
	public String getSnmpPort() {
		return snmpPort;
	}
	public void setSnmpPort(String snmpPort) {
		this.snmpPort = snmpPort;
	}
	public String getDeviceOid() {
		return deviceOid;
	}
	public void setDeviceOid(String deviceOid) {
		this.deviceOid = deviceOid;
	}
	public String getDeviceCommunity() {
		return deviceCommunity;
	}
	public void setDeviceCommunity(String deviceCommunity) {
		this.deviceCommunity = deviceCommunity;
	}
	public String getAlertPloy() {
		return alertPloy;
	}
	public void setAlertPloy(String alertPloy) {
		this.alertPloy = alertPloy;
	}

}
