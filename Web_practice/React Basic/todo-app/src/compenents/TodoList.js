import React, { useCallback } from 'react';
import {List} from 'react-virtualized';
import './TodoList.css';
import TodoListItem from './TodoListItem';

const TodoList = ({todos,onRemove,onToggle}) => {
  const rowRender = useCallback(({index, key, style}) => {
    const todo = todos[index];
    
    return (
      <TodoListItem todo={todo} key={key} onRemove={onRemove} onToggle={onToggle} style={style} />
    );
  },[todos, onRemove, onToggle]);
  return (
    <List
      className='TodoList' width={512} height={513} rowCount={todos.length}
      rowHeight={57} rowRenderer={rowRender} list={todos} style={{outline:'none'}}
      />
    // <div className='TodoList'>
    //   {
    //     todos.map((todo) => <TodoListItem onRemove={onRemove} onToggle={onToggle} todo={todo} key={todo.id} />)
    //   }
    // </div>
  );
};

// export default TodoList;

// 컴포넌트의 props가 바뀌지 않았다면, 리렌더링 하지 않도록 설정한다.
export default React.memo(TodoList);