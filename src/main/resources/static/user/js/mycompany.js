


//创建公司的按钮
var ContentUI=React.createClass({

    getInitialState: function() {
        return {
            companyInfo :{}
        };
    },
    componentDidMount: function() {
        this.serverRequest = $.post("/user/getCompanyInfo",{companyID:"1"}, function (result) {
            this.setState({
                companyInfo : result
            });
        }.bind(this));
    },

    render:function(){
        return(
            <div classNmae="row">
                <div className="col-sm-12 titleHeight">
                    <h2 className="text-center titleHeight">公司啊</h2>
                </div>
                <div className="col-sm-12">

                </div>
                <div className="col-sm-12">
                    <ul className="list-group top15">
                        <li className="list-group-item">公司名称:{this.state.companyInfo.groupName}</li>
                        <li className="list-group-item">公司创建人:{this.state.companyInfo.createName}</li>
                        <li className="list-group-item">公司信息</li>
                    </ul>
                </div>
            </div>
        )
    }
});

ReactDOM.render(

    <ContentUI />,
    document.getElementById('mycompany')
);
