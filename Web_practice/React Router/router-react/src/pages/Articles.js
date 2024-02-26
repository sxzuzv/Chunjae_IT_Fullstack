import React from 'react';
import { Link, Outlet } from 'react-router-dom';

const Articles = () => {
    return (
        <div>
            {/* Outlet = 중첩된 Article.js의 내용이 함께 출력된다. */}
            <Outlet />
            <Link to='/articles/1'>게시글 01</Link> |
            <Link to='/articles/2'>게시글 02</Link> |
            <Link to='/articles/3'>게시글 03</Link>
        </div>
    );
};

export default Articles;