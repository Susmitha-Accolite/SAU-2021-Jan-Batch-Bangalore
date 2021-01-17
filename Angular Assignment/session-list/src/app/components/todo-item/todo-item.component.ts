import { Component, OnInit, Input } from '@angular/core';
import { Todos } from '../../models/Todo';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {

  @Input()
  todo: Todos = new Todos;
  constructor() { }

  isVisible: boolean = false;
  ngOnInit(): void {
  }

  display() {
    this.isVisible = !this.isVisible;
  }

  onShow() {
    return this.isVisible;
  }
}
