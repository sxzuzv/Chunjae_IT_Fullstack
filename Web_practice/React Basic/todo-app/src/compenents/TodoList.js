import React from 'react';
import './TodoList.css';
import TodoListItem from './TodoListItem';

const TodoList = ({todos,onRemove,onToggle}) => {
  return (
    <div className='TodoList'>
      {
        todos.map((todo) => <TodoListItem onRemove={onRemove} onToggle={onToggle} todo={todo} key={todo.id} />)
      }
    </div>
  );
};

// export default TodoList;

// 컴포넌트의 props가 바뀌지 않았다면, 리렌더링 하지 않도록 설정한다.
export default React.memo(TodoList);