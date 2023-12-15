import { Routes } from '@angular/router';

export const appRoutes: Routes = [
    {
        path: 'auth',
        //Cargamos mediante lazyload las routes en este file
        //dentro de esta ruta, encontramos el modulo registerRoute, de donde sacamos el componente
        //para el path register
        loadChildren: () => import('./auth/auth.route').then(
            module => module.registerRoutes
        )
    },
    {
        path: '',
        loadChildren: () => import('../app/globalFeed/globalFeed.route').then(
            module => module.globalFeedRoutes
        )
    },
    {
        path: 'feed',
        loadChildren: () => import('../app/yourFeed/yourFeed.route').then(
            module => module.yourFeedRoutes
        )
    },
    {
        path: 'tags/:slug',
        loadChildren: () => import('../app/tagFeed/tagFeed.route').then(
            module => module.tagFeedRoutes
        )
    },
    {
        path: 'articles/new',
        loadChildren: () => import('../app/createArticle/create-article.route').then(
            module => module.createArticleRoutes
        )
    },
    {
        path: 'articles/:slug',
        loadChildren: () => import('../app/article/article.route').then(
            module => module.articleRoutes
        )
    },
    {
        path: 'articles/:slug/edit',
        loadChildren: () => import('../app/editArticle/edit-article.route').then(
            module => module.editArticleRoutes
        )
    },
    {
        path: 'settings',
        loadChildren: () => import('../app/settings/settings.route').then(
            module => module.settingRoute
        )
    },
    {
        path: 'profiles/:slug',
        loadChildren: () => import('../app/userProfile/user-profile.route').then(
            module => module.userProfileRoutes
        )
    },
    {
        path: 'profiles/:slug/favorites',
        loadChildren: () => import('../app/userProfile/user-profile.route').then(
            module => module.userProfileRoutes
        )
    },
]