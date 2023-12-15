import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';

import { AppState } from '../../app.reducer';
import * as actions from '../../filtro/filtro.actions';
import { limpiarCompletados } from '../todo.action';

@Component({
  selector: 'app-todo-footer',
  templateUrl: './todo-footer.component.html'
})
export class TodoFooterComponent implements OnInit {

  filtroActual: actions.filtrosValidos = 'todos';
  filtros: actions.filtrosValidos[] = ['todos', 'pendientes', 'completados'];
  pentiendes: number = 0;

  constructor(private store: Store<AppState>) {

  }

  ngOnInit(): void {
    // this.store.select('filtro').subscribe((filtro: actions.filtrosValidos) => {
    //   this.filtroActual = filtro
    // });

    this.store.subscribe( state => {

      this.filtroActual = state.filtro;
      this.pentiendes = state.todos.filter( todo => todo.completado === false).length

    })
  }

  cambiarFiltro( filtro: actions.filtrosValidos ){
    console.log(filtro);
    this.store.dispatch( actions.setFiltro( {filtro} ) )
  }

  limpiarCompletos(){
    this.store.dispatch( limpiarCompletados() );
  }

}
