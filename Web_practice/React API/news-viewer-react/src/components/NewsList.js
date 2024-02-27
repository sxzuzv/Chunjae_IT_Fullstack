import React, { useEffect, useState } from 'react';
import NewsItem from './NewsItem';
import axios from '../../node_modules/axios/index';

// NewsItem을 가지고 있는 NewsList 컴포넌트
// News 컴포넌트에서 내려준 category를 받는다.
const NewsList = ({category}) => {
    // Api를 사용해서 뉴스 데이터를 받아온 후,
    // props를 사용하여 NewsItem 컴포넌트에 하나씩 내려준다.

    const [articles, setArticles] = useState(null);


    useEffect(
        () => {
        // fetchData() 실행되면 Api 데이터를 받아온다.
        const fetchData = async () => {
            // props로 내려온 category가 '전체보기'일 경우, url을 유지한다.
            // 그렇지 않을 경우, 쿼리스트링을 이용하여 url을 변경한다.
            const query = category === 'all' ? '' : '&category='+category;

            const apiUrl = 'https://newsapi.org/v2/top-headlines?country=kr&apiKey=e3aabbbc9e0148af8f9574ddc1ba0467';

            // url에 생성한 query를 붙여준다.
            const response = await axios.get(apiUrl+query);
            
            // axios가 가져온 데이터는 data에 담겨져 있다.
            // data의 어떤 내용을 가지고 오고 싶은지를 지정해주면 된다. (현재는 articles에 필요 데이터가 담겨있다.)
            // console.log(response.data.articles);

            // 데이터를 세팅해준다.
            setArticles(response.data.articles);
        };
        fetchData(); // 마운트 걸리면 fetchData() 실행된다.
    }, [category]
    );

    // 데이터가 들어오면 state가 바뀌게 되고 리렌더링이 진행된다.
    // 데이터가 있는 상태에서 .map()을 통해 하나씩 가지고 오게 해야 됨을 유의한다.

    // 데이터가 없을 때, null을 반환한다.
    // 예외 처리 해주지 않는다면 데이터가 없을 때 .map()이 실행돼서 오류가 발생한다.
    if(!articles) {
        return null;
    }

    return (
        <>
            {/* .map()을 사용하여 가져온 뉴스 데이터를 하나씩 꺼낸다. */}
            {/* 하나씩 꺼낸 뒤에 NewsItem에 article이라는 props로 값을 내려줘야 한다. */}
            {/* 그러므로 article이란 이름으로 article 정보를 통째로 내려준다. */}
            {/* 똑같은 태그가 여러 개 반복될 시, key 지정이 필수이므로 unique한 성질을 가진 속성을 key로 지정한다. => url */}
            {articles.map(article => (<NewsItem key={article.url} article={article} />))}
        </>
    );
};

export default NewsList;