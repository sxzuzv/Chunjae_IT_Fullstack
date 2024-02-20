// 함수형 컴포넌트는 state를 제공하지 않는다.
import React, { useState } from 'react';

const EventFunction = () => {
    // setMessage 함수를 통해 들어오는 값은 message에 자동으로 처리된다.
    const [message, setMessage] = useState('')

    const handleChange = (e) => {
        setMessage(e.target.value)
    }

    return (
        <div>
            <h1>이벤트</h1>
            <input type='text' name='message' placeholder='텍스트를 입력하세요.' 
            // 텍스트 입력 시 발생될 이벤트를 작성한다. 이벤트 발생 시, 함수가 실행된다.
                onChange={handleChange}
            /> <br />
            message : {message}
        </div>
    );
};

export default EventFunction;