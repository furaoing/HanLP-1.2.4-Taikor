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
        if (m.find() && (m.groupCount() > 0)) {
            // m.find will return true if a sub-sequence matched is found
            // m.groupCount will return the count of all sub-patterns
            for(int i = 1; i < m.groupCount()+1; i++) {
                // m.group(0) will return the entire pattern matched
                result.add(m.group(i));
                System.out.println("Found value: " + m.group(i));
            }
        } else {
            System.out.println("NO MATCH");
        }
        return result;
    }

}
