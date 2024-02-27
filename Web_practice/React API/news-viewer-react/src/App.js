import React from 'react';
import Layout from './components/Layout';
import { Route, Routes } from '../node_modules/react-router-dom/dist/index';
import Home from './components/Home';
import News from './components/News';
import NotFound from './components/NotFound';

const App = () => {
  return (
    <Routes>
      <Route element={<Layout />}>
        {/* 하위에 들어오는 경로는 Layout에 지정된 대로 출력한다. */}
        <Route path='/' element={<Home />} />
        <Route path='/news' element={<News />} />
        <Route path='*' element={<NotFound />} />
      </Route>
    </Routes>
  );
};

export default App;