/**
 * Created by lingyun on 2018/1/25.
 */
var LaoliLoginAlter = React.createClass({

    getInitialState:function(){
        return {
            data:'劳力' //初始值为[]
        }
    },
    LoginAction: function () {
         this.requestData()//请求===============
    },
    getDefaultProps: function () {
        return {propsData:'props'}
    },
    requestData:function(){

        var parameters = {
            mobilephone:$("#firstname").val(),
            password:$("#lastname").val()
        }
        var url = "/userinfo/login"
        $.ajax({
            type: "POST",
            url: url,
            data: parameters,
            dataType: "json",
            success: function (responseData)
            {
                alert(responseData.info);
                if (res.code == 0)
                {
                    Cookies.set('userId', responseData.data.id, {expires: 7, path: '/'});
                    Cookies.set('phone', responseData.data.mobilephone, {expires: 7, path: '/'});
                    Cookies.set('userName', responseData.data.createName, {expires: 7, path: '/'});
                    Cookies.set('companyId', responseData.data.companyid, {expires: 7, path: '/'});
                    Cookies.set('companyName', responseData.data.companyName, {expires: 7, path: '/'});
                    Cookies.set('groupId', responseData.data.groupid, {expires: 7, path: '/'});
                    Cookies.set('groupName', responseData.data.groupName, {expires: 7, path: '/'});
                    window.location.href = "../../base/index.html";

                } else {
                    alert(responseData.code);
                }
            },
            error: function (err) {

                alert("error");

            }
        });
    },

    render:function(){

        return (<div>
            <form className="logoinAlter form-horizontal" role="form">
                <div className="form-group">
                        <input type="text" className="top input form-control" id="firstname"
                               placeholder="请输入号码" />
                </div>

                <div className="form-group">
                    <input type="text" className="top input form-control" id="lastname"
                               placeholder="请输入密码" />
                </div>

                <div className="form-group">
                    <button type="submit" onClick={this.LoginAction}  className="loginBtn input btn btn-default">登录</button>
                </div>
            </form>
        </div>)
    }
})

var LaoliLoginBody = React.createClass({

    render:function(){
        return (<div className="content">
             <LaoliLoginAlter />
        </div>)
    }
})

ReactDOM.render(<LaoliLoginBody />,

   document.getElementById("root")

)
