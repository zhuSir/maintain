var EquipModel = React.createClass({
    getInitialState: function () {
        return {
            equipList: []
        };
    },

    componentDidMount: function () {
        this.setState({
            equipList: [{equipName: "测试", equipModel: "银江"},{equipName: "测试1", equipModel: "银江1"}]
        });
    },

    render: function () {
        var equipList = this.state.equipList;
        for (var i = 0; i < equipList.length; i++) {
            console.log(equipList[i].equipName);
        }
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
                                    <input type="text" className="form-control" placeholder="设备名称" name="equipName"/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="设备型号" name="equipModel"/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="设备厂商" name="equipFirm"/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="投入时间" name="putUseTime"/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="保修时间"
                                           name="guaranteePeriod"/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="主要性能参数"
                                           name="equipDetail"/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="使用地点" name="address"/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="设备类别" name="equipTypeId"/>
                                    <br/>
                                    <select className="form-control" placeholder="请选择设备类别" defaultValue="0">
                                        <option defaultValue="0">请选择项目</option>
                                        <option defaultValue="1">fk project</option>
                                        <option defaultValue="2">扫厕所项目</option>
                                        <option defaultValue="3">刷马桶项目</option>
                                        <option defaultValue="4">洗屁屁项目</option>
                                        <option defaultValue="5">挤痘痘项目</option>
                                    </select>
                                    <br/>
                                </div>
                            </div>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" className="btn btn-primary">保存</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
});
ReactDOM.render(
    <EquipModel/>,document.getElementById("itemBody")
);