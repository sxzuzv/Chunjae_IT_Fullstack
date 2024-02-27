import React, { useCallback, useState } from 'react';
import NewsList from './NewsList';

// 클릭한 메뉴에 맞는 리스트를 출력한다.
const News = () => {
    const [category, setCategory] = useState('all');

    const onselect = useCallback((e, category) => {
        // 값을 세팅해준다.
        setCategory(category);
        
        // 이중 클릭을 방지한다.
        e.preventDefault();
    }, []
    );
    
    return (
        <section>
            <ul className="nav nav-tabs">
                <li className="nav-item">
                    <a onClick={(e) => onselect(e, 'all')} className={category == 'all' ? 'nav-link active' : 'nav-link'} aria-current="page" href="#">
                        전체보기
                    </a>
                </li>
                <li className="nav-item">
                    <a onClick={(e) => onselect(e, 'business')} className="nav-link active" aria-current="page" href="#">
                        비즈니스
                    </a>
                </li>
                <li className="nav-item">
                    <a onClick={(e) => onselect(e, 'entertainment')} className="nav-link active" aria-current="page" href="#">
                        엔터테인먼트
                    </a>
                </li>
            </ul>
            <div className="album py-5 bg-light">
                    <div className="container">
                        <div className="row">
                            {/* 뉴스 리스트를 출력한다. */}
                            {/* 카테고리 정보를 NewsList에 props로 내려준다. */}
                            {/* 내려주면서 렌더링이 다시 걸린다. */}
                            <NewsList category={category} />
                        </div>
                    </div>
                </div>
        </section>
    );
};

export default News;