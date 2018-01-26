



var ContentUI=React.createClass({

    getInitialState: function() {
        return {
            companyInfo :{}
        };
    },
    componentDidMount: function() {
        this.serverRequest = $.post("/user/getCompanyInfo",{companyID:Cookies.get("companyId")}, function (result) {
            this.setState({
                companyInfo : result
            });
        }.bind(this));

        if (Cookies.get("companyId")>0)
        {
            $("#creatCompany").hide();
        }
        if (cookies.get("companyId")==null ||cookies.get("companyId")==0)
        {
            $("#companyInfo").hide();
        }

    },

    render:function(){
        return(
            <div classNmae="row">
                <div className="col-sm-12 titleHeight">
                    <h2 className="text-center titleHeight">{this.state.companyInfo.groupName}</h2>
                </div>
                <div className="col-sm-12">
                </div>
                <div className="col-sm-12">
                    <button className="btn btn-default" id="creatCompany" data-toggle="modal" data-target="#creatCompanyModalgroup">创建公司</button>
                    <div className="modal fade" id="creatCompanyModalgroup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                         aria-hidden="true">
                        <div className="modal-dialog">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <button type="button" className="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 className="modal-title" id="myModalLabel">
                                        创建公司
                                    </h4>
                                </div>
                                <div className="modal-body">
                                    <input type="text" className="form-control" placeholder="公司名称" id="companypName"></input>

                                </div>
                                <div className="modal-footer">
                                    <button type="button" className="btn btn-default" data-dismiss="modal">关闭
                                    </button>
                                    <CommitBtnGroup/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <ul className="list-group top15" id="companyInfo">
                        <li className="list-group-item">公司名称:{this.state.companyInfo.groupName}</li>
                        <li className="list-group-item">公司创建人:{this.state.companyInfo.createName}</li>
                        <li className="list-group-item">公司信息</li>
                    </ul>
                </div>


            </div>
        )
    }
});

var CommitBtnGroup = React.createClass({

    commit:function(){
        $('#creatCompanyModalgroup').modal('hide')

        var name= $("#companypName").val();
        if(name.length==0)
        {
            alert("请输入名字");
            return;
        }
        //String groupname,String companyID,String reatUserName,String reatUserID
        var  data={
            companyName:name,
            reatUserName:Cookies.get("userName"),
            reatUserID:Cookies.get("userId")
        }

        $.ajax({
            type: "POST",
            url: "/user/creatcompany",
            data: data,
            success: function(data){

                alert(data.companyID);
                Cookies.set('companyId', data.companyID, {expires: 7, path: '/'});

            },
            error:function(err){
                alert("error");
            }
        });


    },
    render:function(){
        return <p onClick={this.commit}  className="btn btn-primary" id="commit">
            创建
        </p>
    }
})
ReactDOM.render(

    <ContentUI />,
    document.getElementById('mycompany')
);
