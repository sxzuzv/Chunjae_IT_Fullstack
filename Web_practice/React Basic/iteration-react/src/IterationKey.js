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

    // 초기값으로 4를 세팅한다.
    const [nextId, setNextId] = useState(names.length+1);

    const onClick = () => {
        // push는 그대로 붙이는 거라서 신규 데이터 반영이 되지 않는다.
        // concat을 사용하여 새로운 배열을 생성하고, 신규 데이터 반영이 될 수 있도록 만든다.
        setNames(names.concat({id:nextId, text:'Vue.js'}));
        // 이미 사용한 nextId는 +1 처리한다.
        setNextId(nextId+1);
    };

    // 배열 속 값(오브젝트 형태)들이 하나씩 name에 들어온다.
    // key는 들어온 name의 id, 출력 값은 name의 text로 지정한다.
    const nameList = names.map((name) => <li key={name.id}>{name.text}</li>);

    return (
        <div>
            <button onClick={onClick}>추가</button>
            <ul>{ nameList }</ul>
        </div>
    );
};

export default IterationKey;