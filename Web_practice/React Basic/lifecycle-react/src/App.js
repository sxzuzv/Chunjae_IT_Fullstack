import React, { Component } from 'react';
import LifeCycle from './LifeCycle';

class App extends Component {
  state = {
    color: 'red'
  }

  render() {
    return (
      <div>
         {/* LifeCycle.js에 color를 props로 내려준다. */}
        <LifeCycle color = {this.state.color} />
        {/* 버튼 클릭 시, state의 color가 'blue'로 변경되며 내려주는 color가 'blue'로 변경된다. */}
        <button onClick={() => {
          this.setState({color:'blue'});
        }}>BLUE</button>
      </div>
    );
  }
}

export default App;