package com.hengyunsoft.platform.file.entity.file.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShareFileRateDO {
    /**
     * 数据类型 image/video/audio/doc/other/DIR
     *
     * @mbggenerated
     */
    private String dataType;

    /**
     * 大小
     *
     * @mbggenerated
     */
    private String size;
}
