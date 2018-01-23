var FaultModel = React.createClass({
    render:function () {
        return (
            <div className="modal fade" id="faultModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div className="modal-dialog">
                <div className="modal-content">
                <div className="modal-header">
                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">
                &times;
            </button>
            <h4 className="modal-title" id="myModalLabel">
                模态框（Modal）标题
            </h4>
            </div>
            <div className="modal-body">
                在这里添加一些文本
                </div>
                <div c                     lass="modal-footer">
                <button type="button" className="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" className="btn btn-primary">
                提交更改
                </button>
                </div>
                </div>
            </div>
            </div>
        );
    }
})