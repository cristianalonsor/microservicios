import { getFeedResponseInterface } from "./getfeedRespnse.interface";

export interface FeedStateInterface {
    isLoading: boolean;
    error: string | null;
    data: getFeedResponseInterface | null;
}