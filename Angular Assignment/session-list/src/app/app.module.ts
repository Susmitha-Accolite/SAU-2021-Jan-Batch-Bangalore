import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SessionsComponent } from './components/sessions/sessions.component';
import { SessionItemComponent } from './components/session-item/session-item.component';
import { HeaderComponent } from './components/header/header.component';
import { AddSessionComponent } from './components/add-session/add-session.component';
import { FormsModule } from'@angular/forms';
import { TodosComponent } from './components/todos/todos.component';
import { TodoItemComponent } from './components/todo-item/todo-item.component';
import { TodoHeaderComponent } from './components/todo-header/todo-header.component';

@NgModule({
  declarations: [
    AppComponent,
    SessionsComponent,
    SessionItemComponent,
    HeaderComponent,
    AddSessionComponent,
    TodosComponent,
    TodoItemComponent,
    TodoHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
