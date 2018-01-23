var projectlist= React.createClass({
    render: function() {
        return (
            <div className="container">
                <table>
                    <td>
                        <th>项目名称</th>
                        <th>创建人</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                    </td>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        )
    }
})
ReactDOM.render(
    <projectlist/>,
    document.getElementById('example')
);