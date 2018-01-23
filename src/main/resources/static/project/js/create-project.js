/*var HelloMessage = React.createClass({
    render: function() {
        return <h1>Hello {this.props.name}</h1>;
    }
});

ReactDOM.render(
<HelloMessage name="Runoob" />,
    document.getElementById('example')
);*/

var project = React.createClass({
    render: function() {
        return(
            <div className="container">
                <div className="btn-group btn-group-justified" role="group" aria-label="...">
                    <div className="btn-group" role="group">
                        <button type="button" className="btn btn-default">Left</button>
                    </div>
                    <div className="btn-group" role="group">
                        <button type="button" className="btn btn-default">Middle</button>
                    </div>
                    <div className="btn-group" role="group">
                        <button type="button" className="btn btn-default">Right</button>
                    </div>
                </div>
            </div>
        )
    }
});
ReactDOM.render(
<project />,
    document.getElementById('example')
);

