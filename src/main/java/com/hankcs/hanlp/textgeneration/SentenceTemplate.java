/*
 * 测试句子： 早盘沪深指数_______(快速杀跌，快速上涨，小幅震荡，大幅高开，大幅震荡字段)
 */

package com.hankcs.hanlp.textgeneration;

import java.util.ArrayList;
import java.util.List;

public class SentenceTemplate {

	 String  String_static;//example: 早盘沪深指数.   允许为空
	 String  String_dynamic;//最终填入空白的位置的string
	 ArrayList<String> alternatives;//可以填入String_dynamic的备选选项
	 int paraposition;//本条template在paragraph中的位置,  -1=不出现
	 boolean valueexist;// false= 当前没有可以填入空白位置的值
	 String punctuation;//句子后紧跟的标点符号
	 boolean staticfirst;//动态text和静态text的前后位置  true=静态文本在前 false=动态文本在前
	 
	//******************************     initial     **********************************
	 
	 
	 /*
	  * initial with no parameter
	  */
	 public SentenceTemplate()
	 {
		 this.String_static="";
		 this.String_dynamic="______";
		 this.alternatives=new ArrayList<String>();
		 this.paraposition=-1;
		 this.valueexist=false;		 
		 this.punctuation="";//默认无标点
		 this.staticfirst=true;//默认静态文本在前
	 }
	
	 /*
	  * initial  with 2 paramaters, static string and alternatives
	  */
	 public SentenceTemplate(String sstatic, ArrayList<String> alter)
	 { 
		 this.String_static=sstatic;//!!!!!!!!!!!!!!!
		 this.String_dynamic="______";
		 this.alternatives=new ArrayList<String>(alter);//!!!!!!!!!!!!!
		 this.paraposition=-1;
		 this.valueexist=false;		 
		 this.punctuation="";//默认无标点
		 this.staticfirst=true;//默认静态文本在前
	 }
	 
 
	 //*************************             Functions    *****************************
	 
	 /*
	  * changing static string
	  */
	 public void changeStringStatic(String s)
	 {
		 this.String_static=s;
		 
	 }
	 
	 /*
	  * changing dynamic string
	  */
	 public void changeStringDynamic(String s)
	 {
		 this.String_dynamic=s;
	 }
	 
	 /*
	  * search in the arraylist
	  * returen index in list
	  */
	 public  int indexofAlternative(String s)
	 {
		  return this.alternatives.indexOf(s);
	 }
	 
	 /*
	  * add alternatives into the arraylist
	  */
	 public void addAlternative(String s)
	 {
		 if(this.indexofAlternative(s)==-1)
		 {
			 //add into arraylist
			 this.alternatives.add(s);
			 
		 }
		 else
		 {
			// System.out.print("已经存在");
		 }
		 
	 }
	 
	 /*
	  * delete alternative
	  */
	 public void deleteAlternative(String s)
	 {
		 if(this.indexofAlternative(s)!=-1)
		 {
			 this.alternatives.remove(s);
		 }
		 else
		 {
			// System.out.print("不存在，删除失败");
		 }
	 }
	 
	 /*
	  * delete all the alternatives in the arraylist
	  */
	 public void clearAlternatives( )
	 {
		 this.alternatives.clear();
	 }
	 
	 /*
	  * change paragraph position
	  */
	 public void changeParapositon(int i)
	 {		 
		 this.paraposition=i;	 
	 }
	 
	 /*
	  * change value-exist flag
	  */
	 public void chageValueexist(boolean  b)
	 {
		 this.valueexist=b;
	 }
	 
	 /*
	  * change the punctuation
	  */
	 public void changePunctuation(String s)
	 {
		 this.punctuation=s;
	 }
	 
	 public void changestaticfirstflag(boolean b)
	 {
		 this.staticfirst=b;
	 }
	 
	 
	 /*
	  * copy all information from a given st
	  */
	 public void  copyfrom(SentenceTemplate st)
	 {
		 this.String_static=st.String_static;
		 this.String_dynamic=st.String_dynamic;
		 
		 this.alternatives.clear();
		 for(String s:st.alternatives)
		 {
			 this.alternatives.add(s);
		 }
		 
		 this.paraposition=st.paraposition;
		 this.valueexist=st.valueexist;
		 this.punctuation=st.punctuation;
		 this.staticfirst=st.staticfirst;
	 }
	 
	 
	 /*
	  * print all the information of a ST
	  */
	 public void printSentenceTemplate()
	 {
		 System.out.println("固定文本："+this.String_static);
		 System.out.println("当前填入文本："+this.String_dynamic);
		 
		System.out.println("候选填入文本个数："+this.alternatives.size());
		System.out.println("***********************");
		 for(int i=1;i<=this.alternatives.size();i++)
		 {
			 System.out.println("候选"+i+":\t\t"+this.alternatives.get(i-1));
		 }
		System.out.println("***********************");
			
		 System.out.println("当前所在段落位置"+this.paraposition);
		 System.out.println("当前可填入状态"+this.valueexist);
		 System.out.println("当前句末标点"+this.punctuation);
	 }
	
	 /*
	  * only print the sentence text
	  */
	 public void printSentenceText()
	 {
		 if(this.staticfirst)
		 {
		 System.out.print(this.String_static+this.String_dynamic+this.punctuation);
		 }
		 else
		 {
		 System.out.print(this.String_dynamic+this.String_static+this.punctuation);
		 }
	 }
	 


	 
	 //*************************             small test in main   *****************************
	 
	 public static  void main(String[] args)
	 {
//		 SentenceTemplate st =new SentenceTemplate();
//		 st.String_static="早盘沪深指数";
//		 st.addAlternatives("快速杀跌");
//		 st.addAlternatives("快速上涨");
//		 st.addAlternatives("小幅震荡");
//		 st.addAlternatives("大幅高开");
//		 st.addAlternatives("大幅震荡");
		 ArrayList al=new ArrayList<String>();
		 al.add("快速杀跌");
		 al.add("快速上涨");
		 al.add("小幅震荡");
		 
		 SentenceTemplate st=new SentenceTemplate("早盘沪深指数",al);
		 
		 st.printSentenceTemplate();
		 
		 System.out.println("other test****************");
		 
		 st.addAlternative("大幅震荡");
		 st.changeStringStatic("早盘沪深");
		 st.printSentenceTemplate();
		 st.printSentenceText();
		 System.out.println("\r\nstart chang");
		 st.changeStringDynamic("123");
		 st.changePunctuation(",");
		 st.changestaticfirstflag(false);
		 st.printSentenceText();
		 System.out.println("\r\nstart chang");
		 st.changeStringStatic("");
		 st.printSentenceText();
	 }
	
}
