import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterRequestInterface } from '../types/registerRequest.interface';
import { map, Observable } from 'rxjs';
import { CurrentUserInterface } from '../../shared/types/currentUser.interface';
import { AuthResponseInterface } from '../types/authResponse.interface';
import { environment } from '../../../environments/environment.development';
import { LoginRequestInterface } from '../types/loginRequest.interface';
import { CurrentUserRequestInterface } from '../../shared/types/currentUserRequest.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  _URL = environment.apiUrl

  constructor(private http: HttpClient) { }

  //Helper adicional para mapear la respuesta obtenida como el currentUser
  getUser(response: AuthResponseInterface): CurrentUserInterface {
    return response.user;
  }

  getCurrentUser(): Observable<CurrentUserInterface>{
    return this.http
      .get<AuthResponseInterface>(`${this._URL}/user`)
      .pipe(
        map(this.getUser)
      )
  }

  register(data: RegisterRequestInterface): Observable<CurrentUserInterface> {

    return this.http
      .post<AuthResponseInterface>(`${this._URL}/users`, data)
      .pipe(
        map(this.getUser)
      )

  }

  login(data: LoginRequestInterface): Observable<CurrentUserInterface> {

    return this.http
      .post<AuthResponseInterface>(`${this._URL}/users/login`, data)
      .pipe(
        map(this.getUser)
      )

  }

  updateCurrentUser(currentUser: CurrentUserRequestInterface): Observable<CurrentUserInterface> {

  return this.http
      .put<AuthResponseInterface>(`${this._URL}/user`, currentUser)
      .pipe(
        map(this.getUser)
      )

  }

}
