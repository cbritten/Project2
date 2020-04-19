import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recommendations } from '../Models/Recommendations';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {

  constructor(private http :HttpClient ) {}

  private headers = new HttpHeaders({'Content-Type':'application/json'});

  createRecommendation(newrec: Recommendations): Observable<Recommendations> {
    return this.http.post<Recommendations>("http://localhost:8080/Recommendations", newrec, { headers: this.headers });
  }
}
