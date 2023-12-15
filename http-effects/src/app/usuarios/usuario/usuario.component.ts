import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Store } from '@ngrx/store';
import { Subscription } from 'rxjs';
import { AppState } from '../../app.reducer';
import * as usuarioAction from '../../store/actions/index'
import { Usuario } from '../../models/usuario.model';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
})
export class UsuarioComponent implements OnInit, OnDestroy {

  usuarioSubscription!: Subscription;
  usuario : Usuario | null = null;
  loading : boolean = false;
  error   : any;

  constructor(private store: Store<AppState>,
    private router: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.usuarioSubscription = this.store.select('usuario')
      .subscribe(({ user, loading, error }) => {
        this.usuario = user;
        this.loading = loading;
        this.error = error;
      })

    this.router.params.subscribe(
      ({ id }) => {
        this.store.dispatch(usuarioAction.cargarUsuario({ id }))
      }
    )
  }

  ngOnDestroy(): void {
    this.usuarioSubscription.unsubscribe();
  }

}
