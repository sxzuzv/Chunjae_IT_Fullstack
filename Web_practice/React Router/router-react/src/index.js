import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// SPA는 본래 URL이 없음에 유의!
import { BrowserRouter } from 'react-router-dom'; 

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // App.js = 하나의 싱글 페이지
  // URL처럼 받아서 BrowserRouter가 제어해주는 역할을 하게 된다.
  <BrowserRouter>
    <App />
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
