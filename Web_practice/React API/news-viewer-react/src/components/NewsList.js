import React, { useEffect, useState } from 'react';
import NewsItem from './NewsItem';
import axios from '../../node_modules/axios/index';

// NewsItem을 가지고 있는 NewsList 컴포넌트
const NewsList = () => {
    // Api를 사용해서 뉴스 데이터를 받아온 후,
    // props를 사용하여 NewsItem 컴포넌트에 하나씩 내려준다.

    // const [articles, setArticles] = useState(null);

    useEffect(
        () => {
        // Api 데이터를 받아온다.
        const fetchData = async () => {
            const response = await axios.get(
                'https://newsapi.org/v2/top-headlines?country=kr&apiKey=e3aabbbc9e0148af8f9574ddc1ba0467');
            
            // axios가 가져온 데이터는 data에 담겨져 있다.
            // data의 어떤 내용을 가지고 오고 싶은지를 지정해주면 된다. (현재는 articles에 필요 데이터가 담겨있다.)
            console.log(response.data.articles);
        };
        fetchData();
    }, [] // 마운트 됐을 때 데이터를 뿌린다.
    );
    return (
        <>
            
        </>
    );
};

export default NewsList;