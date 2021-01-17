import { Component, OnInit} from '@angular/core';
import { Session } from 'src/app/models/Session';

@Component({
  selector: 'app-sessions',
  templateUrl: './sessions.component.html',
  styleUrls: ['./sessions.component.css']
})
export class SessionsComponent implements OnInit {

  sessions: Session[] = [];

  constructor() { }

  ngOnInit(): void {
    this.sessions= [
      {
        id: 1,
        title: 'Version Control System GIT',
        trainerName: 'Devansh',
        date: new Date("2021-01-07")
      },
      {
        id: 2,
        title: 'RDBMS',
        trainerName: 'Sivagami',
        date: new Date("2021-01-08")
      },
      {
        id: 3,
        title: 'NoSQL',
        trainerName: 'Abhishek',
        date: new Date("2021-01-09")
      },
      {
        id:4,
        title: 'JavaScript-1',
        trainerName: 'Anushree',
        date: new Date("2021-01-10")
      },
      {
        id: 5,
        title: 'JavaScript-2',
        trainerName: 'Pranoy',
        date: new Date("2021-01-10")
      },
      {
        id: 6,
        title: 'AngularJS-1',
        trainerName: 'Sharanya',
        date: new Date("2021-01-13")
      },
      {
        id: 7,
        title: 'AngularJS-2',
        trainerName: 'Pritam',
        date: new Date("2021-01-13")
      },
      {
        id: 8,
        title: 'ReactJS-1',
        trainerName: 'Vigneshwar',
        date: new Date("2021-01-14")
      },
      {
        id: 9,
        title: 'ReactJS-2',
        trainerName: 'Raviteja',
        date: new Date("2021-01-14")
      }
    ]
  }

  deleteSession(session:any) {
    console.log("deleteSession")
    this.sessions = this.sessions.filter(s => s.id !== session.id);
  }

  addSession(session: Session) {
    this.sessions.push(session);
    this.sessions[this.sessions.length-1]["id"] = this.sessions[this.sessions.length-2]["id"]+1;
    console.log("Second Add");
  }

  editSession(session: Session) {
    console.log("In edit");
    for(var i = 0; i < this.sessions.length; i++) {
      if(this.sessions[i]["id"] === session.id){
        this.sessions[i]["title"] = session.title;
        this.sessions[i]["trainerName"] = session.trainerName;
        this.sessions[i]["date"] = session.date;
        break;
      }
    }
    console.log(this.sessions);
  }
}
