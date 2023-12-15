import { Routes } from '@angular/router';
import { provideEffects } from '@ngrx/effects';
import { provideState } from '@ngrx/store';
import { articleFeatureKey, articleReducer } from '../article/store/article.reducer';
import { ArticleService } from '../shared/services/article.service';
import { CreateArticleComponent } from './components/create-article/create-article.component';
import * as articleEffects from '../article/store/article.effect'

export const createArticleRoutes: Routes = [
    {
        path: '',
        component: CreateArticleComponent,
        providers: [
            provideEffects(articleEffects),
            provideState(articleFeatureKey, articleReducer),
            ArticleService
        ]
    }
]