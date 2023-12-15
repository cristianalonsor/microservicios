import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Todo } from '../../models/todo.model';
import { AppState } from '../../app.reducer';
import { filtrosValidos } from 'src/app/filtro/filtro.actions';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',

})
export class TodoListComponent implements OnInit {

  todos: Todo[] = [];
  filtroActual: filtrosValidos;

  constructor(private store: Store<AppState> ) {

  }

  ngOnInit(): void {
    
    /**
     * buscamos desde el store lo que necesitamos o sea 'todos'
     * y se lo asignamos a nuestro arreglo de todos que está en este componente
     */
    // this.store.select('todos')
    // .subscribe( todos => { this.todos = todos })
    this.store.subscribe( ({ todos, filtro}) => {
      // nos suscribimos y utilizamos los valores del state para las operaciones
      // necesarias, en este caso para el pipe y obtener los TODOS
      this.todos = todos;
      this.filtroActual = filtro;
    })
  }

}
