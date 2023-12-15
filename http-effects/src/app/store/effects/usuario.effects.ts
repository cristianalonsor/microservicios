import { inject, Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import * as usuarioActions from "../actions";
import { mergeMap, tap, map, catchError, of, switchMap } from 'rxjs';
import { UsuarioService } from "src/app/services/usuario.service";
import { Usuario } from "src/app/models/usuario.model";

//Servicio
@Injectable()
export class UsuarioEffects {

    constructor(private actions$: Actions,
        private usuariosService: UsuarioService) { }

    cargarUsuario$ = createEffect(

        () => this.actions$.pipe(
            ofType(usuarioActions.cargarUsuario),
            //En el switchMap(o mergeMap) tengo la acción y por ende la puedo desestructurar
            //para obtener la data que necesite para el uso del servicio
            switchMap(({ id }) => this.usuariosService.getUserById(id)
                .pipe(
                    tap(data => console.log('user data', data)),
                    map((usuario: Usuario) => {
                        return usuarioActions.cargarUsuarioSuccess({ usuario })
                    }),

                    catchError(error => {
                        return (of(usuarioActions.cargarUsuarioFailure({ payload: error })))
                    })
                ))
        )
    );
}