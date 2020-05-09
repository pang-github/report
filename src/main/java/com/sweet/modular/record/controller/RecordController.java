package com.sweet.modular.record.controller;import cn.hutool.core.date.DateUtil;import com.alibaba.fastjson.JSON;import com.baomidou.mybatisplus.core.conditions.Wrapper;import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;import com.sweet.core.translationDict.DictParam;import com.sweet.core.translationDict.TranslationDict;import com.sweet.core.util.RedisUtil;import com.sweet.modular.clinicPharmacy.entity.ClinicPharmacy;import com.sweet.modular.clinicPharmacy.service.ClinicPharmacyService;import com.sweet.modular.medicine.MedicineController;import com.sweet.modular.patient.entity.Patient;import com.sweet.modular.patient.service.PatientService;import com.sweet.modular.rxdrug.entity.Rxdrug;import com.sweet.modular.rxdrug.service.RxdrugService;import com.sweet.modular.weixin.service.WeiXinService;import com.sweet.system.entity.Dict;import com.sweet.system.entity.User;import com.sweet.system.service.UserService;import me.chanjar.weixin.common.error.WxErrorException;import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;import org.rockyang.tio.websocket.starter.TioWebSocketServerBootstrap;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Value;import org.springframework.transaction.annotation.Transactional;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import com.sweet.core.model.ResultBean;import com.sweet.core.model.system.LayuiPageInfo;import com.sweet.modular.record.entity.Record;import com.sweet.modular.record.service.RecordService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.RequestMapping;import com.sweet.core.util.StringUtil;import java.util.Date;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.stereotype.Controller;import org.tio.core.Tio;import org.tio.utils.jfinal.P;import org.tio.websocket.common.WsResponse;import javax.servlet.http.HttpServletRequest;import java.util.ArrayList;import java.util.List;/** * <p> * 患者住院档案 前端控制器 * </p> * * @author admin * @since 2020-01-08 */@Controller@RequestMapping("/admin/record")public class RecordController {    static Logger logger = LoggerFactory.getLogger(MedicineController.class);    @Autowired    ClinicPharmacyService clinicPharmacyService;    @Autowired    private TioWebSocketServerBootstrap bootstrap;    @Autowired    HttpServletRequest request;    @Autowired    UserService userService;    @Autowired    RecordService recordService;    @Autowired    RedisUtil redisUtil;    @Autowired    RxdrugService rxdrugService;    @Autowired    WeiXinService weiXinService;    @Autowired    PatientService patientService;    @Value("${system.domain}")    public String domain;    /**     * 列表页     */    @RequestMapping("/record_list")    public String list(){        return "/modular/record/record_list";    }    /**     * 打印页     */    @RequestMapping("/record_print")    public String print(){        return "/modular/record/record_print";    }    /**     * 编辑页     */    @RequestMapping("/record_edit")    public String edit(){        return "/modular/record/record_edit";    }    /**     * 添加/编辑     */    @RequestMapping("/editRecord")    @ResponseBody    @Transactional    public ResultBean editRecord(Record record,String rxdata) throws WxErrorException {        Boolean isSend = false;        if(StringUtil.isEmpty(record.getId())){            isSend = true;        }        recordService.saveOrUpdate(record);        if(StringUtil.isNotEmpty(rxdata)){           List<Rxdrug> rxdrugList =  JSON.parseArray(rxdata,Rxdrug.class);            rxdrugList.stream().forEach(rxdrug -> {                rxdrug.setRecordId(record.getId());                rxdrugService.saveOrUpdate(rxdrug);            });        }        List<WxMpTemplateData> data = new ArrayList<>();        data.add(new WxMpTemplateData("first","您有一个新的健康档案"));        data.add(new WxMpTemplateData("keyword1",record.getPatientName()));        data.add(new WxMpTemplateData("keyword2",DateUtil.formatDate(new Date())));        data.add(new WxMpTemplateData("keyword3", record.getCheckDoctor()));        data.add(new WxMpTemplateData("remark", "点击查看详情"));        Patient patient = patientService.getById(record.getPatientId());        User user = userService.getById(patient.getUserid());        System.out.println(user.getOpenId());        if(StringUtil.isNotEmpty(user.getOpenId())&&isSend){            String url = domain+"/weixin";            weiXinService.sendTemplateMessage(WeiXinService.CASE_INFORM,user.getOpenId(),data,url);        }        if(isSend) {            ClinicPharmacy clinicPharmacy = new ClinicPharmacy();            clinicPharmacy.setRecordId(record.getId());            clinicPharmacy.setCreateTime(new Date());            clinicPharmacy.setStateType("0");            clinicPharmacy.setUserId("dev");            clinicPharmacyService.saveOrUpdate(clinicPharmacy);            String message ="id:"+record.getId();            Tio.sendToAll(bootstrap.getServerGroupContext(), WsResponse.fromText(message,"utf-8"));        }        return ResultBean.success(record);    }    /**     * 添加/编辑     */    @RequestMapping("/editupdate")    @ResponseBody    public ResultBean editupdate(Record record,String id,String zycs){        recordService.updatezycs(record,id,zycs);        return ResultBean.success(record);    }    /**     * 删除     */    @RequestMapping("/delRecord")    @ResponseBody    public ResultBean delRecord(Record record){        recordService.removeById(record);        return ResultBean.success(record);    }    /**     * 添加修改菜单     * @param menu     * @return     */    @RequestMapping("/getRecordDetail")    @ResponseBody    public ResultBean getRecordDetail(String id){        Record record = recordService.getById(id);        return ResultBean.success(record);    }    /**     * 列表数据     */    @RequestMapping("/getRecordList")    @ResponseBody    @TranslationDict({            @DictParam(dictType = "e83f192c870f5e6c26bd75318c322d19",dictValueFiled = "stateType"),    })    public LayuiPageInfo getRecordList(Record Record){        LayuiPageInfo pageInfo = recordService.findPageBySpec(Record);        Rxdrug rxdrug = new Rxdrug();        List<Record> list = pageInfo.getData();        list.stream().forEach(record -> {            String recordId = record.getId();            rxdrug.setRecordId(recordId);            QueryWrapper<Rxdrug> queryWrapper = new QueryWrapper<>();            queryWrapper.like("RECORD_ID",record.getId());            List<Rxdrug> re = rxdrugService.list(queryWrapper);            record.setDrugList(re);        });        return pageInfo;    }}