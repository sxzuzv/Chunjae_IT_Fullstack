import React, { useState } from 'react';

const IterationKey = () => {
    // 배열 내에 오브젝트 형태로 값을 설정한다.
    //State를 만들면 저장될 이름과 값을 변경할 수 있는 함수를 지정해야 한다. (names, setNames)
    const [names, setNames] = useState(
        [
            {id: 1, text: 'javascript'},
            {id: 2, text: 'jQuery'},
            {id: 3, text: 'React'}
        ]
    );

    // 배열 속 값(오브젝트 형태)들이 하나씩 name에 들어온다.
    // key는 들어온 name의 id, 출력 값은 name의 text로 지정한다.
    const nameList = names.map((name) => <li key={name.id}>{name.text}</li>);

    return (
        <div>
            <ul>{ nameList }</ul>
        </div>
    );
};

export default IterationKey;