import { PopularTagsType } from "./popularTag.type";
import { ProfileInterface } from "./profile.interface";

export interface ArticleInterface {
    id: string;
    slug: string | null;
    title: string | null;
    description: string | null;
    body: string | null;
    tagList: PopularTagsType[],
    createdAt: string | null;
    updatedAt: string | null;
    favorited: boolean,
    favoritesCount: number,
    author: ProfileInterface,
}