package com.hankcs.hanlp.textgeneration;

import java.util.ArrayList;

public class SentenceTemplate {

    /**
     * 由若干个PhraseTemplate通过list组装成一个sentence
     */
	ArrayList<PhraseTemplate> sentence;
	/**
	 * 本条template在document中的位置,  -1=不出现
	 */
	int documentPosition;

	/**
	 * 默认初始赋值：
	 *  this.sentence=new ArrayList<PhraseTemplate>();
        this.paragraphPosition=-1;
	 */
	public SentenceTemplate()	{
		this.sentence=new ArrayList<PhraseTemplate>();
		this.documentPosition=-1;
	}

	/**
	 * 新增PhraseTemplate到sentence末尾
	 * @param pht 新增的PhraseTemplate
	 */
	public void addPhraseTemplate(PhraseTemplate pht) {
		this.sentence.add(pht);
	}
	
	   /**
     * 新增PhraseTemplate到sentence中的某个位置，方法同java.Arraylist.add
     * @param i 增加的位置
     * @param pht 新增的PhraseTemplate
     */
    public void addPhraseTemplate(int i , PhraseTemplate pht)   {
        this.sentence.add(i, pht);
    }
    
   /**
    * 删除指定位置的PhraseTemplate
    * @param i 待删除的PhraseTemplate的索引位置
    */
    public void removePhraseTemplate(int i)    {
        this.sentence.remove(i);
    }
    
    /**
     * 删除指定位置的PhraseTemplate
     * @param pht 待删除的PhraseTemplate
     */
     public void removePhraseTemplate(PhraseTemplate pht)    {
       
       if(this.sentence.contains(pht)){
         this.sentence.remove(pht);
       }else{
      // System.out.print("不存在，删除失败");
       }// if else
      }
    
     /**
      * 清空sentence中的phrase列表（同时documentPosition重置为-1）
      */
     public void clearSentence() {
       this.sentence.clear();
       this.documentPosition = -1 ;
     }
         
	/**
	 * 修改在document中的位置
	 * @param i 修改后的documentPosition
	 */
	public void changeDocumentPosition(int i) 	{
		this.documentPosition=i;
	}
	
	/**
	 * print all the information of a st
	 */
	public void  printSentenceTemplate() 	{
		System.out.println("该SentenceTemplate包含PhraseTemplate数："+this.sentence.size());
		for(int i=0;i<this.sentence.size();i++) 	{
			System.out.println("****************第"+(i+1)+"个PhraseTemplate信息：************");
			this.sentence.get(i).printPhraseTemplate();
			System.out.println("***********************************");
		}
	}
	
	/**
	 * only print the sentence text
	 */
	public void printSentenceText()  	{
		for(PhraseTemplate pht:this.sentence)		{
			pht.printPhraseText();
		}// for 
		//System.out.println();
	}
	
}
