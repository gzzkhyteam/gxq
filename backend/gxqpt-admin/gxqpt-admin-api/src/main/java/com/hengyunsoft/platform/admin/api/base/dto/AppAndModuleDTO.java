package com.hengyunsoft.platform.admin.api.base.dto;/**
 * Created by Administrator on 2018/4/23.
 */

import lombok.Data;

/**
 * @author madb
 * @create 2018/04/23
 * @desc 应用和功能展示DTO
 **/
@Data
public class AppAndModuleDTO {



        private Long id;

        /**
         * 开发者ID，提供给各个应用的设别码
         *
         * @mbggenerated
         */
        private String appId;

        /**
         * 类型id
         *
         * @mbggenerated
         */
        private Long dictionaryTypeId;

        /**
         * 类型编码
         *
         * @mbggenerated
         */
        private String dictionaryTypeCode;

        /**
         * 字典类型名称
         *
         * @mbggenerated
         */
        private String dictionaryTypeName;

        /**
         * 字典编码
         *
         * @mbggenerated
         */
        private String code;

        /**
         * 字典条目名称
         *
         * @mbggenerated
         */
        private String name;

        /**
         * 是否删除
         1：已删除
         0：未删除
         *
         * @mbggenerated
         */
        private Boolean isDelete;

        /**
         * 启用状态
         1：启用
         0：禁用
         *
         * @mbggenerated
         */
        private Boolean isEnable;

        /**
         * 排序号
         *
         * @mbggenerated
         */
        private Integer orderNum;

        /**
         * 描述
         *
         * @mbggenerated
         */
        private String description;

        /**
         * 创建时间
         *
         * @mbggenerated
         */
        private String createTime;

        /**
         * 创建人
         *
         * @mbggenerated
         */
        private Long createUser;

        /**
         * 更新时间
         *
         * @mbggenerated
         */
        private String updateTime;

        /**
         * 更新人
         *
         * @mbggenerated
         */
        private Long updateUser;

}
