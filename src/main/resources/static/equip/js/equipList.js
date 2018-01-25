
var tableTitleList = [{text: "设备名称"}, {text: "型号"}, {text: "编号"}, {text: "厂家"}, {text: "投入时间"}, {text: "保修时间"}, {text: "使用地点"}, {text: "设备类别"}];


var Table=React.createClass({
    //初始化 相当于构造函数
    addEquip:function (event) {
        layer.open({
            type: 2,
            area: ['680px', '90%'],
            content:"equipDetail.html"
        })
    },
    render: function () {
        return(
            <div className="panel panel-success">
                <div className="panel-heading">
                    <h3 className="panel-title">设备列表</h3>
                </div>
                <div className="panel-body">
                    <button type="button" className="btn btn-success" onClick={this.addEquip}>添加设备
                    </button>
                    <DataTable tableTitleList={tableTitleList} dataTableId="table_id_example"/>
                </div>
            </div>
        );
    }
});

ReactDOM.render(
    <Table />,
    document.getElementById('body')
);

$(document).ready(function () {
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
        ajax: function (data, callback, settings) {
            //封装请求参数
            var param = {};
            param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.start = data.start;//开始的记录序号
            param.page = (data.start / data.length) + 1;//当前页码
            var postData = JSON.stringify({
                "funcName": "getEquipList",                       //controller 中的方法名
                "serviceName": "equipController",           //controller 注解名称
                "serialNumber": guid(),                    //请求流水
                "userAccount": "122222222",                    //用户账户
                "reqSysCode": "A02",                       //请求生成端 A01-web ,A02-app, A03-微信
                "reqTime": new Date().Format("yyyy-MM-dd hh:mm:ss.S"),                      //请求时间
                "data": param,
                "security": {                                //安全层
                    //访问令牌，如果没有这个需要先访问authController中的login来获取
                    "accessTocken": ""
                }
            })
            //ajax请求数据
            $.ajax({
                type: "post",
                url: "/common",
                cache: false, //禁用缓存
                contentType: "application/json; charset=utf-8",
                data: postData, //传入组装的参数
                dataType: "json",
                success: function (result) {
                    var returnData = {};
                    var rtData = result.data;
                    returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                    returnData.recordsTotal = result.recordsTotal;//返回数据全部记录
                    returnData.recordsFiltered = result.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
                    returnData.data = rtData;//返回的数据列表
                    callback(returnData);
                }
            });
        },
        columns: [
            {data: 'equipName'},
            {data: 'equipModel'},
            {data: 'equipCode'},
            {data: 'equipFirm'},
            {data: 'putUseTime'},
            {data: 'guaranteePeriod'},
            {data: 'province'},
            {data: 'equipTypeId'}
        ]
    });
});