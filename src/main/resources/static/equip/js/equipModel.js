var EquipTypeModel = React.createClass({
    getInitialState: function () {
        return {
            equipTypeList: []
        };
    },
    componentDidMount: function () {
        var postData = JSON.stringify({
            "funcName": "listEquipType",                       //controller 中的方法名
            "controllerName": "equipTypeController",           //controller 注解名称
            "serialNumber": guid(),                    //请求流水
            "userAccount": "122222222",                    //用户账户
            "reqSysCode": "A02",                       //请求生成端 A01-web ,A02-app, A03-微信
            "reqTime": new Date().Format("yyyy-MM-dd hh:mm:ss.S"),                      //请求时间
            "data": {
                id:1,
                name:"dd"
                //请求传递的消息报文主体，格式不做控制
            },
            "security": {                                //安全层
                //访问令牌，如果没有这个需要先访问authController中的login来获取
                "accessTocken": "",
                "smsCode": "",
                "emailCode": "",
                "deviceId": "",
                "usbKey": "",
                "imageCode": "",
                "codeKey": ""
            }
        });
        var that = this;
        this.serverRequest = $.ajax({
            type: 'POST',
            url: "/common",
            contentType: "application/json; charset=utf-8",
            data: postData,
            success: function (result) {
                that.setState({
                    equipTypeList: result.data
                });
            },
        });
    },
    componentWillUnmount: function () {
        this.serverRequest.abort();
    },
    render: function () {
        var list = this.state.equipTypeList.map(function (item) {
            return (<option value={item.id}>{item.equipTypeName}</option>)
        });
        return (
            <select className="form-control" placeholder="请选择设备类别" id="equipTypeId" name="equipTypeId">
                <option value="0">请选择设备类别</option>
                {list}
            </select>
        )

    }
});


var EquipModel = React.createClass({
    getInitialState: function () {
        return {
            equipList: []
        };
    },

    componentDidMount: function () {
        this.setState({
            equipList: [{equipName: "测试", equipModel: "银江"}, {equipName: "测试1", equipModel: "银江1"}]
        });
    },

    saveEquip: function () {
        var addEquip=$("#addEquip").serialize();
        console.log(addEquip);
        var option={
            contentType: "application/json; charset=utf-8",
            url:"/common"
        }
    },

    render: function () {
        var equipList = this.state.equipList;
        return (
            <div className="modal fade" id="equipModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <button type="button" className="close" data-dismiss="modal"
                                    aria-hidden="true">&times;</button>
                            <h4 className="modal-title" id="myModalLabel">
                                添加设备
                            </h4>
                        </div>
                        <div className="modal-body">
                            <div className="panel">
                                <div className="panel-body">
                                    <form action="/common" id="addEquip">
                                        <input type="text" className="form-control" placeholder="设备名称"
                                               name="equipName"/>
                                        <br/>
                                        <input type="text" className="form-control" placeholder="设备型号"
                                               name="equipModel"/>
                                        <br/>
                                        <input type="text" className="form-control" placeholder="设备厂商"
                                               name="equipFirm"/>
                                        <br/>
                                        <input type="text" className="form-control" placeholder="投入时间"
                                               name="putUseTime"/>
                                        <br/>
                                        <input type="text" className="form-control" placeholder="保修时间"
                                               name="guaranteePeriod"/>
                                        <br/>
                                        <input type="text" className="form-control" placeholder="主要性能参数"
                                               name="equipDetail"/>
                                        <br/>
                                        <input type="text" className="form-control" placeholder="使用地点" name="address"/>
                                        <br/>
                                        <EquipTypeModel/>
                                        <br/>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" className="btn btn-primary" onClick={this.saveEquip}>保存</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
});