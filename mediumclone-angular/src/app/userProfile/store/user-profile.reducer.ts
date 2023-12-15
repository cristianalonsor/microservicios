import { UserProfileStateInterface } from '../types/userProfileState.interface';
import { createFeature, createReducer, on } from '@ngrx/store';
import { userProfileActions } from './user-profile.actions';
import { routerNavigationAction } from '@ngrx/router-store';

export const initialState: UserProfileStateInterface = {
    isLoading: false,
    data: null,
    errors: null
}

const userProfileFeature = createFeature({
    name: 'UserProfile',
    reducer: createReducer(
        initialState,
        on(userProfileActions.getProfile, (state) => ({ ...state, isLoading: true })),
        on(userProfileActions.getProfileSuccess, (state, action) => ({
            ...state,
            isLoading: false,
            data: action.userProfile
        })),
        on(userProfileActions.getProfileFailure, (state) => ({
            ...state,
            isLoading: false
        })),
        on(routerNavigationAction, () => initialState)
    )
});

export const {
    name: userProfileFeatureKey,
    reducer: userProfileReducer,
    selectIsLoading,
    selectErrors,
    selectData: selectUserProfileData,
} = userProfileFeature

