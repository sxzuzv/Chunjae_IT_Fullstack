import React, { Component } from 'react';

class LifeCycle extends Component {
    state = {
        // color:this.props.color

        // color 값을 초기화한다.
        color:null
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        // 현재 들어오는 props 값과 이전의 state 값을 매개변수로 전달받는다.
        // console.log(nextProps, prevState);

        if (nextProps.color != prevState.color) {
            // 이전 컬러와 현재 컬러가 다르다면 현재 들어온 props의 color 값을 세팅한다.
            return {color:nextProps.color}
        }

        return null;    // 컬러가 동일하다면 null을 반환한다.
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