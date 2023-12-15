import { createActionGroup, emptyProps, props } from '@ngrx/store';
import { CurrentUserInterface } from 'src/app/shared/types/currentUser.interface';
import { RegisterRequestInterface } from '../types/registerRequest.interface';
import { BackendErrorInterface } from '../../shared/types/backendErrors.interface';
import { LoginRequestInterface } from '../types/loginRequest.interface';
import { CurrentUserRequestInterface } from '../../shared/types/currentUserRequest.interface';

//Forma resumida de crear más de una acción que se relacionan
export const authActions = createActionGroup({
    source: 'Auth',
    events: {
        'Register': props<{ request: RegisterRequestInterface }>(),
        'Register Success': props<{ currentUser: CurrentUserInterface }>(),
        'Register Failure': props<{ errors: BackendErrorInterface }>(),

        'Login': props<{ request: LoginRequestInterface }>(),
        'Login Success': props<{ currentUser: CurrentUserInterface }>(),
        'Login Failure': props<{ errors: BackendErrorInterface }>(),

        'Get Current User': emptyProps(),
        'Get Current User Success': props<{ currentUser: CurrentUserInterface }>(),
        'Get Current User Failure': emptyProps(),

        'Update Current User': props<{ currentUser: CurrentUserRequestInterface }>(),
        'Update Current User Success': props<{ currentUser: CurrentUserInterface }>(),
        'Update Current User Failure': props<{ errors: BackendErrorInterface }>(),

        'Logout': emptyProps(),
    },
})

// export const register = createAction(
//     '[Auth] Register',
//     props<{ request: RegisterRequestInterface }>()
// );

// export const registerSuccess = createAction(
//     '[Auth] Register',
//     props<{ request: RegisterRequestInterface }>()
// );

// export const registerFailure = createAction(
//     '[Auth] Register',
//     props<{ request: RegisterRequestInterface }>()
// );
