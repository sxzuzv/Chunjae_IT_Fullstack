import React from 'react';
import NewsItem from './NewsItem';

// NewsItem을 가지고 있는 NewsList 컴포넌트
const NewsList = () => {
    return (
        <>
            <NewsItem />
            <NewsItem />
            <NewsItem />
            <NewsItem />
        </>
    );
};

export default NewsList;