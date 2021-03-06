package com.bracelet.service;

import com.bracelet.entity.SensitiveArea;
import com.bracelet.entity.SensitivePoint;
import java.util.List;

public interface ISensitivePointService {

	List<SensitiveArea> find(Long user_id);

	boolean insert(Long user_id, String name, String lat, String lng, Integer radius);

	boolean update(Long id, Long user_id, String name, String lat, String lng, Integer radius);

	boolean delete(Long id, Long user_id);

	void checkSensitivePointArea(Long user_id, String imei, String lat, String lng, long time);

	boolean updateStatus(Long id, Integer status);

	boolean insertSensitiveArea(Long user_id, String name, String lat, String lng, Integer radius);

	boolean updateSensitiveArea(Long id, Long user_id, String name, String lat, String lng, Integer radius);

	boolean deleteSensitiveArea(Long id, Long user_id);

}
