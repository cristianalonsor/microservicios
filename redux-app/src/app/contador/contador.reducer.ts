import { Action, createReducer, on } from "@ngrx/store";
import { decrementar, incrementar, multiplicar, dividir, reset } from './contador.actions';

// export function contadorReducer( state: number = 10, action: Action ) {
//     switch (action.type) {
//         case incrementar.type:
//             return state + 1;
//         case decrementar.type:
//             return state - 1;
//         default:
//             return state;
//     }
// }

export const initialState = 20;

const _contadorReducer = createReducer(
    initialState,
    /**
     * funcion que trabaja con el create reducer que permite 
     * seleccionar rapidamente la accion en cuestion
    **/
    on(incrementar, state => state + 1),
    on(decrementar, state => state - 1),
    on(reset, state => initialState),
    on(multiplicar, ( state, { numero } ) => state * numero),
    on(dividir    , ( state, { numero } ) => state / numero),
);

export function contadorReducer( state: number | undefined, action: Action ) {
    return _contadorReducer( state, action )
}
