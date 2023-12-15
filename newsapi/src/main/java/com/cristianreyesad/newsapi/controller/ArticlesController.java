package com.cristianreyesad.newsapi.controller;

import com.cristianreyesad.newsapi.model.Article;
import com.cristianreyesad.newsapi.service.ArticlesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.cristianreyesad.newsapi.model.Articles;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//Al momento de compilar crea el constructor por detrás con todos los argumentos
@AllArgsConstructor
//@Controller
@RestController
//Rest controller spring trata esto como un rest controller y retorne una respuesta apropiada en el body como json o html
@RequestMapping("/api/v1/news")//hacemos que todas las funciones de la clase controller esten bajo este path para ser llamadas
public class ArticlesController {

    private final ArticlesService articlesService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Article> getArticles(){
        log.debug("Articles controller called, function getArticles");
        //Retorna el llamado a la funcion que trae el objeto articles que tiene la propiedad de los articulos
        return  articlesService.listArticles();
    }

    @RequestMapping(value = "/{author}", method = RequestMethod.GET)//el parametro entre llaves, es el path variable, debe usarse en conjunto a la anotacion homonima
    //así spring hace match de nombres y lo utiliza dentro de la funcion de la que es parte el requestmapping
    public Article getArticleByAuthor(@PathVariable("author") String author){
        log.debug("Articles controller called, function getArticlesByAuthor: "+ author);
        return articlesService.getArticleByAuthor(author);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST) hay que pasar la anotación requestbody para que tome
    //la información que viene en el body de la transacción
    public ResponseEntity handlePost(@RequestBody String author) {
        /*
        deberíamos recibir en general un objeto en el body que tenga la estructura que deseemos trabajar
        ya que spring intenta hacer bind o hacer que calce el json dentro del objeto que utilizaremos
        acá sólo recibo un string a forma de ejemplo y estudio
         */
        Article savedArticle = articlesService.saveNewArticle(author);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/news " + author.replace(" ",""));

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{author}")
    public ResponseEntity updateByAuthor(@PathVariable("author") String author, @RequestBody Article article){

        articlesService.updateByAuthor(author, article);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{author}")
    public ResponseEntity deleteByAuthor(@PathVariable("author") String author) {

        articlesService.deleteByAuthor(author);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/articles")
    public ResponseEntity getNews(@RequestParam String page) throws Exception {

        Articles articles = articlesService.getArticles(page);
        return new ResponseEntity(articles, HttpStatus.OK);
    }

    //TODO getNews paginated
    //TODO getNews query
    //https://newsapi.org/docs/endpoints/top-headlines

    @GetMapping(value = "/articles/category")
    public ResponseEntity getNewsByCategory(@RequestParam("page") String page, @RequestParam("category") String category) {
        //TODO agregar pagination desde el front
        Articles articles = articlesService.getArticlesByCategory(page, category);
        return ResponseEntity.ok(articles);
    }
}
