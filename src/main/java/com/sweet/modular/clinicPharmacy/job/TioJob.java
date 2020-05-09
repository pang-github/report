package com.sweet.modular.clinicPharmacy.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sweet.modular.clinicPharmacy.entity.ClinicPharmacy;
import com.sweet.modular.clinicPharmacy.service.ClinicPharmacyService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.rockyang.tio.websocket.starter.TioWebSocketServerBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.tio.core.Tio;
import org.tio.websocket.common.WsResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TioJob implements Job {

    @Autowired
    private TioWebSocketServerBootstrap bootstrap;
    @Autowired
    ClinicPharmacyService clinicPharmacyService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        QueryWrapper<ClinicPharmacy> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("state_type","0");
        int s = clinicPharmacyService.count(queryWrapper);

        String message = "tips:"+s ;
        Tio.sendToAll(bootstrap.getServerGroupContext(), WsResponse.fromText(message,"utf-8"));

    }
}
