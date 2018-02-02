//弹窗
var ModelPush = React.createClass({
    render: function () {
        return (
            <div>
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
    commit: function () {
        $('#myModal1').modal('hide')
    },
    render: function () {
        return <p onClick={this.commit} className="btn btn-primary" id="commitYaoqing">
            邀请
        </p>
    }
});

var BgDiv = React.createClass({
    getInitialState: function () {
        return {
            listUser: []
        };
    },

    componentDidMount: function () {
        this.serverRequest = $.post(config.listCompanyMember, {companyID: Cookies.get("companyId")}, function (result) {
            this.setState({
                listUser: result.data
            });
        }.bind(this));
    },

    componentWillUnmount: function () {
        this.serverRequest.abort();
    },

    render: function () {
        var list = this.state.listUser.map(function (item) {
            return (
                <tr>
                    <td>{item.createName}</td>
                    <td>{item.mobilephone}</td>
                    <td>{item.groupName}</td>
                    <td>
                        <EditBtn data={item.id}/>
                    </td>
                </tr>
            )
        });

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
                        <th>部门</th>
                        <th>编辑</th>
                    </tr>
                    </thead>
                    <tbody>
                    {list}
                    </tbody>
                </table>
            </div>
        )
    }
});

var EditBtn = React.createClass({

    removeCompany: function () {
        var id = $('#removeCompany').val();
        alert(id);

        $.post("/userinfo/deleteGroupUser", {userId: id}, function (res) {
            if (res != "" && res != undefined && res != null) {
                if (res.code != 0) {
                    alert(res.info);
                } else {
                    this.getDOMNode().remove();
                }
            }
        })
    },

    render: function () {
        return (
            <div >
                <button id="removeCompany" value={this.props.data} type="button" className="btn btn-info"
                        onClick={this.removeCompany}>移除
                </button>
            </div>
        )
    }
});

ReactDOM.render(
    <BgDiv />,
    document.getElementById('userList')
);

