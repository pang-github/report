package com.sweet.modular.reportresult.mapper;import com.sweet.modular.reportresult.entity.Reportresult;import com.baomidou.mybatisplus.core.mapper.BaseMapper;import com.baomidou.mybatisplus.extension.plugins.pagination.Page;import com.baomidou.mybatisplus.core.mapper.BaseMapper;import org.apache.ibatis.annotations.Param;/** * <p> * 存放检查结果（数据） Mapper 接口 * </p> * * @author admin * @since 2020-05-20 */public interface ReportresultMapper extends BaseMapper<Reportresult> {    Page<Reportresult> customPageList(Page page, @Param("param") Reportresult reportresult);}