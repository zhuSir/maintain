var Companys=React.createClass({
    render:function(){
        return(
            <div>
                <div className="container">
                    <form>
                        <div className="form-group">
                            <label >公司名称:</label>
                            <input  className="form-control" id="comp"/>
                        </div>
                        <div className="form-group">
                            <label for="pwd">联系人</label>
                            <input type="text" className="form-control" id="person"/>
                        </div>
                        <div classname="form-group">
                            <label for="telephone">联系电话</label>
                            <input type="telephone" className="form-control" id="phone"/>
                        </div>
                        <button type="submit" className="btn btn-primary">提交</button>
                    </form>
                </div>
            </div>
        )
    }
});

ReactDOM.render(
    <Companys />,
    document.getElementById('company')
);