import React, { Component } from 'react';

class Validation extends Component {
    handleButtonClick = () => {
        this.input.focus();
    }
    render() {
        return (
            <div>
                {/*  참조를 위해 ref를 사용한다. */}
                <input type='text' name='pwd' ref={(ref) => {this.input = ref}} />
                <button onClick={this.handleButtonClick}>검증</button>
            </div>
        );
    }
}

export default Validation;