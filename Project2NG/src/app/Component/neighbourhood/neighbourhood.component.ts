import { Component, OnInit } from '@angular/core';
import { NeighbService } from 'src/app/Service/neighb.service';
import { Neighborhood } from 'src/app/Models/Neighborhood';
import { DataService } from 'src/app/Service/data.service';
import { Recommendations } from 'src/app/Models/Recommendations';
import { RecommendationService } from 'src/app/Service/recommendation.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-neighbourhood',
  templateUrl: './neighbourhood.component.html',
  styleUrls: ['./neighbourhood.component.css']
})
export class NeighbourhoodComponent implements OnInit {

  constructor(private service: NeighbService, private data: DataService, private rec: RecommendationService, private router: Router) { }

  message: any;
  neighbMessage: any;
  loginState: boolean = false;

  welcome1 :any[] =["What’s new?","Hi!","Hello!","It’s nice to meet you","It’s a pleasure to meet you.","How have you been?",
  "Nice to see you there", "Thank you for using this app!"];
      welcome :string;
      x :number;



  ngOnInit(): void {
    this.getAllNeighbs();
    this.data.currentUserMessage.subscribe(message => this.message = message);
    this.data.currentNeigbhMessage.subscribe(neighbmessage => this.neighbMessage = neighbmessage);
    this.data._loginState.subscribe(loginState => this.loginState = loginState)
    this.showAdminButton();
    this.calcuserRating(this.message.userId);
    this.x=Math.floor(Math.random()*(this.welcome1.length-1));
    this.welcome=this.welcome1[this.x];

  }

  flipOver() {

  }

  images = [
    "../assets/images/DykerHeights.jpg",
    "../assets/images/Mapleton.jpg",
    "../assets/images/Midwood.jpg",
    "../assets/images/Flatbush.jpg",
    "../assets/images/SunsetPark.jpg",
    "../assets/images/BoroughPark.jpg",
    "../assets/images/EastNY.jpg",
    "../assets/images/MarinePark.jpg",
    "../assets/images/BayRidge.jpg",
    "../assets/images/Bensonhurst.jpg"
  ]

  neighborhoods: Array<Neighborhood>;
  neighb_name: string;
  neighb_loc: string;

  getAllNeighbs() {
    this.service.getNeighborhoods().subscribe(
      (response) => {
        this.neighborhoods = response;
        console.log(this.neighborhoods);
      }
    );
  }
  getNeighb(neighb) {
    this.data.changeNeighbMessage(neighb);
  }

  recommendNeighb() {
    let newrec = new Recommendations(this.neighb_name, this.neighb_loc)
    this.rec.createRecommendation(newrec).subscribe(
      (response) => {
        console.log(response);
      },
      (response) => {
        console.log("Failed to add Recommendation")
      }
    );
  }

  logout() {
    this.loginState = false;
    this.router.navigateByUrl("/login");
  }

  adminFunction() {
    this.router.navigateByUrl("/adminPage");

  }
  showAdminButton() {
    if (this.message.roleof == 'Admin') {
      this.loginState = true;
      console.log(this.loginState);
    }
  }

  calcuserRating(userId: number) {
    //this.message.userId=userId;
    this.service.getUserRating(userId).subscribe(
      (response) => {
        console.log("User rating is: " + response);
        this.message.rating = response;
      },
      (response) => {
        console.log("Failed to calculate user rating")
      }
    );
  }

  slideConfig = {
    "slidesToShow": 3,
    "slidesToScroll": 3,
    "dots": true,
    "infinite": true
  };
}
