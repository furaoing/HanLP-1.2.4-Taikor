package com.hankcs.hanlp.ie.pattern.PatternEngines;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.hankcs.hanlp.ie.pattern.PatternEngine;

/**
 * Created by rao on 16-4-16.
 */

public class Regex extends PatternEngine {
    protected List<String> match(String pattern, String text) {
        List<String> result = new LinkedList<String>();
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(text);
        if (m.find()) {
            result.add(m.group(1));
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
        } else {
            System.out.println("NO MATCH");
        }
        return result;
    }

}
