package hankcs.test.tmp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.hankcs.hanlp.ie.ner.Viterbi;
import com.hankcs.hanlp.ie.ner.util.Config;

/**
 * Created by roy on 2016/4/15.
 */

public class ComNameTest {
    public static void main(String[] p) {
        String text = "这意味着，天安财险的注册资本将得到极大提升。此前，经过几轮注资，天安财险的注册资本已经达到了69.81亿元，而在此次增资之后，天安财险的注册资本将超过百亿元。借此，西水股份所持天安财险的股权比例也从16.18%上升至36.3%。 ";
        List<String> t = Viterbi.extract(text, new Config());
        System.out.println(t);
    }
}
