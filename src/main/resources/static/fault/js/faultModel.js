var ProjectList = React.createClass({
    getInitialState: function() {
        return {
            projectList : []
        };
    },
    componentDidMount: function() {
        this.serverRequest = $.post("/project/select",{uId:1},function (result) {
            this.setState({
                projectList : result
            });
        }.bind(this));
    },
    componentWillUnmount: function() {
        this.serverRequest.abort();
    },
    render:function(){
        var list=this.state.projectList.map(function(item){
            return (<option value={item.id}>{item.name}</option>)
        });
        return(
            <select className="form-control" placeholder="请选择项目" id="projectInfo">
                <option value="0">请选择项目</option>
                {list}
            </select>
        )

    }
});

var EquipList = React.createClass({
    getInitialState: function() {
        return {
            equipList : []
        };
    },
    componentDidMount: function() {
        // $.ajax({
        //     url:"/common",
        //     type: "post",
        //     contentType : "application/json; charset=utf-8",
        //     data : JSON.stringify({
        //         "funcName": "getEquipList",                       //controller 中的方法名
        //         "serviceName": "equipController",           //controller 注解名称
        //         "serialNumber": guid(),                    //请求流水
        //         "userAccount": "122222222",                    //用户账户
        //         "reqSysCode": "A02",                       //请求生成端 A01-web ,A02-app, A03-微信
        //         "reqTime": new Date().Format("yyyy-MM-dd hh:mm:ss.S"),                      //请求时间
        //         "data": {
        //             //请求传递的消息报文主体，格式不做控制
        //         },
        //         "security": {                                //安全层
        //             //访问令牌，如果没有这个需要先访问authController中的login来获取
        //             "accessTocken": "",
        //             "smsCode": "",
        //             "emailCode": "",
        //             "deviceId": "",
        //             "usbKey": "",
        //             "imageCode": "",
        //             "codeKey": ""
        //         }
        //     }),
        //     success : function(res){
        //         console.log(res);
        //         this.setState({
        //             equipList : result
        //         });
        //     }
        // });

        // this.serverRequest = $.post("/project/select",{uId:1},function (result) {
        //     this.setState({
        //         projectList : result
        //     });
        // }.bind(this));
    },
    componentWillUnmount: function() {
        this.serverRequest.abort();
    },

    render:function(){
        var list=this.state.projectList.map(function(item){
            return (<option value={item.id}>{item.name}</option>)
        });
        return(
            <select className="form-control" placeholder="请选择设备" id='equipInfo'>
                <option defaultValue="0">请选择设备</option>
                {list}
            </select>
        )
    }
});

var FaultModel = React.createClass({
    render:function () {
        return (
            <div className="modal fade" id="faultModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times</button>
                            <h4 className="modal-title" id="myModalLabel">
                                添加报障信息
                            </h4>
                        </div>
                        <div className="modal-body">

                            <div className="panel">
                                <div className="panel-body">
                                    <input type="number" className="form-control" placeholder="维修人电话" id="maintainPhone" onBlur={this.selectPhone}/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="维修人名称" id="maintainName"/>
                                    <br/>
                                    <textarea className="form-control" placeholder="请添加报障说明" rows="4" id="faultReason"/>
                                    <br/>
                                        <ProjectList/>
                                    <br/>
                                        <select className="form-control" placeholder="请选择设备" id="equipInfo">
                                            <option value="0">请选择设备</option>
                                        </select>
                                    <br/>
                                    <div className="panel-heading">
                                        <h3 className="panel-title">紧急情况</h3>
                                    </div>
                                    <label className="checkbox-inline">
                                        <input name="gender" defaultValue="male" type="radio" data-type='0'/>
                                        <span><i></i>一般</span>
                                    </label>
                                    <label className="checkbox-inline">
                                        <input name="gender" defaultValue="female" type="radio" data-type='1'/>
                                        <span><i></i>紧急</span>
                                    </label>
                                    <label className="checkbox-inline">
                                        <input name="gender" defaultValue="female" type="radio" data-type='2'/>
                                        <span><i></i>特急</span>
                                    </label>
                                </div>
                            </div>

                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-default" data-dismiss="modal" id='cancel'>关闭</button>
                            <button type="button" className="btn btn-primary" onClick={this.saveFaultInfo}>保存</button>
                        </div>
                    </div>
                </div>
            </div>
        )
    },
    selectPhone : function () {
        var phone = $('#maintainPhone').val();
        $.post("/userinfo/byphone",{phone : phone},function(res){
            if(res != "" && res != undefined && res != null){
                $('#maintainName').val(res.createName);
            }
        })
    },
    saveFaultInfo : function(){
        var faultType = 0;
        $.each($('.checkbox-inline input:radio:checked'),function (){
            faultType=$(this).data("type");
        });
        var projectId = $("#projectInfo").find("option:selected").val();
        var equipId = 1;

        var maintainPhone = $('#maintainPhone').val();
        var maintainName = $('#maintainName').val();
        var faultReason = $('#faultReason').val();

        $.post("/fault/add",
            {
                maintainPhone:maintainPhone,
                maintainName:maintainName,
                remarkReason:faultReason,
                projectId : projectId,
                equipId:equipId,
                faultType : faultType
            },function (res){
            if(res != 0){
                alert("保存成功！");
                $('#cancel').click();
            }
        });
    }
});