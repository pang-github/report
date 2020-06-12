package com.sweet.demo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.sweet.modular.reportimage.entity.Reportimage;
import com.sweet.modular.reportimage.mapper.ReportimageMapper;
import com.sweet.modular.reportimage.service.ReportimageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sweet.core.util.ImageBinary.saveImage;
import static com.sweet.core.util.ImageBinary.getImageBinary;


public class test {
    @Autowired
    ReportimageMapper repor;

    @Test
    public void ceshi() {
        String fileName = "D://upload//timg.jpg";
        System.out.println(getImageBinary(fileName));
        saveImage(getImageBinary(fileName));
//        BASE64Encoder encoder = new BASE64Encoder();
//        encoder.encode("")
    }
}
