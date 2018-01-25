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
                    <p className="subTitle">姓名：<span id="name">-----</span></p>
                    <p className="subTitle">手机：<span id="phone">-----</span></p>
                    <p className="subTitle">公司：<span id="company">------</span></p>
                    <p className="subTitle">部门：<span id="groupName">-----</span></p>
                </div>
            </div>
            <div className="col-md-4">
                <h1 className="edit">编辑</h1>
            </div>
        </div>
    </div>,
    document.getElementById('userinfo')
);

$(document).ready( function () {
    //todo
   var userId = Cookies.get('userId');

    // var data={
    //     userId:
    // };

    $.ajax({
        type: "POST",
        url: config.getUserById,
        data: {userId:5},
        dataType: "json",
        success: function (res) {
            //todo
            $('#name').val(res.createName);
            $('#phone').val(res.mobilephone);
            $('#company').val(res.companyName);
            $('#groupName').val(res.groupName);
        },
        error: function (err) {
            alert("登陆失败");
        }
    });
});