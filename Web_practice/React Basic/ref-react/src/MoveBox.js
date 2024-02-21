import React, { Component } from 'react';

class MoveBox extends Component {
    // this.box의 left, top 위치를 바꾸는 함수를 작성한다.
    move = (x, y) => {
        this.box.style.left = x+'px';
        this.box.style.top = y+'px';
    }
    render() {
        const style = {
            border:'1px solid black',
            height:'300px',
            width:'300px',
            position:'relative'
        }
        const innerstyle = {
            height:'100px',
            width:'100px',
            backgroundColor:'red',
            // 부모 요소의 왼쪽 모서리 기준으로 위치를 이동한다.
            // left:'100px',
            // top:'100px',
            position:'absolute'
        }
        return (
            // <div style={style}>
            //     <div style={innerstyle} ref={(ref) => {this.box = ref}} />
            // </div>

            <>
                <div style={style}>
                    <div style={innerstyle} ref={(ref) => {this.box = ref}} />
                    <button onClick={() => {this.move(100, 100)}}>MOVE01</button>
                </div>
            </>
        );
    }
}

export default MoveBox;