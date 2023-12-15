import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { selectCurrentUser } from 'src/app/auth/store/auth.reducer';
import { combineLatest } from 'rxjs';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  standalone: true,
  imports   : [
    CommonModule,
    RouterLink
  ]
})
export class TopbarComponent {

  data$ = combineLatest({
    currentUser: this.store.select(selectCurrentUser)
  })


  constructor(private store: Store) {}

}
