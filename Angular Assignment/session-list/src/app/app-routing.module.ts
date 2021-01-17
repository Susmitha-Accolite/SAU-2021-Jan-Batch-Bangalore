import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SessionsComponent} from './components/sessions/sessions.component';
import { TodosComponent } from './components/todos/todos.component';

const routes: Routes = [
  { path: '', component: SessionsComponent },
  { path: 'todos', component: TodosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
