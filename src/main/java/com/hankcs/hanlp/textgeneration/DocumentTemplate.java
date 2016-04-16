package com.hankcs.hanlp.textgeneration;

import java.util.ArrayList;

public class DocumentTemplate {
	
	ArrayList<ParagraphTemplate> document;
	
	
	//******************************     initial     **********************************
	
	public DocumentTemplate()
	{
		this.document=new ArrayList<ParagraphTemplate>();

	}
	
	//*************************             Functions    *****************************
	
	public void  addParagraph(ParagraphTemplate pt)
	{
		this.document.add(pt);
	}
	
	public void deleteParagraph(int index)
	{
		this.document.remove(index);
	}
	
	public void printDocumentTemplate()
	{
		System.out.println("该文件包含段落数："+this.document.size());
		for(int i=0;i<this.document.size();i++)
		{
			System.out.println("第"+(i+1)+"个段落信息：*************start");
			this.document.get(i).printParagraphTemplate();
			System.out.println("第"+(i+1)+"个段落信息：*************end");
		}
	}
	
	public void printDocumentText()
	{
		for(ParagraphTemplate pt:this.document)
		{
			pt.printParagraphText();
			System.out.println();
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
		 
		 ParagraphTemplate pt1=new ParagraphTemplate();
		 pt1.paragraph.add(lst1);
		 pt1.paragraph.add(lst2);
		 
		 ParagraphTemplate pt2=new ParagraphTemplate();
		 pt2.paragraph.add(lst2);
		 pt2.paragraph.add(lst1);
		 
		 DocumentTemplate dt=new DocumentTemplate();
		 dt.addParagraph(pt1);
		 dt.addParagraph(pt2);
		  
		 
		 dt.printDocumentTemplate();
		 dt.printDocumentText();
		 
		 
		 
	 }
	

}
