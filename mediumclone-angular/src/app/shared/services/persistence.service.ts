import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PersistenceService {

  constructor() { }

  set( key: string, data: unknown): void {
    try {
      localStorage.setItem(key, JSON.stringify(data));
    } catch (error) {
      console.error('Error al guardar en el local storage', error);
    }
  } 

  get(key: string): unknown {
    try {
      const localStorageItem = localStorage.getItem(key) ? 
                               JSON.parse(localStorage.getItem(key)):
                               null;
      return localStorageItem;
    } catch (error) {
      console.error('Error al obtener en el local storage', error);
      return null;
    }
  }


}
