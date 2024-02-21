import React, { Component } from 'react';

class LifeCycle extends Component {
    state = {
        // color:this.props.color

        // color 값을 초기화한다.
        color:null
    }

    constructor(props) {
        super(props);
        console.log('constructor');
    }

    componentDidMount() {
        console.log('componentDidMount');
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        // 현재 들어오는 props 값과 이전의 state 값을 매개변수로 전달받는다.
        // console.log(nextProps, prevState);

        if (nextProps.color !== prevState.color) {
            // 이전 컬러와 현재 컬러가 다르다면 현재 들어온 props의 color 값을 세팅한다.
            return {color:nextProps.color}
        }

        return null;    // 컬러가 동일하다면 null을 반환한다.
    }

    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('getSnapshotBeforeUpdate', prevProps, prevState);  // 이전 color의 'red', state의 'red'가 출력된다.

        // 이전 props의 color와 현재 props의 color가 같지 않으면 이전 props의 color를 반환한다.
        if (prevProps.color !== this.props.color) {
            return prevProps.color;
        }

        return null;
    }

    // getSnapshotBeforeUpdate에서 반환된 값이 snapshot으로 전달된다.
    componentDidCatch(prevProps, prevState, snapshot) {
        console.log('componentDidCatch', prevProps, prevState, snapshot);

        // 이전, 현재 props의 color가 다를 경우 이전 props의 color가 snapshot으로 전달된다.
        if (snapshot) {
            console.log("업데이터 직전 색상은? : ", snapshot);
        }
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log('shouldComponentUpdate', nextProps, nextState);
        
        return nextProps === 'green' ? false : true;
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