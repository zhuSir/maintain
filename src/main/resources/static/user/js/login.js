
var BgDiv = React.createClass({
    render: function() {
        return (
            <div className="bg test row bgImage">

            <div className="col-sm-4 "></div>
            <div className="col-sm-4 centerDivBG ">

            <h5 className="text-center top25">登录</h5>

            <input className="top25 input-group form-control" placeholder="手机号" id="phoneInput"></input>
            <input type="password" className="top25 input-group form-control" placeholder="密码" id="pswInput"></input>
            <DengluBtn/>
              <Zhuce/>

            </div>
            <div className="col-sm-4 "></div>
            </div>
        )
    }
});


var DengluBtn = React.createClass({

    gotoOther:function (event) {
        var  data ={
            phone:$("#phoneInput").val(),
            password:$("#pswInput").val()
        };

//window.open("../../base/index.html");
        window.open("../../base/index.html");

        $.ajax({
            type: "POST",
            url: zydUrl.userlogin,
            data: data,
            dataType: "json",
            success: function(data){
                alert("success");
            },
            error:function(err){
                alert("error");

            }
        });
    },
    render: function() {
        return <p onClick={this.gotoOther} className="btn btn-default col-sm-12 top25 text-center test">登录</p>;
    }
});

var Zhuce = React.createClass({

    gotoOther:function (event) {

       window.open("register.html");
    },
    render: function() {
        return <p onClick={this.gotoOther} className="btn btn-default col-sm-12 text-center test">注册</p>;
    }
});

ReactDOM.render(
    <BgDiv />,
    document.getElementById('example')
);
