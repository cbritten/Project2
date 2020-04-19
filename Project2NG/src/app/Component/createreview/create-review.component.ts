import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/models/Review';
import { ReviewService } from 'src/app/Service/review.service';
import { DatePipe } from '@angular/common';

import { DataService } from 'src/app/Service/data.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-review',
  templateUrl: './create-review.component.html',
  styleUrls: ['./create-review.component.css']
})
export class CreateReviewComponent implements OnInit {


  constructor(private addreview: ReviewService, private data: DataService, private router: Router) { };


  message: any;
  neighbMessage: any;

  ngOnInit(): void {
    this.data.currentUserMessage.subscribe(message => this.message = message);
    this.data.currentNeigbhMessage.subscribe(neighbMessage => this.neighbMessage = neighbMessage);
  }

  info: string;
  rev_id: number;
  user_id: number;
  neighb_id: number;
  dateOf: Date;
  tup: number;
  tdown: number;
  valid: boolean;
  loginState: boolean; 

  // rclean:number;
  // rqoflife:number;
  // rsafety:number;
  // ramenities:number;
  // ressentials:number;

  createReview() {

    let newreview = new Review(-1, this.message.userId, this.neighbMessage.neighbId,
      0, 0, this.info);
    this.addreview.createnewReview(newreview, this.neighbMessage.neighbId, this.message.userId).subscribe(
      (response) => {
        this.valid = true;
      },
      (response) => {
        this.valid = false;
      }
    );
  }

  logout() {
    this.loginState = false;
    this.router.navigateByUrl("/login");
  }

  backToNeighb() {
    this.router.navigateByUrl("/neighbourhoods");
  }

}

