package com.study2know.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.study2know.db.search.Pager;
import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj on 6/1/16.
 */
@ApiModel
public class FilterResultView {
    @JsonProperty
    public List filteredItems = new ArrayList<>();
    @JsonProperty
    public Pager pager;
}
