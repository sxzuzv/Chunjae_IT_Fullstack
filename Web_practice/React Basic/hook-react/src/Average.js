import React, {useMemo, useState} from 'react';

// 입력 값의 평균을 구하는 함수 (입력 값을 담은 list를 매개변수로 받는다.)
const getAverage = (numbers) => {
    console.log("평균을 구할게요!");

    // 입력 값이 없을 때 평균은 0
    if (numbers.length === 0) return 0;

    // reduce() : 배열에 있는 두 개의 값을 가지고 와서 합친 뒤, 자기 자신의 a에 넣는다.
    // 다음으로 a와 c를 가지고 와서 합치고, ...
    // 즉, list에 있는 값들을 모두 더하는 작업을 하게 된다.
    const sum = numbers.reduce((a, b) => a + b);

    // '입력 값의 총합 / 입력 값의 개수'를 계산해 반환한다.
    return sum / numbers.length;
}

const Average = () => {
    const [list, setList] = useState([]);

    // <input>을 통해 number의 값을 받으므로, 문자열로 받게 된다.
    // 그러므로 number의 초기값은 문자 '' 형태로 지정한다.
    const [number, setNumber] = useState('');

    // 등록 버튼을 누를 시, 실행 된다.
    const onClick = () => {
        // 반드시 신규 값으로 넣어줘야 수정 사항이 반영된다. => concat 사용
        // number의 타입이 문자형이므로 정수형으로 parse 해준다.
        // parse 된 값들을 list에 저장한다.
        setList(list.concat(parseInt(number)));
        
        // 입력 값을 초기화한다.
        setNumber('');
    };

    // 필요할 때만 평균을 계산하여 출력할 수 있도록 useMemo()를 적용한다.
    // '등록' 버튼을 누를 때만 평균을 계산한다.
    const avg = useMemo(() => getAverage(list), [list]);

    return (
        <div>
            {/* value 값을 지정해줘야 하는 이유는? */}
            {/* number는 state로 관리 중인 값이고, onClick 메서드의 행위를 하려면 number로 연결이 돼있어야 한다. */}
            <input name='number' value={number} onChange={(e) => setNumber(e.target.value)}/>
            <button onClick={onClick}>등록</button> number : {number} <br />
            <ul>
                {/* <input>으로 받을 출력한다. */}
                {list.map((value, index) => <li key={index}>{value}</li>)}
            </ul>
            {/* 평균 : {getAverage(list)} */}
            평균 : {avg}
        </div>
    );
};

export default Average;