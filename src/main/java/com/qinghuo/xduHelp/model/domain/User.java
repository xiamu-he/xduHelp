package com.qinghuo.xduHelp.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
@author qzx
@create 2022-02-17 17:53
@function
*/
@ApiModel(value="`user`")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String nickName;

    @ApiModelProperty(value="")
    private String realName;

    @ApiModelProperty(value="")
    private Integer gender;

    @ApiModelProperty(value="")
    private String studentNumber;

    @ApiModelProperty(value="")
    private String grade;

    @ApiModelProperty(value="")
    private String academy;

    @ApiModelProperty(value="")
    private String phoneNumber;

    @ApiModelProperty(value="")
    private String avatar;

    @ApiModelProperty(value="")
    private String campusCardAvatar;

    @ApiModelProperty(value="")
    private String wxNumber;

    @ApiModelProperty(value="")
    private String openid;

    @ApiModelProperty(value="")
    private Integer isCertified;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}