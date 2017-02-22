package org.turing.pangu.controller.common;

import org.turing.pangu.model.App;
import org.turing.pangu.model.Device;

public class PhoneTask {
	public Device getStockInfo() {
		return stockInfo;
	}
	public void setStockInfo(Device stockInfo) {
		this.stockInfo = stockInfo;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getShellPath() {
		return shellPath;
	}
	public void setShellPath(String shellPath) {
		this.shellPath = shellPath;
	}
	public int getOperType() {
		return operType;
	}
	public void setOperType(int operType) {
		this.operType = operType;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getSpanTime() {
		return spanTime;
	}
	public void setSpanTime(int spanTime) {
		this.spanTime = spanTime;
	}
	public int getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(int isFinished) {
		this.isFinished = isFinished;
	}
	public String getVpnToken() {
		return vpnToken;
	}
	public void setVpnToken(String vpnToken) {
		this.vpnToken = vpnToken;
	}
	public App getApp() {
		return app;
	}
	public void setApp(App app) {
		this.app = app;
	}
	public int getSendTimes() {
		return sendTimes;
	}
	public void setSendTimes(int sendTimes) {
		this.sendTimes = sendTimes;
	}
	private Device stockInfo; // 存量的设备信息
	private String deviceId;
	private String vpnToken; // 带上VPN的token
	private String taskId; //任务id, 32位
	private String shellPath;
	private int operType = 0; // 操作类型  0:增量赚钱 1:增量水军 2:存量赚钱 3:存量水军
	private App app;
	private int times = 0; // 跑的次数
	private int spanTime; // times > 1次 以上间隔时间,单位秒
	private int sendTimes = 0;// 下发次数
	private int isFinished = 0; // 是否完成,1: 是 0:否
}
