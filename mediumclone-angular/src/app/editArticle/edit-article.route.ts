import { Routes } from '@angular/router';
import { provideEffects } from '@ngrx/effects';
import { provideState } from '@ngrx/store';
import { articleFeatureKey, articleReducer } from '../article/store/article.reducer';
import { ArticleService } from '../shared/services/article.service';
import { EditArticleComponent } from './components/edit-article/edit-article.component';
import * as articleEffects from '../article/store/article.effect'

export const editArticleRoutes: Routes = [
    {
        path: '',
        component: EditArticleComponent,
        providers: [
            provideEffects(articleEffects),
            provideState(articleFeatureKey, articleReducer),
            ArticleService
        ]
    }
]