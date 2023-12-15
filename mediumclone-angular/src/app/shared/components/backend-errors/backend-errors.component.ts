import { Component, Input, OnInit } from '@angular/core';
import { BackendErrorInterface } from '../../types/backendErrors.interface';
import { CommonModule } from '@angular/common';

@Component({
  selector    : 'app-backend-errors',
  templateUrl : './backend-errors.component.html',
  standalone  : true,
  imports: [
    CommonModule
  ]
})
export class BackendErrorsComponent implements OnInit{
  
  @Input() backendError: BackendErrorInterface = {};
  errorMessages: string[] = [];


  ngOnInit(): void {
    this.errorMessages = Object.keys(this.backendError).map( (name: string) => {
      const message = this.backendError[name].join(' ')
      return `${name} ${message || ''}`
    })  
  }
}
