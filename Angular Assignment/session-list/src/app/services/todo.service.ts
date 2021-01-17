import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Todos } from '../models/Todo';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TodoService {
  todosUrl:string = 'https://jsonplaceholder.typicode.com/todos?_limit=20';

  constructor(private http:HttpClient) { }

  getTodos(): Observable<Todos[]> {
    return this.http.get<Todos[]>(this.todosUrl);
  }
}
