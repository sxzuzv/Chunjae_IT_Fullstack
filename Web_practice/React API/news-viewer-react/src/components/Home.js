import React from 'react';
import { NavLink } from '../../node_modules/react-router-dom/dist/index';

const Home = () => {
    return (
        <section className="jumbotron text-center">
            <div className="container">
                <h1 className="jumbotron-heading">코드로 전세계 뉴스 검색</h1>
                    <p className="lead text-muted">
                        JSON API를 사용하여 웹 전반의 뉴스 소스와 블로그에서 기사와 속보
                        헤드라인을 찾아보세요.
                    </p>
                    <p>
                        {/* <a href="#" className="btn btn-primary my-2">
                            메뉴 이동
                        </a> */}

                        {/* <a> 태그 사용 불가 -> <NavLink> 변경 */}
                        <NavLink to='/news' className="btn btn-primary my-2">
                            메뉴 이동
                        </NavLink>
                    </p>
            </div>
        </section>
    );
};

export default Home;