import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { PopularTagsType } from '../../types/popularTag.type';

@Component({
  selector: 'app-tag-list',
  templateUrl: './tag-list.component.html',
  standalone: true,
  imports:[
    CommonModule,
    RouterLink
  ]
})
export class TagListComponent {

  @Input() tags: PopularTagsType[] = [];

}
