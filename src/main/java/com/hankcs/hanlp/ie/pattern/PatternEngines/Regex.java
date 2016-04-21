package com.hankcs.hanlp.ie.pattern.PatternEngines;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.hankcs.hanlp.ie.pattern.PatternEngine;
import com.apollo.common.utils.regexEx;

/**
 * Created by rao on 16-4-16.
 */

public class Regex extends PatternEngine {
    protected List<List<String>> match(String pattern, String text) {
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = r.matcher(text);
        List<List<String>> matches = regexEx.findall(m);
        return matches;
    }
}
