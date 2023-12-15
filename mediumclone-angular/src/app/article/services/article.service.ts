import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { map, Observable } from 'rxjs';
import { ArticleRequestInterface } from '../../shared/types/articleRequest.interface';
import { ArticleInterface } from 'src/app/shared/types/articles.interface';
import { ArticlesResponseInterface } from '../../shared/types/articlesResponse';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  _URL: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  deleteArticle(slug: string): Observable<{}> {
    return this.http.delete(`${this._URL}/articles/${slug}`);
  }

  createArticle(articleRequest: ArticleRequestInterface): Observable<ArticleInterface> {
    console.log(articleRequest);
    
    return this.http.post<ArticlesResponseInterface>(`${this._URL}/articles`, articleRequest)
            .pipe( map( (response) => response.article ));
  }

  editArticle(slug: string, articleRequest: ArticleRequestInterface): Observable<ArticleInterface> {
    return this.http.put<ArticlesResponseInterface>(`${this._URL}/articles/${slug}`, articleRequest)
            .pipe( map( (response) => response.article ));
  }
}
