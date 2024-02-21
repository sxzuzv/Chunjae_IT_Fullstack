import React, { Component } from 'react';

class Validation extends Component {
    render() {
        return (
            <div>
                <input type='text' name='pwd' />
                <button>검증</button>
            </div>
        );
    }
}

export default Validation;