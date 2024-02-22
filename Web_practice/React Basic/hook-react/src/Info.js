import React, {useEffect, useState} from 'react';

const Info = () => {
    // useState로 초기값을 설정한다.
    const [name, setName] = useState('');

    // state 변경 시, useEffect가 실행된다.
    useEffect(() => {
        console.log("렌더링 완료");
        console.log({name});
    },
    []);    // [] 추가 이후 : Mount 될 때만 useEffect가 실행된다.

    return (
        <div>
            {/* 타이핑으로 인해 값의 변화가 생겼을 때 이벤트를 수행한다. */}
            {/* input에 대한 오브젝트 정보가 e에 포함돼 있다. */}
            input : <input type='text' onChange={(e) => setName(e.target.value)} /><br />
            name : {name}
        </div>
    );
};

export default Info;