package com.study2know.core.utils;

import com.rosaloves.bitlyj.Bitly.Provider;
import com.rosaloves.bitlyj.ShortenedUrl;
import com.rosaloves.bitlyj.UrlInfo;

import static com.rosaloves.bitlyj.Bitly.as;

/**
 * Created by ashish on 6/12/16.
 */
public class URLShortner {

    private static Provider bitly;

    static {
        bitly = as("xenohq", "R_9fba893647ec4f7888c8e3ab45c9ab1d");
    }

    public static ShortenedUrl shorten(String url){
        if(url==null || url.isEmpty()) return null;

        return bitly.call(com.rosaloves.bitlyj.Bitly.shorten(url));
    }
}
