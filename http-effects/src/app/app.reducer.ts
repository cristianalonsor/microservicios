import { ActionReducerMap, createReducer, on } from '@ngrx/store';
import * as reducers from './store/reducer/index';

//App Reducer global mediante el cual seleccionaré posteriormente
export interface AppState {
  usuarios: reducers.UsuariosState,
  usuario : reducers.UsuarioState,
}

export const appReducer: ActionReducerMap<AppState> = {
  usuario : reducers.usuarioReducer,
  usuarios: reducers.usuariosReducer,
}