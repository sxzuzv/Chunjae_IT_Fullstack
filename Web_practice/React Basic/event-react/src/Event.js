import React, { Component } from 'react';

class Event extends Component {
    state = {
        message: '',
        username: ''
    }

    handleChangeUsername = (e) => {
        this.setState({username: e.target.value})
    }

    handleChangeMessage = (e) => {
        this.setState({message: e.target.value})
    }

    render() {
        return (
            <div>
                <h1>이벤트</h1>
                <input type='text' name='message' placeholder='텍스트를 입력하세요.' 
                // 텍스트 입력 시 발생될 이벤트를 작성한다. 이벤트 발생 시, 함수가 실행된다.
                    onChange={this.handleChangeMessage} />
                <br />

                <input type='text' name='username' placeholder='이름을 입력하세요.' 
                // 텍스트 입력 시 발생될 이벤트를 작성한다. 이벤트 발생 시, 함수가 실행된다.
                    onChange={this.handleChangeUsername} />
                <br />


                {/* 현재 렌더링 영역 내부에 있음에 유의한다. => state만 데이터 수정이 가능하다. */}
                message : {this.state.message}
                <br />
                username : {this.state.username}
            </div>
        );
    }
}

export default Event;