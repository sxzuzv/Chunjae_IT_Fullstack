import React from 'react';
import {useLocation, useSearchParams} from 'react-router-dom';

const About = () => {
    const location = useLocation();

    const [searchParams, setSearchParams] = useSearchParams();
    const detail = searchParams.get('detail');
    const mode = searchParams.get('mode');

    return (
        <div>
            <h1>소개</h1>
            <p>리액트 라우터를 사용하는 프로젝트입니다.</p>

            {/* 전체 쿼리스트링을 출력한다. */}
            <p>쿼리스트링 : {location.search}</p>

            {/* 쿼리스트링 값들을 각각 출력한다. */}
            <p>detail : {detail}</p>
            <p>mode : {mode}</p>
        </div>
    );
};

export default About;