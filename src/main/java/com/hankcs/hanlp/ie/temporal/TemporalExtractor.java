package com.hankcs.hanlp.ie.temporal;

import com.apollo.common.utils.propertyHandler;
import com.hankcs.hanlp.ie.pattern.PatternExtractors.RegexExtractor;

import java.util.*;

/**
 * Created by roy on 2016/4/19.
 */

public class TemporalExtractor {
    public static List<TimeExtracted> extract(String text){
        String propertyFileName = "regex.properties";
        propertyHandler.loadProperties(propertyFileName);
        String pattern = propertyHandler.readProperty("std");
        List<List<String>> results = RegexExtractor.regexExtract(pattern, text);

        List<TimeExtracted> timeE = new LinkedList<TimeExtracted>();

        for (List<String> result : results){
            TimeExtracted t = new TimeExtracted();
            t.type = TimeInfoType.Time_Point;

            int year = Integer.parseInt(result.get(0));
            int month = Integer.parseInt(result.get(1));
            int day = Integer.parseInt(result.get(2));

            GregorianCalendar myDateTime = new GregorianCalendar(year, month-1, day);
            myDateTime.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            t.timeStamp = Math.round(myDateTime.getTimeInMillis()/1000);

            timeE.add(t);
        }
        return timeE;
    }
}

