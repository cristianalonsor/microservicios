import { BackendErrorInterface } from '../../shared/types/backendErrors.interface';

export interface EditArticleStateInterface {
    isSubmitting: boolean;
    validationErrors: BackendErrorInterface | null;
}