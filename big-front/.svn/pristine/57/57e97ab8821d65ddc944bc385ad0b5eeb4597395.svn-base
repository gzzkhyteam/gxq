const validateNumber = (rule, value, callback) => {//数字类型表单验证
	let reg = /^\d*$/;
	if(!reg.test(value)) {
		callback(new Error(rule.message));
	} else {
		callback();
	}
};
const semicolonNumber = (rule, value, callback) => {//分号和数字表单验证
	let reg = /^[;0-9]*$/;
	if (!reg.test(value)) {
		callback(new Error(rule.message));
	} else {
		callback();
	}
};
export { validateNumber, semicolonNumber}
