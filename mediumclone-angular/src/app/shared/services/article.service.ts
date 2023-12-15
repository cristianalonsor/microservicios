import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { Observable, map } from 'rxjs';
import { ArticlesResponseInterface } from '../types/articlesResponse';
import { ArticleInterface } from '../types/articles.interface';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  _URL: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getArticle(slug: string): Observable<ArticleInterface>{
    return this.http.get<ArticlesResponseInterface>(`${this._URL}/articles/${slug}`).pipe(
      map( response => response.article)
    )
  }
}
