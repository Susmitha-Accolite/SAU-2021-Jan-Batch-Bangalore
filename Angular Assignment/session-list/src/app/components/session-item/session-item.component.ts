import { Component, OnInit, Input, EventEmitter, Output} from '@angular/core';
import { Session } from 'src/app/models/Session';

@Component({
  selector: 'app-session-item',
  templateUrl: './session-item.component.html',
  styleUrls: ['./session-item.component.css']
})
export class SessionItemComponent implements OnInit {

  @Input()
  session: Session = new Session;

  @Output()
  deleteSession: EventEmitter<any> = new EventEmitter();

  @Output()
  editSession: EventEmitter<Session> = new EventEmitter();

  constructor() { }

  isVisible: boolean = false;
  isEditable: boolean = false;

  id:number = 0;
  title:string = "";
  trainerName:string = "";
  date:Date | undefined;

  ngOnInit(): void {
  }

  onToggle() {
    this.isVisible = !this.isVisible;
    console.log(this.isVisible);
  }

  onShow() {
    return this.isVisible;
  }

  onEdit() {
    this.isEditable = !this.isEditable;
  }

  ifEdit() {
    return this.isEditable;
  }

  onDelete(session:any) {
    console.log("On Delete");
    this.deleteSession.emit(session);
  }

  onEditable(session:any) {
    
    const s = {
      id: session.id,
      title: this.title === "" ? session.title : this.title,
      trainerName: this.trainerName === "" ? session.trainerName : this.trainerName,
      date: this.date === undefined ? new Date(session.date) : new Date(this.date)

    }
    console.log("Save Submitted");
    console.log(s);
    this.editSession.emit(s);
    console.log("After Emit");
  }

}
