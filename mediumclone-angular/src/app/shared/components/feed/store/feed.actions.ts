import { createActionGroup, props, emptyProps } from '@ngrx/store';
import { getFeedResponseInterface } from '../types/getfeedRespnse.interface';

export const feedActions = createActionGroup({
    source: 'Feed',
    events: {
        'Get Feed': props<{url: string}>(),
        'Get Feed Success': props<{feed: getFeedResponseInterface}>(),
        'Get Feed Failure': emptyProps(),
    }
});