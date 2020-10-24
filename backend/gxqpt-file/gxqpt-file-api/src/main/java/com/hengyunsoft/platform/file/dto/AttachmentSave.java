package com.hengyunsoft.platform.file.dto;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * This is a Description
 *
 * @author tangyh
 * @date 2019/04/17
 */
@Data
public class AttachmentSave implements Serializable {
    private String url;
    private String filename;
}
