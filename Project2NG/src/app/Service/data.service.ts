import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private loginState = new BehaviorSubject<boolean>(false);
  _loginState = this.loginState.asObservable();

  private userMessageSource = new BehaviorSubject<any>("default message");
  currentUserMessage = this.userMessageSource.asObservable(); 

  private neighbMessageSource = new BehaviorSubject<any>("default message");
  currentNeigbhMessage = this.neighbMessageSource.asObservable(); 

  constructor() { }

  changeUserMessage(userMessage: any){
    this.userMessageSource.next(userMessage); 
  }
  changeNeighbMessage(neighbMessage: any){
    this.neighbMessageSource.next(neighbMessage);
  }

  updateStatus(status: boolean){
    this.loginState.next(status);
  }
}
