import React, { useState } from 'react';
import axios from '../node_modules/axios/index';

const App = () => {
  const [data, setData] = useState(null);
  const onClick = async () => {
    // axios : 응답이 오면 알려준다.
    // axios.get('https://jsonplaceholder.typicode.com/todos/1').then(response => {setData(response)});

    // async, News Api 적용
    const response=await axios.get('https://newsapi.org/v2/top-headlines?country=kr&apiKey=e3aabbbc9e0148af8f9574ddc1ba0467');
    setData(response);
  };

  return (
    <div>
      <button onClick={onClick}>불러오기</button>
      {/* {data}로 출력하려고 하면 오류가 발생한다. Object type은 display 불가하므로 문자로 변환이 필요하다. */}
      <div>
        {data && <textarea value = {JSON.stringify(data, null, 2)} />}
      </div>
    </div>
  );
};

export default App;