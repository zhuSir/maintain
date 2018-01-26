/*var Projects=React.createClass({
    getInitialState: function() {
        return {
            Projects : []
        };

    },
    componentDidMount: function() {
        this.serverRequest = $.post("localhost:8080/project/select","uId:1",  function (result) {
            this.setState({
                Projects : result
            });


        }.bind(this));
    },

    componentWillUnmount: function() {
        this.serverRequest.abort();
    },

    render:function () {
        var datas=this.state.Projects.map(function(){
            return (
                Projects : {}
            )
    }
})*/
/*编辑项目*/
var Mask=React.createClass({
    render:function(){
        return(
            <div>
                <button className=" btn btn-default col-sm-12 top25 text-center test edit" data-toggle="modal" data-target="#myModal" >编辑项目</button>
                <div className="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 className="modal-title" id="myModalLabel">编辑项目</h4>
                            </div>
                            <div className="modal-body">
                                <form action="" className="bs-example bs-example-form">
                                    <input type="text" className="form-control" id="pname" placeholder="项目名称"/><br/>
                                    <input type="text" className="form-control" id="coname" placeholder="公司名称"/><br/>
                                    <input type="text" className="form-control" id="fzr" placeholder="项目负责人"/><br/>
                                    <input type="text" className="form-control" id="cbuid" placeholder="建设单位"/><br/>
                                    <input type="text" className="form-control" id="department" placeholder="归属公司"/><br/>
                                    <input type="text" className="form-control" id="discribe" placeholder="备注"/><br/>
                                    <input type="text" className="form-control" id="begindate" placeholder="计划开始时间"/><br/>
                                    <input type="text" className="form-control" id="endate" placeholder="计划结束时间"/><br/>
                                    <input type="text" className="form-control" id="tobia" placeholder="投标状态"/><br/>
                                    <input type="text" className="form-control" id="prstate" placeholder="项目状态"/><br/>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" className="btn btn-primary " id="confirm" onClick={this.confirm}>提交更改</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
})

/*关联项目*/
var Reinf=React.createClass({
    render:function () {
       return(
           <div>
               <div className="btn-group guanli">
                   <button type="button" className="btn btn-default dropdown-toggle" data-toggle="dropdown" >
                       关联项目 <span class="caret"></span>
                   </button>
                   <ul className="dropdown-menu" role="menu">
                       <li><a href="#"></a></li>
                       <li><a href="#">Another action</a></li>
                       <li><a href="#">Something else here</a></li>
                       <li className="divider"></li>
                       <li><a href="#">Separated link</a></li>
                   </ul>
               </div>
           </div>
       )
   }
})
var ContentUI = React.createClass({
    getInitialState: function() {
        return {
            Projects : {}
        };
    },
    componentDidMount: function() {
        console.log("UI的componentDidMount调用")
        var data={
            uId:1
        }
        $.ajax({
            type: "POST",
            url: "/project/select",
            data: data,
            success: function(data){
                alert("请求成功");
                console.log(data)

            },
            error:function(err){
                alert(err);
            }
        });
        this.serverRequest = $.post("localhost:8080/project/select",{uId:"1"},  function (result) {
            this.setState({
                Projects : result
            });

        }.bind(this))
    },
    componentWillUnmount: function() {
        this.serverRequest.abort();
    },
    render: function() {
        return (<div className="container">
        <div className="main">
            <h3>项目详情</h3>
            <div className="wrap">
                <ul className="list-group">
                    <li className="list-group-item">
                        <p className="navbar-text">项目名称:  <span className="proname" id="proname">3</span> </p>
                    </li>
                    <li className="list-group-item">
                        <p className="navbar-text">公司名称:  <span className="comname" id="comname">大山</span> </p>
                    </li>
                    <li className="list-group-item">
                        <p className="navbar-text">项目负责人：<span className="forperson" id="forperson">咋和你说噶</span></p>
                    </li>
                    <li className="list-group-item">
                        <p className="navbar-text">建设单位： <span className="build" id="build">厦门承建有限公司</span></p>
                    </li>
                    <li className="list-group-item">
                        <p className="navbar-text">归属部门：<span className="deparment" id="deparment">研发部</span></p>
                    </li>
                    <li className="list-group-item beish">
                        <div className="reference">
                            <p className="navbar-text">备注: <div className="discribe" id="discribe">我的描述详情</div></p>
                        </div>
                    </li>
                    <li className="list-group-item">
                        <div className="date">
                            <p className="navbar-text">计划开始日期：<span className="begindate" id="begindate">2018-01-23</span></p>
                            <p className="navbar-text">计划结束日期：<span className="enddate" id="enddate">2018-05-23</span></p>
                        </div>
                    </li>
                </ul>
            </div>
            <div className="bid">
                <p className="navbar-text">投标状态：<span className="bidstatus" id="bidstatus"></span>未选中</p>
            </div>
            <div className="prostatus">
                <p className="navbar-text">项目状态：<span className="">未开工</span></p>
            </div>
            <Reinf/>
            <Mask/>
            <div className="admin">
                <p className="navbar-text">审核人：<span className="auditor">张朝阳</span></p>
                <p className="navbar-text">审核日期：<span className="auditor-date">2017-12-29</span></p>
            </div>
        </div>
        </div>
    )
    }
});
ReactDOM.render(
    <ContentUI url="localhost:8080/project/select"/>,
    document.getElementById('example')
);
/*
ReactDOM.render(
    <Project source="https://api.github.com/users/octocat/gists"/>,
    document.getElementById('example')
);*/

