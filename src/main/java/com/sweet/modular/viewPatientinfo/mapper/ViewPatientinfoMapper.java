package com.sweet.modular.viewPatientinfo.mapper;import com.sweet.modular.viewPatientinfo.entity.ViewPatientinfo;import com.baomidou.mybatisplus.core.mapper.BaseMapper;import com.baomidou.mybatisplus.extension.plugins.pagination.Page;import com.baomidou.mybatisplus.core.mapper.BaseMapper;import org.apache.ibatis.annotations.Param;/** * <p> * 患者信息 Mapper 接口 * </p> * * @author admin * @since 2020-05-20 */public interface ViewPatientinfoMapper extends BaseMapper<ViewPatientinfo> {    Page<ViewPatientinfo> customPageList(Page page, @Param("param") ViewPatientinfo viewPatientinfo);}