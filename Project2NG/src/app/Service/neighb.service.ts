import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Review } from '../Models/Review';
import { Neighborhood } from '../Models/Neighborhood';


@Injectable({
  providedIn: 'root'
})
export class NeighbService {

  constructor(private http: HttpClient) { }

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  seeReviews(): Observable<Review[]> {
    return this.http.get<Review[]>("http://localhost:8080/reviews")
  }

  makeReviews(newreview: Review): Observable<Review> {
    console.log(newreview);
    return this.http.post<Review>("http://localhost:8080/reviews", newreview, { headers: this.headers })
  }

  getNeighborhoods(): Observable<Neighborhood[]> {
    return this.http.get<Neighborhood[]>("http://localhost:8080/neighborhoods")
  }

  deleteNeighborhoods(id: number): Observable<any> {
    return this.http.delete("http://localhost:8080/neighborhoods/" + id, { headers: this.headers });
  }
  updateNeighborhoods(change: Neighborhood): Observable<Neighborhood> {
    console.log("int the update method: " + change);
    return this.http.put<Neighborhood>("http://localhost:8080/neighborhoods", change, { headers: this.headers });
  }
  addNeighborhood(newNeighb: Neighborhood): Observable<Neighborhood> {
    console.log("this is new neighb: " + newNeighb);
    return this.http.post<Neighborhood>("http://localhost:8080/neighborhoods", newNeighb, { headers: this.headers });
  }

  getUserRating(userId: number): Observable<number> {
    return this.http.get<number>("http://localhost:8080/calcurating/" + userId);
  }
}
