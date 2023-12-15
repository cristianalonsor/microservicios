import { createFeature, createReducer, on } from '@ngrx/store';

import { routerNavigationAction } from '@ngrx/router-store';
import { ArticleStateInterface } from '../types/articleState.interface';
import { articleActions } from './article.action';



export const initialState: ArticleStateInterface = {
    isLoading: false,
    error: null,
    data: null,
    isSubmitting: false
};


const articleFeature = createFeature({
    name: 'Article',
    reducer: createReducer(
        initialState,
        //Get Articles
        on(routerNavigationAction, () => initialState),
        on(articleActions.getArticle, (state) => ({ ...state, isLoading: true })),
        on(articleActions.getArticleSuccess, (state, action) => (
            {
                ...state,
                isLoading: false,
                data: action.articles,
            }
        )),
        on(articleActions.getArticleFailure, (state) => (
            {
                ...state,
                isLoading: false,
            }
        )),
        //Create Article
        on(articleActions.createArticle, (state) => ({...state, isSubmitting: true})),
        on(articleActions.createArticleSuccess, (state, action) => ({
            ...state,
            isSubmitting: false
        })),
        on(articleActions.createArticleFailure, (state, action) => ({
            ...state,
            isSubmitting: false,
            error: action.errors
        })),
        //Editar Article
        on(articleActions.editArticle, (state) => ({...state, isSubmitting: true})),
        on(articleActions.editArticleSuccess, (state, action) => ({
            ...state,
            isSubmitting: false,
            data: action.article
        })),
        on(articleActions.editArticleFailure, (state, action) => ({
            ...state,
            isSubmitting: false,
            error: action.errors
        }))
    )
});


export const {
    name: articleFeatureKey,
    reducer: articleReducer,
    selectIsLoading,
    selectIsSubmitting,
    selectError,
    selectData: selectarticleData
} = articleFeature;
