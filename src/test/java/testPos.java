

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;
import java.util.Scanner;

import static com.hankcs.hanlp.HanLP.segment;

/**
 * @author hankcs
 */
public class testPos
{
    public static void main(String[] args)
    {
         String my_str = "天猫超市双十一促销";
         List<Term> result = HanLP.segment(my_str);
        System.out.println(result);

    }

}