import { HttpErrorResponse } from "@angular/common/http";
import { inject } from "@angular/core";
import { createEffect, Actions, ofType } from "@ngrx/effects";
import { switchMap, of, map, catchError } from "rxjs";
import { AddToFavoritesService } from "../services/add-to-favorites.service";
import { addToFavActions } from "./addToFav.actions";
import { ArticleInterface } from '../../../types/articles.interface';

export const getFeedEffect = createEffect(
    (actions$ = inject(Actions),
        addToFavService = inject(AddToFavoritesService),) => {

        return actions$.pipe(

            ofType(addToFavActions.addToFavArticle),
            switchMap(({ isFavorited, slug }) => {
                //dependiendo de si está o no como favorito, retorna el servicio que necesitemos
                const article$ = isFavorited ? addToFavService.removeFromFavorites(slug):
                                addToFavService.addToFavorites(slug);
                
                return article$.pipe(

                    map( (article: ArticleInterface) => {
                        return addToFavActions.addToFavArticleSuccess({article})
                    }),
                    catchError( () => {
                        return of(addToFavActions.addToFavArticleFailure());
                    } )
                )
            })
        )
    },
    { functional: true }

)