import React from 'react';

const Iteration = () => {
    const names = ['javascript', 'jQuery', 'React'];
    // names를 태그로 변환한다. => .map을 사용한다.
    // names 요소를 하나씩 꺼내서 name(파라미터)에 넣고 함수를 실행한다.
    // names(배열)의 요소를 태그 형태로 변환한다. => 배열 속 값이 단순 문자열에서 태그 형태로 변환된다.

    // index : javascript는 0, jQuery는 1, React는 2
    // 각 태그에 대하여 key 값을 넣어준다.
    const nameList = names.map((name, index) => <li key={index}>{name}</li>);
    // ['<li>javascript</li>', '<li>jQuery</li>', '<li>React</li>']
    return (
        <ul>
            {nameList}
        </ul>
    );
};

export default Iteration;