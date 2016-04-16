package com.hankcs.hanlp.ie.pattern;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rao on 16-4-15.
 */

public abstract class PatternEngine {
    protected abstract List<String> match(String pattern, String text);
}
