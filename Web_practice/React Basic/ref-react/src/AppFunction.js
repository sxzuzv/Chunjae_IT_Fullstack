import React from 'react';
// import Validation from './Validation';
import MoveBox from './MoveBox';

const App = () => {
  return (
    <div>
      {/* <Validation /> */}
      <MoveBox ref={(ref) => {this.MoveBox = ref}} />
      <button onClick={() => {this.MoveBox.move(200, 200)}}>MOVE02</button>
    </div>
  );
};

export default App;