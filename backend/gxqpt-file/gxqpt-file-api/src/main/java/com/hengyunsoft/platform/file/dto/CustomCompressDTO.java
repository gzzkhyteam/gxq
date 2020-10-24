//package com.hengyunsoft.platform.file.dto;
//
//import com.hengyunsoft.platform.file.constant.CompressType;
//import com.hengyunsoft.platform.file.constant.PictureType;
//import com.hengyunsoft.platform.file.constant.ThumMethodType;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import org.springframework.web.multipart.MultipartFile;
//
//@Data
//@ApiModel(value = "CustomCompress", description = "图片统一处理实体")
//public class CustomCompressDTO {
//    /**
//     * 缩放-宽
//     */
//    @ApiModelProperty(value = "缩放-宽")
//    private Integer width;
//    /**
//     * 缩放-高
//     */
//    @ApiModelProperty(value = "缩放-高")
//    private Integer height;
//    /**
//     * 缩放-比例
//     */
//    @ApiModelProperty(value = "缩放-比例")
//    private Float rate;
//    /**
//     * 是否等比
//     */
//    @ApiModelProperty(value = "是否等比")
//    private boolean keepRatio;
//    /**
//     * 压缩质量
//     */
//    @ApiModelProperty(value = "压缩质量")
//    private Float quality;
//    /**
//     * 水印图片
//     */
//    @ApiModelProperty(value = "水印图片")
//    private MultipartFile waterFile;
//    /**
//     * 透明度
//     */
//    @ApiModelProperty(value = "透明度")
//    private Float alpha;
//    /**
//     * 旋转角度
//     */
//    @ApiModelProperty(value = "旋转角度")
//    private Float rotate;
//    /**
//     * 压缩大小类型
//     */
//    @ApiModelProperty(value = "压缩大小类型")
//    private CompressType compressType;
//    /**
//     * 修改图片类型
//     */
//    @ApiModelProperty(value = "修改图片类型")
//    private PictureType pictureType;
//    /**
//     * 执行方法method
//     */
//    @ApiModelProperty(value = "执行方法method")
//    private ThumMethodType thumMethodType;
//}
