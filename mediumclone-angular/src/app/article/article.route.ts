
import { Routes } from '@angular/router';
import { ArticleComponent } from './components/article/article.component'
import { provideEffects } from '@ngrx/effects';
import * as articleEffects from "./store/article.effect";
import { provideState } from '@ngrx/store';
import { articleFeatureKey, articleReducer } from './store/article.reducer';
import { ArticleService } from '../shared/services/article.service';

export const articleRoutes: Routes = [
    {
        path: '',
        component: ArticleComponent,
        providers: [
            provideEffects(articleEffects),
            provideState(articleFeatureKey, articleReducer),
            ArticleService
        ]
    }
]