package com.sweet.modular.taskdetail.service.impl;import com.sweet.modular.taskdetail.entity.Taskdetail;import com.sweet.modular.taskdetail.mapper.TaskdetailMapper;import com.sweet.modular.taskdetail.service.TaskdetailService;import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;import org.springframework.stereotype.Service;import com.baomidou.mybatisplus.core.metadata.IPage;import com.baomidou.mybatisplus.extension.plugins.pagination.Page;import com.sweet.core.model.system.LayuiPageFactory;import com.sweet.core.model.system.LayuiPageInfo;import java.util.List;/** * <p> * 随访详情 服务实现类 * </p> * * @author admin * @since 2020-03-13 */@Servicepublic class TaskdetailServiceImpl extends ServiceImpl<TaskdetailMapper, Taskdetail> implements TaskdetailService {    @Override    public LayuiPageInfo findPageBySpec(Taskdetail taskdetail) {        Page pageContext = LayuiPageFactory.defaultPage();        IPage page = this.baseMapper.customPageList(pageContext, taskdetail);        return LayuiPageFactory.createPageInfo(page);    }    @Override    public List<Taskdetail> getPatientTaskdetailList(String patientID) {        return baseMapper.getPatientTaskdetail(patientID);    }}