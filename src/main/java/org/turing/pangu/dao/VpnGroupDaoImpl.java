/**
 * 
 * Title：User
 * Copyright: Copyright (c) 2014
 * Company: 深电中心
 * @author axi
 * @version 1.0, 2016年08月23日 
 * @since 2016年08月23日 
 */

package org.turing.pangu.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.turing.pangu.mapper.VpnGroupMapper;
import org.turing.pangu.model.VpnGroup;

@Repository
public class VpnGroupDaoImpl extends BaseDaoImpl<VpnGroup, Long> implements VpnGroupDao {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(VpnGroupDaoImpl.class);

	@Autowired
	private VpnGroupMapper mapper;
	
	@Autowired
	public void setVpnGroupMapper(VpnGroupMapper mapper) {
		super.setBaseMapper(mapper);
	}

	@Override
	public List<VpnGroup> selectValid(VpnGroup model) {
		// TODO Auto-generated method stub
		List<VpnGroup> list = null;
		try {
			list = mapper.selectList(model);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return list;
	}

}
