var ProjectList = React.createClass({

    getInitialState: function() {
        return {
            projectList : []
        };
    },

    componentDidMount: function() {
        this.serverRequest = $.post("/project/list", function (result) {
            var lastGist = result[0];
            this.setState({
                projectList : result.data
            });
        }.bind(this));
    },

    componentWillUnmount: function() {
        this.serverRequest.abort();
    },

    render:function () {
        //TODO foreach project list
    }
})

var FaultModel = React.createClass({
    render:function () {
        return (
            <div className="modal fade" id="faultModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 className="modal-title" id="myModalLabel">
                                添加报障信息
                            </h4>
                        </div>
                        <div className="modal-body">

                            <div className="panel">
                                <div className="panel-body">
                                    <input type="text" className="form-control" placeholder="维修人电话"/>
                                    <br/>
                                    <input type="text" className="form-control" placeholder="维修人名称"/>
                                    <br/>
                                    <textarea className="form-control" placeholder="报障信息" rows="4"></textarea>
                                    <br/>
                                    <select className="form-control" placeholder="请选择项目" defaultValue="请选择项目">
                                        <option defaultValue="0">请选择项目</option>
                                        <option defaultValue="1">fk project</option>
                                        <option defaultValue="2">扫厕所项目</option>
                                        <option defaultValue="3">刷马桶项目</option>
                                        <option defaultValue="4">洗屁屁项目</option>
                                        <option defaultValue="5">挤痘痘项目</option>
                                    </select>
                                    <br/>
                                    <div className="panel-heading">
                                        <h3 className="panel-title">紧急情况</h3>
                                    </div>
                                    <label className="checkbox-inline">
                                        <input name="gender" defaultValue="male" type="radio"/>
                                        <span><i></i>一般</span>
                                    </label>
                                    <label className="checkbox-inline">
                                        <input name="gender" defaultValue="female" type="radio" />
                                        <span><i></i>紧急</span>
                                    </label>
                                    <label className="checkbox-inline">
                                        <input name="gender" defaultValue="female" type="radio" />
                                        <span><i></i>特急</span>
                                    </label>
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
})