import { createActionGroup, emptyProps, props } from '@ngrx/store';
import { ArticleInterface } from 'src/app/shared/types/articles.interface';
import { ArticleRequestInterface } from '../../shared/types/articleRequest.interface';
import { BackendErrorInterface } from '../../shared/types/backendErrors.interface';




export const articleActions = createActionGroup({
    source: 'Article',
    events: {
        'Get Article': props<{slug: string}>(),
        'Get Article Success': props<{articles: ArticleInterface}>(),
        'Get Article Failure': emptyProps(),

        'Delete Article': props<{slug: string}>(),
        'Delete Article Success': emptyProps(),
        'Delete Article Failure': emptyProps(),
        
        'Create Article': props<{request: ArticleRequestInterface}>(),
        'Create Article Success': props<{article: ArticleInterface}>(),
        'Create Article Failure': props<{errors: BackendErrorInterface}>(),

        'Edit Article': props<{request: ArticleRequestInterface, slug: string}>(),
        'Edit Article Success': props<{article: ArticleInterface}>(),
        'Edit Article Failure': props<{errors: BackendErrorInterface}>()
    }
});