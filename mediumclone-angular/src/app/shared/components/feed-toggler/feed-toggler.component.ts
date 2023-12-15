import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { Store } from '@ngrx/store';
import { selectCurrentUser } from 'src/app/auth/store/auth.reducer';

@Component({
  selector: 'app-feed-toggler',
  templateUrl: './feed-toggler.component.html',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    RouterLinkActive,
  ]
})
export class FeedTogglerComponent implements OnInit {
  
  @Input() tagName: string;
  currentUser$ = this.store.select(selectCurrentUser)
  
  constructor(private store: Store) {}
  
  ngOnInit(): void {
  }


}
