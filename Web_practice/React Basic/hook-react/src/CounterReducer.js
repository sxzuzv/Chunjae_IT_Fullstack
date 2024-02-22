import React, { useReducer } from 'react';

// action type : object
function reducer(state, action) {
    switch(action.type) {
        case 'INC' :
            // state에서 count를 관리하며 state의 count 값을 증가시킨다.
            return {count:state.count + 1};
        case 'DEC' :
            return {count:state.count - 1};
        // switch-case문은 default가 반드시 존재해야 한다.
        default :
            return state;
    }
}

const CounterReducer = () => {
    // 값 확인은 state로, 값 수정은 dispatch를 활용해서 원하는 액션을 지정한다.
    // state에서 count를 관리하며, 초기값은 0으로 지정한다.
    const [state, dispatch] = useReducer(reducer, {count:0});

    return (
        <div>
            <p>count : {state.count}</p>
            {/* dispatch를 호출하여 type을 지정한다. */}
            <button onClick={() => dispatch({type:'INC'})}>+1</button>
            <button onClick={() => dispatch({type:'DEC'})}>-1</button>
        </div>
    );
};

export default CounterReducer;