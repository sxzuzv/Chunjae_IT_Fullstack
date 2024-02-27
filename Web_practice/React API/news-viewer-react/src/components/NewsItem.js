import React from 'react';

// 각각의 뉴스를 의미하는 NewsItem 컴포넌트
const NewsItem = ({article}) => {
    // 하나의 뉴스 기사를 비할당 방식으로 꺼내서 사용한다.
    // 제목, 설명, url, 썸네일, 작성자
    const { title, description, url, urlToImage, author } = article;

    return (
        <div className="col-md-6">
            <div className="card mb-4 box-shadow">
                {/* 썸네일의 경우, 있거나 null일 수 있음에 유의한다. */}
                {/* urlToImage가 있을 시, 화면에 출력한다. */}
                {urlToImage && <img className="card-img-top"
                                src={urlToImage}
                                alt="Card image cap"
                />}
                <div className="card-body">
                    <h4>{title}</h4>
                        <p className="card-text">
                            {description}
                        </p>
                <div className="d-flex justify-content-between align-items-center">
                    <div className="btn-group">
                        {/* 같은 페이지가 아닌 아예 다른 페이지로 이동, <a> 태그 사용 가능하다. */}
                        <a href={url} target='_blank' className="btn btn-sm btn-outline-secondary">
                            View
                        </a>
                    <small className="text-muted">{author}</small>
                </div>
            </div>
        </div>
        </div>
        </div>
    );
};

export default NewsItem;