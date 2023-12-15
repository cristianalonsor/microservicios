import { createActionGroup, emptyProps, props } from '@ngrx/store';
import { ArticleInterface } from '../../../types/articles.interface';

export const addToFavActions = createActionGroup({
    source: 'AddToFav',
    events: {
        'Add to Fav Article': props<{
            slug: string,
            isFavorited: boolean
        }>(),
        'Add to Fav Article Success': props<{article: ArticleInterface}>(),
        'Add to Fav Article Failure': emptyProps(),
    }
});