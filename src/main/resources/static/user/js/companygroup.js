
//弹窗
var ModelPushInval = React.createClass({


    render:function() {
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
                                    邀请组成员
                                </h4>
                            </div>
                            <div className="modal-body">
                                <input type="text" className="form-control" placeholder="手机号" id="invitPhone"></input>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default" data-dismiss="modal">关闭
                                </button>
                        <CommitBtnInval/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }


});
var CommitBtnInval = React.createClass({

    commit:function(){
        $('#myModal1').modal('hide')

        if($("#invitPhone").val().length==0)
        {
            alert("手机号为空");
            return;
        }
        $.ajax({
            type: "POST",
            url: "/user/invitePeopleGroup",
            data: {phone:$("#invitPhone").val(),companyID:2,groupID:2},
            success: function(data){
                alert(data.info);
            },
            error:function(err){
                alert("邀请失败");
            }
        });






    },
    render:function(){
        return <p onClick={this.commit}  className="btn btn-primary" id="commitYaoqing">
            邀请
        </p>
    }
})



var ListUi=React.createClass({
    getInitialState: function() {
        return {
            groupList : []
        };
    },
    componentDidMount: function() {
        this.serverRequest = $.post("/user/getGroupList",{sonGroupID:Cookies.get("companyId")}, function (result) {
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
            <li  className="list-group-item leftw"><a href="#">{item.groupName}</a>
                <button className="btn btn-default leftw">查看权限</button>
                <button className=" btn btn-default leftw"data-toggle="modal" data-target="#myModal1">邀请成员</button>
                <ModelPushInval/>
            </li>
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
                            <ModelPushCreatGroup/>
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
var ModelPushCreatGroup = React.createClass({

    render:function() {
        return (
            <div>
                  <button className="btn btn-default top15" data-toggle="modal" data-target="#myModalgroup">
                   创建组
                </button>
                <div className="modal fade" id="myModalgroup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
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
                                 <CommitBtnGroup/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

});
var CommitBtnGroup = React.createClass({

    commit:function(){
        $('#myModalgroup').modal('hide')

        var name= $("#groupName").val();
        if(name.length==0)
        {
            alert("请输入名字");
            return;
        }
        //String groupname,String companyID,String reatUserName,String reatUserID
        var  data={
            groupname:name,
            companyID:Cookies.get("companyId"),
            reatUserName:Cookies.get("userName"),
            reatUserID:Cookies.get("userId")
        }

        $.ajax({
            type: "POST",
            url: "/user/creatGroup",
            data: data,
            success: function(data){
                alert("创建成功");
            },
            error:function(err){
                alert("创建失败");
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
