import React from 'react';
import { useParams } from 'react-router-dom';

const data = {
    user1 : {
        name : '홍길동',
        desc : '시니어 개발자'
    },
    user2 : {
        name : '김기가',
        desc: '주니어 개발자'
    }
};

const Profile = () => {
    const params = useParams();
    const profile = data[params.id];

    return (
        <div>
            <h1>사용자 프로필</h1>
            {/* profile 값의 유무에 따라 출력 내용을 결정한다. */}
            {profile ? ( <div><h2>{profile.name}</h2><p>{profile.desc}</p></div>) : (<p>존재하지 않는 프로필입니다.</p>)}
        </div>
    );
};

export default Profile;