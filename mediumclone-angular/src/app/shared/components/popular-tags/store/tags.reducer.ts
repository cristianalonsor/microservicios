import { Action, createFeature, createReducer, on } from '@ngrx/store';
import { routerNavigationAction } from '@ngrx/router-store';
import { TagsStateInterface } from '../types/tagsState.interface.ts';
import { tagsActions } from './tags.actions';


export const initialState: TagsStateInterface = {
    isLoading: false,
    error: null,
    data: null
};


const tagsFeature = createFeature({
    name: 'Tags',
    reducer: createReducer(
        initialState,
        on(tagsActions.getTags, (state) => ({ ...state, isLoading: true })),
        on(tagsActions.getTagsSuccess, (state, action) => (
            {
                ...state,
                isLoading: false,
                data: action.tags,
            }
        )),
        on(tagsActions.getTagsFaiulure, (state) => (
            {
                ...state,
                isLoading: false,
            }
        )),
    )
});


export const {
    name: tagsFeatureKey,
    reducer: tagsReducer,
    selectIsLoading,
    selectError,
    selectData: selectTagsdata
} = tagsFeature;
