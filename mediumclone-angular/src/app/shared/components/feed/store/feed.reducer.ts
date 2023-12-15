import { Action, createFeature, createReducer, on } from '@ngrx/store';
import { FeedStateInterface } from '../types/feedState.interface';
import { feedActions } from './feed.actions';
import { routerNavigationAction } from '@ngrx/router-store';


export const initialState: FeedStateInterface = {
    isLoading: false,
    error: null,
    data: null
};


const feedFeature = createFeature({
    name: 'Feed',
    reducer: createReducer(
        initialState,
        on(routerNavigationAction, () => initialState),
        on(feedActions.getFeed, (state) => ({ ...state, isLoading: true })),
        on(feedActions.getFeedSuccess, (state, action) => (
            {
                ...state,
                isLoading: false,
                data: action.feed,
            }
        )),
        on(feedActions.getFeedFailure, (state) => (
            {
                ...state,
                isLoading: false,
            }
        )),
    )
});


export const {
    name: feedFeatureKey,
    reducer: feedReducer,
    selectIsLoading,
    selectError,
    selectData: selectFeedData
} = feedFeature;
