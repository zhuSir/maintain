
var BgDiv = React.createClass({
    render: function() {
        return (
            <div className="bg test row">

            <div className="col-sm-4 "></div>
            <div className="col-sm-4 centerDivBG ">

            <h5 className="text-center top25">登录</h5>
            <input className="top25 input-group " placeholder="手机号" id="phoneInput"></input>
            <input type="password" className="top25 input-group " placeholder="密码" id="pswInput"></input>
            <DengluBtn/>


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



        $.ajax({
            type: "POST",
            url: zydUrl.userlogin,
            data: data,
            dataType: "json",
            success: function(data){
                alert("success");
            },
            error:function(err){
                alert("success");

            }
        });
    },
    render: function() {
        return <p onClick={this.gotoOther} className="top25 text-center test">点击我登录</p>;
    }
});

ReactDOM.render(
    <BgDiv />,
    document.getElementById('example')
);
