import React from 'react';
import { Outlet } from 'react-router-dom';

const Layout = () => {
    return (
        <div>
            <header style={{background:'lightgray',padding:16,fontSize:24}}>
            header
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