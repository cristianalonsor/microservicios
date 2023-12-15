import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Store } from '@ngrx/store';
import { selectarticleData, selectError, selectIsLoading } from '../../store/article.reducer';
import { articleActions } from '../../store/article.action';
import { combineLatest, filter, map } from 'rxjs';
import { selectCurrentUser } from 'src/app/auth/store/auth.reducer';
import { CurrentUserInterface } from '../../../shared/types/currentUser.interface';
import { LoadingComponent } from '../../../shared/components/loading/loading.component';
import { ErrorMessageComponent } from '../../../shared/components/errorMessages/errorMessage.component';
import { TagListComponent } from '../../../shared/components/tag-list/tag-list.component';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    LoadingComponent,
    ErrorMessageComponent,
    TagListComponent
  ]
})
export class ArticleComponent implements OnInit {

  //Observable de booleano para verificar el current user y el usuario de la publicación
  isAuthor$ = combineLatest({
    article: this.store.select(selectarticleData),
    currentUser: this.store.select(selectCurrentUser).pipe(
      filter((currentUser): currentUser is CurrentUserInterface | null =>
        currentUser !== undefined)
    )
  }).pipe(map(({ article, currentUser }) => {
    if (!article || !currentUser) {
      return false;
    }
    return article.author.username === currentUser.username
  }
  ));

  data$ = combineLatest({
    isLoading: this.store.select(selectIsLoading),
    error: this.store.select(selectError),
    article: this.store.select(selectarticleData),
    isAuthor: this.isAuthor$
  });

  slug = this.router.snapshot.paramMap.get('slug') ?? '';

  constructor(private router: ActivatedRoute,
    private store: Store) { }


  ngOnInit(): void {
    this.store.dispatch(articleActions.getArticle({ slug: this.slug }))
  }

  deleteArticle(): void {
    this.store.dispatch(articleActions.deleteArticle({ slug: this.slug }));
  }
}
