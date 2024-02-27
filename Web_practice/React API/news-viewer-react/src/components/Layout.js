import React from 'react';
import Header from './Header';
import Footer from './Footer';
import Home from './Home';
import { Outlet } from '../../node_modules/react-router-dom/dist/index';

const Layout = () => {
    // 세부 내용은 컴포넌트로 나눴고, 각 컴포넌트와 함께 전체 레이아웃을 잡아준다.
    return (
        <>
            <Header />
            <div className="container">
                <main role="main">
                    {/* Route 컴포넌트 설정에 따라 콘텐츠가 출력된다. */}
                    <Outlet />
                </main>
                <Footer />
            </div>
        </>
    );
};

export default Layout;