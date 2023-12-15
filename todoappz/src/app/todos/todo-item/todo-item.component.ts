import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { Todo } from '../../models/todo.model';
import { AppState } from '../../app.reducer';
import * as actions from '../todo.action';


@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html'
})
export class TodoItemComponent implements OnInit { 
  /**
   * Recibimos por referencia del padre al hijo el todo
   * para trabajarlo desde acá (el hijo)
   */
  @Input() todo: Todo;
  // relaciona el elemento al html
  @ViewChild('inputFisico') txtFisico: ElementRef;
  todoCopia : Todo;
  
  editando: boolean = false;
  chkCompletado: FormControl;
  txtInput     : FormControl;

  constructor(private store: Store<AppState>) {
  }
  
  ngOnInit(): void {
    this.todoCopia = {...this.todo};
    
    this.chkCompletado = new FormControl( this.todoCopia.completado );
    this.txtInput = new FormControl( this.todoCopia.texto, Validators.required );

    this.chkCompletado.valueChanges.subscribe( valor => {
      this.store.dispatch( actions.toggle({id: this.todoCopia.id}))
    })
  }

  editar(){
    this.editando = true;
    this.txtInput.setValue( this.todoCopia.texto )
    setTimeout(() => {
      // hacemos un focus pero seleccionando todo el texto
      // dentro del time out porque sino no se ejecuta correctamente en angular
      this.txtFisico.nativeElement.select();
    }, 1);
  }

  terminarEdicion(){
    this.editando = false;
    // Validamos para que se realice o no los cambios
    if(this.txtInput.invalid){ return; }
    if(this.txtInput.value === this.todoCopia.texto){ return; }
    // despues de las validaciones ejecutamos el action
    this.store.dispatch( actions.editar({
      id: this.todoCopia.id,
      texto: this.txtInput.value
    }))
  }

  borrar(){
    this.store.dispatch( actions.borrar({ id: this.todoCopia.id }))
  }
}
