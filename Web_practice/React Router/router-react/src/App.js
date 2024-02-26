import React from'react';
import{Route,Routes}from'react-router-dom';
import About from'./pages/About';
import Home from'./pages/Home';
import Profile from './pages/Profile';
import Articles from './pages/Articles';
import Article from './pages/Article';
import Layout from './pages/Layout';
import NotFound from './pages/NotFound';

const App=()=>{
  return(
    // <Routes>
    //   {/* URL을 받아오면 에러가 발생한다. SPA는 URL이 바뀌면 안 된다 !!
    //   현재 상태는 React 내부적으로 어디로 가야할지를 판단하고 페이지를 띄워준 것이다. */}
    //   {/* 주소로 한 번 접속하면 HTML 내려 받고, 이후에는 또 내려 받지 않는다. => SPA의 기본 개념 */}
    //   <Route path='/' element={<Home/>}/>
    //   <Route path='/about' element={<About/>}/>

    //   {/* 파라미터를 ':파라미터명' 형태로 넣어준다. */}
    //   <Route path='/profiles/:id' element={<Profile />} />

    //   {/* 라우팅 경로를 세팅해준다. */}
    //   {/* 중첩된 라우트를 설정한다. */}
    //   <Route path='/articles' element={<Articles />} >
    //   {/* <Route path='/articles/:id' element={<Article />} /> */}
    //     <Route path=':id' element={<Article />} />
    //   </Route>
    // </Routes>

    // ** 중첩된 라우트를 이용한 공통 레이아웃 구성 **
    // Layout 페이지 띄우고, Home일 경우 Layout의 Outlet에 내용을 출력한다.
    // SPA는 한 덩어리로 페이지가 구성돼 있고, 주로 콘텐츠가 변경된다.
    // Layout에 고정되는 부분을 만들고, 바뀌어야 될 부분만 변경하면
    // React가 Outlet에 print 되도록 해준다.
    <Routes>
      <Route element={<Layout />}>
        <Route path='/' element={<Home/>}/>
        <Route path='/about' element={<About/>}/>
        <Route path='/profiles/:id' element={<Profile />} />
      </Route>
      <Route path='/articles' element={<Articles />} >
        <Route path=':id' element={<Article />} />
      </Route>
      {/* 잘못된 접근에 대한 NotFound 페이지 */}
      <Route path="*" element={<NotFound />} />
    </Routes>
  );
};

export default App;