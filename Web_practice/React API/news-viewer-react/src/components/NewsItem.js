import React from 'react';

// 각각의 뉴스를 의미하는 NewsItem 컴포넌트
const NewsItem = () => {
    return (
        <div className="col-md-6">
            <div className="card mb-4 box-shadow">
                <img className="card-img-top"
                src="https://placehold.co/160X80"
                alt="Card image cap"
                />
                <div className="card-body">
                    <h4>title</h4>
                        <p className="card-text">
                            This is a wider card with supporting text below as a natural
                            lead-in to additional content. This content is a little bit
                            longer.
                        </p>
                <div className="d-flex justify-content-between align-items-center">
                    <div className="btn-group">
                        <a href="#" className="btn btn-sm btn-outline-secondary">
                            View
                        </a>
                    <small className="text-muted">NAVER</small>
                </div>
            </div>
        </div>
        </div>
        </div>
    );
};

export default NewsItem;