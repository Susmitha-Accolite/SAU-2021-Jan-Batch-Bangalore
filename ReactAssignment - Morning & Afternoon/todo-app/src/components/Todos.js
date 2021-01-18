import React, { Component } from 'react';
import TodoItem from './TodoItem';
import Title from './Title';
import AddTodoItem from './AddTodoItem';

class Todos extends Component {

    state = {
        todos: [
         {
           id: 1,
           title: 'Clean the trash',
           completed: false,
           dueDate: '05-01-2021'
         },
         {
           id: 2,
           title: 'Angular Assignment',
           completed: false,
           dueDate: '17-01-2021'
         },
         {
           id: 3,
           title: 'React Assignment',
           completed: false,
           dueDate: '18-01-2021'
         },
         {
           id: 4,
           title: 'Complete the notes',
           completed: false,
           dueDate: '20-01-2021'
         },
         {
           id: 5,
           title: 'Catch up with meeting',
           completed: false,
           dueDate: '22-01-2021'
         },
         {
           id: 6,
           title: 'Weekend party',
           completed: false,
           dueDate: '24-01-2021'
         }
       ]
     }

     markComplete = (id) => {
       console.log(id);
       this.setState({ todos: this.state.todos.map(t => {
         if(t.id === id) {
           t.completed = !t.completed;
         }
         return t;
       }) })
     }

     onDelete = (id) => {
        this.setState({ todos: [...this.state.todos.filter(todo => todo.id !== id)]
        });
      }

      addTodo = (title, dueDate) => {
        const newTodo = {
          id: this.state.todos.length + 1,
          title,
          dueDate,
          completed: false
        }
        this.setState( {todos: [...this.state.todos, newTodo].sort( function (a, b) {
          var s1 = a.dueDate;
          var s2 = b.dueDate;
          return s1 < s2 ? -1 : s1 > s2 ? 1 : 0;
        } ) }
        );
      }

    render() {
        return (
            <>
        <Title />
        <AddTodoItem addTodo={this.addTodo}/>
        {
        this.state.todos.map((todo) => (
            <TodoItem key={todo.id} todo={todo}
            markComplete={this.markComplete}
            onDelete={this.onDelete}
            />
        ))
        }
        </>
        );
    }
}


export default Todos;