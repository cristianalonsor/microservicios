import { CommonModule } from '@angular/common';
import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Store } from '@ngrx/store';
import { feedActions } from './store/feed.actions';
import { combineLatest } from 'rxjs';
import { selectError, selectFeedData, selectIsLoading } from './store/feed.reducer';
import { RouterLink, Router, ActivatedRoute, Params } from '@angular/router';
import { ErrorMessageComponent } from '../errorMessages/errorMessage.component';
import { LoadingComponent } from '../loading/loading.component';
import { PaginationComponent } from '../pagination/pagination.component';
import { environment } from '../../../../environments/environment.development';
import queryString from 'query-string'
import { TagListComponent } from '../tag-list/tag-list.component';
import { AddToFavoritesComponent } from '../add-to-favorites/add-to-favorites.component';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    TagListComponent,
    LoadingComponent,
    PaginationComponent,
    ErrorMessageComponent,
    AddToFavoritesComponent,
  ]
})
export class FeedComponent implements OnInit, OnChanges{
  
  @Input() apiUrl: string = '';
  limit: number = environment.limit;
  baseUrl: string = this.router.url.split('?')[0];
  currentPage: number = 0
  isApiURLChanged;

  data$ = combineLatest({
    isLoading: this.store.select(selectIsLoading),
    error: this.store.select(selectError),
    feed: this.store.select(selectFeedData),
  })
  
  constructor(private store: Store,
              private router: Router,
              private route: ActivatedRoute) {
    
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe( (params: Params) => {      
      //extraemos de los params el page y lo transformamos a numero      
      this.currentPage = Number(params['page'] || 1);
      this.fetchFeed();
    })    
  }
  
  ngOnChanges(changes: SimpleChanges): void {
    
    this.isApiURLChanged = !changes['apiUrl'].firstChange &&
                            changes['apiUrl'].currentValue !== changes['apiUrl'].previousValue
    
    if(this.isApiURLChanged){
      this.fetchFeed()
    }
  }

  fetchFeed(): void {
    // const offset = this.currentPage * this.limit
    const parsedUrl = queryString.parseUrl(this.apiUrl)
    const stringifiedParams = queryString.stringify({
      limit: this.limit,
      // offset,
      ...parsedUrl.query,
    })
    
    const apiUrlWithParams = `${parsedUrl.url}?${stringifiedParams}`
    
    this.store.dispatch( feedActions.getFeed({url: apiUrlWithParams}));

    
  }


}
