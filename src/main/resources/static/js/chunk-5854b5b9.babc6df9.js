(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5854b5b9"],{"0fea":function(e,t,a){"use strict";a.d(t,"a",(function(){return o}));var r=a("b775"),n={user:"/user",role:"/role",service:"/service",permission:"/permission",permissionNoPager:"/permission/no-pager",orgTree:"/org/tree"};function o(e){return Object(r["b"])({url:n.role,method:"get",params:e})}},6239:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-card",{attrs:{bordered:!1}},[a("a-button",{staticStyle:{"margin-bottom":"18px"},attrs:{type:"primary",icon:"plus"},on:{click:function(t){return e.$refs.createModal.add()}}},[e._v("添加新节点")]),a("a-table",{attrs:{columns:e.columns,dataSource:e.data},scopedSlots:e._u([{key:"serial",fn:function(t,r,n){return a("span",{},[e._v(" "+e._s(n+1)+" ")])}},{key:"status",fn:function(t){return a("span",{},[a("a-badge",{attrs:{status:e._f("statusTypeFilter")(t),text:e._f("statusFilter")(t)}})],1)}},{key:"action",fn:function(t,r){return a("span",{},[[a("a",{on:{click:function(t){return e.handleEdit(r)}}},[e._v("修改")]),a("a-divider",{attrs:{type:"vertical"}}),a("a",{on:{click:function(t){return e.handleSub(r)}}},[e._v("删除")]),a("a-divider",{attrs:{type:"vertical"}}),a("a",{on:{click:function(t){return e.handleSub(r)}}},[e._v("置维护")])]],2)}}])}),a("create-form",{ref:"createModal",on:{ok:e.handleOk}})],1)},n=[],o=a("2af9"),i=a("0fea"),s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-modal",{attrs:{title:"添加新节点",width:640,visible:e.visible,confirmLoading:e.confirmLoading},on:{ok:e.handleSubmit,cancel:e.handleCancel}},[a("a-spin",{attrs:{spinning:e.confirmLoading}},[a("a-form",{attrs:{form:e.form}},[a("a-form-item",{attrs:{label:"名称",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["desc",{rules:[{required:!0,min:5,message:"请输入至少五个字符的规则描述！"}]}],expression:"['desc', {rules: [{required: true, min: 5, message: '请输入至少五个字符的规则描述！'}]}]"}]})],1),a("a-form-item",{attrs:{label:"IP",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["IP",{rules:[{required:!0}]}],expression:"['IP', {rules: [{required: true}]}]"}]})],1),a("a-form-item",{attrs:{label:"模式选择",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-radio-group",{attrs:{name:"radioGroup",defaultValue:1}},[a("a-radio",{attrs:{value:1}},[e._v("高安全")]),a("a-radio",{attrs:{value:2}},[e._v("普通")])],1)],1),a("a-form-item",{attrs:{label:"裁决功能",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-switch",{attrs:{checkedChildren:"开",unCheckedChildren:"关",defaultChecked:""}})],1),a("a-form-item",{attrs:{label:"异常修复功能",labelCol:e.labelCol,wrapperCol:e.wrapperCol}},[a("a-switch",{attrs:{checkedChildren:"开",unCheckedChildren:"关",defaultChecked:""}})],1)],1)],1)],1)},l=[],c={data:function(){return{labelCol:{xs:{span:24},sm:{span:7}},wrapperCol:{xs:{span:24},sm:{span:13}},visible:!1,confirmLoading:!1,form:this.$form.createForm(this)}},methods:{add:function(){this.visible=!0},handleSubmit:function(){var e=this,t=this.form.validateFields;this.confirmLoading=!0,t((function(t,a){t?e.confirmLoading=!1:setTimeout((function(){e.visible=!1,e.confirmLoading=!1,e.$emit("ok",a)}),1500)}))},handleCancel:function(){this.visible=!1}}},d=c,u=a("623f"),m=Object(u["a"])(d,s,l,!1,null,null,null),f=m.exports,p={0:{status:"warning",text:"警告"},1:{status:"success",text:"正常"},2:{status:"error",text:"异常"}},h={0:{text:"minic"},1:{text:"NameNode"},2:{text:"DataNode"}},b=[{title:"#",scopedSlots:{customRender:"serial"}},{title:"名称",dataIndex:"name",key:"name"},{title:"IP",dataIndex:"IP",key:"IP"},{title:"角色",key:"role",dataIndex:"role"},{title:"状态",dataIndex:"status",scopedSlots:{customRender:"status"}},{title:"上线时间",dataIndex:"updatedAt",sorter:!0},{title:"操作",dataIndex:"action",width:"250px",scopedSlots:{customRender:"action"}}],v={name:"Workplace",components:{CreateForm:f,STable:o["m"]},data:function(){return{mdl:{},advanced:!1,queryParam:{},columns:b,data:[],selectedRowKeys:[],selectedRows:[]}},filters:{statusFilter:function(e){return p[e].text},statusTypeFilter:function(e){return p[e].status},callNoFilter:function(e){return h[e].text}},created:function(){Object(i["a"])({t:new Date})},mounted:function(){this.getData()},methods:{getData:function(){var e=this;this.axios.get("/workplace/radar").then((function(t){e.data=t.result}))},handleEdit:function(e){this.$refs.modal.edit(e)},handleSub:function(e){0!==e.status?this.$message.info("".concat(e.no," 订阅成功")):this.$message.error("".concat(e.no," 订阅失败，规则已关闭"))},handleOk:function(){this.$refs.table.refresh()},onSelectChange:function(e,t){this.selectedRowKeys=e,this.selectedRows=t},toggleAdvanced:function(){this.advanced=!this.advanced},resetSearchForm:function(){this.queryParam={date:moment(new Date)}}}},C=v,w=Object(u["a"])(C,r,n,!1,null,null,null);t["default"]=w.exports}}]);