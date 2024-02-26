import React from 'react';
import { useParams } from 'react-router-dom';

const Article = () => {
    // 파라미터(id) 값을 id에 저장한다.
    // /articles/1 과 같은 형태로 들어오면, 1이 id에 저장된다.
    const { id } = useParams();

    return (
        <div>
            <h2>게시글 {id}</h2>
        </div>
    );
};

export default Article;