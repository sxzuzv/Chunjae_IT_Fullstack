import React from 'react';
import Header from './Header';
import Footer from './Footer';
import Home from './Home';

const Layout = () => {
    // 세부 내용은 컴포넌트로 나눴고, 각 컴포넌트와 함께 전체 레이아웃을 잡아준다.
    return (
        <>
            <Header />
            <div className="container">
                <main role="main">
                    <Home />
                </main>
                <Footer />
            </div>
        </>
    );
};

export default Layout;