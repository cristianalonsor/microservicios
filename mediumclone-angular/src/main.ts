import { isDevMode } from "@angular/core";
import { bootstrapApplication } from "@angular/platform-browser";
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';

import { provideState, provideStore } from "@ngrx/store";
import { provideEffects } from "@ngrx/effects";
import { provideStoreDevtools } from "@ngrx/store-devtools";
import { provideRouterStore, routerReducer } from "@ngrx/router-store";

import { AppComponent } from './app/app.component';
import { appRoutes } from "./app/app.routes";
import { authFeatureKey, authReducer } from "./app/auth/store/auth.reducer";
import * as authEffects from "./app/auth/store/auth.effect";
import * as feedEffects from "./app/shared/components/feed/store/feed.effects";
import * as tagsEffects from "./app/shared/components/popular-tags/store/tags.effect";
import * as addToFavEffects from "./app/shared/components/add-to-favorites/store/addToFav.effect";
import { authInterceptor } from "./app/shared/services/auth.interceptor";
import { feedFeatureKey, feedReducer } from "./app/shared/components/feed/store/feed.reducer";
import { tagsFeatureKey, tagsReducer } from "./app/shared/components/popular-tags/store/tags.reducer";


bootstrapApplication(AppComponent, {
    providers: [
        provideRouter(appRoutes),
        //store para toda la app implementado
        provideStore({
            router : routerReducer
        }),
        provideRouterStore(),
        provideState(authFeatureKey, authReducer),
        provideState(feedFeatureKey, feedReducer),
        provideState(tagsFeatureKey, tagsReducer),
        provideEffects(
            authEffects,
            feedEffects,
            tagsEffects,
            addToFavEffects
        ),
        provideStoreDevtools({
            maxAge: 25,
            logOnly: !isDevMode(),
            trace: false,
            traceLimit: 75
        }),
        provideHttpClient(withInterceptors([
            authInterceptor
        ])),
    ]
})