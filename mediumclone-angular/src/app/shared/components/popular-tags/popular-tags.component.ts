import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, Router, ActivatedRoute, Params } from '@angular/router';
import { Store } from '@ngrx/store';
import { GetTagsInterface } from './types/getTags.interface';
import { tagsActions } from './store/tags.actions';
import { combineLatest } from 'rxjs';
import { selectError, selectIsLoading, selectTagsdata } from './store/tags.reducer';
import { LoadingComponent } from '../loading/loading.component';
import { ErrorMessageComponent } from '../errorMessages/errorMessage.component';

@Component({
  selector: 'app-popular-tags',
  templateUrl: './popular-tags.component.html',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    LoadingComponent,
    ErrorMessageComponent
  ]
})
export class PopularTagsComponent implements OnInit{

  data$ = combineLatest({
    isLoading: this.store.select(selectIsLoading),
    error : this.store.select(selectError),
    popularTags  : this.store.select(selectTagsdata)
  })

  constructor(private store: Store, private router: Router) {
    
  }

  ngOnInit(): void {
    this.store.dispatch( tagsActions.getTags() ); 
  }

  clickTag(tag: string) {
  }

}
