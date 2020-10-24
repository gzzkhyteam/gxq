<template>
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>运维人员管理</BreadcrumbItem>
					<BreadcrumbItem>人员管理</BreadcrumbItem>
				</Breadcrumb>
                <Layout class="ivu-layout-has-sider">
                    <Row type="flex" justify="space-between">
                        <Col style="min-height: 10px; width: 240px;">
                            <Menu
                                active-name="0-0"
                                :open-names="['0']"
                                style="height:100%;border-bottom:1px solid #ccc"
                                @on-select="changeItem"
                                accordion
                                v-if="menuShow">
                                <template v-for="(item, i) in perList">
                                    <template v-if="item.dpms.length > 0">
                                        <Submenu :name="`${i}`">
                                            <template slot="title">
                                                <Icon type="ios-analytics"></Icon>
                                                {{item.name}}
                                            </template>
                                            <template v-for="(menu, j) in item.dpms">
                                                <MenuItem :name="`${i}-${j}`">
                                                    {{menu.name}}
                                                </MenuItem>
                                            </template>
                                        </Submenu>
                                    </template>
                                    <template v-else>
                                        <MenuItem :name="item.name">
                                            <Icon type="heart"></Icon>
                                            {{item.name}}
                                        </MenuItem>
                                    </template>
                                </template>
                            </Menu>
                        </Col>
                        <Col span="20" style="background-color: #fff;width: calc(100% - 250px);padding: 15px;">
                            <h4>人员列表</h4>
                            <Form ref="formValidate" inline :label-width="90">
                                <FormItem label="姓名">
                                    <Input v-model="name" type="text" placeholder="请输入姓名"></Input>
                                </FormItem>
                                <FormItem :label-width="20">
                                    <Button type="primary" @click="preSearch" v-if="authButton.includes('personnel_manage_query')">查询</Button>
                                </FormItem>
                            </Form>
                            <hy-table
                              highlight-row
                              border
                              :current="pageInfo.pageNo"
                              :columns="columns"
                              :data="tableData"
                              :total="Number(pageInfo.total)"
                              :pageSize="Number(pageInfo.pageSize)"
                              pageType="small"
                              show-elevator
                              show-sizer
                              ref="selection"
                              placement="top"
                              @on-page-change="pageChange" />
                        </Col>
                    </Row>
                </Layout>
			</Content>
			<Modal
                v-model="modal"
                :mask-closable="false"
                :title="isDetail ? '详情' : '编辑'"
                width="60%">
				<div style="text-align:center">
                    <Form ref="evalData" :model="evalData" :rules="ruleValidate" :label-width="100">
                        <Row :gutter="40">
                            <Col span="12">
                                <FormItem label="姓名" :label-width="100" label-position="left">
                                    <Input v-model="evalData.name" disabled></Input>
                                </FormItem>
                            </Col>
                            <Col span="9">
                                <FormItem label="性别" prop="sex" id="sex">
                                    <RadioGroup v-model="evalData.sex" label-position="left">
                                        <Radio label="1" disabled>男</Radio>
                                        <Radio label="0" disabled>女</Radio>
                                    </RadioGroup>
                                </FormItem>
                            </Col>
                            <Col span="12">
                                <FormItem label="职位" :label-width="100" label-position="left">
                                    <Input
                                        v-model="evalData.maindutyname"
                                        type="text"
                                        disabled>
                                    </Input>
                                </FormItem>
                            </Col>
                            <Col span="11">
                                <FormItem label="电话" label-position="left">
                                    <Input v-model="evalData.mainmobile" disabled></Input>
                                </FormItem>
                            </Col>
                            <Col span="12">
                                <FormItem label="主要负责系统" :label-width="100" label-position="left" prop="systemName" required>
                                    <template v-if="isDetail">
                                        <Input
                                            v-model="evalData.systemName.join(',')"
                                            type="textarea"
                                            :autosize="{minRows: 5, maxRows: 5}"
                                            disabled>
                                        </Input>
                                    </template>
                                    <template v-else>
                                        <Select v-model="evalData.systemName" :disabled="isDetail" :multiple="true">
                                            <template v-for="(option, idx) in appList">
                                                <Option :value="idx">{{option.name}}</Option>
                                            </template>
                                        </Select>
                                    </template>
                                </FormItem>
                            </Col>
                            <Col span="23">
                                <FormItem label="主要工作内容" :label-width="100" label-position="left" prop="content">
                                    <Input
                                        v-model="evalData.content"
                                        type="textarea"
                                        placeholder="请输入工作内容..."
                                        :disabled="isDetail"
                                        :rows="5"
                                        :autosize="{ minRows: 5, maxRows: 5 }"
                                        :maxlength="999"
                                        style="resize: none">
                                    </Input>
                                </FormItem>
                            </Col>
                        </Row>
                    </Form>
                </div>
                <div slot="footer">
                    <Button type="default" @click="closeModal" size="large">取消</Button>
                    <Button type="primary" @click="handleSubmit" size="large">确定</Button>
                </div>
			</Modal>
		</Layout>
