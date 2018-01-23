/**
 * Created by welleast on 2018/1/22.
 */
var CreatCompanyinit = React.createClass({

    render: function() {
        return (
            <div className="bg test row bgimage">

                <div className="col-sm-4"></div>
                <div className="col-sm-4 centerBG">
                    <p className="text-center top20">创建公司</p>
                    <input className="top25 input-group top20 " placeholder="公司名称" id="name"></input>
                    <input className="top25 input-group top20" placeholder="公司地址" id="address"></input>
                    <input type="number" className="top25 input-group top20" placeholder="公司电话" id="CompanyPhone"></input>

                    <DengluBtn/>
                </div>
                <div className="col-sm-4"></div>
            </div>
        )
    }

});
// 嵌套登录按钮以及事件
var DengluBtn = React.createClass({

    gotoOther:function (event) {

        alert("点击了注册")

    },
    render: function() {
        return <p type="button" onClick={this.gotoOther} className="btn btn-default top20 text-center leftAndRight20 col-sm-12">创建</p>;
    }
});
ReactDOM.render(
    <CreatCompanyinit />,

    document.getElementById('creatCompany')
);
