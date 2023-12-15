import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment.development';
import { map, Observable, tap } from 'rxjs';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private _url: string = environment._URL;

  constructor(private http: HttpClient) { }

  getUsers(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this._url}/users?delay=2`)
      .pipe(
        // return resp.data;
        map((resp: any) => resp['data'])
      );
  }

  getUsersPage(page: number): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this._url}/users?page=${page}`)
      .pipe(
        map((resp: any) => resp['data'])
      );
  }

  getUserById(id: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this._url}/users/${id}?delay=2`)
      .pipe(
        map((resp: any) => resp['data'])
      );
  }
}
