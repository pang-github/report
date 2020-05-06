package com.sweet.modular.patient.mapper;import com.sweet.modular.patient.entity.Patient;import com.baomidou.mybatisplus.core.mapper.BaseMapper;import com.baomidou.mybatisplus.extension.plugins.pagination.Page;import com.baomidou.mybatisplus.core.mapper.BaseMapper;import org.apache.ibatis.annotations.Param;import org.apache.ibatis.annotations.Select;import java.util.List;/** * <p> * 患者表 Mapper 接口 * </p> * * @author admin * @since 2020-01-07 */public interface PatientMapper extends BaseMapper<Patient> {    Page<Patient> customPageList(Page page, @Param("param") Patient patient);    @Select("select * from business_patient where userid = #{userId}")    Patient getPatientByUserId(@Param("userId")String userId);    @Select("select * from business_patient where patient_type = #{patientType}")    List<Patient> getPatientByType(@Param("patientType")String patientType);    @Select("select * from business_patient where blcjz = #{doctorId}")    List<Patient> getPatientByDoctorId(@Param("doctorId")String doctorId);    @Select("select * from business_patient where phone_number = #{phone_number}")    Patient getPatientphone(@Param("phone_number")String phone_number);    @Select("select * from business_patient where id = #{id}")    Patient getPatientById(@Param("id")String id);}