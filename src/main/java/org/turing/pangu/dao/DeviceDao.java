/**
 * 
 * Title：User
 * Copyright: Copyright (c) 2014
 * Company: 深电中心
 * @author axi
 * @version 1.0, 2016年08月22日 
 * @since 2016年08月22日 
 */

package org.turing.pangu.dao;

import java.util.List;

import org.turing.pangu.model.Device;

public interface DeviceDao extends BaseDao<Device, Long> {
	public List<Device> selectCanRemainData(Device device);
	public List<Device> selectTimeSpan(Device device);
	public int selectCountByTimeSpan(Device device);
}
