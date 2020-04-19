import { Component, OnInit } from '@angular/core';
import { P2LoginService } from 'src/app/service/p2-login.service';
import { CurrentUser } from 'src/app/models/CurrentUser';
import { Router, Data } from '@angular/router';
import { DataService } from 'src/app/Service/data.service';


@Component({
      selector: 'app-login',
      templateUrl: './login.component.html',
      styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

      constructor(private ulogin: P2LoginService, private router: Router, private data: DataService) { }
      ngOnInit(): void {
            this.data.currentUserMessage.subscribe(message => this.message = message);
            // this.data._loginState.subscribe(loginState => this.loginState = loginState);
      }
      message: any;
      username: string;
      pword: string;
      valid: boolean = true;
      show: boolean = false;
      userloggingin: CurrentUser;


      login() {
            let currentuser = new CurrentUser(this.username, this.pword);
            this.ulogin.loginById(currentuser).subscribe(
                  (response) => {
                        console.log(response);
                        if (response === null) {
                              this.valid = false;
                              console.log("failed to log in");
                        }
                        else
                        {
                              this.valid = true;
                              this.router.navigateByUrl('/neighbourhoods');
                              this.data.changeUserMessage(response);
                        }
                  }
            );
      }
      myFunction() {
            // var x = document.getElementById("myInput");
            // if (x.type === "password") {
            //   x.type = "text";
            // } else {
            // x.type = "password";
            // }
      }

}