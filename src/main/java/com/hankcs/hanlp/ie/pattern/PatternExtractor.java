package com.hankcs.hanlp.ie.pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by roy on 2016/4/15.
 */

public class PatternExtractor {
    protected static PatternEngine engine;

    protected static List<List<String>> extract(String pattern, String text){
        List<List<String>> result = engine.match(pattern, text);
        return result;
    }
}

