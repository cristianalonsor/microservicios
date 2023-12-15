import { inject } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { catchError, map, of, switchMap } from "rxjs";
import { userProfileActions } from './user-profile.actions';
import { UserProfileInterface } from '../types/userProfile.interface';
import { UserProfileService } from '../service/user-profile.service';

export const getUserProfileEffect = createEffect(

    (actions$ = inject(Actions),
        userProfileService = inject(UserProfileService),) => {

        return actions$.pipe(

            ofType(userProfileActions.getProfile),
            switchMap(({ slug }) => {

                return userProfileService.getUserProfile(slug).pipe(

                    map( (userProfile: UserProfileInterface) => {
                        return userProfileActions.getProfileSuccess({userProfile})
                    } ),

                    catchError( () => {
                        return of(userProfileActions.getProfileFailure())
                    } )
                    
                )
            })
        )
    },
    { functional: true }
);


