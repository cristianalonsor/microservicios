import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Usuario } from 'src/app/models/usuario.model';
import { AppState } from '../../app.reducer';
import * as usuariosActions from '../../store/actions/index';
import { map } from 'rxjs';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
})
export class ListaComponent implements OnInit {

  usuarios: Usuario[] = [];
  page: number = 1;
  loading: boolean = false;
  error: any;

  constructor(
    // private usuarioService: UsuarioService
    private store: Store<AppState>
  ) { }

  ngOnInit(): void {

    //CON LOS EFECTOS EVITAMOS LLAMAR LOS SERVICIOS DIRECTAMENTE
    //DESDE LOS COMPONENTES Y DEJAMOS EL CÓDIGO MÁS LIMPIO
    // this.usuarioService.getUsers()
    //   .subscribe(usuarios => {
    //     console.log(usuarios);
    //     this.usuarios = usuarios;
    //   })
    //Hacemos el dispatch de la acción y ejecutamos el efecto
    this.store.dispatch( usuariosActions.cargarUsuarios() );
    
    //nos suscribimos al store y mediante la desestructuración del objeto obtenemos a los usuarios
    //sin ver otra propiedad del store
    this.store.select('usuarios')
      .subscribe( ( {users, loading, error} ) => {
        this.usuarios = users;
        this.loading = loading;
        this.error = error
      });
  }

  siguientePag(){
    this.page++;
    this.store.dispatch( usuariosActions.cargarUsuariosPage({page: this.page}) );
  }

  anteriorPag(){
    this.page--;
    this.store.dispatch( usuariosActions.cargarUsuariosPage({page: this.page}) );
  }

}
