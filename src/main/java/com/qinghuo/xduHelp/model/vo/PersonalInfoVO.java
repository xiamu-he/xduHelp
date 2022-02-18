package com.qinghuo.xduHelp.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class PersonalInfoVO implements Serializable {
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;


    /**
     * 学号
     */
    @ApiModelProperty(value = "学号")
    private String studentNumber;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String academy;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String phoneNumber;

    /**
     * 个人头像地址
     */
    @ApiModelProperty(value = "个人头像地址")
    private String avatar;

    private static final long serialVersionUID = 1L;
}

