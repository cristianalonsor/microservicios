import { HttpErrorResponse } from "@angular/common/http";
import { inject } from "@angular/core";
import { createEffect, Actions, ofType } from "@ngrx/effects";
import { switchMap, map, catchError, of } from "rxjs";
import { PopularTagsService } from "../services/popular-tags.service";
import { tagsActions } from "./tags.actions";

export const getFeedEffect = createEffect(
    (actions$ = inject(Actions),
        tagsService = inject(PopularTagsService),) => {

        return actions$.pipe(

            ofType(tagsActions.getTags),
            switchMap(()=>{
                return tagsService.getTags().pipe(
                    map((tags)=>{
                        return tagsActions.getTagsSuccess({tags});
                    }),
                    catchError((errors: HttpErrorResponse)=>{
                        return of(tagsActions.getTagsFaiulure());
                    })
                )
            })
        )
    },
    { functional: true }

)