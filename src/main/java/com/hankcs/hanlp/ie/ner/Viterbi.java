package com.hankcs.hanlp.ie.ner;

import com.hankcs.hanlp.HanLP;
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
public class Viterbi {
    public static List<String> extract(String text, Config config) {
        List<String> ne = new LinkedList<String>();

        Segment segment = HanLP.newSegment().enableOrganizationRecognize(true);
        List<Term> Result = segment.seg(text);



        for (Term t : Result) {
            String tag = t.nature.name();
            String w = t.word;
            if (config.orgTagging.contains(tag)) {
                ne.add(w);
                System.out.println("Naming Entity Found: " + w);
            }
        }
        return ne;
    }
}
