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
                                    <input type="text" className="form-control" id="comname" placeholder="归属公司"/><br/>
                                    <input type="text" className="form-control" id="addres" placeholder="地址"/><br/>
                                    <input type="text" className="form-control" id="yezbuild" placeholder="业主单位"/><br/>
                                    <input type="text" className="form-control" id="department" placeholder="归属部门"/><br/>
                                    <input type="text" className="form-control" id="discribe" placeholder="备注"/><br/>
                                    <input type="text" className="form-control" id="begindate" placeholder="计划开始时间"/><br/>
                                    <input type="text" className="form-control" id="endate" placeholder="计划结束时间"/><br/>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" className="btn btn-primary">提交更改</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
})
 var Create=React.createClass({

 })
var Projectlist= React.createClass({
    render: function() {
        return (
            <div>
                <Mask/>
                <div className="container">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>项目名称</th>
                            <th>
                               项目状态
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Anna</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Debbie</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>John</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
               {/* <button className=" btn btn-default col-sm-12 top25 text-center test click" onClick={this.create}>创建项目</button>*/}
            </div>
        )
    }
})
ReactDOM.render(
    <Projectlist />,
    document.getElementById('example')
);