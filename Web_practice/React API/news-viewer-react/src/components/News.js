import React from 'react';
import NewsList from './NewsList';

const News = () => {
    return (
        <section>
            <ul className="nav nav-tabs">
                <li className="nav-item">
                    <a className="nav-link active" aria-current="page" href="#">
                        전체보기
                    </a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#">
                        비즈니스
                    </a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="#">
                        엔터테인먼트
                    </a>
                </li>
            </ul>
            <div className="album py-5 bg-light">
                    <div className="container">
                        <div className="row">
                            {/* 뉴스 리스트를 출력한다. */}
                            <NewsList />
                        </div>
                    </div>
                </div>
        </section>
    );
};

export default News;