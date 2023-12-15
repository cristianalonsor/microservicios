import { HttpErrorResponse } from "@angular/common/http";
import { inject } from "@angular/core";
import { createEffect, Actions, ofType } from "@ngrx/effects";
import { switchMap, of, map, catchError } from "rxjs";

import { FeedService } from "../services/feed.service";
import { getFeedResponseInterface } from "../types/getfeedRespnse.interface";
import { feedActions } from "./feed.actions";

export const getFeedEffect = createEffect(
    (actions$ = inject(Actions),
        feedService = inject(FeedService),) => {

        return actions$.pipe(

            ofType(feedActions.getFeed),
            switchMap(({ url }) => {

                return feedService.getFeed(url).pipe(

                    map((feed: getFeedResponseInterface) => {
                        return feedActions.getFeedSuccess({ feed });
                    }),

                    catchError((errors: HttpErrorResponse) => {
                        return of(feedActions.getFeedFailure());
                    })
                )
            })
        )
    },
    { functional: true }

)