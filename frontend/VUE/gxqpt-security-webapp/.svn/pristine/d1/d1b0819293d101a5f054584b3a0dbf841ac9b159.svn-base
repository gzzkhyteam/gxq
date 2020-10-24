<!-- 业务应用运行监管配置中心 -->
<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>统一监管平台</BreadcrumbItem>
        <BreadcrumbItem>{{ title }}</BreadcrumbItem>
      </Breadcrumb>
      <Card style="min-height: 600px;">
        <Form ref="formValidate" inline :label-width="110" :model="serverData">
          <FormItem label="应用名称：">
            <Select v-model="serverData.appId" style="width:200px" clearable>
                <Option v-for="item in appArr" :value="item.appId" :key="item.appId">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem label="监管方式：">
            <Select v-model="serverData.superviseType" style="width:200px" clearable>
                <Option v-for="item in superviseTypeData" :value="item.id" :key="item.id">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem label="运行状态：">
            <Select class="queryItem" v-model="serverData.runStatusArr" clearable>
              <Option value="1">开启</Option>
              <Option value="0">禁用</Option>
            </Select>
          </FormItem>
          <FormItem :label-width="20">
            <Button type="primary" @click="search">查询</Button>
            <Button type="primary" @click="addNew">新增</Button>
          </FormItem>
        </Form>
        <hy-table ref="selection" :data="data" :columns="columns" :current="pageOption.pageNo" :total="pageOption.total" :page-size="pageOption.pageSize" @on-page-change="pageChange" show-sizer border/>
      </Card>
      <Modal v-model="createModal" :title="modelTitle" width="40%" :mask-closable="false">
        <Form ref="createForm" :model="createForm" :rules="createRule" :label-width="120">
          <FormItem label="应用名称" prop="appId">
            <template v-if="!disa">
              <Select v-model="createForm.appId" style="width:200px" :clearable="!disa" :disabled="disa">
                <Option v-for="item in appArr" :value="item.appId" :key="item.appId">{{ item.name }}</Option>
              </Select>
            </template>
            <template v-else>
              <Input type="text" v-model="createForm.appName" disabled/>
            </template>
          </FormItem>
          <FormItem label="同时在线用户上限" prop="onlineLimit">
            <Input type="text" v-model="createForm.onlineLimit"  :disabled="disa" @on-change="onChange" :maxlength="9" style="width: calc(100% - 180px); float: left; margin-right: 10px;">
              <span slot="append">个</span>
            </Input>
            <span class="fontTooltip">请输入长度为1-9位的正整数</span>
          </FormItem>
          <FormItem label="预警级别" required>
            <Select v-model="createForm.level" :disabled="disa">
                <Option :value="1" >一般</Option>
                <Option :value="2" >较重</Option>
                <Option :value="3" >严重</Option>
                <Option :value="4" >特别严重</Option>
            </Select>
          </FormItem>
          <FormItem label="责任人" prop="dutyUser">
            <template v-if="!disa">
              <Select v-model="createForm.dutyUser" ref="dutyUser" clearable filterable :disabled="disa">
                <Option v-for="item in dutyUsers" :value="item.gxqptEmpId" :key="item.gxqptEmpId">{{ item.name }}</Option>
              </Select>
            </template>
            <template v-else>
              <Input type="text" v-model="createForm.dutyUserName" disabled/>
            </template>
          </FormItem>
          <FormItem label="确认人" prop="confirmUser">
            <template v-if="!disa">
              <Select v-model="createForm.confirmUser" filterable multiple :disabled="disa">
                <Option v-for="item in confirmUsers" :value="item.gxqptEmpId" :key="item.gxqptEmpId">{{ item.name }}</Option>
              </Select>
            </template>
            <template v-else>
              <Input type="text" v-model="createForm.confirmUserName" disabled/>
            </template>
          </FormItem>
          <FormItem label="抄送人" prop="copyUser">
            <template v-if="!disa">
              <Select v-model="createForm.copyUser" filterable multiple :disabled="disa">
                <Option v-for="item in copyUsers" :value="item.gxqptEmpId" :key="item.gxqptEmpId">{{ item.name }}</Option>
              </Select>
            </template>
            <template v-else>
              <Input type="text" v-model="createForm.copyUserName" disabled/>
            </template>
          </FormItem>
          <FormItem label="监管方式" prop="superviseType">
            <Select v-model="createForm.superviseType" :clearable="!disa" style="width:200px" :disabled="disa">
                <Option v-for="item in superviseTypeData" :value="item.id" :key="item.id">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem label="提醒方式" prop="remindType">
            <Select class="queryItem" :clearable="!disa" multiple v-model="createForm.remindType" :disabled="disa" @on-change="selectChange">
              <Option value="1">消息</Option>
              <Option value="2">短信</Option>
            </Select>
          </FormItem>
          <FormItem label="运行状态" prop="runStatusArr">
            <Select class="queryItem" :clearable="!disa" v-model="createForm.runStatusArr" :disabled="disa">
              <Option value="1">开启</Option>
              <Option value="0">禁用</Option>
            </Select>
          </FormItem>
          <FormItem label="备注" prop="desc">
            <Input type="textarea" v-model="createForm.desc"  :disabled="disa"/>
          </FormItem>
          <!-- <FormItem label="附件报告" style="margin-top: 40px;" prop="file">
            <hy-upload ref="evalReport" multiple :on-success="setEvalReport" :on-remove="removeEvalReport" :before-upload="evalBeforeUpload" :defaultFileList="createForm.attachment"></hy-upload>
          </FormItem> -->
        </Form>
        <div slot="footer" v-if="modelType!='2'">
          <Button class="modalBtn" type="primary" @click="saveHostRoom" size="large">确定</Button>
          <Button class="modalBtn" type="default" @click="createModal = false" size="large">取消</Button>
        </div>
        <div slot="footer" v-else>
          <Button class="modalBtn" type="default" @click="createModal = false" size="large">关闭</Button>
        </div>
      </Modal>
    </Content>
  </Layout>
