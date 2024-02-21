import React, { Component } from 'react';

class MoveBox extends Component {
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
            left:'10px',
            position:'absolute'
        }
        return (
            <div style={style}>
                <div style={innerstyle}>

                </div>
            </div>
        );
    }
}

export default MoveBox;