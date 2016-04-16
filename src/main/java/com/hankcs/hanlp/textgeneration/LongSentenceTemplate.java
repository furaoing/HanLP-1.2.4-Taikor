
/*
 * 测试句子：_______(券商、银行等板块字段)等板块_______(领跌,领跌：二选一)
 */

package com.hankcs.hanlp.textgeneration;

import java.util.ArrayList;

public class LongSentenceTemplate {
	
	
	
	ArrayList<SentenceTemplate> longsentence;
	int paraposition;//本条template在paragraph中的位置,  -1=不出现

	
	//******************************     initial     **********************************
	
	public LongSentenceTemplate()
	{
		this.longsentence=new ArrayList<SentenceTemplate>();
		this.paraposition=-1;
		
	}
	
	
//*************************             Functions    *****************************
	
	public void addSentence(SentenceTemplate st)
	{
		this.longsentence.add(st);
	}
	
	public void changeparaposition(int i)
	{
		this.paraposition=i;
	}
	
	
	public void deleteSentence(int index)
	{
		this.longsentence.remove(index);
	}
	
	
	public void  printLongSentenceTemplate()
	{
		System.out.println("该长句包含句子数："+this.longsentence.size());
		for(int i=0;i<this.longsentence.size();i++)
		{
			System.out.println("第"+(i+1)+"个句子信息：*************start");
			this.longsentence.get(i).printSentenceTemplate();
			System.out.println("第"+(i+1)+"个句子信息：*************end");
		}
	}
	
	public void printLongSentenceText()
	{
		for(SentenceTemplate st:this.longsentence)
		{
			st.printSentenceText();
		}
		
		//System.out.println();
	}
	
	
	
	
	 //*************************             small test in main   *****************************
	 
	 public static  void main(String[] args)
	 {
	 
		 System.out.println("测试句子：_______(券商、银行等板块字段)等板块_______(领跌,领跌：二选一)");
		LongSentenceTemplate lst=new LongSentenceTemplate();
		 
		 SentenceTemplate st1 =new SentenceTemplate();
		 st1.String_static="等板块";
		 st1.addAlternative("券商");
		 st1.addAlternative("银行");
		 st1.changestaticfirstflag(false);//动态文本在先
		 
		 SentenceTemplate st2 =new SentenceTemplate();
		// st2.changeStringStatic("");
		 st2.addAlternative("领涨");
		 st2.addAlternative("领跌");
		 st2.changePunctuation(",");
		 			 
		 lst.addSentence(st1);
		 lst.addSentence(st2);
		 
		 lst.printLongSentenceTemplate();
		 lst.printLongSentenceText();
		 
	 }
}
