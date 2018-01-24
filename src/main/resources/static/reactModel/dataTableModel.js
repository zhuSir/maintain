/**
 * Created by BinYiChen on 2018/1/24.
 */
/**
 * dataTable表头控件
 * @type {*}
 */
var TitleDatatable = React.createClass({
    render: function () {
        var nodes = this.props.tableTitleList.map(function (item) {
            return (<th>
                {item.text}
            </th>);
        });
        return (
            <thead>
            <tr>
                {nodes}
            </tr>
            </thead>
        );
    }
});

var DataTable = React.createClass({
    //初始化 相当于构造函数
    getInitialState: function () {
        return {
            tableTitleList: this.props.tableTitleList,
            dataTableId: this.props.dataTableId
        };
    },
    render: function () {
        return (
            <table id={this.state.dataTableId} className="display">
                <TitleDatatable tableTitleList={this.state.tableTitleList}/>
                <tbody>
                </tbody>
            </table>
        );
    }
});