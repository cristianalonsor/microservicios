import { createAction, createActionGroup, emptyProps, props } from '@ngrx/store';
import { GetTagsInterface } from '../types/getTags.interface';



export const tagsActions = createActionGroup({
    source: 'Tags',
    events: {
        'Get Tags': emptyProps(),
        'Get Tags Success': props<{tags: GetTagsInterface}>(),
        'Get Tags Faiulure': emptyProps(),
    }
})