import React from 'react';
import { NavLink } from '../../node_modules/react-router-dom/dist/index';

// 페이지 header를 설계한다.
// 최종적으로 <div> 태그 하나만을 감싸져 있으므로, 변환(HTML->JSX)한 코드를 그대로 사용한다.
const Header = () => {
    return (
    <div className="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h5 className="my-0 mr-md-auto font-weight-bold">News API</h5>
            <nav className="my-2 my-md-0 mr-md-3">
                {/* <a className="p-2 text-dark active" href="#">HOME</a>
                <a className="p-2 text-dark" href="#">뉴스</a> */}

                {/* SPA : <a> 태그 적용 불가, NavLink를 사용하여 Request URL을 유지하면서 페이지는 변경한다. */}
                {/* isActive를 활용하여 header 우측의 'HOME' 혹은 'NEWS' 선택 효과를 준다. */}
                <NavLink className={({isActive}) => (isActive ? "p-2 text-dark active" : "p-2 text-dark")} to="/">HOME</NavLink>
                <NavLink className={({isActive}) => (isActive ? "p-2 text-dark active" : "p-2 text-dark")} to="/news">NEWS</NavLink>
            </nav>
    </div>
    );
};

export default Header;