package org.turing.pangu.task;

import java.util.Date;

import org.turing.pangu.model.Device;
// 留存专用,先通过IP查询出每个应用的地域留存信息,供后续请求下发
public class StockTask {
	private boolean isUsed = false; // 1:已使用 0: 未使用
	private Device device ; // 对应设备记录
	private Date sendDate = new Date(); // 下发时间
	private Date finishedDate = new Date(); // 完成时间
	
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Date getFinishedDate() {
		return finishedDate;
	}
	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}
	
	
}
