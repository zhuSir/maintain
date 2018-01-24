



var ListUi=React.createClass({
    getInitialState: function() {
        return {
            groupList : []
        };
    },
    componentDidMount: function() {
        this.serverRequest = $.post("/user/getGroupList",{sonGroupID:"2"}, function (result) {
            this.setState({
                groupList : result
            });
        }.bind(this));
    },



    componentWillUnmount: function() {
        this.serverRequest.abort();
    },

    render:function(){
        var list=this.state.groupList.map(function(item){
            return (
            <li className="list-group-item">{item.groupName}</li>
        )
    })
        return (
            <div className="panel-group" id="accordion">
                <div className="col-sm-12 top15">
                </div>
                <div className="panel panel-default top40">
                    <div className="panel-heading">
                        <h4 className="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion">
                                银江公司
                            </a>
                            <ModelPush/>
                        </h4>

                    </div>

                    <ul className="list-group">
                        {list}
                    </ul>

                </div>
            </div>

        )

    }

});


//创建部门的按钮
var EditBtn=React.createClass({

    render:function(){
        return(
            <button className="btn btn-default">创建部门</button>
        )
    }
});

//弹窗
var ModelPush = React.createClass({

    render:function() {
        return (
            <div>
                  <button className="btn btn-default top15" data-toggle="modal" data-target="#myModal">
                   创建组
                </button>
                <div className="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 className="modal-title" id="myModalLabel">
                                    创建组
                                </h4>
                            </div>
                            <div className="modal-body">
                                <input type="text" className="form-control" placeholder="组名称" id="groupName"></input>

                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                 <CommitBtn/>
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
        $('#myModal').modal('hide')

        var name= $("#groupName").val();
        if(name.length==0)
        {
            alert("请输入名字");
            return;
        }
        $.ajax({
            type: "POST",
            url: "/user/creatGroup",
            data: {groupname:name},
            success: function(data){
                alert("success");
            },
            error:function(err){

                alert(err.key);

            }
        });


    },
    render:function(){
        return <p onClick={this.commit}  className="btn btn-primary" id="commit">
            提交
        </p>
    }
})

ReactDOM.render(
    <ListUi />,
    document.getElementById('group')

);
