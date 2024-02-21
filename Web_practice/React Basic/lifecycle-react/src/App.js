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
      </div>
    );
  }
}

export default App;