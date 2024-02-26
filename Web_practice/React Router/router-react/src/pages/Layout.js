import React from 'react';
import { Outlet, useNavigate } from 'react-router-dom';

const Layout = () => {
    const navigate = useNavigate();
    const goBack = () => {
        navigate(-1); // 뒤로가기
    }
    const goArticles = () => {
        navigate('/articles', {replace:true});
    };

    return (
        <div>
            <header style={{background:'lightgray',padding:16,fontSize:24}}>
            header
                <button onClick={goBack}>뒤로가기</button>
                <button onClick={goArticles}>게시글 목록 바로가기</button>
            </header>
            <main>
                {/* 중첩 라우트 설정된 내용이 출력된다. */}
                {/* 중첩 라우트 설정 => 나의 path 아래로 다른 path가 들어와 있어야 한다. */}
                <Outlet />
            </main>
        </div>
    );
};

export default Layout;