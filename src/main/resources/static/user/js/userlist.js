
//弹窗
var ModelPush = React.createClass({


    render:function() {
        return (
            <div>
                <button className="btn btn-success top15" data-toggle="modal" data-target="#myModal1">
                    邀请成员
                </button>
                <div className="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 className="modal-title" id="myModalLabel">
                                    邀请成员
                                </h4>
                            </div>
                            <div className="modal-body">
                                <input type="text" className="form-control" placeholder="手机号" id="groupName"></input>

                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default" data-dismiss="modal">关闭
                                </button>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }


});
var CommitBtn = React.createClass({

    commit:function(){
        $('#myModal1').modal('hide')



    },
    render:function(){
        return <p onClick={this.commit}  className="btn btn-primary" id="commitYaoqing">
            邀请
        </p>
    }
})
var BgDiv = React.createClass({
    render: function() {
        return (
            <div className="bg test row leftAndRight15 top15">
                <div className="col-xs-12">
                    <ModelPush/>

                </div>
                <table className="table table-striped top15">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>手机号</th>
                        <th>职位</th>
                        <th>部门</th>
                        <th>编辑</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>张也</td>
                        <td>15738039217</td>
                        <td>喂饱</td>
                        <td>研发部</td>
                        <td>
                            <EditBtn/>
                        </td>
                    </tr>
                    <tr>
                        <td>啊哈哈</td>
                        <td>15738039217</td>
                        <td>保障</td>
                        <td>技术部</td>
                        <td>
                            <EditBtn/>
                        </td>
                    </tr>
                    <tr>
                        <td>啊哈哈</td>
                        <td>15738039217</td>
                        <td>保障</td>
                        <td>技术部</td>
                        <td>
                            <EditBtn/>
                        </td>
                    </tr>
                    <tr>
                        <td>啊哈哈</td>
                        <td>15738039217</td>
                        <td>保障</td>
                        <td>技术部</td>
                        <td>
                            <EditBtn/>
                        </td>
                    </tr>
                    </tbody>

                </table>
            </div>
        )
    }
});
var EditBtn = React.createClass({
    render: function() {
        return (
          <div>
              <button className="btn btn-info">移除</button>
          </div>
        )
    }
});
ReactDOM.render(
    <BgDiv />,
    document.getElementById('userList')
);
