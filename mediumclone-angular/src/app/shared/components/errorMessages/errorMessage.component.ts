import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-errorMessage',
  template: '<div>{{message}}</div>',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink
  ]
})
export class ErrorMessageComponent {

  @Input() message: string = 'Algo salió mal'

}
