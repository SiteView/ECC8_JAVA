package com.siteview.ecc.alert;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;
import com.siteview.ecc.alert.dao.bean.AccessControl;
import com.siteview.ecc.alert.dao.bean.BaseAlert;
import com.siteview.ecc.alert.dao.bean.SnmpTrapAlert;
import com.siteview.ecc.alert.util.BaseTools;
import com.siteview.ecc.alert.util.DictionaryFactory;
import com.siteview.ecc.util.Message;
import com.siteview.ecc.util.Toolkit;

public class SnmpTrapAlertView extends AbstractWindow {

	private static final long serialVersionUID = -8320453436709586893L;
	private SnmpTrapAlert alertinformation = null;
	
	public BaseAlert getAlertinformation() {
		return alertinformation;
	}
	public void setAlertinformation(SnmpTrapAlert alertinformation) {
		this.alertinformation = alertinformation;
	}
	class OkClickListener implements EventListener {
		SnmpTrapAlertView view = null;
		public OkClickListener(SnmpTrapAlertView view){
			this.view = view;
		}
		@Override
		public void onEvent(Event event) throws Exception {
			try{
				view.setBaseAlertInformation(alertinformation);
				alertinformation.setAlertServer(getAlertServer().getValue());
				alertinformation.setSnmpPort(getSnmpPort().getValue());
				alertinformation.setDeviceOid(getDeviceOid().getValue());
				alertinformation.setDeviceCommunity(getDeviceCommunity().getValue());
				alertinformation.setAlertPloy(view.getAlertPloy().getValue());
				if (EmailAlertView.CMD_ADD.equals(this.view.getVariable(EmailAlertView.COMMAND_VAR, true))){
					DictionaryFactory.getIAlertDao().addAlert(new AccessControl(), alertinformation);
				}else if (EmailAlertView.CMD_EDIT.equals(this.view.getVariable(EmailAlertView.COMMAND_VAR, true))){
					DictionaryFactory.getIAlertDao().updateAlert(new AccessControl(), alertinformation, true);
				}
				Toolkit.getToolkit().setCookie("alert_rul_imfomation", alertinformation.getId(), 99999999);
				view.detach();
			}catch (Exception e){
				Message.showError(e.getMessage());
			}
		}
	}
	public void onCreate() throws Exception{
		try{
			getOkButton().addEventListener(Events.ON_CLICK, new OkClickListener(this));
			
			if (CMD_ADD.equals(this.getVariable(COMMAND_VAR, true))){
				this.setAlertinformation(new SnmpTrapAlert());
			}else if (CMD_EDIT.equals(this.getVariable(COMMAND_VAR, true))){
				this.setAlertinformation((SnmpTrapAlert) this.getVariable("alertinformation",true));
				getAlertServer().setText(alertinformation.getAlertServer());
				getSnmpPort().setText(alertinformation.getSnmpPort());
				getDeviceOid().setText(alertinformation.getDeviceOid());
				getDeviceCommunity().setText(alertinformation.getDeviceCommunity());
				getAlertPloy().setValue(alertinformation.getAlertPloy());
				setBaseAlertComponentInformation(this.getAlertinformation());
				
			}
		}catch (Exception e){
			Message.showError(e.getMessage());
		}
	}
	/**
	 * 目标服务器
	 * @return Textbox
	 */
	public Textbox getAlertServer(){
		return (Textbox)BaseTools.getComponentById(this,"alertServer");
	}
	/**
	 * 端口号
	 * @return Textbox
	 */
	public Textbox getSnmpPort(){
		return (Textbox)BaseTools.getComponentById(this,"snmpPort");
	}
	/**
	 * 设备Oid
	 * @return Textbox
	 */
	public Textbox getDeviceOid(){
		return (Textbox)BaseTools.getComponentById(this,"deviceOid");
	}
	/**
	 * 设备共同体
	 * @return Textbox
	 */
	public Textbox getDeviceCommunity(){
		return (Textbox)BaseTools.getComponentById(this,"deviceCommunity");
	}
	/**
	 * 告警策略
	 */
	public Combobox getAlertPloy(){
		return (Combobox)BaseTools.getComponentById(this,"alertPloy");
	}
}
