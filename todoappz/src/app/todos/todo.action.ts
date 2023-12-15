import { createAction, props } from '@ngrx/store';

export const crear = createAction(
    '[TODO] Crear Todo',
    props<{texto: string}>()
);

// Cambia el estado del TODO de false to true y true to false
export const toggle = createAction(
    '[TODO] Toggle Todo',
    props<{ id: number }>()
)

// Guardamos el nuevo texto al terminar la edición
export const editar = createAction(
    '[TODO] Editar Todo',
    props<{id: number, texto: string}>()
)

// Eliminamos un TODO según su ID
export const borrar = createAction(
    '[TODO] Borrar Todo',
    props<{ id: number }>()
)

// Establecer todos los todos que tenga a true o false según lo que mande
export const toggleAll = createAction(
    '[TODO] Toggle All Todo',
    props<{ completado: boolean }>()
)

// Limpiar todos los completados
export const limpiarCompletados = createAction('[TODO] Limpiar Completados');