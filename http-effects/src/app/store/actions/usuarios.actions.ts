import { createAction, props } from '@ngrx/store';
import { Usuario } from 'src/app/models/usuario.model';

//Efecto escucha esta acción y lo que se le solicita
export const cargarUsuarios = createAction('[Usuarios] Cargar Usuarios');
//Efecto intenta resolver la acción anterior y tiene dos alternativas

/**
 * Exitosa donde retorna la data sin errores y como se le solicita
 * Fallida donde no retorna data, pero si errores y mensaje para que los manejemos
 */
export const cargarUsuariosSuccess = createAction(
    '[Usuarios] Cargar Usuarios Success',
    props<{ usuarios: Usuario[] }>()
);

export const cargarUsuariosFailure = createAction(
    '[Usuarios] Cargar Usuarios Failure',
    props<{ payload: any }>()
);

export const cargarUsuariosPage = createAction(
    '[Usuarios] Cargar Usuarios Page',
    props<{ page: number }>()
);