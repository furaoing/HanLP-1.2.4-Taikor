package com.hankcs.test.tmp;

import com.hankcs.hanlp.ie.pattern.PatternExtractors.RegexExtractor;

import java.util.List;

/**
 * Created by rao on 16-4-16.
 */
public class RegexExtractTest {
    public static void main(String[] p) {
        String text = "这意味着，胡锦涛的注册资本将得到极大提升。此前，经过几轮注资，天安财险的注册资本已经达到了69.81亿元，而在此次增资之后，天安财险的注册资本将超过百亿元。借此，西水股份所持天安财险的股权比例也从16.18%上升至36.3%。 ";
        String pattern = "胡锦涛(.+?)极大提升";
        List<String> t = RegexExtractor.regexExtract(pattern, text);
        System.out.println(t);
    }
}
