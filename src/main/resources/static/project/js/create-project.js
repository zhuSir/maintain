var Projects=React.createClass({
    getInitialState: function() {
        return {
            Projects : []
        };

    },
    componentDidMount: function() {
        this.serverRequest = $.post("localhost:8080/project/select","uId:1",  function (result) {
            this.setState({
                Projects : result.data
            });


        }.bind(this));
    },

    componentWillUnmount: function() {
        this.serverRequest.abort();
    },

    render:function () {

    }
})
var Project = React.createClass({
    getInitialState: function() {
        return {
            Projects : []
        };

    },
    componentDidMount: function() {
        this.serverRequest = $.post("localhost:8080/project/select","uId:1",  function (result) {
            this.setState({
                Projects : result.data
            });


        }.bind(this));
    },

    render:function(){
        var list=this.state.groupList.map(function(item){
            return (
                <li className="list-group-item">
                <p className="navbar-text">项目编号: {item.id} <span className="numberl" id="numberl">03</span> </p>
             </li>
            )
        })





    render: function() {
        return (<div className="container">
        <div className="main">
            <h3>项目详情</h3>
            <div className="wrap">
                <ul className="list-group">
                    {list}
                    <li className="list-group-item">
                        <p className="navbar-text">项目名称:  <span className="proname" id="proname">维修管理</span> </p>
                </li>
                    <li className="list-group-item">
                        <p className="navbar-text">公司名称:  <span className="comname" id="comname">小康建材</span> </p>
                    </li>
                    <li className="list-group-item">
                        <p className="navbar-text">项目负责人：<span className="forperson" id="forperson">张三</span></p>
                    </li>
                    <li className="list-group-item">
                        <p className="navbar-text">建设单位： <span className="build" id="build">厦门承建有限公司</span></p>
                    </li>
                    <li className="list-group-item">
                        <p className="navbar-text">归属部门：<span className="deparment" id="deparment">研发部</span></p>
                    </li>
                    <li className="list-group-item">
                        <div className="reference">
                            <p className="navbar-text">备注: <div className="discribe">我的描述详情</div></p>
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


            <div className="btn-group">
                <button type="button" className="btn btn-default dropdown-toggle" data-toggle="dropdown" onclick={this.pulling}>
                    Action <span class="caret"></span>
                </button>
                <ul className="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li className="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </div>

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
    <Project />,
    document.getElementById('example')
);
/*
ReactDOM.render(
    <Project source="https://api.github.com/users/octocat/gists"/>,
    document.getElementById('example')
);*/

