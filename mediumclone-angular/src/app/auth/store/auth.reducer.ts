import { state } from '@angular/animations';
import { routerNavigationAction } from '@ngrx/router-store';
import { createReducer, createFeature, on } from '@ngrx/store';
import { AuthStateInterface } from '../types/authState.interface';
import { authActions } from './auth.action';

const initialState: AuthStateInterface = {
  isSubmitting: false,
  isLoading: false,
  currentUser: undefined,
  validationErrors: null
}


const authFeature = createFeature({
  name: 'Auth',
  reducer: createReducer(
    initialState,

    //Register User
    on(authActions.register, (state) => (
      {
        ...state,
        isSubmitting: true,
        validationErrors: null
      }
    )),

    on(authActions.registerSuccess, (state, action) => (
      {
        ...state,
        isSubmitting: false,
        currentUser: action.currentUser
      }
    )),

    on(authActions.registerFailure, (state, action) => (
      {
        ...state,
        isSubmitting: false,
        validationErrors: action.errors
      }
    )),

    //Login User
    on(authActions.login, (state) => (
      {
        ...state,
        isSubmitting: true,
        validationErrors: null
      }
    )),

    on(authActions.loginSuccess, (state, action) => (
      {
        ...state,
        isSubmitting: false,
        currentUser: action.currentUser
      }
    )),

    on(authActions.loginFailure, (state, action) => (
      {
        ...state,
        isSubmitting: false,
        validationErrors: action.errors
      }
    )),

    //Get Current User
    on(authActions.getCurrentUser, (state) => (
      {
        ...state,
        isLoading: true,
        validationErrors: null
      }
    )),

    on(authActions.getCurrentUserSuccess, (state, action) => (
      {
        ...state,
        isLoading: false,
        currentUser: action.currentUser
      }
    )),

    on(authActions.getCurrentUserFailure, (state) => (
      {
        ...state,
        isLoading: false,
        currentUser: null
      }
    )),

    //Update Current User
    on(authActions.updateCurrentUserSuccess, (state, action) => (
      {
        ...state,
        isLoading: false,
        currentUser: action.currentUser
      }
    )),

    //Logout
    on(authActions.logout, (state, action) => (
      {
        ...state,
        ...initialState,
        currentUser: null
      }
    )),

    //Router
    on(routerNavigationAction, (state) => (
      {
        ...state,
        validationErrors: null
      }
    )),

  )
})

export const {
  name: authFeatureKey,
  reducer: authReducer,
  selectIsLoading,
  selectCurrentUser,
  selectIsSubmitting,
  selectValidationErrors
} = authFeature