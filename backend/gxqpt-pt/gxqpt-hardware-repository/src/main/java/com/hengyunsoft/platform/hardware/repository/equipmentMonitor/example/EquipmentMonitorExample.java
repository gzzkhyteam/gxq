package com.hengyunsoft.platform.hardware.repository.equipmentMonitor.example;

import java.io.Serializable;
import java.util.Date;

import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.db.example.BaseGeneratedCriteria;

public class EquipmentMonitorExample extends BaseExample<EquipmentMonitorExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends BaseGeneratedCriteria implements Serializable {

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

        public Criteria andRoomNumberIsNull() {
            addCriterion("room_number is null");
            return (Criteria) this;
        }

        public Criteria andRoomNumberIsNotNull() {
            addCriterion("room_number is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNumberEqualTo(String value) {
            addCriterion("room_number =", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotEqualTo(String value) {
            addCriterion("room_number <>", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThan(String value) {
            addCriterion("room_number >", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThanOrEqualTo(String value) {
            addCriterion("room_number >=", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThan(String value) {
            addCriterion("room_number <", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThanOrEqualTo(String value) {
            addCriterion("room_number <=", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLike(String value) {
            addCriterion("room_number like", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotLike(String value) {
            addCriterion("room_number not like", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberIn(java.util.List<java.lang.String> values) {
            addCriterion("room_number in", values, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotIn(java.util.List<java.lang.String> values) {
            addCriterion("room_number not in", values, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberBetween(String value1, String value2) {
            addCriterion("room_number between", value1, value2, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotBetween(String value1, String value2) {
            addCriterion("room_number not between", value1, value2, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomAdminIsNull() {
            addCriterion("room_admin is null");
            return (Criteria) this;
        }

        public Criteria andRoomAdminIsNotNull() {
            addCriterion("room_admin is not null");
            return (Criteria) this;
        }

        public Criteria andRoomAdminEqualTo(String value) {
            addCriterion("room_admin =", value, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminNotEqualTo(String value) {
            addCriterion("room_admin <>", value, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminGreaterThan(String value) {
            addCriterion("room_admin >", value, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminGreaterThanOrEqualTo(String value) {
            addCriterion("room_admin >=", value, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminLessThan(String value) {
            addCriterion("room_admin <", value, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminLessThanOrEqualTo(String value) {
            addCriterion("room_admin <=", value, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminLike(String value) {
            addCriterion("room_admin like", value, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminNotLike(String value) {
            addCriterion("room_admin not like", value, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminIn(java.util.List<java.lang.String> values) {
            addCriterion("room_admin in", values, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminNotIn(java.util.List<java.lang.String> values) {
            addCriterion("room_admin not in", values, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminBetween(String value1, String value2) {
            addCriterion("room_admin between", value1, value2, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andRoomAdminNotBetween(String value1, String value2) {
            addCriterion("room_admin not between", value1, value2, "roomAdmin");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNull() {
            addCriterion("contact_number is null");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNotNull() {
            addCriterion("contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andContactNumberEqualTo(String value) {
            addCriterion("contact_number =", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotEqualTo(String value) {
            addCriterion("contact_number <>", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThan(String value) {
            addCriterion("contact_number >", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contact_number >=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThan(String value) {
            addCriterion("contact_number <", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThanOrEqualTo(String value) {
            addCriterion("contact_number <=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLike(String value) {
            addCriterion("contact_number like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotLike(String value) {
            addCriterion("contact_number not like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberIn(java.util.List<java.lang.String> values) {
            addCriterion("contact_number in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotIn(java.util.List<java.lang.String> values) {
            addCriterion("contact_number not in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberBetween(String value1, String value2) {
            addCriterion("contact_number between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotBetween(String value1, String value2) {
            addCriterion("contact_number not between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andHostNumIsNull() {
            addCriterion("host_num is null");
            return (Criteria) this;
        }

        public Criteria andHostNumIsNotNull() {
            addCriterion("host_num is not null");
            return (Criteria) this;
        }

        public Criteria andHostNumEqualTo(Integer value) {
            addCriterion("host_num =", value, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumNotEqualTo(Integer value) {
            addCriterion("host_num <>", value, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumGreaterThan(Integer value) {
            addCriterion("host_num >", value, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("host_num >=", value, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumLessThan(Integer value) {
            addCriterion("host_num <", value, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumLessThanOrEqualTo(Integer value) {
            addCriterion("host_num <=", value, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("host_num in", values, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("host_num not in", values, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumBetween(Integer value1, Integer value2) {
            addCriterion("host_num between", value1, value2, "hostNum");
            return (Criteria) this;
        }

        public Criteria andHostNumNotBetween(Integer value1, Integer value2) {
            addCriterion("host_num not between", value1, value2, "hostNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumIsNull() {
            addCriterion("router_num is null");
            return (Criteria) this;
        }

        public Criteria andRouterNumIsNotNull() {
            addCriterion("router_num is not null");
            return (Criteria) this;
        }

        public Criteria andRouterNumEqualTo(Integer value) {
            addCriterion("router_num =", value, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumNotEqualTo(Integer value) {
            addCriterion("router_num <>", value, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumGreaterThan(Integer value) {
            addCriterion("router_num >", value, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("router_num >=", value, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumLessThan(Integer value) {
            addCriterion("router_num <", value, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumLessThanOrEqualTo(Integer value) {
            addCriterion("router_num <=", value, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("router_num in", values, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("router_num not in", values, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumBetween(Integer value1, Integer value2) {
            addCriterion("router_num between", value1, value2, "routerNum");
            return (Criteria) this;
        }

        public Criteria andRouterNumNotBetween(Integer value1, Integer value2) {
            addCriterion("router_num not between", value1, value2, "routerNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumIsNull() {
            addCriterion("air_con_num is null");
            return (Criteria) this;
        }

        public Criteria andAirConNumIsNotNull() {
            addCriterion("air_con_num is not null");
            return (Criteria) this;
        }

        public Criteria andAirConNumEqualTo(Integer value) {
            addCriterion("air_con_num =", value, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumNotEqualTo(Integer value) {
            addCriterion("air_con_num <>", value, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumGreaterThan(Integer value) {
            addCriterion("air_con_num >", value, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("air_con_num >=", value, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumLessThan(Integer value) {
            addCriterion("air_con_num <", value, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumLessThanOrEqualTo(Integer value) {
            addCriterion("air_con_num <=", value, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("air_con_num in", values, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("air_con_num not in", values, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumBetween(Integer value1, Integer value2) {
            addCriterion("air_con_num between", value1, value2, "airConNum");
            return (Criteria) this;
        }

        public Criteria andAirConNumNotBetween(Integer value1, Integer value2) {
            addCriterion("air_con_num not between", value1, value2, "airConNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumIsNull() {
            addCriterion("cabinet_num is null");
            return (Criteria) this;
        }

        public Criteria andCabinetNumIsNotNull() {
            addCriterion("cabinet_num is not null");
            return (Criteria) this;
        }

        public Criteria andCabinetNumEqualTo(Integer value) {
            addCriterion("cabinet_num =", value, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumNotEqualTo(Integer value) {
            addCriterion("cabinet_num <>", value, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumGreaterThan(Integer value) {
            addCriterion("cabinet_num >", value, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cabinet_num >=", value, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumLessThan(Integer value) {
            addCriterion("cabinet_num <", value, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumLessThanOrEqualTo(Integer value) {
            addCriterion("cabinet_num <=", value, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cabinet_num in", values, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cabinet_num not in", values, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumBetween(Integer value1, Integer value2) {
            addCriterion("cabinet_num between", value1, value2, "cabinetNum");
            return (Criteria) this;
        }

        public Criteria andCabinetNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cabinet_num not between", value1, value2, "cabinetNum");
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

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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
    }

    /**
    b_hd_equipment_monitoraddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}