import React, { Component } from 'react';

class Event extends Component {
    state = {
        message: ''
    }

    render() {
        return (
            <div>
                <h1>이벤트</h1>
                <input type='text' name='message' placeholder='텍스트를 입력하세요.' 
                // 텍스트 입력 시 발생될 이벤트를 작성한다. 이벤트 발생 시, 함수가 실행된다.
                onChange={
                    (e) => {
                        // 넘겨 받는 파라미터의 target에 접근해 name, value 값을 출력한다.
                        // console.log(e.target.name, e.target.value);

                        // setState를 활용하여 입력되는 값을 message에 넣는다.
                        this.setState({message : e.target.value})
                    }
                }
                /> <br />

                {/* 현재 렌더링 영역 내부에 있음에 유의한다. => state만 데이터 수정이 가능하다. */}
                {/* state에 정의된 message를 이용하여 신규 데이터로 만들 수 있도록 한다. */}
                message : {this.state.message}
            </div>
        );
    }
}

export default Event;