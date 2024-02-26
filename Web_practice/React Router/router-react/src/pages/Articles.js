import React from 'react';
import { NavLink, Link, Outlet } from 'react-router-dom';

const Articles = () => {
    const activeStyle = {color:'green', fontSize:21};

    return (
        <div>
            {/* Outlet = 중첩된 Article.js의 내용이 함께 출력된다. */}
            <Outlet />
            {/* <Link to='/articles/1'>게시글 01</Link> |
            <Link to='/articles/2'>게시글 02</Link> |
            <Link to='/articles/3'>게시글 03</Link> */}

            {/* 페이지 진입 상황에 따라 지정된 style을 적용한다. */}
            <NavLink to='/articles/1' style={({isActive}) => (isActive ? activeStyle : undefined)}>게시글 01</NavLink> |
            <NavLink to='/articles/2' style={({isActive}) => (isActive ? activeStyle : undefined)}>게시글 02</NavLink> |
            <NavLink to='/articles/3' style={({isActive}) => (isActive ? activeStyle : undefined)}>게시글 03</NavLink>
        </div>
    );
};

export default Articles;