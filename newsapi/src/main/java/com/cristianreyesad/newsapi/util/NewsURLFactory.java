package com.cristianreyesad.newsapi.util;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class NewsURLFactory {

    private final Environment environment;
    private StringBuilder urlBuilder;

    public NewsURLFactory(Environment environment, StringBuilder urlBuilder){
        this.urlBuilder = urlBuilder;
        this.environment = environment;
    }

    public String getUrl(){
        if( urlBuilder != null) {
            urlBuilder = new StringBuilder();
        }

        urlBuilder.append(environment.getProperty("news-api.host"));
        urlBuilder.append(environment.getProperty("news-api.version"));
        urlBuilder.append(environment.getProperty("news-api.operation")).append("?");
        urlBuilder.append(environment.getProperty("news-api.country")).append("&");
        urlBuilder.append(environment.getProperty("news-api.pageSize")).append("&");
        urlBuilder.append(environment.getProperty("news-api.apiKey"));

        //El front llama la paginación (page=1,page=2,page=n) pusheando las nuevas noticias a un nodo del state
        //así manteniendo las noticias antiguas y las nuevas, limpiando las noticias cuando vas a ver el tiempo

        return urlBuilder.toString().trim().toLowerCase();
    }

    public String getUrl(Byte page){
        if( urlBuilder != null) {
            urlBuilder = new StringBuilder();
        }

        urlBuilder.append(environment.getProperty("news-api.host"));
        urlBuilder.append(environment.getProperty("news-api.version"));
        urlBuilder.append(environment.getProperty("news-api.operation")).append("?");
        urlBuilder.append(environment.getProperty("news-api.country")).append("&");
        urlBuilder.append(environment.getProperty("news-api.pageSize")).append("&");
        urlBuilder.append("page=").append(page).append("&");
        urlBuilder.append(environment.getProperty("news-api.apiKey"));

        //El front llama la paginación (page=1,page=2,page=n) pusheando las nuevas noticias a un nodo del state
        //así manteniendo las noticias antiguas y las nuevas, limpiando las noticias cuando vas a ver el tiempo

        return urlBuilder.toString().trim().toLowerCase();
    }
}
