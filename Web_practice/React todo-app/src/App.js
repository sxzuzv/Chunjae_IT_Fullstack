import React, { useCallback, useRef, useState } from 'react';
import TodoTemplate from './compenents/TodoTemplate';
import TodoInsert from './compenents/TodoInsert';
import TodoList from './compenents/TodoList';

function createBulkTodos(){
  const array = [];
  for (let index = 0; index < 2500; index++) {
    array.push({id:index+1,text:'할일'+(index+1),checked:false}); 
  }
  return array;
}

const App = () => {
  const [todos,setTodos] = useState(createBulkTodos);
  const nextId = useRef(2501); //id 관리용
  const onToggle = useCallback(
    (id) => {
      setTodos(todos.map(
        todo => todo.id == id ? {...todo,checked:!todo.checked} : todo
      ));
    }
  );
  const onInsert = useCallback(
    (text) => {
      const nextTodo = {id:nextId.current,text:text,checked:false};
      setTodos(todos.concat(nextTodo));
      nextId.current = nextId.current + 1; //id 4 -> 5
    },[todos]
  );
  //TodoListItem remove button click -> id
  const onRemove = useCallback(
    (id) => {
      setTodos(todos.filter(todo => todo.id != id));
    },[todos]
  );

  return (
    <TodoTemplate>
      <TodoInsert onInsert={onInsert} />
      <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} />
    </TodoTemplate> 
  );
};

export default App;