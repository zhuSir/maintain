/**
 * 用户信息
 * Created by zhangzhifu on 2018/1/23.
 */

ReactDOM.render(
    <div className="container">
        <div className="row">
            <div className="col-md-4 col-md-offset-4">
                <h1 className="title">个人中心</h1>
                <div className="info">
                    <p className="subTitle">姓名：<span>张志福</span></p>
                    <p className="subTitle">公司：<span>厦门银江智慧城市股份有限公司</span></p>
                    <p className="subTitle">部门：<span>研发部</span></p>
                    <p className="subTitle">手机号：<span>15880239410</span></p>
                </div>
            </div>
            <div className="col-md-4">
                <h1 className="edit">编辑</h1>
            </div>
        </div>
    </div>,
    document.getElementById('userinfo')
);