</template>

<script>
  import api from '@/api/axiosApi'
  import superviseApiList from '@/api/superviseApiList'
  import hyUpload from '@/components/hengyun/hyUpload'
  import { validateNumber } from '@/api/formValidate'
  import comApiList from '@/api/comApiList'
  import { mapState } from 'vuex'
  function getCreateForm() {
    return {
      appId:null,//应用名称
      onlineLimit:'',//同时在线用户量上限
      level: 1,//预警级别
      dutyUser:'',//责任人
      confirmUser:[],//确认人
      copyUser:[],//抄送人
      superviseType:0,//监管方式1:实时，2:天，3:周，4:月
      remindType:[],//提醒方式
      runStatusArr:'',
      runStatus:'',//运行状态
      desc:'',//备注
    }
  }
  const superviseTypeData = [{name:"实时",id:1},{name:"天",id:2},{name:"周",id:3},{name:"月",id:4}];
  export default {
    data() {
      return {
        title:this.$store.state.title,
        remindTypes:'',
        appArr:[],//应用列表,
        serverData: { //查询参数
          appIds:[],
          appId:null,//应用id
          superviseType:0,//监管方式
          runStatusArr:'',
          runStatus:'',//运行状态
        },
        myAppData:this.$store.state.myAppData,//应用列表
        superviseTypeData:superviseTypeData,
        modelType:'0',//0新增，1修改，2详情
        modelTitle:'新建',
        personArr:[],//人员列表
        createForm:{
          appId:'',//应用名称
          onlineLimit:'',//同时在线用户量上限
          level: 1,//预警级别
          dutyUser:'',//责任人
          confirmUser:[],//确认人
          copyUser:[],//抄送人
          superviseType:null,//监管方式1:实时，2:天，3:周，4:月
          remindType:[],//提醒方式
          runStatusArr:'',
          runStatus:'',//运行状态
          desc:'',//备注
        },
        createModal:false,
        createRule: {
          appId: [{
            required: true,
            trigger: 'change',
            validator: (rule, value, cb) => {
              if (!this.createForm.appId) {
                cb(new Error('请选择应用名称！'))
                return
              }
              cb()
            }
          }],
          dutyUser: [{required: true, message: '责任人不能为空', trigger: 'change'}],
          confirmUser: [{
            required: true,
            trigger: 'change',
            validator: (rule, value, cb) => {
              if (value.length == 0) {
                cb(new Error('确认人不能为空'))
                return
              }
              cb()
            }
          }],
          superviseType:  [{
            required: true,
            trigger: 'change',
            validator: (rule, value, cb) => {
              if (!value) {
                cb(new Error('监管方式不能为空'))
                return
              }
              cb()
            }
          }],
          // remindType: [{required: true, message: '提醒方式不能为空', trigger: 'change'}],
          remindType: [{
            required: true,
            trigger: 'change',
            validator: (rule, value, cb) => {
              if (this.createForm.remindType.length==0) {
                cb(new Error('请选择提醒方式！'))
                return
              }
              cb()
            }
          }],
          runStatusArr: [{
            required: true,
            trigger: 'change',
            validator: (rule, value, cb) => {
              if (!value) {
                cb(new Error('请选择运行状态！'))
                return
              }
              cb()
            }
          }],
          onlineLimit: [
            {required: true, trigger: 'change',
            validator:(rule, value, callback) => {
              let reg = /^\d*$/;
              if(value === '') {
                callback(new Error("同时在线用户量上限不能为空"));
              } else if(value<=0 || value > 999999999){
                callback(new Error("请输入长度为1-9位的正整数"));
              } else {
                callback();
              }
            }}],
            desc: [{required: false, trigger: 'blur',validator: (rule, value, cb) => {
              if (value.length>500) {
                cb(new Error('请输入0-500字符的备注！'))
                return
              }
              cb()
            }}],
        },
        columns: [{
            type: 'index',
            title: '序号',
            width: 60,
            align: 'center'
          },
          {
            title: '应用名称',
            key: 'appName'
          },
          {
            title: '同时在线用户量上限',
            key: 'onlineLimit'
          },
          {
            title: '预警级别',
            key: 'level',
            render: (h, params) => {
              let level = ['一般', '较重', '严重', '特别严重']
              if (params.row.level) {
                let num = params.row.level -1
                return h('span', level[num])
              } else {
                return h('span', '-')
              }
            }
          },
          {
            title: '责任人',
            key: 'dutyUserName'
          },
          {
            title: '确认人',
            key: 'confirmUserName'
          },
          {
            title: '监管方式',
            key: 'superviseType',
            render: (h, params) => {
              return h('span', superviseTypeData[params.row.superviseType-1].name)
            }
          },
          {
            title: '运行状态',
            key: 'runStatus',
            render: (h, params) => {
              return h('span', (params.row.runStatus) ? "开启" : "禁用")
            }
          },
          {
            title: '操作',
            key: 'act',
            width: 180,
            render: (h, params) => {
              const edit = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                // style: {
                //  display:this.checkButton('hardware_bmyh_fwqgl_xq')?'inline-block':'none'
                // },
                on: {
                  click: () => {
                    this.modelTitle = '修改';
                    console.log(params);
                    this.gotoCtrl(1, params.index)
                  }
                }
              },"修改");
              const detail = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                // style: {
                //  display:this.checkButton('hardware_bmyh_fwqgl_xq')?'inline-block':'none'
                // },
                on: {
                  click: () => {
                    this.modelTitle = '详情';
                    console.log(params);
                    this.gotoCtrl(2, params.index)
                  }
                }
              },"详情");
              const del = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                // style: {
                //  display:this.checkButton('hardware_bmyh_fwqgl_xq')?'inline-block':'none'
                // },
                on: {
                  click: () => {
                    this.itemDelete(params.row.id,params.index);
                  }
                }
              },"删除");
              return h('div', [edit, detail, del]);
            }
          }
        ],
        data: [],
        pageOption: { //分页参数
          pageNo: 1,
          total: 0,
          pageSize: 10
        },
      }
    },
    mounted() {
      this.init(); //初始化
    },
    methods: {
      onChange (e) {
        this.$nextTick(() => {
          var num = this.createForm.onlineLimit
          .replace(/[^\d]/g, '');
          if(num !== null && num !== ''){
            num =  parseInt(num);
          }
          this.createForm.onlineLimit = num
        })
      },
      init(){
        this.findOrgByPower();
        // this.pageAppSupervise(); //查询服务分配管理分页
        this.fwlbByAdmin()
      },
      fwlbByAdmin() {//查询我所管理的所有启用的应用或服务(1：应用；2：服务)
        api(comApiList.findAppIdListByPt, {
          type: 1
        }).then((res) => {
          if (res.status == 200 && res.data.data) {
          this.appArr = res.data.data
          this.appArr.forEach(item=>{
            this.serverData.appIds.push(item.appId)
          })
          // this.serverData.appId = this.appIds
          this.pageAppSupervise(); //查询分页
        }
      }, (err) => {
          //dong something...
        })
      },
      pageChange(num, size) {
        if (!num || !size) {
          return
        }
        this.pageOption.pageSize = size;
        this.pageOption.pageNo = num;
        this.pageAppSupervise();
      },
      pageAppSupervise() { // 查询分页
      switch (this.serverData.runStatusArr) {
        case "0":
          this.serverData.runStatus = false;
          break;
        case "1":
          this.serverData.runStatus = true;
          break;
        default:
          this.serverData.runStatus = "";
          break;
      }
        let ids = [];
        /*this.myAppData.forEach(item=>{
          ids.push(item.appId);
        })
        this.serverData.appIds = ids;*/
        this.data = [];
        var formData = {
          "data": { ...this.serverData},
          "pageNo": this.pageOption.pageNo,
          "pageSize": this.pageOption.pageSize
        };
        api(superviseApiList.pageAppSupervise, formData).then((res) => {
          if(res.status == 200 && res.data.data) {
            this.data = res.data.data.list;
            this.pageOption.pageSize = res.data.data.pageSize;
            this.pageOption.total = res.data.data.total;
            this.pageOption.pageNo = res.data.data.pageNum;
          }
        }, (err) => {
          //dong something...
        })
      },
      findOrgByPower() {
        api(superviseApiList.findOrgByPower).then((res) => {
          if (res.status == 200 && res.data.data) {
            let ids = [];
            res.data.data.forEach(item=>{
              ids.push(String(item.id));
            })
            this.findEmpByOrgId(ids);
          }
        }, (err) => {
          //dong something...
        })
      },
      findEmpByOrgId(ids){
        api(superviseApiList.findEmpByOrgId, {orgIds: ids}).then((resp) => {
          if (resp.status == 200 && resp.data.data) {
            let data = [];
            resp.data.data.forEach(item => {
              data.push({ name: item.name, gxqptEmpId: item.gxqptEmpId });
            })
            this.personArr = data;
            // commit("GETORGBYPOWER", data);
          }
        }, (err) => {
          //dong something...
        })
      },
      search() {
        this.pageOption.pageNo=1;
        console.log(this.serverData);
        this.pageAppSupervise();
      },
      addNew(){
        console.log(this.createForm);
        this.modelType = '0';
        this.modelTitle = '新建';
        this.createModal = true;
        this.$refs.createForm.resetFields();
        this.$refs.dutyUser.clearSingleSelect();
      },
      saveHostRoom(){
        const vm = this
        const url = vm.modelType == '0' ? superviseApiList.saveAppSupervise : superviseApiList.updateAppSupervise;
        vm.$refs['createForm'].validate((valid) => {
          if(valid) {
            const data = {
              ...vm.createForm,
              remindType: vm.remindTypes,
              confirmUser: vm.createForm.confirmUser.join(","),
              copyUser: vm.createForm.copyUser ? vm.createForm.copyUser.join(",") : '',
              runStatus: (vm.createForm.runStatusArr=="0") ? false : true,
              onlineLimit: parseInt(vm.createForm.onlineLimit)
            }
            api(url, data).then((res) => {
              if(res.status == 200 && res.data.data) {
                if(res.data.data && res.data.errmsg == 'ok'){
                  let msg = (this.modelType=='0') ? '保存成功！' : '编辑成功！';
                  vm.$Message.success(msg);
                  vm.pageAppSupervise();
                  vm.createModal = false;
                }else{
                  vm.$Message.error(res.data.errmsg);
                  vm.createModal = true;
                }
              }else{
                vm.$Message.error(res.data.errmsg);
                vm.createModal = true;
              }
            });
          }
        })
      },
      itemDelete(id,idx) {//删除
        const vm = this
        vm.$Modal.confirm({
          title: '删除确认',
          content: '确认删除吗？',
          onOk: () => {
            api(superviseApiList.deleteAppSupervise, {id: id}).then(res => {
              if (res.data.errcode === 0) {
                vm.$Message.success('删除成功！')
                vm.modal = false;
                vm.data.splice(idx, 1)
              }else{
                vm.$Message.error(res.data.errmsg)
              }
            }, error => {console.log(error)})
          }
        })
      },
      selectChange (val) {
        console.log(val)
        if (val.length == 1) {
          this.remindTypes = val.join(",")
        } else if (val.length == 2) {
          this.remindTypes = '3'
        }
      },
      // 操作
      gotoCtrl (type, idx) {
        this.idx = idx;
        if(type==0){// 删除
          this.tableList.data.splice(idx, 1)
        }else{// 修改和详情
          this.$refs.createForm.resetFields();
          const data = JSON.parse(JSON.stringify(this.data[idx]))
          this.createForm = {...getCreateForm(), ...data};
          if (this.createForm.remindType == '3') {
              this.createForm.remindType = ["1", "2"]
          } else {
            this.createForm.remindType = this.createForm.remindType.toString();
          }
          this.createForm.confirmUser = this.createForm.confirmUser.split(",");
          if(this.createForm.copyUser==null)this.createForm.copyUser="";
          if(this.createForm.copyUser)this.createForm.copyUser = this.createForm.copyUser.split(",");
          this.createForm.runStatusArr = (this.createForm.runStatus) ?　'1' : '0';
          this.createModal = true;
          (type==1) ?　this.modelType='1' : this.modelType='2';
        }
      },
      checkButton(code){//按钮权限
        if(this.authButton.indexOf(code) >= 0){
          return true;
        }else{
          return false;
        }
      }
    },
    computed: {
      // 责任人列表
        dutyUsers () {
          return this.personArr.filter(item => {
            return !(this.createForm.confirmUser.includes(item.gxqptEmpId) || this.createForm.copyUser.includes(item.gxqptEmpId))
          })
        },
        // 确认人列表
        confirmUsers () {
          return this.personArr.filter(item => {
            return !((this.createForm.dutyUser ? this.createForm.dutyUser.includes(item.gxqptEmpId) : false) || this.createForm.copyUser.includes(item.gxqptEmpId))
          })
        },
        // 抄送人列表
        copyUsers () {
          return this.personArr.filter(item => {
            return !((this.createForm.dutyUser ? this.createForm.dutyUser.includes(item.gxqptEmpId) : false) || this.createForm.confirmUser.includes(item.gxqptEmpId))
          })
        },
      ...mapState([
        'authButton'
      ]),
      disa(){
        return(this.modelType=="2") ?  true : false;
      }
    },
    components:{
      hyUpload
    },
  }
</script>

<style lang='less' scoped>
  .ivu-btn-small {
    margin: 0 3px;
  }
  .handle{
    color:red;
    cursor: pointer;
  }
  .queryItem {
    width: 200px;
  }
  .access-list {
    span.handle {
      margin: 0 5px;
      display: inline-block;
      cursor: pointer;
      &:hover {
        color: #57a3f3;
      }
    }
  }
  .fontTooltip{
    font-size: 12px;
    color: #bbb;
  }
</style>
