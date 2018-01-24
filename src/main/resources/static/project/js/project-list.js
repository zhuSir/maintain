var Projectlist= React.createClass({
    render: function() {
        return (
            <div className="container">
                {/*<table>
                    <thead>
                        <tr>
                            <th>项目名称</th>
                            <th>项目状态</th>
                            <th >
                                <p className=" btn btn-default col-sm-12 top25 text-center test" onClick={this.edit}>编辑</p>
                            </th>
                            <th >
                                <p className=" btn btn-default col-sm-12 top25 text-center test" onClick={this.delete}>删除</p>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>*/}
                <div className="panel panel-default">
                    <div className="panel-heading">项目列表</div>
                    <div className="panel-body">
                        <p>...</p>
                    </div>
                    <!-- Table -->
                    <table className="table">
                        <tr>
                            <th>项目名称</th>
                            <th>项目状态</th>
                        </tr>
                    </table>
                </div>
            </div>
        )
    }
})
//创建项目弹框
var Mask=React.createClass({
    render:function(){
        return(
            <div>
                <div className="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 className="modal-title" id="exampleModalLabel">输入信息</h4>
                            </div>
                            <div className="modal-body">
                                <form>
                                    <div className="form-group">
                                        <label for="recipient-name" className="control-label">Recipient:</label>
                                        <input type="text" className="form-control" id="recipient-name"/>
                                    </div>
                                    <div className="form-group">
                                        <label for="message-text" className="control-label">Message:</label>
                                        <textarea className="form-control" id="message-text"></textarea>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" className="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" className="btn btn-primary">发送</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
})
//创建项目按钮点击事件
var Diji=React.createClass({
    create:function(even){
        $("#exampleModal").modal("show");
    }
    render:function(){
        <button className=" btn btn-default col-sm-12 top25 text-center test" onClick={this.create}>创建项目</button>
    }
})
ReactDOM.render(
    <Projectlist />,
    document.getElementById('example')
);