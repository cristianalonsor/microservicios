import { createAction, props, emptyProps } from '@ngrx/store';
import { IngresoEgreso } from '../../models/ingreso-egreso.model';



export const setItems = createAction(
    '[Ingreso Egreso] Set Items',
    props<{ items: IngresoEgreso[] }>()
);
export const unsetItems = createAction(
    '[Ingreso Egreso] Unset Items',
    emptyProps
);