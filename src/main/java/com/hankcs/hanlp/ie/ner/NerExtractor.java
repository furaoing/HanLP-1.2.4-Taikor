package com.hankcs.hanlp.ie.ner;

import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by roy on 2016/4/15.
 */

public class NerExtractor {

    protected static Segment SegEngine;

    protected static List<String> extract(Set<String> tagging, String text) {
        List<String> ne = new LinkedList<String>();

        com.hankcs.hanlp.seg.Segment segment = SegEngine.enableOrganizationRecognize(true)
                .enableNameRecognize(true)
                .enablePlaceRecognize(true);

        List<Term> Result = segment.seg(text);

        for (Term t : Result) {
            String tag = t.nature.name();
            String w = t.word;
            if (tagging.contains(tag)) {
                ne.add(w);
                System.out.println("Naming Entity Found: " + w);
            }
        }
        return ne;
    }
}
