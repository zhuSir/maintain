$(function(){
    $('#iframepage').load(function(){
        var ch=$('#iframepage').contents().find('body.document').height();
        console.log(ch);
        $('#iframepage').height(ch+200);
    })
})
function page(o) {
    var i = Number(o);
    $('window.iframe').css('margin-top','0');
    switch(i) {
        //用户列表
        case 1:
            window.iframepage.location = "../user/html/login.html";
            break;
        //工作面板——初始页
        case 2:
            window.iframepage.location = "../user/html/register.html";
            break;
        //报修管理——我的报修单
        case 3:
            window.iframepage.location = "";
            break;
        //报修管理——我的签到
        case 4:
            window.iframepage.location = "";
            break;
        //我的消息——企业消息
        case 5:
            window.iframepage.location = "";
            break;
        //我的消息-项目消息
        case 6:
            window.iframepage.location = "";
            break;
        //我的消息-故障消息
        case 7:
            window.iframepage.location = "";
            break;
        //我的项目——项目管理
        case 8:
            window.iframepage.location = "";
            break;
        //我的团队——团队信息
        case 9:
            window.iframepage.location = "";
            break;
        //	设备管理-设备列表
        case 10:
            window.iframepage.location = "";
            break;
        //	设备管理-设备类别
        case 11:
            window.iframepage.location = "";
            break;
        //	个人中心-编辑
        case 12:
            window.iframepage.location = "";
            break;
        //个人中心-安全中心
        case 13:
            window.iframepage.location = "";
            break;
        //报表汇总-报修概要
    }
}