import React, { Component } from 'react'

class AddTodoItem extends Component {

    state = {
        title: '',
        date: ''
    }

    onSubmit = (e) => {
        e.preventDefault();
        this.props.addTodo(this.state.title, this.state.dueDate);
        this.setState({
            title: '',
            dueDate: ''
        })
    }

    onChange = (e) => this.setState({ 
        [e.target.name] : e.target.value
    })

    render() {
        return (
            <form onSubmit={this.onSubmit} style={{ display: 'flex' }}>
                <input type="text" name="title" placeholder="Add title" 
                style={inputStyle} 
                value={this.state.title}
                onChange={this.onChange}
                />
                <input type="text" name="dueDate" placeholder="Add due date (dd-mm-yyy)"
                 style={inputStyle}
                 value={this.state.dueDate}
                 onChange={this.onChange}
                 />
                <input type="submit" value="Submit" className="btn" style={{flex: 1}}/>
            </form>
        )
    }
}

const inputStyle = {
    flex: '10px',
    padding: '10px'
}

export default AddTodoItem;