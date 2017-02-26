package org.turing.pangu.engine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.turing.pangu.controller.phone.request.ReportReq;
import org.turing.pangu.model.App;
import org.turing.pangu.model.Device;
import org.turing.pangu.service.DeviceService;

public class DeviceEngine {
	private static DeviceEngine mInstance = new DeviceEngine();
	private List<Device> deviceReportListCache1 = new ArrayList<Device>(); // 用于保存上报信息的两个缓存
	private List<Device> deviceReportListCache2 = new ArrayList<Device>();
	
	private List<Device> remainListCache = new ArrayList<Device>(); // 提前从数据库中查好数据放到缓存中
	private int usedWhichList = 1; 
	private DeviceService deviceService;
	public static DeviceEngine getInstance()
	{
		if(null == mInstance)
			mInstance = new DeviceEngine();
		return mInstance;
	}
	
	public void setService(DeviceService deviceService){
		this.deviceService = deviceService;
	}
	
	//从数据库中查出设备信息放入缓存, 由线程跑
	public void selectDeviceByIp(String remoteIp){
		for(Device device:remainListCache){
			if(remoteIp.equals(device.getIp())){ // 命中
				return;
			}
		}
		List<Device> fromDbList = selectStockByIp(remoteIp);
		for(Device fromDb:fromDbList){
			remainListCache.add(fromDb);
		}
	}
	
	public List<Device> getStockListFromPhoneByIp(String remoteIp){
		List<Device> stockList = new ArrayList<Device>();
		for(Device cache:remainListCache){
			if(remoteIp.equals(cache.getIp())){ // 手机端请求命中
				stockList.add(cache);
			}
		}
		return stockList;
	}
	
	private List<Device> selectStockByIp(String ip){
		Device model = new Device();
		model.setIp(ip);
		return deviceService.selectStockByIp(model);
	}
	// 由定时器调用
	public void saveReportDateToDB(){
		List<Device> needSaveList = null;
		if(usedWhichList == 1){
			needSaveList = deviceReportListCache1;
			usedWhichList = 2;
		}else{
			needSaveList = deviceReportListCache2;
			usedWhichList = 1;
		}
		for(Device device:needSaveList){
			device.setUpdateDate(new Date());
			deviceService.insert(device);
		}
	}
	public boolean saveReport(ReportReq req,boolean isWhiteIp){
		// TODO Auto-generated method stub
		Device device = new Device();
		//----------------------------------------------------------------------
		if(null == req || null == req.getDevice())
			return false;
		if( null != req.getDevice().getAndroidId())
			device.setAndroidId(req.getDevice().getAndroidId());
		
		if( null != req.getDevice().getAndroidSerial())
			device.setAndroidSerial(req.getDevice().getAndroidSerial());
			
		if( null != req.getDevice().getAndroidVersion())			
			device.setAndroidVersion(req.getDevice().getAndroidVersion());
			
		if( null != req.getDevice().getBlueTooth())			
			device.setBlueTooth(req.getDevice().getBlueTooth());
			
		if( null != req.getDevice().getBoard())			
			device.setBoard(req.getDevice().getBoard());
		
		if( null != req.getDevice().getBrand())
			device.setBrand(req.getDevice().getBrand());
		
		if( null != req.getDevice().getBssid())
			device.setBssid(req.getDevice().getBssid());
		
		if( null != req.getDevice().getCarrier())
			device.setCarrier(req.getDevice().getCarrier());
		
		if( null != req.getDevice().getCarrierCode())
			device.setCarrierCode(req.getDevice().getCarrierCode());
		
		if( null != req.getDevice().getCountryCode())
			device.setCountryCode(req.getDevice().getCountryCode());
		
		if( null != req.getDevice().getDisplay())
			device.setDisplay(req.getDevice().getDisplay());
		
		if( null != req.getDevice().getImei())
			device.setImei(req.getDevice().getImei());
		
		if( null != req.getDevice().getImsi())
			device.setImsi(req.getDevice().getImsi());
		
		if( null != req.getDevice().getIp())
			device.setIp(req.getDevice().getIp());
		

			//device.set(req.getDevice().getLatitude());
			//device.setAndroidSerial(req.getDevice().getLongitude());
		if( null != req.getDevice().getMac())
			device.setMac(req.getDevice().getMac());
		
		if( null != req.getDevice().getManufacture())
			device.setManufacture(req.getDevice().getManufacture());
		
		if( null != req.getDevice().getModel())
			device.setModel(req.getDevice().getModel());
		
			//device.set(req.getDevice().getOsArch());
			//device.setAndroidSerial(req.getDevice().getOsName());
			//device.setAndroidSerial(req.getDevice().getOsVersion());
		if( null != req.getDevice().getPhone())
			device.setPhone(req.getDevice().getPhone());
		
		if( null != req.getDevice().getSimSerial())
			device.setSimSerial(req.getDevice().getSimSerial());
		
		if( null != req.getDevice().getSsid())
			device.setSsid(req.getDevice().getSsid());
		
		if( null != req.getDevice().getUa())
			device.setUa(req.getDevice().getUa());
		
		device.setPhoneStatus(1);
		if( null != req.getDevice().getPhoneStatus() && !req.getDevice().getPhoneStatus().equals(""))
			device.setPhoneStatus(Integer.valueOf(req.getDevice().getPhoneStatus()));
		
		device.setSdk(19);
		if( null != req.getDevice().getSdk() && !req.getDevice().getSdk().equals(""))
			device.setSdk(Integer.valueOf(req.getDevice().getSdk()));
		
		device.setSimStatus(5);
		if( null != req.getDevice().getSimStatus() && !req.getDevice().getSimStatus().equals(""))
			device.setSimStatus(Integer.valueOf(req.getDevice().getSimStatus()));
		
		device.setHeight(1280);
		if( null != req.getDevice().getHeight() && !req.getDevice().getHeight().equals(""))
			device.setHeight(Integer.valueOf(req.getDevice().getHeight()));
		
		device.setWidth(720);
		if( null != req.getDevice().getWidth() && !req.getDevice().getWidth().equals(""))
			device.setWidth(Integer.valueOf(req.getDevice().getWidth()));
		
		if( null != req.getDevice().getDevice() && !req.getDevice().getDevice().equals(""))
			device.setDevice(req.getDevice().getDevice());
		
		if( null != req.getDevice().getCpuABI() && !req.getDevice().getCpuABI().equals(""))
			device.setCpuAbi(req.getDevice().getCpuABI());
		
		if( null != req.getDevice().getBootloader() && !req.getDevice().getBootloader().equals(""))
			device.setBootloader(req.getDevice().getBootloader());
		
		if( null != req.getDevice().getProduct() && !req.getDevice().getProduct().equals(""))
			device.setProduct(req.getDevice().getProduct());
		//----------------------------------------------------------------------

		device.setAppId(req.getAppId());
		device.setDeviceType(req.getDevice_type());
		device.setIsActived(req.getIs_active());
		Integer whiteIp = (isWhiteIp == true) ? 1: 0;
		device.setIsWhiteIp(whiteIp);
		device.setIsRemain(req.getIs_remain());
		device.setCreateDate(new Date());
		device.setUpdateDate(new Date());
		if(usedWhichList == 1){
			deviceReportListCache1.add(device);
		}else{
			deviceReportListCache2.add(device);
		}
		return false;
	}
}