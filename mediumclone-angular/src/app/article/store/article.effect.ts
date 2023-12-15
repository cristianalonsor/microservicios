import { HttpErrorResponse } from "@angular/common/http";
import { inject } from "@angular/core";
import { createEffect, Actions, ofType } from "@ngrx/effects";
import { switchMap, of, map, catchError, tap } from 'rxjs';
import { ArticleService } from '../../shared/services/article.service';
import { articleActions } from './article.action';
import { ArticleInterface } from "src/app/shared/types/articles.interface";
import { ArticleService as service } from "../services/article.service";
import { Router } from '@angular/router';



export const getArticleEffect = createEffect(
    (actions$ = inject(Actions),
        articleService = inject(ArticleService),) => {

        return actions$.pipe(

            ofType(articleActions.getArticle),
            switchMap(({ slug }) => {

                return articleService.getArticle(slug).pipe(

                    map((articles: ArticleInterface) => {
                        return articleActions.getArticleSuccess({ articles });
                    }),

                    catchError((errors: HttpErrorResponse) => {
                        return of(articleActions.getArticleFailure());
                    })
                )
            })
        )
    },
    { functional: true }

);

export const deleteArticleEffect = createEffect(
    (actions$ = inject(Actions),
        articleService = inject(service),) => {

        return actions$.pipe(

            ofType(articleActions.deleteArticle),
            switchMap(({ slug }) => {

                return articleService.deleteArticle(slug).pipe(

                    map((articles: ArticleInterface) => {
                        return articleActions.deleteArticleSuccess();
                    }),

                    catchError((errors: HttpErrorResponse) => {
                        return of(articleActions.deleteArticleFailure());
                    })
                )
            })
        )
    },
    { functional: true }

);

export const createArticleEffect = createEffect(
    (actions$ = inject(Actions),
        articleService = inject(service),) => {

        return actions$.pipe(

            ofType(articleActions.createArticle),
            switchMap(({ request }) => {

                return articleService.createArticle(request).pipe(

                    map((article: ArticleInterface) => {
                        console.log(article);
                        
                        return articleActions.createArticleSuccess( {article} );
                    }),

                    catchError((errors: HttpErrorResponse) => {
                        return of(articleActions.createArticleFailure({ errors: errors.error }));
                    })
                )
            })
        )
    },
    { functional: true }

);

export const editArticleEffect = createEffect(
    (actions$ = inject(Actions),
        articleService = inject(service),) => {

        return actions$.pipe(

            ofType(articleActions.editArticle),
            switchMap(({ request, slug }) => {

                return articleService.editArticle(slug, request).pipe(

                    map((article: ArticleInterface) => {
                        return articleActions.editArticleSuccess( {article} );
                    }),

                    catchError((errors: HttpErrorResponse) => {
                        return of(articleActions.editArticleFailure({ errors: errors.error }));
                    })
                )
            })
        )
    },
    { functional: true }

);


//REDIRECT
export const redirectAfterDeleteEffect = createEffect(
    (actions$ = inject(Actions), router = inject(Router)) => {
        return actions$.pipe(
            ofType(articleActions.deleteArticleSuccess),
            tap(() => {
                router.navigateByUrl('/')
            })
        )
    },
    { functional: true, dispatch: false }
)

export const redirectAfterCreateEffect = createEffect(
    (actions$ = inject(Actions), router = inject(Router)) => {
        return actions$.pipe(
            ofType(articleActions.createArticleSuccess),
            tap(({article}) => {
                router.navigate(['/articles', article.slug])
            })
        )
    },
    { functional: true, dispatch: false }
)

export const redirectAfterEditEffect = createEffect(
    (actions$ = inject(Actions), router = inject(Router)) => {
        return actions$.pipe(
            ofType(articleActions.editArticleSuccess),
            tap(({article}) => {
                router.navigate(['/articles', article.slug])
            })
        )
    },
    { functional: true, dispatch: false }
)