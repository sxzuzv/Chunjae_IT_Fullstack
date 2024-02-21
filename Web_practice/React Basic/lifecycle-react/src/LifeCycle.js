import React, { Component } from 'react';

class LifeCycle extends Component {
    state = {
        color:this.props.color
    }
    render() {
        console.log('render');
        return (
            <div>
                 {/* props로 넘어온 값들로 구성한다. */}
                <h1 style={{color:this.props.color}}>
                    props : {this.props.color} <br />
                    state : {this.state.color}
                </h1>
            </div>
        );
    }
}

export default LifeCycle;