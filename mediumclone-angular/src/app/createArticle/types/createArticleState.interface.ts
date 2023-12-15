import { BackendErrorInterface } from '../../shared/types/backendErrors.interface';

export interface CreateArticleStateInterface {
    isSubmitting: boolean;
    validationErrors: BackendErrorInterface | null;
}