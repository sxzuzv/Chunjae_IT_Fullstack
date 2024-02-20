import React, { Component } from 'react';

class Event extends Component {
    render() {
        return (
            <div>
                <h1>이벤트</h1>
                <input type='text' name='message' placeholder='텍스트를 입력하세요.' 
                // 텍스트 입력 시 발생될 이벤트를 작성한다. 이벤트 발생 시, 함수가 실행된다.
                onChange={
                    (e) => {
                        // 넘겨 받는 파라미터의 target에 접근해 name, value 값을 출력한다.
                        console.log(e.target.name, e.target.value);
                    }
                }
                />
            </div>
        );
    }
}

export default Event;