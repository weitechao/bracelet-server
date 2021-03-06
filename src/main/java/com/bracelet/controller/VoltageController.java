package com.bracelet.controller;

import com.bracelet.dto.HttpBaseDto;
import com.bracelet.dto.LatestVoltageDto;
import com.bracelet.entity.Voltage;
import com.bracelet.service.IVoltageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/voltage")
public class VoltageController extends BaseController {
    @Autowired
    IVoltageService voltageService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("/search/latest/{token}")
    public HttpBaseDto getLatestVoltage(@PathVariable String token) {
        Long user_id = checkTokenAndUser(token);
        Voltage voltage = voltageService.getLatest(user_id);
        LatestVoltageDto latestVoltageDto = null;
        if (voltage != null) {
        	latestVoltageDto = new LatestVoltageDto();
        	latestVoltageDto.setVoltage(voltage.getVoltage());
        	latestVoltageDto.setTimestamp(voltage.getUpload_time().getTime());
        }
        HttpBaseDto dto = new HttpBaseDto();
        dto.setData(latestVoltageDto);
        return dto;
    }

}
