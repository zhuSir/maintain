//创建项目弹框
var Mask=React.createClass({
    render:function(){
        return(
            <div>
                <button className=" btn btn-default col-sm-12 top25 text-center test create" data-toggle="modal" data-target="#myModal" >创建项目</button>
                <div className="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 className="modal-title" id="myModalLabel">创建项目</h4>
                            </div>
                            <div className="modal-body">
                                <form action="" className="bs-example bs-example-form">
                                    <label >
                                        <span>项目名称</span>
                                        <input type="text" className="form-control" id="pname" placeholder="项目名称"/>
                                    </label><br/>
                                    <label >
                                        <span>项目状态</span>
                                        <input type="text" className="form-control" id="pstates" placeholder="项目状态"/>
                                    </label><br/>
                                    <label >
                                        <span>归属公司</span>
                                        <input type="text" className="form-control" id="comname" placeholder="归属公司"/>
                                    </label><br/>
                                    <label >
                                        <span>地址</span>
                                        <input type="text" className="form-control" id="addres" placeholder="地址"/>
                                    </label><br/>
                                    <label >
                                        <span>归属部门</span>
                                        <input type="text" className="form-control" id="department" placeholder="归属部门"/>
                                    </label><br/>
                                    <label >
                                        <span>备注</span>
                                        <input type="text" className="form-control" id="discribe" placeholder="备注"/>
                                    </label><br/>
                                    <label >
                                        <span>计划开始时间</span>
                                        <input type="text" className="form-control" id="begindate" placeholder="计划开始时间"/>
                                    </label><br/>
                                    <label >
                                        <span>计划结束时间</span>
                                        <input type="text" className="form-control" id="endate" placeholder="计划结束时间"/>
                                    </label><br/>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default qu" data-dismiss="modal">取消</button>
                                <Cofirm/>
                                {/*<button type="button" className="btn btn-primary" onClick={this.confirm}>提交更改</button>*/}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
})
/*删除按钮*/
var Delete=React.createClass({
    render:function(){
        return(
            <div>
                <button className="btn btn-default delete" data-toggle="modal" data-target="#mdModal">删除</button>
                <div className="modal fade" id="mdModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header hed">
                                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default qu" data-dismiss="modal">取消</button>
                                <button type="button" className="btn btn-primary" >确定</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
})
/*编辑项目弹框*/
var Edit=React.createClass({
    render:function(){
        return(
            <div>
                <button className=" btn btn-default edit" data-toggle="modal" data-target="#meModal" >编辑</button>
                <div className="modal fade" id="meModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div className="modal-body">
                                <form action="" className="bs-example bs-example-form">
                                    <label >
                                        <span>项目名称</span>
                                        <input type="text" className="form-control" id="pname" placeholder="项目名称"/>
                                    </label><br/>
                                    <label >
                                        <span>项目状态</span>
                                        <input type="text" className="form-control" id="pstates" placeholder="项目状态"/>
                                    </label><br/>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default qu" data-dismiss="modal">取消</button>
                                {/*<button type="button" className="btn btn-primary" >确定</button>*/}
                                <Edits/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
})
/*创建项目提交操作*/
var Cofirm=React.createClass({
    commit:function(){
        $('#myModal').modal('hide')
            var name= $(".modal-body form input").val();
            var pname=$('#pstates').val();
            if(name==0)
            {
                alert("输入框为空，请输入！");
                return;
            }else{
                $('.state').html(pname);
            }

    },
    render:function(){
        return <p onClick={this.commit}  className="btn btn-primary" id="commit">
            提交
        </p>
    }
})
var Edits=React.createClass({
    commit:function(){
        $('#myModal').modal('hide')
        var name= $(".modal-body form input").val();
        var pname=$('#pstates').val();
        if(name==0)
        {
            alert("输入框为空，请输入！");
            return;
        }else{
            $('.state').html(pname);
        }

    },
    render:function(){
        return <p onClick={this.Edits}  className="btn btn-primary" id="commit">
             确定
        </p>
    }
})
var Projectlist= React.createClass({
    getInitialState: function() {
        return {
            groupList : []
        };
    },
    componentDidMount: function() {
        console.log("Box的componentDidMount调用");
        this.serverRequest = $.post("/project/getGroupList",{uId:"1"}, function (result) {
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
                <tr className="listgroup-item">{list.groupName}</tr>
            )
        })
        return (
            <div>
                <div className="container">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>项目名称</th>
                            <th>
                               项目状态
                            </th>
                            <th>
                                <Mask/>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr className="listgroup">
                                    <td className="pname">信阳火车站</td>
                                    <td className="state">已开工</td>
                                    <td className="button">
                                        <Delete/>
                                        <Edit/>
                                    </td>
                                </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
})

ReactDOM.render(
    <Projectlist />,
    document.getElementById('pro-list')
);