import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FeedComponent } from 'src/app/shared/components/feed/feed.component';
import { BannerComponent } from '../../../shared/components/banner/banner.component';
import { PopularTagsComponent } from '../../../shared/components/popular-tags/popular-tags.component';
import { FeedTogglerComponent } from '../../../shared/components/feed-toggler/feed-toggler.component';

@Component({
  selector: 'app-your-feed',
  templateUrl: './your-feed.component.html',
  standalone: true,
  imports:[
    CommonModule,
    FeedComponent,
    BannerComponent,
    PopularTagsComponent,
    FeedTogglerComponent,
  ]
})
export class YourFeedComponent {

  apiUrl: string = '/articles';

}