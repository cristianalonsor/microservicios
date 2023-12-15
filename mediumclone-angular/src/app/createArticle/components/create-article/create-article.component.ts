import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ArticleFormComponent } from '../../../shared/components/article-form/article-form.component';
import { ArticleFormValuesInterface } from '../../../shared/components/article-form/types/articleFormValues.interface';
import { BackendErrorInterface } from '../../../shared/types/backendErrors.interface';
import { Store } from '@ngrx/store';
import { articleActions } from '../../../article/store/article.action';
import { combineLatest } from 'rxjs';
import { selectError, selectIsLoading, selectIsSubmitting } from 'src/app/article/store/article.reducer';
import { ArticleRequestInterface } from '../../../shared/types/articleRequest.interface';
import { LoadingComponent } from '../../../shared/components/loading/loading.component';
import { ErrorMessageComponent } from '../../../shared/components/errorMessages/errorMessage.component';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  standalone: true,
  imports: [
    RouterLink,
    CommonModule,
    LoadingComponent,
    ArticleFormComponent,
    ErrorMessageComponent
  ]
})
export class CreateArticleComponent {

  initialValues: ArticleFormValuesInterface = {
    title: '',
    description: '',
    body: '',
    tagList: []
  };
  isSubmitting: boolean = false;
  errors: BackendErrorInterface | null = null

  data$ = combineLatest({
    isSumbitting: this.store.select(selectIsSubmitting),
    errors: this.store.select(selectError)
  })

  constructor(private store: Store) {}

  onSubmit( articleFormValues: ArticleFormValuesInterface ) {

    const request: ArticleRequestInterface ={
      article: articleFormValues
    }
    this.store.dispatch( articleActions.createArticle({request}) )
  }

}
