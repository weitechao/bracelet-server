package com.bracelet.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.bracelet.entity.FrequencyContro;
import com.bracelet.entity.HeartRate;
import com.bracelet.service.PageParam;
import com.bracelet.service.Pagination;

public interface IHeartRateService {

	boolean insert(Long user_id, Integer heartRate, Timestamp timestamp);

	/**
	 * 查询最近的脉搏
	 * 
	 * @param user_id
	 * @return
	 */
	HeartRate getLatest(Long user_id);

	Pagination<HeartRate> find(Long user_id, PageParam pageParam);

	FrequencyContro getHeartCheckFrequency(String s);
		List<Map<String, Object>> monthData(Long user_id);

}
