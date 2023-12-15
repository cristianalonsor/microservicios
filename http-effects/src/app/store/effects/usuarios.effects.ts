import { inject, Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import * as usuariosActions from "../actions";
import { mergeMap, tap, map, catchError, of } from 'rxjs';
import { UsuarioService } from "src/app/services/usuario.service";
import { Usuario } from "src/app/models/usuario.model";

//Servicio
@Injectable()
export class UsuariosEffects {

    // El $ es una notación de observable
    //Es un observable que está pendiente de todas las acciones que se disparan
    constructor(private actions$: Actions,
        private usuariosService: UsuarioService) { }

    cargarUsuarios$ = createEffect(

        //Necesita un callback (una funcion) que retorne un observable
        () => this.actions$.pipe(
            //Filtramos las acciones y especificamos la acción a escuchar
            ofType(usuariosActions.cargarUsuarios),

            //Tap-> rxjs operator que permite ejecutar alguna funcion
            tap(data => console.log('Effect tap ', data)),

            //Disparamos un nuevo observable que pedirá la info
            //1.- disparar el servicio que retorna la data
            //El switchMap sirve de igual forma
            mergeMap(() => this.usuariosService.getUsers()
                //Necesita retornar la acción que modificará el store ( de forma exitosa o fallida)
                .pipe(

                    tap(data => console.log('tap desd el getUsers ', data)),
                    //2.- recibimos la data y verifiamos si el resultado de la llamada al servicio es correcto o no
                    //los que vienen del servicio          lo que mando a la accion
                    map((usuarios: Usuario[]) => {
                        //3.1.- Si todo sale bien llamamos la accion exitosa, retornamos los usuarios y manipulamos el store
                        return usuariosActions.cargarUsuariosSuccess({ usuarios })
                    }),

                    catchError(errors => {
                        //3.2.- Si hay algún error en la llamada al servicio, manipulamos el store y enviamos los errores
                        return (of(usuariosActions.cargarUsuariosFailure({ payload: errors })))
                    })
                ))
        ),
        //configuraciones del efecto
        { dispatch: true }
    );

    cargarUsuariosPage$ = createEffect(
        () => this.actions$.pipe(
            ofType(usuariosActions.cargarUsuariosPage),
            mergeMap(({ page }) => this.usuariosService.getUsersPage(page)
                .pipe(
                    map((usuarios: Usuario[]) => {
                        return usuariosActions.cargarUsuariosSuccess({ usuarios })
                    }),

                    catchError(errors => {
                        return (of(usuariosActions.cargarUsuariosFailure({ payload: errors })))
                    })
                ))
        )
    );
}