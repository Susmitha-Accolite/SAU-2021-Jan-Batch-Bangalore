import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Session } from 'protractor';

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {

  @Output()
  addSession: EventEmitter<any> = new EventEmitter()
  
  title:string = "";
  trainerName:string = "";
  date: Date = new Date();

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {
    const session = {
      title: this.title,
      trainerName: this.trainerName,
      date: this.date
    }
    console.log("First Submit");
    this.addSession.emit(session);
  }

}
