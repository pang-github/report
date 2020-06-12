package com.sweet.modular.reportimage.controller;import com.sweet.core.translationDict.DictParam;import com.sweet.core.translationDict.TranslationDict;import org.springframework.web.bind.annotation.RequestMapping;import com.sweet.core.model.ResultBean;import com.sweet.core.model.system.LayuiPageInfo;import com.sweet.modular.reportimage.entity.Reportimage;import com.sweet.modular.reportimage.service.ReportimageService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.RequestMapping;import com.sweet.core.util.StringUtil;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.stereotype.Controller;import sun.misc.BASE64Encoder;import java.util.List;import static com.sweet.core.util.ImageBinary.getImageBinary;/** * <p> * 存放检查报告（图片） 前端控制器 * </p> * * @author admin * @since 2020-05-20 */@Controller@RequestMapping("/admin/reportimage")public class ReportimageController {    @Autowired    ReportimageService reportimageService;    /**     * 列表页     */    @RequestMapping("/reportimage_list")    public String list(){        return "/modular/reportimage/reportimage_list";    }    /**     * 编辑页     */    @RequestMapping("/reportimage_edit")    public String edit(){        return "/modular/reportimage/reportimage_edit";    }    /**     * 添加/编辑     */    @RequestMapping("/editReportimage")    @ResponseBody    public ResultBean editReportimage(Reportimage reportimage){        reportimageService.saveOrUpdate(reportimage);        return ResultBean.success(reportimage);    }    /**     * 删除     */    @RequestMapping("/delReportimage")    @ResponseBody    public ResultBean delReportimage(Reportimage reportimage){        reportimageService.removeById(reportimage);        return ResultBean.success(reportimage);    }    /**     * 添加修改菜单     * @param menu     * @return     */    @RequestMapping("/getReportimageDetail")    @ResponseBody    public ResultBean getReportimageDetail(String id){        Reportimage reportimage = reportimageService.getById(id);        return ResultBean.success(reportimage);    }    /**     * 列表数据     */    @RequestMapping("/getReportimageList")    @ResponseBody    @TranslationDict({    })    public LayuiPageInfo getReportimageList(Reportimage reportimage){        BASE64Encoder encoder = new BASE64Encoder();        LayuiPageInfo pageInfo = reportimageService.findPageBySpec(reportimage);        return pageInfo;    }    /**     * 添加/编辑     */    @RequestMapping("/fileimage")    @ResponseBody    public ResultBean fileimage(String imageName){        Reportimage reportimage  = new Reportimage();        String fileName = "D://upload//"+imageName;        String i =  getImageBinary(fileName);        System.out.println(i);        if(StringUtil.isNotEmpty(i)){            reportimage.setJcbg00(i);            reportimageService.saveOrUpdate(reportimage);        }        return ResultBean.success(reportimage);    }}