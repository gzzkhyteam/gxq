package com.hengyunsoft.platform.file.repository.file.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileExample extends com.hengyunsoft.db.example.BaseExample<FileExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

        public GeneratedCriteria() {
            super();
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(java.util.List<java.lang.String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Long value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Long value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Long value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Long value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Long value1, Long value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFolderIdIsNull() {
            addCriterion("folder_id is null");
            return (Criteria) this;
        }

        public Criteria andFolderIdIsNotNull() {
            addCriterion("folder_id is not null");
            return (Criteria) this;
        }

        public Criteria andFolderIdEqualTo(Long value) {
            addCriterion("folder_id =", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotEqualTo(Long value) {
            addCriterion("folder_id <>", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdGreaterThan(Long value) {
            addCriterion("folder_id >", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("folder_id >=", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdLessThan(Long value) {
            addCriterion("folder_id <", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdLessThanOrEqualTo(Long value) {
            addCriterion("folder_id <=", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("folder_id in", values, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("folder_id not in", values, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdBetween(Long value1, Long value2) {
            addCriterion("folder_id between", value1, value2, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotBetween(Long value1, Long value2) {
            addCriterion("folder_id not between", value1, value2, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderNameIsNull() {
            addCriterion("folder_name is null");
            return (Criteria) this;
        }

        public Criteria andFolderNameIsNotNull() {
            addCriterion("folder_name is not null");
            return (Criteria) this;
        }

        public Criteria andFolderNameEqualTo(String value) {
            addCriterion("folder_name =", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameNotEqualTo(String value) {
            addCriterion("folder_name <>", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameGreaterThan(String value) {
            addCriterion("folder_name >", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameGreaterThanOrEqualTo(String value) {
            addCriterion("folder_name >=", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameLessThan(String value) {
            addCriterion("folder_name <", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameLessThanOrEqualTo(String value) {
            addCriterion("folder_name <=", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameLike(String value) {
            addCriterion("folder_name like", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameNotLike(String value) {
            addCriterion("folder_name not like", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameIn(java.util.List<java.lang.String> values) {
            addCriterion("folder_name in", values, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("folder_name not in", values, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameBetween(String value1, String value2) {
            addCriterion("folder_name between", value1, value2, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameNotBetween(String value1, String value2) {
            addCriterion("folder_name not between", value1, value2, "folderName");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(String value) {
            addCriterion("object_id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(String value) {
            addCriterion("object_id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(String value) {
            addCriterion("object_id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("object_id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(String value) {
            addCriterion("object_id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(String value) {
            addCriterion("object_id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLike(String value) {
            addCriterion("object_id like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotLike(String value) {
            addCriterion("object_id not like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(java.util.List<java.lang.String> values) {
            addCriterion("object_id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("object_id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(String value1, String value2) {
            addCriterion("object_id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(String value1, String value2) {
            addCriterion("object_id not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andNamespaceIsNull() {
            addCriterion("namespace is null");
            return (Criteria) this;
        }

        public Criteria andNamespaceIsNotNull() {
            addCriterion("namespace is not null");
            return (Criteria) this;
        }

        public Criteria andNamespaceEqualTo(String value) {
            addCriterion("namespace =", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceNotEqualTo(String value) {
            addCriterion("namespace <>", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceGreaterThan(String value) {
            addCriterion("namespace >", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceGreaterThanOrEqualTo(String value) {
            addCriterion("namespace >=", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceLessThan(String value) {
            addCriterion("namespace <", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceLessThanOrEqualTo(String value) {
            addCriterion("namespace <=", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceLike(String value) {
            addCriterion("namespace like", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceNotLike(String value) {
            addCriterion("namespace not like", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceIn(java.util.List<java.lang.String> values) {
            addCriterion("namespace in", values, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceNotIn(java.util.List<java.lang.String> values) {
            addCriterion("namespace not in", values, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceBetween(String value1, String value2) {
            addCriterion("namespace between", value1, value2, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceNotBetween(String value1, String value2) {
            addCriterion("namespace not between", value1, value2, "namespace");
            return (Criteria) this;
        }

        public Criteria andUKeyIsNull() {
            addCriterion("u_key is null");
            return (Criteria) this;
        }

        public Criteria andUKeyIsNotNull() {
            addCriterion("u_key is not null");
            return (Criteria) this;
        }

        public Criteria andUKeyEqualTo(String value) {
            addCriterion("u_key =", value, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyNotEqualTo(String value) {
            addCriterion("u_key <>", value, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyGreaterThan(String value) {
            addCriterion("u_key >", value, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyGreaterThanOrEqualTo(String value) {
            addCriterion("u_key >=", value, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyLessThan(String value) {
            addCriterion("u_key <", value, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyLessThanOrEqualTo(String value) {
            addCriterion("u_key <=", value, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyLike(String value) {
            addCriterion("u_key like", value, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyNotLike(String value) {
            addCriterion("u_key not like", value, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyIn(java.util.List<java.lang.String> values) {
            addCriterion("u_key in", values, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("u_key not in", values, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyBetween(String value1, String value2) {
            addCriterion("u_key between", value1, value2, "uKey");
            return (Criteria) this;
        }

        public Criteria andUKeyNotBetween(String value1, String value2) {
            addCriterion("u_key not between", value1, value2, "uKey");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(java.util.List<java.lang.String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameIsNull() {
            addCriterion("remote_file_name is null");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameIsNotNull() {
            addCriterion("remote_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameEqualTo(String value) {
            addCriterion("remote_file_name =", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameNotEqualTo(String value) {
            addCriterion("remote_file_name <>", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameGreaterThan(String value) {
            addCriterion("remote_file_name >", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("remote_file_name >=", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameLessThan(String value) {
            addCriterion("remote_file_name <", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameLessThanOrEqualTo(String value) {
            addCriterion("remote_file_name <=", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameLike(String value) {
            addCriterion("remote_file_name like", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameNotLike(String value) {
            addCriterion("remote_file_name not like", value, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_file_name in", values, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_file_name not in", values, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameBetween(String value1, String value2) {
            addCriterion("remote_file_name between", value1, value2, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andRemoteFileNameNotBetween(String value1, String value2) {
            addCriterion("remote_file_name not between", value1, value2, "remoteFileName");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathIsNull() {
            addCriterion("absolute_path is null");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathIsNotNull() {
            addCriterion("absolute_path is not null");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathEqualTo(String value) {
            addCriterion("absolute_path =", value, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathNotEqualTo(String value) {
            addCriterion("absolute_path <>", value, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathGreaterThan(String value) {
            addCriterion("absolute_path >", value, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathGreaterThanOrEqualTo(String value) {
            addCriterion("absolute_path >=", value, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathLessThan(String value) {
            addCriterion("absolute_path <", value, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathLessThanOrEqualTo(String value) {
            addCriterion("absolute_path <=", value, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathLike(String value) {
            addCriterion("absolute_path like", value, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathNotLike(String value) {
            addCriterion("absolute_path not like", value, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathIn(java.util.List<java.lang.String> values) {
            addCriterion("absolute_path in", values, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathNotIn(java.util.List<java.lang.String> values) {
            addCriterion("absolute_path not in", values, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathBetween(String value1, String value2) {
            addCriterion("absolute_path between", value1, value2, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andAbsolutePathNotBetween(String value1, String value2) {
            addCriterion("absolute_path not between", value1, value2, "absolutePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathIsNull() {
            addCriterion("relative_path is null");
            return (Criteria) this;
        }

        public Criteria andRelativePathIsNotNull() {
            addCriterion("relative_path is not null");
            return (Criteria) this;
        }

        public Criteria andRelativePathEqualTo(String value) {
            addCriterion("relative_path =", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathNotEqualTo(String value) {
            addCriterion("relative_path <>", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathGreaterThan(String value) {
            addCriterion("relative_path >", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathGreaterThanOrEqualTo(String value) {
            addCriterion("relative_path >=", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathLessThan(String value) {
            addCriterion("relative_path <", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathLessThanOrEqualTo(String value) {
            addCriterion("relative_path <=", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathLike(String value) {
            addCriterion("relative_path like", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathNotLike(String value) {
            addCriterion("relative_path not like", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathIn(java.util.List<java.lang.String> values) {
            addCriterion("relative_path in", values, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathNotIn(java.util.List<java.lang.String> values) {
            addCriterion("relative_path not in", values, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathBetween(String value1, String value2) {
            addCriterion("relative_path between", value1, value2, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathNotBetween(String value1, String value2) {
            addCriterion("relative_path not between", value1, value2, "relativePath");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andCharactersIsNull() {
            addCriterion("characters is null");
            return (Criteria) this;
        }

        public Criteria andCharactersIsNotNull() {
            addCriterion("characters is not null");
            return (Criteria) this;
        }

        public Criteria andCharactersEqualTo(String value) {
            addCriterion("characters =", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersNotEqualTo(String value) {
            addCriterion("characters <>", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersGreaterThan(String value) {
            addCriterion("characters >", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersGreaterThanOrEqualTo(String value) {
            addCriterion("characters >=", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersLessThan(String value) {
            addCriterion("characters <", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersLessThanOrEqualTo(String value) {
            addCriterion("characters <=", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersLike(String value) {
            addCriterion("characters like", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersNotLike(String value) {
            addCriterion("characters not like", value, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersIn(java.util.List<java.lang.String> values) {
            addCriterion("characters in", values, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersNotIn(java.util.List<java.lang.String> values) {
            addCriterion("characters not in", values, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersBetween(String value1, String value2) {
            addCriterion("characters between", value1, value2, "characters");
            return (Criteria) this;
        }

        public Criteria andCharactersNotBetween(String value1, String value2) {
            addCriterion("characters not between", value1, value2, "characters");
            return (Criteria) this;
        }

        public Criteria andScreenshotIsNull() {
            addCriterion("screenshot is null");
            return (Criteria) this;
        }

        public Criteria andScreenshotIsNotNull() {
            addCriterion("screenshot is not null");
            return (Criteria) this;
        }

        public Criteria andScreenshotEqualTo(String value) {
            addCriterion("screenshot =", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotNotEqualTo(String value) {
            addCriterion("screenshot <>", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotGreaterThan(String value) {
            addCriterion("screenshot >", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotGreaterThanOrEqualTo(String value) {
            addCriterion("screenshot >=", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotLessThan(String value) {
            addCriterion("screenshot <", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotLessThanOrEqualTo(String value) {
            addCriterion("screenshot <=", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotLike(String value) {
            addCriterion("screenshot like", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotNotLike(String value) {
            addCriterion("screenshot not like", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotIn(java.util.List<java.lang.String> values) {
            addCriterion("screenshot in", values, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotNotIn(java.util.List<java.lang.String> values) {
            addCriterion("screenshot not in", values, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotBetween(String value1, String value2) {
            addCriterion("screenshot between", value1, value2, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotNotBetween(String value1, String value2) {
            addCriterion("screenshot not between", value1, value2, "screenshot");
            return (Criteria) this;
        }

        public Criteria andSwfIsNull() {
            addCriterion("swf is null");
            return (Criteria) this;
        }

        public Criteria andSwfIsNotNull() {
            addCriterion("swf is not null");
            return (Criteria) this;
        }

        public Criteria andSwfEqualTo(String value) {
            addCriterion("swf =", value, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfNotEqualTo(String value) {
            addCriterion("swf <>", value, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfGreaterThan(String value) {
            addCriterion("swf >", value, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfGreaterThanOrEqualTo(String value) {
            addCriterion("swf >=", value, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfLessThan(String value) {
            addCriterion("swf <", value, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfLessThanOrEqualTo(String value) {
            addCriterion("swf <=", value, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfLike(String value) {
            addCriterion("swf like", value, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfNotLike(String value) {
            addCriterion("swf not like", value, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfIn(java.util.List<java.lang.String> values) {
            addCriterion("swf in", values, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfNotIn(java.util.List<java.lang.String> values) {
            addCriterion("swf not in", values, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfBetween(String value1, String value2) {
            addCriterion("swf between", value1, value2, "swf");
            return (Criteria) this;
        }

        public Criteria andSwfNotBetween(String value1, String value2) {
            addCriterion("swf not between", value1, value2, "swf");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andMimeIsNull() {
            addCriterion("mime is null");
            return (Criteria) this;
        }

        public Criteria andMimeIsNotNull() {
            addCriterion("mime is not null");
            return (Criteria) this;
        }

        public Criteria andMimeEqualTo(String value) {
            addCriterion("mime =", value, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeNotEqualTo(String value) {
            addCriterion("mime <>", value, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeGreaterThan(String value) {
            addCriterion("mime >", value, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeGreaterThanOrEqualTo(String value) {
            addCriterion("mime >=", value, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeLessThan(String value) {
            addCriterion("mime <", value, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeLessThanOrEqualTo(String value) {
            addCriterion("mime <=", value, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeLike(String value) {
            addCriterion("mime like", value, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeNotLike(String value) {
            addCriterion("mime not like", value, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeIn(java.util.List<java.lang.String> values) {
            addCriterion("mime in", values, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("mime not in", values, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeBetween(String value1, String value2) {
            addCriterion("mime between", value1, value2, "mime");
            return (Criteria) this;
        }

        public Criteria andMimeNotBetween(String value1, String value2) {
            addCriterion("mime not between", value1, value2, "mime");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameIsNull() {
            addCriterion("submitted_file_name is null");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameIsNotNull() {
            addCriterion("submitted_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameEqualTo(String value) {
            addCriterion("submitted_file_name =", value, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameNotEqualTo(String value) {
            addCriterion("submitted_file_name <>", value, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameGreaterThan(String value) {
            addCriterion("submitted_file_name >", value, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("submitted_file_name >=", value, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameLessThan(String value) {
            addCriterion("submitted_file_name <", value, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameLessThanOrEqualTo(String value) {
            addCriterion("submitted_file_name <=", value, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameLike(String value) {
            addCriterion("submitted_file_name like", value, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameNotLike(String value) {
            addCriterion("submitted_file_name not like", value, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameIn(java.util.List<java.lang.String> values) {
            addCriterion("submitted_file_name in", values, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("submitted_file_name not in", values, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameBetween(String value1, String value2) {
            addCriterion("submitted_file_name between", value1, value2, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andSubmittedFileNameNotBetween(String value1, String value2) {
            addCriterion("submitted_file_name not between", value1, value2, "submittedFileName");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(java.util.List<java.lang.String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andExtIsNull() {
            addCriterion("ext is null");
            return (Criteria) this;
        }

        public Criteria andExtIsNotNull() {
            addCriterion("ext is not null");
            return (Criteria) this;
        }

        public Criteria andExtEqualTo(String value) {
            addCriterion("ext =", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotEqualTo(String value) {
            addCriterion("ext <>", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThan(String value) {
            addCriterion("ext >", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThanOrEqualTo(String value) {
            addCriterion("ext >=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThan(String value) {
            addCriterion("ext <", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThanOrEqualTo(String value) {
            addCriterion("ext <=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLike(String value) {
            addCriterion("ext like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotLike(String value) {
            addCriterion("ext not like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtIn(java.util.List<java.lang.String> values) {
            addCriterion("ext in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ext not in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtBetween(String value1, String value2) {
            addCriterion("ext between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotBetween(String value1, String value2) {
            addCriterion("ext not between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(java.util.List<java.lang.String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(java.util.List<java.lang.String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(java.util.List<java.lang.String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andTreePathIsNull() {
            addCriterion("tree_path is null");
            return (Criteria) this;
        }

        public Criteria andTreePathIsNotNull() {
            addCriterion("tree_path is not null");
            return (Criteria) this;
        }

        public Criteria andTreePathEqualTo(String value) {
            addCriterion("tree_path =", value, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathNotEqualTo(String value) {
            addCriterion("tree_path <>", value, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathGreaterThan(String value) {
            addCriterion("tree_path >", value, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathGreaterThanOrEqualTo(String value) {
            addCriterion("tree_path >=", value, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathLessThan(String value) {
            addCriterion("tree_path <", value, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathLessThanOrEqualTo(String value) {
            addCriterion("tree_path <=", value, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathLike(String value) {
            addCriterion("tree_path like", value, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathNotLike(String value) {
            addCriterion("tree_path not like", value, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathIn(java.util.List<java.lang.String> values) {
            addCriterion("tree_path in", values, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathNotIn(java.util.List<java.lang.String> values) {
            addCriterion("tree_path not in", values, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathBetween(String value1, String value2) {
            addCriterion("tree_path between", value1, value2, "treePath");
            return (Criteria) this;
        }

        public Criteria andTreePathNotBetween(String value1, String value2) {
            addCriterion("tree_path not between", value1, value2, "treePath");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andFileMd5IsNull() {
            addCriterion("file_md5 is null");
            return (Criteria) this;
        }

        public Criteria andFileMd5IsNotNull() {
            addCriterion("file_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andFileMd5EqualTo(String value) {
            addCriterion("file_md5 =", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5NotEqualTo(String value) {
            addCriterion("file_md5 <>", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5GreaterThan(String value) {
            addCriterion("file_md5 >", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5GreaterThanOrEqualTo(String value) {
            addCriterion("file_md5 >=", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5LessThan(String value) {
            addCriterion("file_md5 <", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5LessThanOrEqualTo(String value) {
            addCriterion("file_md5 <=", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5Like(String value) {
            addCriterion("file_md5 like", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5NotLike(String value) {
            addCriterion("file_md5 not like", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5In(java.util.List<java.lang.String> values) {
            addCriterion("file_md5 in", values, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5NotIn(java.util.List<java.lang.String> values) {
            addCriterion("file_md5 not in", values, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5Between(String value1, String value2) {
            addCriterion("file_md5 between", value1, value2, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5NotBetween(String value1, String value2) {
            addCriterion("file_md5 not between", value1, value2, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andContextTypeIsNull() {
            addCriterion("context_type is null");
            return (Criteria) this;
        }

        public Criteria andContextTypeIsNotNull() {
            addCriterion("context_type is not null");
            return (Criteria) this;
        }

        public Criteria andContextTypeEqualTo(String value) {
            addCriterion("context_type =", value, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeNotEqualTo(String value) {
            addCriterion("context_type <>", value, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeGreaterThan(String value) {
            addCriterion("context_type >", value, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeGreaterThanOrEqualTo(String value) {
            addCriterion("context_type >=", value, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeLessThan(String value) {
            addCriterion("context_type <", value, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeLessThanOrEqualTo(String value) {
            addCriterion("context_type <=", value, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeLike(String value) {
            addCriterion("context_type like", value, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeNotLike(String value) {
            addCriterion("context_type not like", value, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("context_type in", values, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("context_type not in", values, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeBetween(String value1, String value2) {
            addCriterion("context_type between", value1, value2, "contextType");
            return (Criteria) this;
        }

        public Criteria andContextTypeNotBetween(String value1, String value2) {
            addCriterion("context_type not between", value1, value2, "contextType");
            return (Criteria) this;
        }

        public Criteria andFileSha1IsNull() {
            addCriterion("file_sha1 is null");
            return (Criteria) this;
        }

        public Criteria andFileSha1IsNotNull() {
            addCriterion("file_sha1 is not null");
            return (Criteria) this;
        }

        public Criteria andFileSha1EqualTo(String value) {
            addCriterion("file_sha1 =", value, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1NotEqualTo(String value) {
            addCriterion("file_sha1 <>", value, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1GreaterThan(String value) {
            addCriterion("file_sha1 >", value, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1GreaterThanOrEqualTo(String value) {
            addCriterion("file_sha1 >=", value, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1LessThan(String value) {
            addCriterion("file_sha1 <", value, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1LessThanOrEqualTo(String value) {
            addCriterion("file_sha1 <=", value, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1Like(String value) {
            addCriterion("file_sha1 like", value, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1NotLike(String value) {
            addCriterion("file_sha1 not like", value, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1In(java.util.List<java.lang.String> values) {
            addCriterion("file_sha1 in", values, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1NotIn(java.util.List<java.lang.String> values) {
            addCriterion("file_sha1 not in", values, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1Between(String value1, String value2) {
            addCriterion("file_sha1 between", value1, value2, "fileSha1");
            return (Criteria) this;
        }

        public Criteria andFileSha1NotBetween(String value1, String value2) {
            addCriterion("file_sha1 not between", value1, value2, "fileSha1");
            return (Criteria) this;
        }
    }

    /**
    f_fileaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}