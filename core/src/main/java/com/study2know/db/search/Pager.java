package com.study2know.db.search;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kurtesy on 4/1/16.
 */
public class Pager {

    @JsonProperty
    public int pageSize = 50;
    @JsonProperty
    public int numPages;
    @JsonProperty
    public int currentPage;
    @JsonProperty
    public int totalItems;
    @JsonProperty
    public int firstItem;
    @JsonProperty
    public int lastItem;

    public int first() {
        if (currentPage < 1)
            currentPage = 1;
        return pageSize * (currentPage - 1);
    }

    public int last() {
        if (currentPage < 1)
            currentPage = 1;
        if (currentPage == numPages)
            return totalItems - 1;
        else
            return pageSize * currentPage - 1;
    }
}
