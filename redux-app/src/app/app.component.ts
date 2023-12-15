import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from './app.reducers';
import * as actions from './contador/contador.actions';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  contador!: number;
  // Store<tiene una estructura similar a lo que aparece en el module>
  constructor( private store: Store<AppState> ){

    // this.store.subscribe( state => {
    //   console.log(state);
    //   this.contador = state.contador
    // })

    this.store.select('contador').subscribe( contador => {
      console.log(contador);
      this.contador = contador
    })
  }

  incrementar() {
    //traemos la action desde el action file
    this.store.dispatch( actions.incrementar() )
  }

  decrementar() {
    this.store.dispatch( actions.decrementar() )
  }
}
