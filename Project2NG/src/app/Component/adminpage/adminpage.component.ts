import { DataService } from './../../Service/data.service';
import { P2LoginService } from 'src/app/service/p2-login.service';
import { P2user } from 'src/app/Models/User';
import { Component, OnInit } from '@angular/core';
import { Router, Data } from '@angular/router';
import { ReviewService } from 'src/app/Service/review.service';
import { Review } from 'src/app/models/Review';
import { Neighborhood } from 'src/app/Models/Neighborhood';
import { NeighbService } from 'src/app/Service/neighb.service';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {

  constructor(private users :P2LoginService, private reviews :ReviewService,
     private neighb :NeighbService, private userinfo :DataService,
     private router: Router ) { }

  user :any;
  ngOnInit(): void {
    this.users.getAllUsers();
    this.getAllNeighb();
    console.log(this.users.getAllUsers());
    this.reviews.getAllRev();
    this.neighb.getNeighborhoods();
    this.userinfo.currentUserMessage.subscribe(user => this.user =user);
  }

  showDu: boolean =false;
  showAu: boolean =false;
  showAn: boolean =false;
  showUn: boolean =false;
  showDn: boolean =false;
  showDr: boolean =false;

  neighbName :string;
  neighbRating :number;
  neighbLoc :string;
  popsqm :number;
  avgprice :number;
  hospital :number;
  pow :number;
  education :number;
  grocery :number;
  transit :number;
  airports :number;
  hotels :number;
  pubsrv :number;
  crmrate :number;
  povrate :number;
  homrate :number;
  result :string;

  uNeighbId :number;
  uNeighbName :string;
  uNeighbRating :number;
  uNeighbLoc :string;
  uPopsqm :number;
  uAvgprice :number;
  uHospital :number;
  uPow :number;
  uEducation :number;
  uGrocery :number;
  uTransit :number;
  uAirports :number;
  uHotels :number;
  uPubsrv :number;
  uCrmrate :number;
  uPovrate :number;
  uHomrate :number;


  
  nList :Array<Neighborhood>;
  uList :Array<P2user>;
  rList :Array<Review>;
  

  count: number = 0;
  max :number;
  next(){
    if(this.count>=(this.max-1)){
      this.result="This is top of list";
      console.log(this.count)
      this.count=this.max-1;
      
    }else{
      this.result="";
      this.count++;
      this.getNeighList();
    }
  }
  previous(){
    if(this.count<=0){
      this.result="This is end of list";
      this.count=0;
    }else{
      this.result="";
      this.count--;
      this.getNeighList();
    }
  }

  /**getting objects from DB functions */
  getUserIds(){
    this.users.getAllUsers().subscribe(
      (response) =>{
        console.log(response);
        this.uList =response;
      },
      (error)=>{
        console.log(error);
        this.result="Server is busy, try later";
      }
    )
  }

  getAllRev(){
    this.reviews.getAllRev().subscribe(
      (response) =>{
        console.log("coming from response: " +response);
        this.rList = response;
        console.log(this.rList);;
      },
      (error)=>{
        console.log("failed to getting all reviews");
        this.result="Server is busy, try later";
      }
    )
  }

  getAllNeighb(){
    this.neighb.getNeighborhoods().subscribe(
      (response) =>{
        console.log("coming from response: " +response);
        this.nList = response;
        console.log(this.nList);;
      },
      (error)=>{
        console.log("failed to getting all neighborhood");
        this.result="Server is busy, try later";
      }
    )
  }


  /**getting objects from DB functions END*/

  goBack(){
    this.router.navigateByUrl("/neighbourhoods");
  }
  /**show forms functions */
  showAuF(){
    this.result="";
    this.getUserIds();
    if(this.showAu){
      this.showAu=false;
    }else{
      this.showAn=false;
      this.showDn=false;
      this.showDr=false;
      this.showDu=false;
      this.showUn=false;
      this.showAu=true;
    }
  }

  showDuF(){
    this.result="";
    this.getUserIds();
    if(this.showDu){
      this.showDu=false;
    }else{
      this.showAn=false;
      this.showDn=false;
      this.showDr=false;
      this.showAu=false;
      this.showUn=false;
      this.showDu=true;
      
    }
  }

  showAnF(){
    this.result="";
    if(this.showAn){
      this.showAn=false;
    }else{
      this.showAu=false;
      this.showDn=false;
      this.showDr=false;
      this.showDu=false;
      this.showUn=false;
      this.showAn=true;
    }
  }
  showUnF(){
    this.getAllNeighb();
    this.result="";
    this.max=this.nList.length;
    this.getNeighList()
    if(this.showUn){
      this.showUn=false;
    }else{
      this.showAn=false;
      this.showDn=false;
      this.showDr=false;
      this.showDu=false;
      this.showAu=false;
      this.showUn=true;
    }
  }
  showDnF(){
    this.getAllNeighb();
    this.result="";
    if(this.showDn){
      this.showDn=false;
    }else{
      this.showAn=false;
      this.showAu=false;
      this.showDr=false;
      this.showDu=false;
      this.showUn=false;
      this.showDn=true;
    }
  }
  showDrF(){
    this.result="";
    this.getAllRev()
    if(this.showDr){
      this.showDr=false;
    }else{
      this.showAn=false;
      this.showDn=false;
      this.showAu=false;
      this.showDu=false;
      this.showUn=false;
      this.showDr=true;
    }
  }
  /**show forms functions ends */

    /**admin functions ends */
  deleteU(_id){
    this.users.deleteUser(_id).subscribe(
      (response)=> {
        console.log("delete user: "+response);
      this.result="Successfully deleted the user"}
      ,(error)=> {
        console.log("delete user: "+ error);
        this.result="Problem deleting user";
      });
  }

  deleteReview(rId: number){
    console.log("delete rId: " +rId);
    this.reviews.deleteReview(rId).subscribe(
      (response)=> {
        console.log("delete review: "+response);
        this.result="Successfully deleted the review"
      },
      (error)=> {
        console.log("delete review: "+ error);
        this.result="problem deleteing review";
      });
  }

  addNeighb(){
    let newNeighb = new Neighborhood(
      -1,this.neighbName,this.neighbRating,this.neighbLoc,
      this.popsqm,this.avgprice,this.hospital,this.pow,
      this.education,this.grocery,this.transit,this.airports,
      this.hotels,this.pubsrv,this.crmrate,this.povrate,this.homrate);
      console.log(newNeighb);
      this.neighb.addNeighborhood(newNeighb).subscribe(
        (response)=>{
          console.log(response);
          this.result="Successfully added this neighborhood";
        },
        (error)=>{
          console.log(error);
          this.result="Server is busy, try later";
        }
      );
  }

  updateNeighb(id: number){
      let uNeighb = new Neighborhood(
        id,this.uNeighbName,this.uNeighbRating,this.uNeighbLoc,
        this.uPopsqm,this.uAvgprice,this.uHospital,this.uPow,
        this.uEducation,this.uGrocery,this.uTransit,this.uAirports,
        this.uHotels,this.uPubsrv,this.uCrmrate,this.uPovrate,this.uHomrate);
        console.log(uNeighb);
        this.neighb.updateNeighborhoods(uNeighb).subscribe(
          (response)=>{
            console.log(response);
            this.result="Successfully updated this neighborhood";
          },
          (error)=>{
            console.log(error);
            this.result="Server is busy, try later";
          }
        );
  }

  deleteNeighb(nId: number){
    console.log("delete nId: " +nId);
    this.neighb.deleteNeighborhoods(nId).subscribe(
      (response)=> {
        console.log("delete Neighb: "+response)
        this.result="Successfully deleted the neighborhood";
        this.neighb.getNeighborhoods();
      },
      (error)=> {
        console.log("delete Neighb: "+ error)
        this.result="Server is busy, try later";
      });
  }


  getNeighList(){
    this.uNeighbId=this.nList[this.count].neighbId;
    this.uNeighbName=this.nList[this.count].neighbName;
    this.uNeighbRating=this.nList[this.count].neighbRating;
    this.uNeighbLoc=this.nList[this.count].neighbLoc;
    this.uPopsqm=this.nList[this.count].popsqm;
    this.uAvgprice=this.nList[this.count].avgprice;
    this.uHospital=this.nList[this.count].hospital;
    this.uPow=this.nList[this.count].pow;
    this.uEducation=this.nList[this.count].education;
    this.uGrocery=this.nList[this.count].grocery;
    this.uTransit=this.nList[this.count].transit;
    this.uAirports=this.nList[this.count].airports;
    this.uHotels=this.nList[this.count].hotels;
    this.uPubsrv=this.nList[this.count].pubsrv;
    this.uCrmrate=this.nList[this.count].crmrate;
    this.uPovrate=this.nList[this.count].povrate;
    this.uHomrate=this.nList[this.count].homrate;
  }
   /**admin functions ends */

}
