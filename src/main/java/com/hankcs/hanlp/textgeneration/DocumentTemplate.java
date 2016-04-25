package com.hankcs.hanlp.textgeneration;

import java.util.ArrayList;

public class DocumentTemplate {
	
  /**
   * 由若干个ParagraphTemplate通过list组装成一个document
   */
	ArrayList<ParagraphTemplate> document;
	/**document的标题title*/
	String documentTitle;
	/**document的作者名*/
	String authorName;
	
	/**
	 * 默认初始化值：
	 *   this.document=new ArrayList<ParagraphTemplate>();
        String documentTitle="";
        String authorName="";
	 */
	public DocumentTemplate()	{
		this.document=new ArrayList<ParagraphTemplate>();
		this.documentTitle="";
		this.authorName="";
	}
	
/**
 * 新增ParagraphTemplate到document末尾
 * @param pt  新增的ParagraphTemplate
 */
	public void  addParagraph(ParagraphTemplate pt) 	{
		this.document.add(pt);
	}
	
	/**
	 * 新增ParagraphTemplate到document中的某个位置，方法同java.Arraylist.add
	 * @param i 增加的位置
	 * @param pt  新增的ParagraphTemplate
	 */
	    public void  addParagraph(int i, ParagraphTemplate pt)     {
	        this.document.add(i, pt);
	    }    
	
	/**
     * 移除索引位置 i 上的ParagraphTemplate
     * @param i 待移除ParagraphTemplate的索引位置
	 */
	public void removeParagraph(int i) 	{
		this.document.remove(i);
	}
	
	   /**
     * 移除索引位置 i 上的ParagraphTemplate
     * @param pt  待移除ParagraphTemplate
     */
    public void removeParagraph(ParagraphTemplate pt)  {
        this.document.remove(pt);
    }
    
    /**
     * 清空document中的paragraph列表
        同时作者名也documenttitle也清空
     */
    public void clearParagraph() {
      this.document.clear();
      this.authorName = "" ;
      this.documentTitle = "" ;
    }
     
	/**
	 * 修改作者名
	 * @param s 修改后的作者名
	 */
	public void changeAuthorname(String s)	{
		this.authorName=s;
	}
	
	/**
	 * 修改document标题名
	 * @param s 修改后的document标题
	 */
	public void changeDocumentTitle(String s)	{
		this.documentTitle=s;
	}
	
	/**
	 * print all the information of a dt
	 */
	public void printDocumentTemplate()	{	
		System.out.println("文章标题："+this.documentTitle);
		System.out.println("作者："+this.authorName);
		System.out.println("该文件包含ParagraphTemplate数："+this.document.size());
		for(int i=0;i<this.document.size();i++)		{
			System.out.println("*************第"+(i+1)+"个ParagraphTemplate*************");
			this.document.get(i).printParagraphTemplate();
			System.out.println("********************************************");
		}//for	
	}
	
	/**
	 * only print the document text
	 */
	public void printDocumentText() 	{
		System.out.println("《"+this.documentTitle+"》");
		System.out.println("作者/"+this.authorName);
		for(ParagraphTemplate pt:this.document)		{
			pt.printParagraphText();
			System.out.println();
		}//for 		
	}
	
}
