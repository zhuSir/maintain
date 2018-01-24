ReactDOM.render(
    <div className="panel panel-success">
        <div className="panel-heading">
            <h3 className="panel-title">设备列表</h3>
        </div>
        <div className="panel-body">
            <table id="table_id_example" className="display">
            <thead>
                <tr>
                    <th>Column1</th>
                    <th>Column2</th>
                    <th>Column1</th>
                    <th>Column2</th>
                    <th>Column1</th>
                    <th>Column2</th>
                    <th>Column1</th>
                    <th>Column2</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Row1Data1</td>
                    <td>Row1Data2</td>
                    <td>Row1Data1</td>
                    <td>Row1Data2</td>
                    <td>Row1Data1</td>
                    <td>Row1Data2</td>
                    <td>Row1Data1</td>
                    <td>Row1Data2</td>
                </tr>
            </tbody>
            </table>
        </div>
    </div>,
    document.getElementById('body')
);

// var

var data = [
    [
        "Tiger Nixon",
        "System Architect",
        "Edinburgh",
        "5421",
        "2011/04/25",
        "$3,120",
        "2011/07/25",
        "$5,300"
    ],
    [
        "Garrett Winters",
        "Director",
        "Edinburgh",
        "8422",
        "2011/07/25",
        "$5,300",
        "2011/07/25",
        "$5,300"
    ]
];

data = [["1",1,1,1516740176000,"1","1",1,3]];

$(document).ready( function () {
    var table = $('#table_id_example').dataTable({
        "responsive": true,
        "lengthChange": false,
        "processing": true,
        "searching": true,
        "language": {
            "sProcessing": "处理中...",
            "sLengthMenu": "显示 _MENU_ 项结果",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            },
            "paginate": {
                "previous": '<i className="demo-psi-arrow-left"></i>',
                "next": '<i className="demo-psi-arrow-right"></i>'
            }
        },
        ajax : {
            url:"/common",
            type: "post",
            contentType : "application/json; charset=utf-8",
            data : JSON.stringify({
                "funcName" : "getEquipList",                       //controller 中的方法名
                "serviceName" : "equipController",           //controller 注解名称
                "serialNumber" : guid(),                    //请求流水
                "userAccount" : "122222222",                    //用户账户
                "reqSysCode" : "A02",                       //请求生成端 A01-web ,A02-app, A03-微信
                "reqTime" : new Date().Format("yyyy-MM-dd hh:mm:ss.S"),                      //请求时间
                "data" : {
                    //请求传递的消息报文主体，格式不做控制
                },
                "security":{                                //安全层
                    //访问令牌，如果没有这个需要先访问authController中的login来获取
                    "accessTocken" : "",
                    "smsCode":"",
                    "emailCode":"",
                    "deviceId":"",
                    "usbKey":"",
                    "imageCode":"",
                    "codeKey":""
                }
            })

        }
        // data : data
    });
});