package com.hankcs.test.tmp;

import com.hankcs.hanlp.ie.temporal.TemporalExtractor;
import com.hankcs.hanlp.ie.temporal.TimeExtracted;

import java.util.List;

/**
 * Created by roy on 2016/4/20.
 */
public class TemporalTest {
     public static void main(String[] p) {
        String text = "我的1999年10月21日之旅我的1998年10月21日之旅";
         List<TimeExtracted> r = TemporalExtractor.extract(text);
         for (TimeExtracted t : r) {
             System.out.println(t.timeStamp);
         }
    }
}
