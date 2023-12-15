package com.cristianreyesad.newsapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articles {

    private String status;
    private int totalResults;
    private ArrayList<Article> articles;
}
