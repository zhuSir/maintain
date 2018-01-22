
var BgDiv = React.createClass({
    render: function() {
        return (
            <div className="bg test row">
                <table className="table table-hover">
                    <caption>悬停表格布局</caption>
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>手机号</th>
                        <th>职位</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>张也</td>
                        <td>15738039217</td>
                        <td>喂饱</td>
                    </tr>
                    <tr>
                        <td>啊哈哈</td>
                        <td>15738039217</td>
                        <td>保障</td>
                    </tr>
                    </tbody>

                </table>
            </div>
        )
    }
});

ReactDOM.render(
    <BgDiv />,
    document.getElementById('userList')
);
