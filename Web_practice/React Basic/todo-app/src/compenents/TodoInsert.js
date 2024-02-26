import React, { useCallback, useState } from 'react';
import './TodoInsert.css';
import {MdAdd} from 'react-icons/md';

const TodoInsert = ({onInsert}) => {
  const [value,setValue] = useState('');
  const onChange = useCallback(
    (e) => {
      setValue(e.target.value);
    },[]
  );
  const onSubmit = useCallback(
    (e) => {
      onInsert(value); // App.js -> onInsert text = value
      setValue('');
      e.preventDefault(); // onsubmit 방지...
    },[onInsert,value]
  );
  return (
    <form className='TodoInsert' onSubmit={onSubmit}>
      <input placeholder='할 일을 입력하세요.' value={value} onChange={onChange} />
      <button type='submit'><MdAdd /></button>
    </form>
  );
};

export default TodoInsert;