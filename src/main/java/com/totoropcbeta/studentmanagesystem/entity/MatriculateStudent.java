package com.totoropcbeta.studentmanagesystem.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "学生录取信息表")
@Data
public class MatriculateStudent {
    @ApiModelProperty(value = "学生录取信息表主键")
    @ExcelIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    @ExcelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "学生身份证")
    @ExcelProperty(value = "学生身份证")
    private String idCard;

    @ApiModelProperty(value = "所属学院")
    @ExcelProperty(value = "所属学院")
    private Byte collegeId;

    @ApiModelProperty(value = "所属专业")
    @ExcelProperty(value = "所属专业")
    private Byte majorId;

    @ApiModelProperty(value = "所属班级")
    @ExcelProperty(value = "所属班级")
    private Byte classId;

    @ApiModelProperty(value = "学生顺序码")
    @ExcelProperty(value = "学生顺序码")
    private Byte orderNum;

    @ApiModelProperty(value = "录取年份")
    @ExcelProperty(value = "录取年份")
    //@DateTimeFormat(pattern = "yyyyMMdd")
    private String matriculateYear;

    @ApiModelProperty(value = "毕业年份")
    @ExcelProperty(value = "毕业年份")
    //@DateTimeFormat(pattern = "yyyyMMdd")
    private String graduateYear;

    @ApiModelProperty(value = "是否已登记注册")
    @ExcelIgnore
    private Byte isRegistered;

    @ApiModelProperty(value = "创建时间")
    @ExcelIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @ExcelIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date updateTime;
}
