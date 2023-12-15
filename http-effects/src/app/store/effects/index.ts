import { UsuariosEffects } from './usuarios.effects';
import { UsuarioEffects } from './usuario.effects';

//Centralizo los effects para realizar solo una exportacion
export const EffectsArray: any[] = [
    UsuarioEffects,
    UsuariosEffects,
];