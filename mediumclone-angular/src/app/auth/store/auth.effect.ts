import { inject } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { catchError, map, of, switchMap, tap } from "rxjs";
import { AuthService } from "../services/auth.service";
import { authActions } from "./auth.action";
import { CurrentUserInterface } from '../../shared/types/currentUser.interface';
import { HttpErrorResponse } from "@angular/common/http";
import { PersistenceService } from "src/app/shared/services/persistence.service";
import { Router } from "@angular/router";


//Register Effects
export const registerEffect = createEffect(
    (actions$ = inject(Actions),
        authService = inject(AuthService),
        persistenceService = inject(PersistenceService),) => {

        return actions$.pipe(

            ofType(authActions.register),
            switchMap(({ request }) => {

                return authService.register(request).pipe(

                    map((currentUser: CurrentUserInterface) => {
                        persistenceService.set('accessToken', currentUser.token);
                        return authActions.registerSuccess({ currentUser });
                    }),
                    catchError((errors: HttpErrorResponse) => {
                        return of(authActions.registerFailure(errors.error));
                    })
                )
            })
        )
    },
    { functional: true }

)

export const redirectAfterRegisterEffect = createEffect(
    (actions$ = inject(Actions),
        router = inject(Router)) => {
        return actions$.pipe(
            ofType(authActions.registerSuccess),
            tap(() => {
                router.navigateByUrl('/')
            })
        )
    },
    {
        functional: true,
        dispatch: false
    }
)

//Login Effects
export const loginEffect = createEffect(
    (actions$ = inject(Actions),
        authService = inject(AuthService),
        persistenceService = inject(PersistenceService),) => {

        return actions$.pipe(

            ofType(authActions.login),
            switchMap(({ request }) => {

                return authService.login(request).pipe(

                    map((currentUser: CurrentUserInterface) => {
                        persistenceService.set('accessToken', currentUser.token);
                        return authActions.loginSuccess({ currentUser });
                    }),
                    catchError((errors: HttpErrorResponse) => {
                        return of(authActions.loginFailure(errors.error));
                    })
                )
            })
        )
    },
    { functional: true }

)

export const redirectAfterLoginEffect = createEffect(
    (actions$ = inject(Actions),
        router = inject(Router)) => {
        return actions$.pipe(
            ofType(authActions.loginSuccess),
            tap(() => {
                router.navigateByUrl('/')
            })
        )
    },
    {
        functional: true,
        dispatch: false
    }
)

//Get Current User Effects
export const getCurrentUserEffect = createEffect(
    (actions$ = inject(Actions),
        authService = inject(AuthService),
        persistenceService = inject(PersistenceService),) => {

        return actions$.pipe(

            ofType(authActions.getCurrentUser),
            switchMap(() => {
                if(!persistenceService.get('accessToken')){                    
                    return of(authActions.getCurrentUserFailure())
                }

                return authService.getCurrentUser().pipe(
                map((currentUser: CurrentUserInterface) => {
                    return authActions.getCurrentUserSuccess({ currentUser });
                }),
                catchError((errors: HttpErrorResponse) => {
                    return of(authActions.getCurrentUserFailure());
                })
            )
            })
        )
    },
    { functional: true }

)

//Update CurrentUser
export const updateCurrentUserEffect = createEffect(
    (actions$ = inject(Actions),
        authService = inject(AuthService),) => {

        return actions$.pipe(

            ofType(authActions.updateCurrentUser),
            switchMap(({ currentUser }) => {

                return authService.updateCurrentUser(currentUser).pipe(

                    map((currentUser: CurrentUserInterface) => {
                        return authActions.updateCurrentUserSuccess({ currentUser });
                    }),
                    catchError((errors: HttpErrorResponse) => {
                        return of(authActions.updateCurrentUserFailure({errors: errors.error}));
                    })
                )
            })
        )
    },
    { functional: true }

)

export const redirectAfterUpdateEffect = createEffect(
    (actions$ = inject(Actions),
        router = inject(Router)) => {
        return actions$.pipe(
            ofType(authActions.updateCurrentUserSuccess),
            tap(() => {
                router.navigateByUrl('/')
            })
        )
    },
    {
        functional: true,
        dispatch: false
    }
)

export const logoutEffect = createEffect(
    (actions$ = inject(Actions),
     router = inject(Router),
     persistenceService = inject(PersistenceService)) => {
        
        return actions$.pipe(

            ofType( authActions.logout ),
            tap( () => {
                persistenceService.set('accessToken', ''),
                router.navigateByUrl('/')
            } )
        )
     },
     {functional: true, dispatch: false}
)
