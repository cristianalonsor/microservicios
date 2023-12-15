import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { select, Store } from '@ngrx/store';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { combineLatest, filter, Subscription } from 'rxjs';
import { selectCurrentUser } from 'src/app/auth/store/auth.reducer';
import { CurrentUserInterface } from '../../shared/types/currentUser.interface';
import { selectIsSubmitting, selectValidationErrors } from '../store/settings.reducer';
import { BackendErrorsComponent } from 'src/app/shared/components/backend-errors/backend-errors.component';
import { LoadingComponent } from 'src/app/shared/components/loading/loading.component';
import { CurrentUserRequestInterface } from '../../shared/types/currentUserRequest.interface';
import { authActions } from '../../auth/store/auth.action';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  standalone: true,
  imports: [
    RouterLink,
    CommonModule,
    LoadingComponent,
    ReactiveFormsModule,
    BackendErrorsComponent,
  ]
})
export class SettingsComponent implements OnInit, OnDestroy{

  data$ = combineLatest({
    isSubmitting: this.store.select(selectIsSubmitting),
    backendErrors: this.store.select(selectValidationErrors)
  });
  currentUser?: CurrentUserInterface;
  form: FormGroup = this.fb.nonNullable.group({
    image: [''],
    username: ['', Validators.required],
    bio: ['', Validators.required],
    email: ['', Validators.required],
    password: ['', Validators.required]
  });
  currentUserSubscription?: Subscription;

  constructor(private store: Store,
              private fb: FormBuilder) {
    
  }

  ngOnInit(): void {
    this.currentUserSubscription = this.store.pipe(
      select( selectCurrentUser ),
      filter( Boolean )
    ).subscribe( currentUser => {      
      this.currentUser = currentUser;
      this.initializeForm();
    })
  }

  ngOnDestroy(): void {
    this.currentUserSubscription?.unsubscribe();
  }

  initializeForm() {
    console.log(this.currentUser);
    
    if( !this.currentUser ){
      throw new Error('Current User is not set');
    }

    this.form.patchValue({
      image: this.currentUser.image ?? '',
      username : this.currentUser.username,
      bio: this.currentUser.bio ?? '',
      email: this.currentUser.email,
      password: ''
    })
  }

  onSubmit() {
    if( !this.currentUser ){
      throw new Error('Current User is not set');
    }

    const currentUserRequest: CurrentUserRequestInterface = {

      user: {...this.form.getRawValue()}
    }  

    this.store.dispatch( authActions.updateCurrentUser({currentUser:currentUserRequest}) )
  }

  logout() {
    this.store.dispatch( authActions.logout() )    
  }

}
