import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { CurrentUser } from '../models/CurrentUser';
import { Observable } from 'rxjs';
import { P2user } from '../Models/User';

@Injectable({
  providedIn: 'root'
})


export class P2LoginService {
  createnewReview(newreview: import("../Models/Review").Review) {
    throw new Error("Method not implemented.");
  }

  constructor(private http :HttpClient) { }

  private headers = new HttpHeaders({'Content-Type':'application/json'});

  createUser(newuser: P2user) :Observable<P2user>{
    return this.http.post<P2user>("http://localhost:8080/users", newuser, {headers: this.headers});
  }
                
                
  loginById(cuser:CurrentUser):Observable<CurrentUser>{
    return this.http.get<CurrentUser>("http://localhost:8080/users/search?username=" +cuser.cmuserid +"&pword=" +cuser.cmuserpass);
  }

  getAllUsers() :Observable<P2user[]>{
    return this.http.get<P2user[]>("http://localhost:8080/users");
  }
  deleteUser(_id :number) :Observable<any>{
    console.log("this is delete id in p2-login"+_id);
    return this.http.delete("http://localhost:8080/users/"+_id, {headers: this.headers});
  }




















}
