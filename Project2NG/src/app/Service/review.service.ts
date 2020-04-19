import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../Models/Review';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Comm } from '../Models/Comm';
import { P2user } from '../Models/User';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) { }


  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllReviews(neighbId: Number): Observable<Review[]> {
    return this.http.get<Review[]>('http://localhost:8080/reviews/' + neighbId);
  }
  createnewReview(newreview: Review, neighbId: Number, userId: Number): Observable<Review> {
    return this.http.post<Review>("http://localhost:8080/reviews/" + neighbId + "/" + userId, newreview, { headers: this.headers });

  }
  getReviewComments(rev_id): Observable<Comm[]> {
    return this.http.get<Comm[]>('http://localhost:8080/comments/' + rev_id);
  }
  makeComment(newcmnt: Comm, rev_id: Number): Observable<Comm> {
    return this.http.post<Comm>("http://localhost:8080/comments/" + rev_id, newcmnt, { headers: this.headers })
  }

  getAllRev(): Observable<Review[]> {
    return this.http.get<Review[]>("http://localhost:8080/reviews");
  }
  deleteReview(revId: number): Observable<any> {
    return this.http.delete("http://localhost:8080/reviews/" + revId, { headers: this.headers });
  }

  addTUp(updatereview:Review){
    return this.http.put<Review>("http://localhost:8080/reviews",updatereview, {headers:this.headers});
  }
  getRevbyId(revId:number){
    return this.http.get<Review>("http://localhost:8080/getreviewbyid/"+revId);
  }
  getRevbyUser(userId:number){
    return this.http.get<Review[]>("http://localhost:8080/reviewsbyuserid/"+userId);
  }
  UpdateURating(updateduser:P2user){
    return this.http.put<P2user>("http://localhost:8080/users",updateduser,{headers:this.headers});
  }
  getUserbyUserId(userId:number){
    return this.http.get<P2user>("http://localhost:8080/users/"+userId);
  }
  getallUsers(){
    return this.http.get<P2user[]>("http://localhost:8080/users");
  }
}
