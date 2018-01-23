ReactDOM.render(
    <div className="panel panel-success">
        <div className="panel-heading">
            <h3 className="panel-title">报障单列表</h3>
        </div>
        <div className="panel-body">
            <table id="table_id_example" className="display">
            <button type="button" className="btn btn-success" data-toggle="modal" data-target="#faultModel">添加报障</button>
            <thead>
                <tr>
                    <th>报障单号</th>
                    <th>项目名称</th>
                    <th>紧急情况</th>
                    <th>设备名称</th>
                    <th>报障备注</th>
                    <th>创建时间</th>
                    <th>报障人名称</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
            </table>
        </div>
        <FaultModel/>
    </div>,
    document.getElementById('body')
);

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
            url:"/fault/list",
            dataSrc: ''
        },
        columns: [
            { data: 'faultCode' },
            { data: 'projectName' },
            { data: 'faultType' },
            { data: 'equipName' },
            { data: 'remarkReason' },
            { data: 'createtime' },
            { data: 'username' }
        ]
    });
});