</template>

<script>
import {mapState} from 'vuex'
// api util和接口列表
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'

function defaultRender(h, value) {
    return h('span', value || '--')
}

const SEX = {
    '0': '女',
    '1': '男'
}

const STATUS = {
    DETAIL: 'detail',
    EDIT: 'edit',
    CREATE: 'create'
}

export default {
    data() {
        const vm = this
        const validater = {
            systemName (rule, value, callback) {
                if (value.length === 0) {
                    callback(new Error('请至少选择一个负责系统'))
                } else {
                    callback();
                }
            }
        }
        const slgLineStyle =  {
            maxHeight: '36px',
            overflow: 'hidden',
            margin: '10px 0',
            textOverflow: 'ellipsis',
            whiteSpace: 'nowrap'
        }
        return {
            // 搜索关键字
            name: '',
            // 职务列表
            perList: [],
            // 单位id
            currentOrgId: '',
            // 部门id
            currentDeptId: '',
            // 当前操作的人员的id
            currentEmpId: '',
            // 体系代码
            systemCode: '',
            // 当前弹窗状态
            currentStatus: '',
            // 分页信息
            pageInfo: {
                pageNo: 1,
                pageSize: 10,
                total: 0
            },
            // 系统列表
            appList: [],
            // 当前被操作的人员的personId
            currentPersonId: '',
            modal: false,
            queryTime: ['2018-06-01', '2018-07-01'],
            evalData: {
                name:'',
                sex:'',
                maindutyname:'',
                mainmobile:'',
                systemName:[],
                content:''
            },
            ruleValidate: {
                mainmobile:[
                    { required:true, message:'电话号码不能为空', trigger: 'blur' }
                ],
                systemName: { validator: validater.systemName, message:'主要负责系统不能为空', trigger: 'blur' },
                content: { required:true, message:'工作内容不能为空', trigger: 'blur' }
            },
            columns: [{
                type: 'index',
                title: '序号',
                maxWidth: 80,
                align: 'center'
            },
            {
                title: '姓名',
                maxWidth: 100,
                key: 'name',
                render: (h, params) => {
                    return defaultRender(h, params.row.name)
                }
            },
            {
                title: '性别',
                maxWidth: 80,
                key: 'sex',
                render: (h, params) => {
                    return h('span', SEX[params.row.sex] || '--')
                }
            },
            {
                title: '职位',
                maxWidth: 150,
                key: 'maindutyname',
                render: (h, params) => {
                    return defaultRender(h, params.row.maindutyname)
                }
            },
            {
                title: '电话',
                maxWidth: 150,
                key: 'mainmobile',
                render: (h, params) => {
                    return defaultRender(h, params.row.mainmobile)
                }
            },
            {
                title: '主要工作内容',
                key: 'content',
                render: (h, params) => {
                    const html = params.row.content || '--'
                    return h('div', {
                        style: {...slgLineStyle},
                        attrs: {
                            title: html
                        }
                    },html)
                }
            },
            {
                title: '主要负责系统',
                key: 'systemName',
                render: (h, params) => {
                    const names = []
                    params.row.systemName.forEach(value => {
                        names.push(value.systemName)
                    })
                    const html = names.join(' | ') || '--'
                    return h('div', {
                        style: {...slgLineStyle},
                        attrs: {
                            title: html
                        }
                    },html)
                }
            },
            {
                title: '操作',
                key: 'act',
                width: 140,
                align: 'center',
                render: (h, params) => {
                    const edit = h('Button', {
                        props: {
                            type: 'primary',
                            size: 'small'
                        },
                        style: {
                            marginRight: '15px'
                        },
                        on: {
                            click: () => {
                                const value = params.row
                                vm.currentPersonId = value.personId
                                if (vm.currentPersonId) {
                                    vm.currentStatus = STATUS.EDIT
                                } else {
                                    vm.currentStatus = STATUS.CREATE
                                }
                                const systemName = []
                                // 遍历所有已选的系统
                                value.systemName.forEach(name => {
                                    // 遍历所有系统
                                    for (var i = 0; i < vm.appList.length; i++) {
                                        if (name.systemId === vm.appList[i].appId) {
                                            systemName.push(i)
                                            break
                                        }
                                    }
                                })
                                vm.evalData = {
                                    name: value.name,
                                    sex: params.row.sex,
                                    maindutyname: value.maindutyname,
                                    mainmobile: value.mainmobile,
                                    systemName: systemName,
                                    content: value.content
                                }
                                vm.currentEmpId = value.gxqptEmpId
                                vm.modal = true
                            }
                        }
                    }, '编辑')
                    const detail = h('Button', {
                        props: {
                            type: 'primary',
                            size: 'small'
                        },
                        on: {
                            click: () => {
                                const value = params.row
                                vm.currentStatus = STATUS.DETAIL
                                const names = []
                                value.systemName.map(item => {
                                    names.push(item.systemName)
                                })
                                vm.evalData = {
                                    name: value.name,
                                    sex: params.row.sex,
                                    maindutyname: value.maindutyname,
                                    mainmobile: value.mainmobile,
                                    systemName: names,
                                    content: value.content
                                }
                                vm.currentEmpId = value.gxqptEmpId
                                vm.modal = true
                            }
                        }
                    }, '详情')
                    const btns = []
                    if (vm.authButton.includes('personnel_manage_update')) {
                        btns.push(edit)
                    }
                    if (vm.authButton.includes('personnel_manage_detail')) {
                        btns.push(detail)
                    }
                    return h('div', btns)
                }
            }],
            tableData: []
        }
    },
    computed: {
        menuShow () {
            return this.perList.length > 0
        },
        isDetail () {
            return this.currentStatus === STATUS.DETAIL
        },
        ...mapState(['authButton'])
    },
    mounted () {
        this.findOrgTreeByLoginInOperation()
        this.findAppByAdminWithEnable()
    },
    methods:{
        preSearch() {
            this.pageInfo.pageNo = 1
            this.getDeptPerson()
        },
        // 分页变化或者页码变化
        pageChange(pageNo, pageSize) {
          this.pageInfo.pageNo = pageNo
          this.pageInfo.pageSize = pageSize
          this.getDeptPerson()
        },
        // 获取系统列表
        findAppByAdminWithEnable() {
            const vm = this
            api(operationApiList.findAppByAdminWithEnable)
            .then(res => {
                if (res.data.errcode === 0) {
                    vm.appList = res.data.data
                }
            },(error) => {console.log(error)})
        },
        // 获取运维单位树
        findOrgTreeByLoginInOperation() {
            const vm = this
            api(operationApiList.findOrgTreeByLoginInOperation)
            .then(res => {
                if (res.data.errcode === 0) {
                    vm.perList = res.data.data
                    if (vm.perList.length > 0) {
                        vm.currentOrgId = vm.perList[0].id
                        vm.systemCode = vm.perList[0].dpms[0].systemCode || 'gxqpt'
                        vm.currentDeptId = vm.perList[0].dpms[0].id
                    }
                }
            },(error) => {console.log(error)})
        },
        // 根据部门id查询人员列表
        getDeptPerson() {
            const vm = this
            api(operationApiList.getDeptPerson, {
                data: {
                    // 单位id
                    mainorgid: vm.currentOrgId,
                    // 部门id
                    maindeptid: vm.currentDeptId,
                    // 体系
                    systemCode: vm.systemCode,
                    // 搜索关键字
                    name: vm.name
                },
                pageNo: vm.pageInfo.pageNo,
                pageSize: vm.pageInfo.pageSize
            }).then(res => {
                if (res.data.errcode === 0) {
                    const result = res.data.data
                    vm.tableData = result.list
                    vm.pageInfo.pageNo = result.pageNum
                    vm.pageInfo.total = Number(result.total)
                }
            },(error) => {console.log(error)})
        },
        closeCallBack(status) {
            if(!status) {
                this.$refs['interfaceData'].resetFields();
            }
        },
        closeModal() {
            this.modal = false;
        },
        addBackup(){
            this.modal = true;
        },
        handleSubmit() {
            if (this.isDetail) {
                this.modal = false
                return
            }
            this.$refs['evalData'].validate((valid) => {
                if(valid) {
                    this.saveOrUpdate()
                } else {
                    this.$Message.error('表单验证失败!');
                }
            })
        },
        saveOrUpdate() {
            const vm = this
            const systemName = []
            vm.evalData.systemName.map(data => {
                systemName.push({
                    pid: String(vm.currentEmpId),
                    systemId: vm.appList[data].appId,
                    systemName: vm.appList[data].name
                })
            })
            const apiUrl = vm.currentPersonId ? 'updatePersonInfo' : 'savePersonInfo'
            api(operationApiList[apiUrl], {
                content: vm.evalData.content,
                // 用户id
                id: String(vm.currentEmpId),
                systemName: systemName,
                mainmobile: vm.evalData.mainmobile
            }).then(res => {
                if (res.data.errcode === 0) {
                    vm.modal = false
                    this.getDeptPerson()
                }
            },(error) => {console.log(error)})
        },
        changeItem (name) {
            const idxs = name.split('-')
            const org = this.perList[idxs[0]]
            const dept = this.perList[idxs[0]].dpms[idxs[1]]
            this.currentOrgId = org.id
            this.currentDeptId = dept.id
            this.systemCode = dept.systemCode || 'gxqpt'
        }
    },
    watch: {
        currentDeptId () {
            this.getDeptPerson()
        }
    }
}
</script>

<style lang="less" scoped>
.wAuto{
	width: 100%;
}
.queryTime{
	width: 200px;
}
.flow{
	margin-top: 20px ;
}
</style>

<style lang="less">
#sex{
    .ivu-form-item-content{
        text-align: left;
    }
}
</style>
