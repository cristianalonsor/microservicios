import { Component, OnInit, } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Store } from "@ngrx/store";
import * as actions from '../../store/auth.action';
import { RegisterRequestInterface } from '../../types/registerRequest.interface';
import { AuthStateInterface } from '../../types/authState.interface';
import { CommonModule } from '@angular/common';
import { selectIsSubmitting, selectValidationErrors } from '../../store/auth.reducer';
import { combineLatest } from 'rxjs';
import { BackendErrorsComponent } from 'src/app/shared/components/backend-errors/backend-errors.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  standalone: true,
  imports:[
    ReactiveFormsModule,
    RouterLink,
    CommonModule,
    BackendErrorsComponent
  ]
})
export class RegisterComponent implements OnInit {

  form = this.fb.nonNullable.group({
    userName: ['', Validators.required],
    email   : ['', Validators.required],
    password: ['', Validators.required],
  })
  // para evitar crear observables de cada propiedad podemos resumerlo con un combineLatest()
  // isSubmitting$ = this.store.select(selectIsSubmitting);
  // backendErrors$ = this.store.select(selectValidationErrors);

  data$ = combineLatest({
    isSubmitting: this.store.select(selectIsSubmitting),
    backendErrors: this.store.select(selectValidationErrors)
  })

  constructor(private fb: FormBuilder,
              private store: Store<{auth: AuthStateInterface}>) {
    
  }
  ngOnInit(): void {
  }
  
  onSubmit(){
    console.log(this.form.getRawValue());
    const req: RegisterRequestInterface = {
      user: {
        username: this.form.getRawValue().userName,
        password: this.form.getRawValue().password,
        email   : this.form.getRawValue().email
      }
    }    
    this.store.dispatch( actions.authActions.register({ request: req }))
  }

}
