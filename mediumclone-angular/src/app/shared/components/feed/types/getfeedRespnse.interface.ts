import { ArticleInterface } from "src/app/shared/types/articles.interface";

export interface getFeedResponseInterface {
    articles: ArticleInterface[];
    articlesCount: number;
}