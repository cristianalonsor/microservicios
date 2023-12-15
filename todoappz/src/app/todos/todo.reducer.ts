import { createReducer, on, Action } from '@ngrx/store';
import { Todo } from '../models/todo.model';
import { crear, toggle, editar, borrar, toggleAll, limpiarCompletados } from './todo.action';

export const estadoInicial: Todo[] = [
    new Todo("Estudiar Redux"),
    new Todo("Estudiar Angular"),
    new Todo("Estudiar Guidewire"),
    new Todo("Estudiar la Vida"),
];

export const _todoReducer = createReducer(
    estadoInicial,
    // Retorno un nuevo arreglo extrayendo los elementos del state independientemente
    // con el new Todo(texto) agrego el nuevo elemento al arreglo previniendo mutación del array
    // si fuera un primitivo se puede pasar directamente porque pasan por valor
    // los objetos pasan por referencia en JS y por eso no se pasan con un push
    on(crear, (state, { texto }) => [...state, new Todo(texto)]),
    on(borrar, (state, { id }) => state.filter(todo => todo.id !== id)),
    on(limpiarCompletados, (state) => state.filter( todo => !todo.completado)),
    
    on(toggle, (state, { id }) => {

        //Siempre regresar un nuevo state, no modificar el actual
        return state.map(todo => {
            if (todo.id === id) {
                return {
                    // traigo todos los todos, quedandome con completado para trabajar
                    // creamos un objeto nuevo en base al anterior, no alteramos ni mutamos el original
                    ...todo,
                    completado: !todo.completado
                };
            } else {
                return todo;
            }
        });
    }),

    on(editar, (state, { id, texto }) => {

        return state.map(todo => {
            if (todo.id === id) {
                return {
                    ...todo,
                    texto
                };
            } else {
                return todo;
            }
        })
    }),

    on(toggleAll, (state, { completado }) => {
        
        return state.map( todo => {
          return {
            ...todo,
            completado
          }  
        })
    })

);

export function todoReducer(state, action) {
    return _todoReducer(state, action)
}

