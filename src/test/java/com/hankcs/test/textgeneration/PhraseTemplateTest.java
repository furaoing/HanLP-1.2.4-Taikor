import com.hankcs.hanlp.textgeneration.PhraseTemplate;


public class PhraseTemplateTest  {
  
    public static void main(String[] args)     {

      PhraseTemplate pht =new PhraseTemplate();
     pht.changeStaticString("早盘沪深指数");
     pht.addAlternative("快速杀跌");
     pht.addAlternative("快速上涨");
     pht.addAlternative("小幅震荡");
     pht.addAlternative("大幅高开");
     pht.addAlternative("大幅震荡"); 
     pht.printPhraseTemplate();
     pht.printPhraseText();
    }

}