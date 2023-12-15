import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { ArticleInterface } from 'src/app/shared/types/articles.interface';
import { environment } from '../../../../../environments/environment.development';
import { ArticlesResponseInterface } from '../../../types/articlesResponse';

@Injectable({
  providedIn: 'root'
})
export class AddToFavoritesService {

  _URL: string = environment.apiUrl;
  

  constructor(private http: HttpClient) { }

  addToFavorites( slug: string ): Observable<ArticleInterface> {
    const url = this.fullUrl(slug);
    return this.http.post<ArticlesResponseInterface>(url, {}).pipe(
      map( (response) => response.article)
    )
  }

  removeFromFavorites( slug: string ): Observable<ArticleInterface> {
    const url = this.fullUrl(slug);
    return this.http.delete<ArticlesResponseInterface>(url).pipe(
      map( (response) => response.article)
    )
  }

  fullUrl( slug: string ): string {
    return `${this._URL}/articles/${slug}/favorite`
  }
}
