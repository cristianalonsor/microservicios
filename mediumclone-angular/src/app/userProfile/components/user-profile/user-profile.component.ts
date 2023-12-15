import { Component, computed, Inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, ActivatedRoute, Params, RouterLinkActive, Router } from '@angular/router';
import { LoadingComponent } from 'src/app/shared/components/loading/loading.component';
import { select, Store } from '@ngrx/store';
import { userProfileActions } from '../../store/user-profile.actions';
import { combineLatest, filter, map } from 'rxjs';
import { selectErrors, selectIsLoading, selectUserProfileData } from '../../store/user-profile.reducer';
import { selectCurrentUser } from 'src/app/auth/store/auth.reducer';
import { CurrentUserInterface } from '../../../shared/types/currentUser.interface';
import { UserProfileInterface } from '../../types/userProfile.interface';
import { FeedComponent } from '../../../shared/components/feed/feed.component';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  standalone: true,
  imports: [
    RouterLink,
    CommonModule,
    FeedComponent,
    RouterLinkActive,
    LoadingComponent,
  ]
})
export class UserProfileComponent implements OnInit {

  //Se pueden injectar así o en el constructor como siempre se ha echo
  route : ActivatedRoute   = Inject(ActivatedRoute);
  router: Router  = Inject(Router);
  store : Store   = Inject(Store)

  slug?: string = '';
  //Verifica si el usuario actual es el mismo que el del perfil que estamos viendo
  isCurrentUserProfile$ = combineLatest({
    currentUser: this.store.pipe(
      select(selectCurrentUser),
      filter((currentUser): currentUser is CurrentUserInterface => Boolean(currentUser))
    ),
    userProfile: this.store.pipe(
      select(selectUserProfileData),
      filter((userProfile): userProfile is UserProfileInterface => Boolean(userProfile))
    )
  }).pipe(map(({ currentUser, userProfile }) => { return currentUser.username === userProfile.username }))

  //Data que usaremos en el html
  data$ = combineLatest({
    isLoading: this.store.select(selectIsLoading),
    errors: this.store.select(selectErrors),
    data: this.store.select(selectUserProfileData),
    isCurrentUserProfile: this.isCurrentUserProfile$
  });

  // isLoading = this.store.selectSignal(selectIsLoading)
  // foo = computed(() => this.isLoading() ? 'true' : ' false')

 
  // constructor(private store: Store,
  //             private route: ActivatedRoute,
  //             private router: Router) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.slug = params['slug'];
      this.fetchUserProfile();
    })
  }

  fetchUserProfile() {
    this.store.dispatch(userProfileActions.getProfile({ slug: this.slug }))
  }

  getApiUrl(): string {
    const isFavorited = this.router.url.includes('favorites');
    return isFavorited ? `/articles?favorited=${this.slug}` : `/articles?author=${this.slug}`;
  }

}
