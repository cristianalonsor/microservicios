/**
 * INDICA COMO ESTÁ EL APP STATE GLOBAL DE LA APLICACIÓN
 */
import { ActionReducerMap } from "@ngrx/store";
import { Todo } from "./models/todo.model";
import { todoReducer } from "./todos/todo.reducer";
import { filtroReducer } from "./filtro/filtro.reducer";
import { filtrosValidos } from './filtro/filtro.actions';

export interface AppState {
    todos: Todo[],
    filtro: filtrosValidos
}


export const appReducers: ActionReducerMap<AppState> = {
    todos: todoReducer,
    filtro: filtroReducer
}

