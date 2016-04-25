package com.hankcs.test.tmp;

import com.hankcs.hanlp.ie.pattern.PatternExtractors.RegexExtractor;

import java.util.List;

/**
 * Created by rao on 16-4-16.
 */
public class RegexExtractTest {
    public static void main(String[] p) {
        String text = "日前，国家税务总局发布《关于全面推开营业税改征增值税试点有关税收征收管理事项的公告》（以下简称《公告》）、《进一步做好营改增一次性业务办理纳税服务工作的通知》和《关于进一步做好营改增税控装置安装服务和监督管理工作有关问题的通知》，对全面推开营改增试点有关税收征管事项进行了细化明确。";
        String pattern = "，(.+?)发布";
        List<List<String>> t = RegexExtractor.regexExtract(pattern, text);
        System.out.println(t);
    }
}
