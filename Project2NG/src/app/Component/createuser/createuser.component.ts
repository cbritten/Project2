import { Component, OnInit } from '@angular/core';
import { P2LoginService } from 'src/app/service/p2-login.service';
import { P2user } from 'src/app/Models/User';
@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css']
})
export class CreateuserComponent implements OnInit {
  constructor(private create :P2LoginService) { }
  ngOnInit(): void {
  }
  myuserList: Array<P2user>;
  //model
  show:boolean=false;
    
    roleof:string= "user";
    userId:number;
    uname:string;
    upwd:string;
    uemail:string;
    ufname:string;
    ulname:string;
    uneigh:string;
    urating:number;
    uallowemail:number;




  createAccount(){
    let mynewuser = new P2user(-1, this.roleof, this.uname,this.upwd,this.uemail,
                  this.ufname,this.ulname,this.uneigh,0,this.uallowemail);
      this.create.createUser(mynewuser).subscribe(
        (response) => {
          this.myuserList.push(response);
        },
        (response) => {
          console.log("Failed to add new user")
          console.log(response);
        }
      );
  }
}