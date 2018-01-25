

var BgDiv = React.createClass({
    render: function() {
        return (
            <div className="bg test row leftAndRight15 top15 leftW">
                <div className="col-xs-12 ">


                </div>
                <table className="table table-striped top15 leftAndRight15">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>手机号</th>
                        <th>职位</th>
                        <th>部门</th>
                        <th>编辑</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>张也</td>
                        <td>15738039217</td>
                        <td>喂饱</td>
                        <td>研发部</td>
                        <td>
                            <EditBtn/>
                        </td>
                    </tr>
                    <tr>
                        <td>啊哈哈</td>
                        <td>15738039217</td>
                        <td>保障</td>
                        <td>技术部</td>
                        <td>
                            <EditBtn/>
                        </td>
                    </tr>
                    <tr>
                        <td>啊哈哈</td>
                        <td>15738039217</td>
                        <td>保障</td>
                        <td>技术部</td>
                        <td>
                            <EditBtn/>
                        </td>
                    </tr>
                    <tr>
                        <td>啊哈哈</td>
                        <td>15738039217</td>
                        <td>保障</td>
                        <td>技术部</td>
                        <td>
                            <EditBtn/>
                        </td>
                    </tr>
                    </tbody>

                </table>
            </div>
        )
    }
});
var EditBtn = React.createClass({
    render: function() {
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
