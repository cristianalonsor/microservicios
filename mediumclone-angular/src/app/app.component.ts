
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Store } from '@ngrx/store';
import { authActions } from './auth/store/auth.action';
import { TopbarComponent } from './shared/components/topbar/topbar.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: true,
  imports: [
    RouterOutlet,
    TopbarComponent
  ]
})
export class AppComponent implements OnInit{
  
  constructor(private store: Store) {
    
  }


  ngOnInit(): void {
    this.store.dispatch(authActions.getCurrentUser())  
  }


}
