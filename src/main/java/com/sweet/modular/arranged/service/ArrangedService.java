package com.sweet.modular.arranged.service;import com.sweet.modular.arranged.entity.Arranged;import com.baomidou.mybatisplus.extension.service.IService;import com.sweet.core.model.system.LayuiPageInfo;import com.baomidou.mybatisplus.extension.service.IService;import java.text.ParseException;import java.util.Date;import java.util.List;/** * <p> * 预约信息 服务类 * </p> * * @author admin * @since 2020-04-03 */public interface ArrangedService extends IService<Arranged> {    public LayuiPageInfo findPageBySpec(Arranged arranged);    public List<Arranged> getStime(String timeF, String timeR, String patient_id) throws ParseException;}