import { Routes } from '@angular/router';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { UserProfileService } from './service/user-profile.service';
import { provideState } from '@ngrx/store';
import { userProfileFeatureKey, userProfileReducer } from './store/user-profile.reducer';
import { provideEffects } from '@ngrx/effects';
import * as userProfileEffects from './store/user-profile.effects'

export const userProfileRoutes: Routes = [
  {
    path: '',
    component: UserProfileComponent,
    providers: [
      UserProfileService,
      provideState( userProfileFeatureKey, userProfileReducer),
      provideEffects( userProfileEffects )
    ]
  }
]
