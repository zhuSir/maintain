/**
 * Created by welleast on 2018/1/23.
 */

var BgDiv = React.createClass({
    render: function() {
        return (
            <div className="bg test row leftAndRight15 top15">

                <table className="table table-striped top15">
                    <thead>
                    <tr>
                        <th>部门</th>
                          <th>权限</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>技术研发部</td>
                        <td>
                            <EditBtn/>

                        </td>
                    </tr>
                    <tr>
                        <td>市场部</td>
                        <td>
                            <EditBtn/>

                        </td>
                    </tr>
                    <tr>
                        <td>运维部</td>
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
                <div className="form-check">
                     <input className="form-check-input" type="checkbox" value="" id="defaultCheck1"></input>
                     <label className="form-check-label" for="defaultCheck1">
                    允许报账
                     </label>
                 </div>
                <div className="form-check">
                    <input className="form-check-input" type="checkbox" value="" id="defaultCheck2"></input>
                    <label className="form-check-label" for="defaultCheck1">
                        允许修改
                    </label>
                </div>
                <div className="form-check">
                    <input className="form-check-input" type="checkbox" value="" id="defaultCheck3"></input>
                    <label className="form-check-label" for="defaultCheck1">
                        只能查看
                    </label>
                </div>
                <div className="form-check">
                    <input className="form-check-input" type="checkbox" value="" id="defaultCheck1"></input>
                    <label className="form-check-label" for="defaultCheck1">
                        禁止查看报修单
                    </label>
                </div>
            </div>

        )
    }
});
ReactDOM.render(
    <BgDiv />,
    document.getElementById('Permission')
);
