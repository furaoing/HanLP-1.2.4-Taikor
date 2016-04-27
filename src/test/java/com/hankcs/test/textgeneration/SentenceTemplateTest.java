package com.hankcs.test.textgeneration;

import com.hankcs.hanlp.textgeneration.PhraseTemplate;
import com.hankcs.hanlp.textgeneration.SentenceTemplate;

public class SentenceTemplateTest  {
  
  public static void main(String[] args)     {
    System.out.println("测试句子：_______(券商、银行等板块字段)等板块_______(领跌,领跌：二选一)");
   SentenceTemplate st=new SentenceTemplate();
    
    PhraseTemplate pht1 =new PhraseTemplate();
    pht1.changeStaticString("等板块");
    pht1.addAlternative("券商");
    pht1.addAlternative("银行");
    pht1.changeStaticFirstFlag(false);//动态文本在先
    
    PhraseTemplate pht2 =new PhraseTemplate();
   // pht2.changeStringStatic("");
    pht2.addAlternative("领涨");
    pht2.addAlternative("领跌");
    pht2.changePunctuation(",");
                
    st.addPhraseTemplate(pht1);
    st.addPhraseTemplate(pht2);
    
    st.printSentenceTemplate();
    st.printSentenceText();

  }

}
