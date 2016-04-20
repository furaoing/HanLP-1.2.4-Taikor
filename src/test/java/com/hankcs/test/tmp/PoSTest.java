package hankcs.test.tmp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * Created by roy on 2016/4/20.
 */

public class PoSTest {
    public static void main(String[] p) {
        String text = "沪指今日下跌5%，市场恐慌情绪蔓延";
        List<Term> result = HanLP.segment(text);
        System.out.println(result);
    }
}
