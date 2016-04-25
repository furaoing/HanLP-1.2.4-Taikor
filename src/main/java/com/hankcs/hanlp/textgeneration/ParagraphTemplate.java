package com.hankcs.hanlp.textgeneration;

import java.util.ArrayList;

public class ParagraphTemplate {
	
  /**
   * 由若干个SentenceTemplate通过list组装成一个paragraph
   */
	ArrayList<SentenceTemplate> paragraph;
	/**
     * 本条template在Document中的位置,  -1=不出现
     */
	int documentPosition;

	/**
	 *  默认初始赋值：
	 *  this.paragraph=new ArrayList<SentenceTemplate>();
         this.documentPosition=-1;
	 */
	public ParagraphTemplate()	{
		this.paragraph=new ArrayList<SentenceTemplate>();
		this.documentPosition=-1;	
	}
	
/**
 * 新增SentenceTemplate到paragraph末尾
 * @param st  新增的SentenceTemplate
 */
	public void addSentenceTemplate(SentenceTemplate st)	{
		this.paragraph.add(st);
	}
	
/**
 * 新增SentenceTemplate到paragraph中的某个位置，方法同java.Arraylist.add
 * @param i  增加的位置
 * @param st  新增的SentenceTemplate
 */
    public void addSentenceTemplate(int i, SentenceTemplate st)    {
        this.paragraph.add(i, st);
    }
	
	/**
	 * 移除索引位置 i 上的SentenceTemplate
	 * @param i 待移除SentenceTemplate的索引位置
	 */
	public void removeSentenceTemplate(int i)	{
		this.paragraph.remove(i);
	}
	
	
    public void removeSentenceTemplate(SentenceTemplate st)   {
      if(this.paragraph.contains(st)){
        this.paragraph.remove(st);
      }else{
        // System.out.print("不存在，删除失败");
      }//if else
  }

    /**
     * 清空paragraph中的sentence列表（同时documentPosition重置为-1）
     */
    public void clearParagraph() {
      this.paragraph.clear();
      this.documentPosition = -1 ;
    }
	
    /**
     * 修改在document中的位置
     * @param i 修改后的documentPosition
     */
    public void changeDocumentPosition(int i)   {
        this.documentPosition=i;
    }
	
	/**
	 * print all the information of a ParagraphTemplate
	 */
	public void printParagraphTemplate() 	{
		System.out.println("该ParagraphTemplate包含SentenceTemplate数："+this.paragraph.size());
		for(int i=0;i<this.paragraph.size();i++)  {
			System.out.println("************第"+(i+1)+"个SentenceTemplate信息*************");
			this.paragraph.get(i).printSentenceTemplate();
			System.out.println("***************************************");
		}//for
	}
	
	/**
	 * only print the paragraph text
	 */
  public void printParagraphText() {
	for(SentenceTemplate st : this.paragraph) 	{
		st.printSentenceText();
	}//for
  }

}
