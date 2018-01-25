//弹窗
var ModelPush = React.createClass({
    render: function () {
        return (
            <div>
                <button className="btn btn-default top15" data-toggle="modal" data-target="#myModal1">
                    邀请成员
                </button>
                <div className="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 className="modal-title" id="myModalLabel">
                                    邀请成员
                                </h4>
                            </div>
                            <div className="modal-body">
                                <input type="text" className="form-control" placeholder="手机号" id="groupName"></input>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default" data-dismiss="modal">关闭
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
});

var CommitBtn = React.createClass({
    commit: function () {
        $('#myModal1').modal('hide')
    },
    render: function () {
        return <p onClick={this.commit} className="btn btn-primary" id="commitYaoqing">
            邀请
        </p>
    }
});

var BgDiv = React.createClass({

    render: function () {
        return (
            <div className="bg test leftAndRight15 top15">
                <div className="col-xs-12">
                    <ModelPush/>
                </div>
                <div className="panel-body">
                    <table id="table_id_example" className="display">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>部门</th>
                            <th>编辑</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
});

var EditBtn = React.createClass({
    render: function () {
        return (
            <div>
                <button className="btn btn-info">移除</button>
            </div>
        )
    }
});

ReactDOM.render(
    <BgDiv />,
    document.getElementById('userList')
);


$(document).ready(function () {
    var companyId = Cookies.get("companyId");
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
            "sEmptyTable": "暂无成员",
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
        ajax: {
            url: config.listCompanyMember,
            type: "POST",
            data: {
                companyID: companyId
            },
            dataSrc: ''
        },

        columnDefs: [{
            targets: 3,
            render: function (data, type, row) {
                console.log(row);
                // var id = "'" + row[0] + "'";
                // var odd = "'" + row[1] + "'";
                // var money = "'" + row[10] + "'";
                return '<a type="button"  class="btn btn-info" onclick=""> 移除 </a>';
            },
            "data": null
        },
        ],
        columns: [
            {data: 'create_name'},
            {data: 'mobilePhone'},
            {data: 'group_name'},
        ]
    });
});
