// 验证表单参数
import store from '@/store'

var applyData = store.state.applyData,msg = "";
export function validation () {
    switch (applyData.aprType) {
        case 'outside'://外勤申请
            if (!applyData.startTime) return msg = '开始时间不能为空，请重新选择！';
            if (!applyData.endTime) return msg = '结束时间不能为空，请重新选择！';
            if (applyData.description == '') return msg = '描述不能为空，请重新输入！';
                break;
        case 'overtime'://加班申请
            if (!applyData.startTime) return msg = '开始时间不能为空，请重新选择！';
            if (!applyData.endTime) return msg = '结束时间不能为空，请重新选择！';
            if (applyData.content == '') return msg = '加班内容不能为空，请重新输入！';
            break
        case 'leave'://请假申请
            if (applyData.leaveType == '') return msg = '请假类型不能为空，请重新选择！';
            if (!applyData.startTime) return msg = '开始时间不能为空，请重新选择！';
            if (!applyData.endTime) return msg = '结束时间不能为空，请重新选择！';
            if (applyData.leaveReason == '') return msg = '请假事由不能为空，请重新输入！';
            if (!applyData.leaveHour) return msg = '请假时间不能为0，请重新选择！';
            break
        case 'supply'://补签申请
            if (applyData.supplyType == 0) return msg = '补签类型不能为空，请重新选择！';
            if (applyData.reason == '') return msg = '补签理由不能为空，请重新输入！';
            if (!applyData.date) return msg = '补签日期不能为空，请重新输入！';
            break
        case 'business'://出差申请
            if (applyData.entourageName == '') return msg = '出差类型不能为空，请重新选择！';
            if (applyData.province == '') return msg = '出差省份不能为空，请重新输入！';
            if (applyData.city == '') return msg = '出差市不能为空，请重新输入！';
            if (applyData.address == '') return msg = '详细地址不能为空，请重新输入！';
            if (applyData.vehicle == '') return msg = '交通工具不能为空，请重新输入！';
            if (applyData.entourage == '') return msg = '随行人员不能为空，请重新输入！';
            if (applyData.entouragePhone == '') return msg = '联系电话不能为空，请重新输入！';
            if (!applyData.startTime) return msg = '开始时间不能为空，请重新选择！';
            if (!applyData.endTime) return msg = '结束时间不能为空，请重新选择！';
            if (applyData.businessReason == '') return msg = '出差事由不能为空，请重新输入！';
            break
        default:
            break;
    }
    // 审批人和抄送人：
    if (applyData.apprPersons.length == 0) return msg = '审批人名单不能为空，请重新选择！';
    if (applyData.sendPersons.length == 0) return msg = '抄送人名单不能为空，请重新选择！';
    return msg;
}