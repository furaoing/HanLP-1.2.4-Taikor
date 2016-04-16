package com.hankcs.hanlp.ie.pattern.PatternExtractors;

import com.hankcs.hanlp.ie.pattern.PatternEngines.Regex;
import com.hankcs.hanlp.ie.pattern.PatternExtractor;

import java.util.List;

/**
 * Created by rao on 16-4-16.
 */
public class RegexExtractor extends PatternExtractor {
    public static List<String> regexExtract(String pattern, String text) {
        engine = new Regex();
        return extract(pattern, text);
    }
}
