package com.hankcs.hanlp.ie.ner.SegExtractors;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.ie.ner.NerExtractor;
import com.hankcs.hanlp.ie.ner.util.Config;

import java.util.List;

/**
 * Created by roy on 2016/4/15.
 */

public class Viterbi extends NerExtractor {

    public static List<String> extractOrg(String text) {
        SegEngine = HanLP.newSegment();
        return extract(new Config().orgTagging, text);
    }

    public static List<String> extractPerson(String text) {
        SegEngine = HanLP.newSegment();
        return extract(new Config().personTagging, text);
    }

}
