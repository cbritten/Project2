import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/models/Review';
import { ReviewService } from 'src/app/Service/review.service';
import { DataService } from 'src/app/Service/data.service';
import { Comm } from 'src/app/Models/Comm';
import { NeighbService } from 'src/app/Service/neighb.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seereview',
  templateUrl: './seereview.component.html',
  styleUrls: ['./seereview.component.css']
})
export class SeereviewComponent implements OnInit {

  constructor(private seerevservice: ReviewService, private data: DataService, private service: NeighbService, private router: Router) { }

  message: any;
  neighbMessage: any;
  ngOnInit(): void {
    this.data.currentUserMessage.subscribe(message => this.message = message);
    this.data.currentNeigbhMessage.subscribe(neighbMessage => this.neighbMessage = neighbMessage)
    this.displayAllReviews();
    this.updateURating(); 
  }

  reviewList: Array<Review>;
  cmntList: Array<Comm>;
  rempty: boolean;
  commReturned: string;
  cmntcreated: string;
  temprevid:Number;
  loginState:boolean; 

  rev_id: number;
  user_id: number;
  neighbId: number;
  dateof: string;
  tUp: number;
  tDown: number;
  info: string;
  cmnt: string;


  displayAllReviews() {
    this.seerevservice.getAllReviews(this.neighbMessage.neighbId).subscribe(

      (response) => {
        this.reviewList = response;
        this.rempty = true;
      },
      (response) => {
        this.rempty = false;
      }
    );
  }

  displayAllComments(rev_id) {
    console.log(rev_id);
    this.seerevservice.getReviewComments(rev_id).subscribe(
      (response) => {
        console.log(response);
        this.cmntList = response;
        this.commReturned = "The comments are listed below";
      },
      (response) => {
        this.commReturned = "There are no comments for this review."
      }
    );
  }

  makeComment(cmnt, rev_id) {
    console.log(rev_id);
    console.log(cmnt);
    let newcmnt = new Comm(rev_id, cmnt);
    console.log(newcmnt);
    this.seerevservice.makeComment(newcmnt, rev_id).subscribe(
      (response) => {
        this.cmntcreated = "Comment successfully added!"
      },
      (reponse) => {
        this.cmntcreated = "Sorry, your comment could not be processed."
      }
    );
  }

  updateURating(){
    this.seerevservice.getallUsers().subscribe(
      (response1)=>{
        for(let i=0;i<response1.length;i++){
          console.log("response from getuserbyuserid: "+response1);
          this.service.getUserRating(response1[i].userId).subscribe(
            (response2)=>{
              console.log("response from get user rating by user id: "+response2);
              console.log(response1[i].rating);
              response1[i].rating=response2;
              console.log(response1[i].rating);
              this.seerevservice.UpdateURating(response1[i]).subscribe(
                (response3)=>{
                  console.log("Updated rating is: "+response3.rating);
                },
                (response3)=>{
                  console.log("unable to update rating in HTML");
                }
              );
            },
            (response2)=>{
              console.log("Unable to fetch user by user id");
            }
          );
        }
      },
      (response1)=>{
        console.log("unable to fetch user by user id");
      }
    );   
  }


  addThumbsUp(temprevid: number) {
    this.seerevservice.getRevbyId(temprevid).subscribe(

      (response) => {
        ++response.tUp;
        this.seerevservice.addTUp(response).subscribe(
          (response) => {
            console.log(response);
            console.log(response.tUp);
            console.log(response.info);
          },
          (response) => {
            console.log("review could not be updated");
          }
        );
      },
      (response) => {
        console.log("Could not get review by revId");
      }
    );
  }
  addThumbsDown(temprevid: number) {
    this.seerevservice.getRevbyId(temprevid).subscribe(

      (response) => {

        ++response.tDown;
        this.seerevservice.addTUp(response).subscribe(
          (response) => {
            console.log(response);
            console.log(response.tDown);
            console.log(response.info);
          },
          (response) => {
            console.log("review could not be updated");
          }
        );
      },
      (response) => {
        console.log("Could not get review by revId");
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
