import { createActionGroup, emptyProps, props } from '@ngrx/store';
import { UserProfileInterface } from '../types/userProfile.interface';


export const userProfileActions = createActionGroup({
    source: 'GetProfile',
    events: {
        'Get Profile': props<{ slug: string }>(),
        'Get Profile Success': props<{userProfile: UserProfileInterface}>(),
        'Get Profile Failure': emptyProps(),
    },
})