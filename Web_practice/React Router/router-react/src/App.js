import React from'react';
import{Route,Routes}from'react-router-dom';
import About from'./pages/About';
import Home from'./pages/Home';
import Profile from './pages/Profile';

const App=()=>{
  return(
    <Routes>
      {/* URL을 받아오면 에러가 발생한다. SPA는 URL이 바뀌면 안 된다 !!
      현재 상태는 React 내부적으로 어디로 가야할지를 판단하고 페이지를 띄워준 것이다. */}
      {/* 주소로 한 번 접속하면 HTML 내려 받고, 이후에는 또 내려 받지 않는다. => SPA의 기본 개념 */}
      <Route path='/' element={<Home/>}/>
      <Route path='/about' element={<About/>}/>

      {/* 파라미터를 ':파라미터명' 형태로 넣어준다. */}
      <Route path='/profiles/:id' element={<Profile />} />
    </Routes>
  );
};

export default App;