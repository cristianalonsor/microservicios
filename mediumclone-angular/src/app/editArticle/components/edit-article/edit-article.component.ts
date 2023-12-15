import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ArticleFormComponent } from '../../../shared/components/article-form/article-form.component';
import { ArticleFormValuesInterface } from '../../../shared/components/article-form/types/articleFormValues.interface';
import { BackendErrorInterface } from '../../../shared/types/backendErrors.interface';
import { select, Store } from '@ngrx/store';
import { articleActions } from '../../../article/store/article.action';
import { combineLatest, filter, Observable, map } from 'rxjs';
import { selectarticleData, selectError, selectIsLoading, selectIsSubmitting } from 'src/app/article/store/article.reducer';
import { ArticleRequestInterface } from '../../../shared/types/articleRequest.interface';
import { LoadingComponent } from '../../../shared/components/loading/loading.component';
import { ErrorMessageComponent } from '../../../shared/components/errorMessages/errorMessage.component';
import { ArticleInterface } from '../../../shared/types/articles.interface';

@Component({
  selector: 'app-edit-article',
  templateUrl: './edit-article.component.html',
  standalone: true,
  imports: [
    RouterLink,
    CommonModule,
    LoadingComponent,
    ArticleFormComponent,
    ErrorMessageComponent
  ]
})
export class EditArticleComponent implements OnInit {

  initalValues$: Observable<ArticleFormValuesInterface> = this.store.pipe(
    select(selectarticleData),
    filter( (article): article is ArticleInterface => article !== null ),
    map( (article: ArticleInterface) =>{
      return {
        title: article.title,
        description: article.description,
        body: article.body,
        tagList: article.tagList
      }
    } )
  )

  isSubmitting: boolean = false;
  errors: BackendErrorInterface | null = null
  slug = this.route.snapshot.paramMap.get('slug') ?? '';
  data$ = combineLatest({
    isSumbitting: this.store.select(selectIsSubmitting),
    errors: this.store.select(selectError),
    initialValues: this.initalValues$,
    isLoading: this.store.select(selectIsLoading)
  })

  constructor(private store: Store,
              private route: ActivatedRoute) {}

  ngOnInit(): void {
    //LLENAR LA DATA ANTES DE MOSTRARLA PARA SU EDICIÓN
    this.store.dispatch( articleActions.getArticle({slug: this.slug}) )
  }

  onSubmit( articleFormValues: ArticleFormValuesInterface ) {

    const request: ArticleRequestInterface ={
      article: articleFormValues
    }

    this.store.dispatch( articleActions.editArticle({request, slug: this.slug}) )
  }

}
