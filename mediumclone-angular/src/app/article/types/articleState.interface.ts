import { ArticleInterface } from 'src/app/shared/types/articles.interface';
import { BackendErrorInterface } from '../../shared/types/backendErrors.interface';

export interface ArticleStateInterface {
    isLoading: boolean;
    error: string | BackendErrorInterface | null;
    data: ArticleInterface | null;
    isSubmitting: boolean;
}