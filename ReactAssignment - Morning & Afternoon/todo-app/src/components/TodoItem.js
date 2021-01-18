import React, { Component } from 'react'

export class TodoItem extends Component {

    changeStyle = () => {
        return {
            backgroundColor: this.props.todo.completed ? '#AEF1C2' : '#f4f4f4',
            padding: '10px',
            border: '#ccc 1px dotted'
        }
    }

    render() {
        const { id, title, dueDate } = this.props.todo;

        return (
            <div style={this.changeStyle()}>
                <p>
                    <input type="checkbox" onChange={this.props.markComplete.bind(this, id)}/> {' '}
                    { title } by { dueDate }
                    <button onClick={ this.props.onDelete.bind(this, id) } style={btnStyle}>Delete</button>
                </p>
            </div>
        )
    }
}


const btnStyle = {
    backgroundColor: 'red',
    color: 'white',
    border: 'none',
    padding: '5px 10px',
    borderRadius: '20%',
    cursor: 'pointer',
    float: 'right'
}

export default TodoItem
