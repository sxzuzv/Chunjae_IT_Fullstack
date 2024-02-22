import React, {useEffect, useState} from 'react';

const Info = () => {
    // useState로 초기값을 설정한다.
    const [name, setName] = useState('');

    // state 변경 시, useEffect가 실행된다.
    useEffect(() => {
        // console.log("렌더링 완료");
        // console.log({name});

        console.log('useEffect', {name});

        // useEffect 실행 시, 특정 함수의 결과값을 반환한다.
        // 현재 name의 값이 변화되고 있는지를 관찰하는 중인데,
        // return은 언마운트 전이나 업데이트 되기 직전에 실행된다. (추적 중인 값을 업데이트 되기 직전에 확인한다.)
        // 입력 값이 업데이트 되기 직전에 계속해서 'cleanup'이 찍힌다.
        return () => {
            console.log('cleanup', {name});
        };
    },
    [name]);    
    // [] 추가 이후 : Mount 될 때만 useEffect가 실행된다. 내부에 값을 포함하면 해당 값이 업데이트 될 때만 실행된다.

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