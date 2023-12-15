import { BackendErrorInterface } from '../../shared/types/backendErrors.interface'

export interface SettingsStateInterface {
    isSubmitting: boolean;
    validationErrors: BackendErrorInterface | null;
}