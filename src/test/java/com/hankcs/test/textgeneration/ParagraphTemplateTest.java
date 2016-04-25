import com.hankcs.hanlp.textgeneration.ParagraphTemplate;
import com.hankcs.hanlp.textgeneration.PhraseTemplate;
import com.hankcs.hanlp.textgeneration.SentenceTemplate;

public class ParagraphTemplateTest  {
  
    public static void main(String[] args)     {
      
      SentenceTemplate st1=new SentenceTemplate();
      
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
                  
      st1.addPhraseTemplate(pht1);
      st1.addPhraseTemplate(pht2);
            
      SentenceTemplate st2=new SentenceTemplate();
      
      PhraseTemplate pht3 =new PhraseTemplate();
      pht3.changeStaticString("成交量有所");
      pht3.addAlternative("放大");
      pht3.addAlternative("缩小");
      pht3.changePunctuation(".");
                          
      st2.addPhraseTemplate(pht3);
      
      //paragraph structure
      ParagraphTemplate pt=new ParagraphTemplate();
      pt.addSentenceTemplate(st1);
      pt.addSentenceTemplate(st2);
      //print
      pt.printParagraphTemplate();
      pt.printParagraphText();

      

    }

}