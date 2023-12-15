import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { Observable } from 'rxjs';
import { getFeedResponseInterface } from '../types/getfeedRespnse.interface';

@Injectable({
  providedIn: 'root'
})
export class FeedService {

  _URL: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getFeed(url: string): Observable<getFeedResponseInterface>{
    return this.http.get<getFeedResponseInterface>(`${this._URL}${url}`)
  }
}
