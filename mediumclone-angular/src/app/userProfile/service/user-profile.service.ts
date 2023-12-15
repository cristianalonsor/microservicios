import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { UserProfileInterface } from '../types/userProfile.interface';
import { environment } from '../../../environments/environment.development';
import { GetUserProfileResponseInterface } from '../types/getUserProfileResponse.interface';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  _URL: string = environment.apiUrl;

  constructor(private http: HttpClient) { }


  getUserProfile( slug: string ): Observable<UserProfileInterface> {

    return this.http.get<GetUserProfileResponseInterface>(`${this._URL}/profiles/${slug}`).pipe(
      map( (response) => response.profile )
    );

  }
}
