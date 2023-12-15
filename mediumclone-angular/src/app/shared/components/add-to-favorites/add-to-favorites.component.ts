import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Store } from '@ngrx/store';
import { addToFavActions } from './store/addToFav.actions';

@Component({
  selector: 'app-add-to-favorites',
  templateUrl: './add-to-favorites.component.html',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink
  ]
})
export class AddToFavoritesComponent {

  @Input() isFavorited: boolean = false;
  @Input() favoritesCount: number = 0;
  @Input() articleSlug: string = '';

  constructor(private store: Store) {

  }

  handleLike(): void {    
    this.store.dispatch(
      addToFavActions.addToFavArticle(
        {
          slug: this.articleSlug,
          isFavorited: this.isFavorited
        }
      )
    )
    if (this.isFavorited) {
      this.favoritesCount = this.favoritesCount - 1;
    } else {
      this.favoritesCount = this.favoritesCount + 1;
    }

    this.isFavorited = !this.isFavorited;
  }

}
