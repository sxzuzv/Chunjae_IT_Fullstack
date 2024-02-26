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

export default TodoList;