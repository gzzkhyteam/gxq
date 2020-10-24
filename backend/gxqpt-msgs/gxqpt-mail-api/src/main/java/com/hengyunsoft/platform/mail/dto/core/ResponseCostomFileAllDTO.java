package com.hengyunsoft.platform.mail.dto.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 所有目录文件夹
 *
 * @auth wt
 * @date 2018/07/30
 */
@Data
@ApiModel(value = "ResponseCostomFileAll", description = "所有目录文件夹返回")
public class ResponseCostomFileAllDTO {

    public ResponseCostomFileAllDTO() {

    }

    public ResponseCostomFileAllDTO(String fileName, String fileMark, Integer countSum) {
        this.fileName = fileName;
        this.countSum = countSum;
        this.fileMark = fileMark;
    }

    /**
     * 文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名")
    private String fileName;

    /**
     * 数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数量")
    private Integer countSum;

    /**
     * 文件标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件标识")
    private String fileMark;

    /**
     * 自定义文件
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "自定义文件")
    private List<ResponseCostomFileAllDTO> costomFIle;

}
