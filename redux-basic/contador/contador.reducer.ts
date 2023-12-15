import { Action } from "../ngrx-fake/ngrx";

export const contadorReducer = (state = 10, action: Action)=>{
    
    switch ( action.type ) {
        case "INCREMENTAR":
            return state += 1;

        case "DECREMENTAR":
            return state -= 1;

        case "MULTIPLICAR":
            return state * action.payload;

        case "DIVIDIR":
            return action.payload != 0 ? state/action.payload : 0

        case "RESET":
            return state = 0;    

        default:
            return state;
    }
}