import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { GetTagsInterface } from '../types/getTags.interface';
import { environment } from '../../../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class PopularTagsService {

  _URL: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getTags(): Observable<GetTagsInterface>{
    return this.http.get<GetTagsInterface>(`${this._URL}/tags`);
  }
}
