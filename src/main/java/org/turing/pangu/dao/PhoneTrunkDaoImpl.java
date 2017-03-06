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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.turing.pangu.mapper.PhoneTrunkMapper;
import org.turing.pangu.model.PhoneTrunk;

@Repository
public class PhoneTrunkDaoImpl extends BaseDaoImpl<PhoneTrunk, Long> implements PhoneTrunkDao {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PhoneTrunkDaoImpl.class);

	@Autowired
	private PhoneTrunkMapper mapper;
	
	@Autowired
	public void setAppMapper(PhoneTrunkMapper mapper) {
		super.setBaseMapper(mapper);
	}
}
