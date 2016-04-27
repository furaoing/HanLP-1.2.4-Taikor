package com.hankcs.test.tmp;

import com.hankcs.hanlp.HanLP;

/**
 * Created by roy on 2016/4/22.
 */
public class DependencyTest {
    public static void main(String arg[]){
        System.out.println(HanLP.parseDependency("把市场经济奉行的等价交换原则引入党的生活和国家机关政务活动中"));
    }
}
