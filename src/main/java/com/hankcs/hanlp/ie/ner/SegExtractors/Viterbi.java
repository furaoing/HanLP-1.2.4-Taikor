package com.hankcs.hanlp.ie.ner.SegExtractors;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.ie.ner.NerExtractor;
import com.hankcs.hanlp.ie.ner.util.Config;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by roy on 2016/4/15.
 */

public class Viterbi extends NerExtractor {

    public static List<String> extractOrg(String text) {
        SegEngine = HanLP.newSegment();
        return extract(text, new Config().orgTagging);
    }

    public static List<String> extractPerson(String text) {
        SegEngine = HanLP.newSegment();
        return extract(text, new Config().personTagging);
    }

}
