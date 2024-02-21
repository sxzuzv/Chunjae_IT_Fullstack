// 함수형 컴포넌트는 state를 제공하지 않는다.
import React, { useState } from 'react';

const EventFunction = () => {
    // setMessage 함수를 통해 들어오는 값은 message에 자동으로 처리된다.
    
    // message, username의 데이터를 수정할 수 있도록 오브젝트 형태로 초기값을 설정한다.
    // const [message, setMessage] = useState('')
    const [form, setForm] = useState({message:'', username:''})
    // message, username 두 개의 state 값을 꺼내서 사용한다.
    // form에 담긴 값을 활용하여 message, username 값을 오브젝트로 세팅한다.
    const {message, username} = form;

    // 오브젝트 요소인 message, username이 setForm에 들어가므로 오브젝트 타입으로 변경한다.
    const handleChange = (e) => {
        // setForm(e.target.value)
        // 오브젝트 내에 있는 요소를 하나씩 모두 가져온다. (spread 연산자 사용)
        // e.target.value: e.target.value 와 같은 형태로 작성 불가하다.
        // '상수: 값' 과 같은 형태가 아니라면 []를 씌워줘야 한다.
        // 정확한 키가 구성돼 있다면 대괄호 없이 작성해도 괜찮다.
        // 하지만 e.target. .. 과 같은 방식은 키로 인식 불가하기 때문에 대괄호를 작성해줘야 한다.
        // obj["오브젝트 키"]와 같은 개념으로 이해한다.
        setForm({...form, [e.target.name]:e.target.value})
    }

    return (
        <div>
            <h1>이벤트</h1>
            <input type='text' name='message' placeholder='텍스트를 입력하세요.' 
            // 텍스트 입력 시 발생될 이벤트를 작성한다. 이벤트 발생 시, 함수가 실행된다.
                onChange={handleChange}
            /> <br />
            message : {message}
            <hr />
            <input type='text' name='username' placeholder='텍스트를 입력하세요.' 
            // 텍스트 입력 시 발생될 이벤트를 작성한다. 이벤트 발생 시, 함수가 실행된다.
                onChange={handleChange}
            /> <br />
            username : {username}
        </div>
    );
};

export default EventFunction;