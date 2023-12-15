import { Action, createReducer, on } from '@ngrx/store';
import { Usuario } from '../../models/usuario.model';
import * as actions from './../actions/usuarios.actions'

export interface UsuariosState {
    users: Usuario[],
    loaded: boolean
    loading: boolean,
    error: any,
    page?: number
}

const initialState: UsuariosState = {
    users: [],
    loaded: false,
    loading: false,
    error: null,
};


const _usuariosReducer = createReducer(
    initialState,
    on(actions.cargarUsuarios, (state) => ({ ...state, loading: true })),
    on(actions.cargarUsuariosPage, (state, actions) => ({ ...state, loading: true, page: actions.page })),
    on(actions.cargarUsuariosSuccess, (state, actions) => ({
        ...state,
        users   : [...actions.usuarios],
        loaded  : true,
        loading : false,
        error   : null,
    })),
    on(actions.cargarUsuariosFailure, (state, actions) => ({
        ...state,
        users   : [],
        loaded  : false,
        loading : false,
        error   : {
            status: actions.payload.status,
            url: actions.payload.url,
            name: actions.payload.name,
            message: actions.payload.message
        }
    }))
)


export function usuariosReducer(state: any, action: Action) {
    return _usuariosReducer(state, action)
}