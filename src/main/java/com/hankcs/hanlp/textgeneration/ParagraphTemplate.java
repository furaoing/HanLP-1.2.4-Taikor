/*
 * 测试句子：
 * 早盘沪深指数_______(快速杀跌，快速上涨，小幅震荡，大幅高开，大幅震荡字段)，_______(券商、银行等板块字段)等板块_______(领跌,领跌：二选一)，_______(券商、银行等板块字段)等板块_______(领跌,领跌：二选一)，沪指报收­­­­_______(指数值)点，深指报收­­­­_______(指数值)点。两市半日成交_______(成交量值)亿元，成交量有所________(放大,缩小：二选一)
 */


package com.hankcs.hanlp.textgeneration;

import java.util.ArrayList;

public class ParagraphTemplate {
	
	
	ArrayList<LongSentenceTemplate> paragraph;
	int documentposition;
	
	
	
	//******************************     initial     **********************************
	public ParagraphTemplate()
	{
		this.paragraph=new ArrayList<LongSentenceTemplate>();
		this.documentposition=-1;
		
	}
	
	//*************************             Functions    *****************************

	public void addLongSentence(LongSentenceTemplate lst)
	{
		this.paragraph.add(lst);
	}
	
	public void deleteLongsentence(int index)
	{
		this.paragraph.remove(index);
	}
	
	public void printParagraphTemplate()
	{
		System.out.println("该段落包含长句子数："+this.paragraph.size());
		for(int i=0;i<this.paragraph.size();i++)
		{
			System.out.println("第"+(i+1)+"个长句子信息：*************start");
			this.paragraph.get(i).printLongSentenceTemplate();
			System.out.println("第"+(i+1)+"个长句子信息：*************end");
		}
	}
	
public void printParagraphText()
{
	for(LongSentenceTemplate lst:this.paragraph)
	{
		lst.printLongSentenceText();
	}
}
	
	 //*************************             small test in main   *****************************
	 
	 public static  void main(String[] args)
	 {
		 
         LongSentenceTemplate lst1=new LongSentenceTemplate();
		 
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
		 			 
		 lst1.addSentence(st1);
		 lst1.addSentence(st2);
		 
		 
         LongSentenceTemplate lst2=new LongSentenceTemplate();
		 
		 SentenceTemplate st3 =new SentenceTemplate();
		 st3.String_static="成交量有所";
		 st3.addAlternative("放大");
		 st3.addAlternative("缩小");
		st3.changePunctuation(".");
				 			 
		 lst2.addSentence(st3);
		 
		 ParagraphTemplate pt=new ParagraphTemplate();
		 pt.paragraph.add(lst1);
		 pt.paragraph.add(lst2);
		 
		 pt.printParagraphTemplate();
		 pt.printParagraphText();

		 
	 }
}
