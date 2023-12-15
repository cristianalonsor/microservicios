import { createReducer, on, createFeature } from '@ngrx/store';
import { SettingsStateInterface } from '../types/settingsState.interface';
import { authActions } from '../../auth/store/auth.action';
import { routerNavigationAction } from '@ngrx/router-store';

export const initialState: SettingsStateInterface = {
    isSubmitting: false,
    validationErrors: null
};


const settingsFeature = createFeature({
    name: 'Settings',
    reducer: createReducer(
        initialState,
        on(authActions.updateCurrentUser, (state) => ({ ...state, isSubmitting: true })),
        on(authActions.updateCurrentUserSuccess, (state) => (
            {
                ...state,
                isSubmitting: false
            }
        )),
        on(authActions.updateCurrentUserFailure, (state, action) => (
            {
                ...state,
                isSubmitting: false,
                validationErrors: action.errors
            }
        )),
        on( routerNavigationAction, () => initialState )
    )
});

export const {
    name: settingsFeatureKey,
    reducer: settingsReducer,
    selectIsSubmitting,
    selectValidationErrors
} = settingsFeature