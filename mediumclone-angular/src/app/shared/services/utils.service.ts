import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {

  constructor() { }

  range(start: number, end: number): number[]{
    return [...Array(end-start).keys()].map( x => x + 1);
  }
}
