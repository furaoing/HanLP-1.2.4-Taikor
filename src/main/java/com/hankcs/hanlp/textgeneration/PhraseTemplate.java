package com.hankcs.hanlp.textgeneration;

import java.util.ArrayList;

public class PhraseTemplate {
  
     /**
      * 静态文本
                例如:" 早盘沪深指数______.   "中的“早盘沪深指数”
                静态文本允许为空
      */
	 String  staticString;	 
	 /**
	  * 动态文本（最终填入空白的位置的文本）
	  * 例如:" 早盘沪深指数______.   "中的“______”
	  * 动态文本允许为空
	  */
	 String  dynamicString;
	 /**
	  * 可以填入String_dynamic的备选选项
	  */
	 ArrayList<String> alternativeList;
	 /**
	  * 本条template在Document中的位置,  -1=不出现
	  */
	 int documentPosition;
	 /**
	  * false= 当前没有可以填入空白位置的合适的动态文本（默认）
	  * */
	 boolean dynamicTextExistFlag;
	 /**
	  * 句子后紧跟的标点符号
	  * */
	 String punctuation;	 
	/**
	 * 动态text和静态text的前后位置 
	 * true=静态文本在前（默认）
	 * */
	 boolean staticTextFirst;	 
	 
	 
	 
	 /**
	  * 默认初始化值：
	  *       this.staticString  =  ""  ;
       this.dynamicString  =  "________"  ;
       this.alternativeList  =  new ArrayList <String> ();
       this.documentPosition =  -1 ;
       this.dynamicTextExistFlag =  false ;
       this.punctuation =  "" ;
       this.staticTextFirst =  true ; 
	  * 
	  */
	 public PhraseTemplate() {
	   this.staticString  =  ""  ;
	   this.dynamicString  =  "________"  ;
	   this.alternativeList  =  new ArrayList <String> ();
	   this.documentPosition =  -1 ;
	   this.dynamicTextExistFlag =  false ;
	   this.punctuation =  "" ;
	   this.staticTextFirst =  true ;  
	 }
	
	 /**
	  * 将静态文本内容修改为String s
	  * @param s 修改后的文本内容
	  */
	 public void changeStaticString(String s) {   
		this.staticString = s; 
	 }
	 
	 /**
	  * 将动态文本内容修改为s
	  * @param s  修改后的文本内容
	  */
	 public void changeStringDynamic(String s)	 {
		 this.dynamicString = s;
	 }
	 
	 /**
	  * 查询备选动态文本列表中是否有文本s
	  * @param  s    查询内容
	  * @return    列表中的索引位置
	  */
	 public  int indexOfAlternativeList(String s)  {
		  return this.alternativeList.indexOf(s);
	 }
	 
	 /**
	  * 向备选动态文本列表中增加备选动态文本s
	  * @param s 待增加备选动态文本
	  */
	 public void addAlternative(String s)	 {
		 if(this.indexOfAlternativeList(s)==-1)  {
			 //add into arraylist
			 this.alternativeList.add(s);
		     }else {
			//System.out.print("已经存在");
		 } //if else
	 }
	 
	 /**
	 * 从备选动态文本列表中删除备选动态文本s
      * @param s 待删除备选动态文本
	  */
	 public void removeAlternative(String s)	 {
		 if(this.indexOfAlternativeList(s)!=-1)		 {
			 this.alternativeList.remove(s);
		 }		 else		 {
			// System.out.print("不存在，删除失败");
		 }// if else 
	 }
	 
	 /**
	  * 清空备选动态文本列表
	  */
	 public void clearAlternativeList( ) {
		 this.alternativeList.clear();
	 }
	 
	 /**
	  * 修改此template在document中的位置
	  * @param i 修改后的位置
	  */
	 public void changeDocumentPositon(int i) {		 
		 this.documentPosition=i;	 
	 }
	 
	 /**
	  *修改动态文本存在标志
	  *@param b 修改后的标志
	  */
	 public void changeDynamicTextExistFlag(boolean  b) {
		 this.dynamicTextExistFlag=b;
	 }
	 
	 /**
	  * 修改template末尾标点符号
	  * @param s 修改后的标点
	  */
	 public void changePunctuation(String s)	 {
		 this.punctuation=s;
	 }
	 
	 /**
	  * 修改静态文本顺序在先标志
	  * @param b 修改后的标志
	  */
	 public void changeStaticFirstFlag(boolean b)	 {
		 this.staticTextFirst=b;
	 }
	 
	 /**
	  * 从给定的PhraseTemplate 中复制全部信息（赋值）
	  * @param pht 给定的PhraseTemplate 
	  */
	 public void  copyFrom(PhraseTemplate pht)	 {
	   this.staticString = pht.staticString; 
	   this.dynamicString  = pht.dynamicString; 
	   //
	   //copy alternativelist
	   this.alternativeList.clear();
	   for(String s : pht.alternativeList){
	     this.alternativeList.add(s);
	   }//for
	//
	   this.documentPosition = pht.documentPosition;
	   this.dynamicTextExistFlag  = pht.dynamicTextExistFlag;
	   this.punctuation = pht.punctuation;
	   this.staticTextFirst = pht.staticTextFirst;
	 }
	  
	 /**
	  * print all the information of a PhT
	  */
	 public void printPhraseTemplate()	 {
		 System.out.println("当前静态文本："+this.staticString);
		 System.out.println("当前动态文本："+this.dynamicString);
		 
		System.out.println("候选动态文本个数："+this.alternativeList.size());
		System.out.println("*******候选动态文本列表*********");
		 for(int i=1;i<=this.alternativeList.size();i++)	 {
			 System.out.println("候选"+i+":\t\t"+this.alternativeList.get(i-1));
		 }//for
		System.out.println("***********************");
		
		 System.out.println("当前所在document位置"+this.documentPosition);
		 System.out.println("当前动态文本可填入状态"+this.dynamicTextExistFlag);
		 System.out.println("当前句末标点"+this.punctuation);
		 System.out.println("当前静态文本优先标志"+this.staticTextFirst);
	 }
	
	 /**
	  * only print the phrase text
	  */
	 public void printPhraseText()	 {
		 if(this.staticTextFirst)
		 {
		 System.out.print(this.staticString+this.dynamicString+this.punctuation);
		 }	 else {
		 System.out.print(this.dynamicString+this.staticString+this.punctuation);
		 }// if else
	 }
	 
}
