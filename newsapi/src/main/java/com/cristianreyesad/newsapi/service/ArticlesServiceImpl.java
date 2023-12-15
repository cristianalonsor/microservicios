package com.cristianreyesad.newsapi.service;

import com.cristianreyesad.newsapi.model.Source;
import com.cristianreyesad.newsapi.util.IsNumber;
import com.cristianreyesad.newsapi.util.NewsURLFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.cristianreyesad.newsapi.model.Article;
import com.cristianreyesad.newsapi.model.Articles;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class ArticlesServiceImpl implements ArticlesService {

    private Map<String, Article> articleMap;
    private NewsURLFactory newsURLFactory;
    private RestTemplate restTemplate;
    private IsNumber isNumber;

    /*public ArticlesServiceImpl() {
        this.articleMap = new HashMap<>();

        Article article1 = Article.builder()
                .author("autor1")
                .content("contenido")
                .url("url")
                .publishedAt("publicado")
                .source(Source.builder().id("id").name("name").build())
                .urlToImage("")
                .build();

        Article article2 = Article.builder()
                .author("autor2")
                .content("contenido")
                .url("url")
                .publishedAt("publicado")
                .source(Source.builder().id("id").name("name").build())
                .urlToImage("")
                .build();

        Article article3 = Article.builder()
                .author("autor3")
                .content("contenido")
                .url("url")
                .publishedAt("publicado")
                .source(Source.builder().id("id").name("name").build())
                .urlToImage("")
                .build();


        articleMap.put(article1.getAuthor(), article1);
        articleMap.put(article2.getAuthor(), article2);
        articleMap.put(article3.getAuthor(), article3);
    }*/

    /*
    public Articles getArticles() {
        //MOCK Articles
        Article article = Article.builder()
                .author("autor")
                .content("contenido")
                .url("url")
                .publishedAt("publicado")
                .source(Source.builder().id("id").name("name").build())
                .urlToImage("")
                .build();
        List<Article> artList = List.of(article);

        //Devuelve un Json con la respuesta que estamos definiendo
        return Articles.builder()
                .status("ok")
                .totalResutls(0)
                .articles(artList)
                .build();
    }*/

    //Simulando manejo de data, creación, actualización y eliminación de datos, persistencia durante ejecución
    public List<Article> listArticles() {
        //retorna una el map de article como lista
        return new ArrayList<>(articleMap.values());
    }

    @Override
    public void updateByAuthor(String author, Article article) {

        Article exist = articleMap.get(author);

        exist.setContent(article.getContent());
        exist.setDescription(article.getDescription());
        exist.setTitle(article.getTitle());

        articleMap.put(author, exist);
    }

    @Override
    public void deleteByAuthor(String author) {
        articleMap.remove(author);
    }

    @Override
    public Article getArticleByAuthor(String author) {
        log.debug("getArticle by author called: " + author);
        return articleMap.get(author);
    }

    @Override
    public Article saveNewArticle(String author) {

        Article savedArticle = Article.builder()
                .author(author)
                .content("contenido generico")
                .publishedAt("publicado")
                .source(Source.builder().id("id").name("name").build())
                .urlToImage("url de la imagen")
                .url("url")
                .description("descripción")
                .title("titulo")
                .build();

        //Mete el articulo creado en el mapa que persiste mientras la app de ejemplo corra
        articleMap.put(savedArticle.getAuthor(), savedArticle);

        return savedArticle;
    }
    //Fin

    @Override
    public Articles getArticles(String page) throws Exception {
        log.debug("getArticles called: " + page);
        Articles response = null;
        try {
            if ( !isNumber.isNumber(page) ){
                throw new Exception("Page is not a number: "+ page);
            }
            Byte param = Byte.parseByte(page);
            //TODO call news api and get the results
            //llamo la url y paso el tipo de dato que recibiré, si no estoy seguro
            //puedo pasarle el Object.class para verificar el objeto que trae, ya que paso un generico
            response = restTemplate.getForObject(newsURLFactory.getUrl(param), Articles.class);

        } catch (Exception e ) {
            e.printStackTrace();
        }

        return  response;
    }

    @Override
    public Articles getArticlesByCategory(String category, String page) {

        log.debug("getArticlesByCategoryv called: "+ category);
        Articles response = null;
        try {
            if ( !isNumber.isNumber(page) ){
                throw new Exception("Page is not a number: "+ page);
            }
            Byte param = Byte.parseByte(page);
            response = restTemplate.getForObject(newsURLFactory.getUrl(param)+"&category="+category, Articles.class);
        } catch (Exception e) {
           e.printStackTrace();
        }

        return response;
    }
}
