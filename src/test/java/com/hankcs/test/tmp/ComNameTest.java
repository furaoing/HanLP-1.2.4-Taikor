package com.hankcs.test.tmp;

import java.util.List;

import com.hankcs.hanlp.ie.ner.SegExtractors.Viterbi;

/**
 * Created by roy on 2016/4/15.
 */

public class ComNameTest {
    public static void main(String[] p) {
        String text = "这意味着，胡锦涛的注册资本将得到极大提升。此前，经过几轮注资，天安财险的注册资本已经达到了69.81亿元，而在此次增资之后，天安财险的注册资本将超过百亿元。借此，西水股份所持天安财险的股权比例也从16.18%上升至36.3%。 ";
        List<String> t = Viterbi.extractPerson(text);
        System.out.println(t);
    }
}
