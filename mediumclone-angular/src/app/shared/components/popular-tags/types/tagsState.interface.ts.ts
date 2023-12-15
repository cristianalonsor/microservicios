import { GetTagsInterface } from "./getTags.interface";

export interface TagsStateInterface {
    isLoading: boolean;
    error: string | null;
    data : GetTagsInterface | null
}