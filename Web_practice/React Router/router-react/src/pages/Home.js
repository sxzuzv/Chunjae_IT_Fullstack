import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div>
                <h1>HOME</h1>
                <p>가장 먼저 보이는 페이지입니다!</p>
                {/* Link 컴포넌트를 사용해 링크를 설정한다. */}
                {/* '소개' 클릭 시, 페이지가 전환되나 Request URL은 변경되지 않는다. */}
                <Link to="/about">소개</Link>

                <br />
                <Link to="/profiles/user2">user2 프로필</Link> | <Link to="/profiles/user1">user1 프로필</Link>
                
                <br />
                <Link to="/articles">게시글</Link>
            </div>
    );
};

export default Home;