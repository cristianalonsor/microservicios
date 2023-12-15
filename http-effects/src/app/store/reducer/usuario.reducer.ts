import { Action, createReducer, on } from '@ngrx/store';
import { Usuario } from '../../models/usuario.model';
import * as actions from './../actions/usuario.actions'

export interface UsuarioState {
    id: string | null,
    user: Usuario | null,
    loaded: boolean
    loading: boolean,
    error: any,
}

const initialState: UsuarioState = {
    id: null,
    user: null,
    loaded: false,
    loading: false,
    error: null,
};


const _usuarioReducer = createReducer(
    initialState,
    on(actions.cargarUsuario, (state, { id }) => ({
        ...state,
        id: id,
        loading: true
    })),
    on(actions.cargarUsuarioSuccess, (state, { usuario }) => ({
        ...state,
        user: { ...usuario },
        loaded: true,
        loading: false,
        error  : null,
    })),
    on(actions.cargarUsuarioFailure, (state, { payload }) => ({
        ...state,
        user: null,
        loaded: false,
        loading: false,
        error: {
            status: payload.status,
            url: payload.url,
            name: payload.name,
            message: payload.message
        }
    }))
)


export function usuarioReducer(state: any, action: Action) {
    return _usuarioReducer(state, action)
}