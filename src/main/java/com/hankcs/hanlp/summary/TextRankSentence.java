/*
 * <summary></summary>
 * <author>He Han</author>
 * <email>hankcs.cn@gmail.com</email>
 * <create-date>2014/8/22 15:58</create-date>
 *
 * <copyright file="TextRank.java" company="上海林原信息科技有限公司">
 * Copyright (c) 2003-2014, 上海林原信息科技有限公司. All Right Reserved, http://www.linrunsoft.com/
 * This source is subject to the LinrunSpace License. Please contact 上海林原信息科技有限公司 to get more information.
 * </copyright>
 */
package com.hankcs.hanlp.summary;


import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.util.*;
import java.util.regex.*;

/**
 * TextRank 自动摘要
 * @author hankcs
 */
public class TextRankSentence
{
    /**
     * 阻尼系数（ＤａｍｐｉｎｇＦａｃｔｏｒ），一般取值为0.85
     */
    final static double d = 0.85;
    /**
     * 最大迭代次数
     */
    final static int max_iter = 200;
    final static double min_diff = 0.001;
    /**
     * 文档句子的个数
     */
    int D;
    /**
     * 拆分为[句子[单词]]形式的文档
     */
    List<List<String>> docs;
    /**
     * 排序后的最终结果 score <-> index
     */
    TreeMap<Double, Integer> top;

    /**
     * 句子和其他句子的相关程度
     */
    double[][] weight;
    /**
     * 该句子和其他句子相关程度之和
     */
    double[] weight_sum;
    /**
     * 迭代之后收敛的权重
     */
    double[] vertex;

    /**
     * BM25相似度
     */
    BM25 bm25;

    public TextRankSentence(List<List<String>> docs)
    {
        this.docs = docs;
        bm25 = new BM25(docs);
        D = docs.size();
        weight = new double[D][D];
        weight_sum = new double[D];
        vertex = new double[D];
        top = new TreeMap<Double, Integer>(Collections.reverseOrder());
        solve();
    }

    private void solve()
    {
        int cnt = 0;
        for (List<String> sentence : docs)
        {
            double[] scores = bm25.simAll(sentence);
//            System.out.println(Arrays.toString(scores));
            weight[cnt] = scores;
            weight_sum[cnt] = sum(scores) - scores[cnt]; // 减掉自己，自己跟自己肯定最相似
            vertex[cnt] = 1.0;
            ++cnt;
        }
        for (int _ = 0; _ < max_iter; ++_)
        {
            double[] m = new double[D];
            double max_diff = 0;
            for (int i = 0; i < D; ++i)
            {
                m[i] = 1 - d;
                for (int j = 0; j < D; ++j)
                {
                    if (j == i || weight_sum[j] == 0) continue;
                    m[i] += (d * weight[j][i] / weight_sum[j] * vertex[j]);
                }
                double diff = Math.abs(m[i] - vertex[i]);
                if (diff > max_diff)
                {
                    max_diff = diff;
                }
            }
            vertex = m;
            if (max_diff <= min_diff) break;
        }
        // 我们来排个序吧
        for (int i = 0; i < D; ++i)
        {
            top.put(vertex[i], i);
        }
    }

    /**
     * 获取前几个关键句子
     * @param size 要几个
     * @return 关键句子的下标
     */
    public int[] getTopSentence(int size)
    {
        Collection<Integer> values = top.values();
        size = Math.min(size, values.size());
        int[] indexArray = new int[size];
        Iterator<Integer> it = values.iterator();
        for (int i = 0; i < size; ++i)
        {
            indexArray[i] = it.next();
        }
        return indexArray;
    }

    /**
     * 简单的求和
     * @param array
     * @return
     */
    private static double sum(double[] array)
    {
        double total = 0;
        for (double v : array)
        {
            total += v;
        }
        return total;
    }

    public static void main(String[] args)
    {
        String document = "算法可大致分为基本算法、数据结构的算法、数论算法、计算几何的算法、图的算法、动态规划以及数值分析、加密算法、排序算法、检索算法、随机化算法、并行算法、厄米变形模型、随机森林算法。\n" +
                "算法可以宽泛的分为三类，\n" +
                "一，有限的确定性算法，这类算法在有限的一段时间内终止。他们可能要花很长时间来执行指定的任务，但仍将在一定的时间内终止。这类算法得出的结果常取决于输入值。\n" +
                "二，有限的非确定算法，这类算法在有限的时间内终止。然而，对于一个（或一些）给定的数值，算法的结果并不是唯一的或确定的。\n" +
                "三，无限的算法，是那些由于没有定义终止定义条件，或定义的条件无法由输入的数据满足而不终止运行的算法。通常，无限算法的产生是由于未能确定的定义终止条件。";
        System.out.println(TextRankSentence.getTopSentenceList(document, 3));
    }

    /**
     * 将文章分割为句子
     * @param document
     * @return
     */
    static List<String> spiltSentence(String document)
    {
        List<String> sentences = new ArrayList<String>();
        for (String line : document.split("[\r\n]"))
        {
            line = line.trim();
            if (line.length() == 0) continue;
            for (String sent : line.split("[。]"))
            {
                sent = sent.trim();
                if (sent.length() == 0) continue;
                sentences.add(sent);
            }
        }

        int length = sentences.size();
        for (int i = 0; i < length; i++)
        {
            String buffer = sentences.get(i);
            if (!buffer.contains("。"))
            {
                buffer = buffer + "。";
                sentences.set(i, buffer);
            }
        }
        return sentences;
    }

    /**
     * 一句话调用接口
     * @param document 目标文档
     * @param size 需要的关键句的个数
     * @return 关键句列表
     */
    public static List<String> getTopSentenceList(String document, int size)
    {
        List<String> sentenceList = spiltSentence(document);
        List<List<String>> docs = new ArrayList<List<String>>();
        for (String sentence : sentenceList)
        {
            List<Term> termList = StandardTokenizer.segment(sentence.toCharArray());
            List<String> wordList = new LinkedList<String>();
            for (Term term : termList)
            {
                if (CoreStopWordDictionary.shouldInclude(term))
                {
                    wordList.add(term.word);
                }
            }
            docs.add(wordList);
//            System.out.println(wordList);
        }
        TextRankSentence textRank = new TextRankSentence(docs);
        int[] topSentence = textRank.getTopSentence(size);
        List<String> resultList = new LinkedList<String>();
        for (int i : topSentence)
        {
            resultList.add(sentenceList.get(i));
        }
        return resultList;
    }

    /**
     * 一句话调用接口
     * @param document 目标文档
     * @param max_length 需要摘要的长度
     * @return 摘要文本
     */
    public static String getSummary(String document, int max_length)
    {
        document = mark_html_tag(document);
        List<String> sentenceList = spiltSentence(document);
        List<String> unstripped_list = deep_copy(sentenceList);
        List[] strip_result = strip_html_tag(sentenceList);
        List html_tags = strip_result[0];
        sentenceList = strip_result[1];

        int sentence_count = sentenceList.size();
        int document_length = document.length();
        int sentence_length_avg = document_length/sentence_count;
        int size = max_length/sentence_length_avg + 1;
        List<List<String>> docs = new ArrayList<List<String>>();
        for (String sentence : sentenceList)
        {
            List<Term> termList = StandardTokenizer.segment(sentence.toCharArray());
            List<String> wordList = new LinkedList<String>();
            for (Term term : termList)
            {
                if (CoreStopWordDictionary.shouldInclude(term))
                {
                    wordList.add(term.word);
                }
            }
            docs.add(wordList);
//            System.out.println(wordList);
        }

        TextRankSentence textRank = new TextRankSentence(docs);
        int[] topSentence = textRank.getTopSentence(size);
        List<String> resultList = new LinkedList<String>();
        for (int i : topSentence)
        {
            resultList.add(sentenceList.get(i));
        }

        resultList = permutation(resultList, sentenceList);
        resultList = pick_sentences(resultList, max_length);
        resultList = restore_html_tagging(resultList, unstripped_list, html_tags);
        //String summary = String.join("", resultList); // incompatible with .net in Storm clusters
        String summary = "";
        for(String temp : resultList)
        {
        	summary += temp;
        }
        return summary;
    }

    public static List<String> permutation(List<String> resultList, List<String> sentenceList)
    {
        int index_buffer_x;
        int index_buffer_y;
        String sen_x;
        String sen_y;
        int length = resultList.size();
        // bubble sort derivative
        for (int i = 0; i < length; i++)
            for (int offset=0; offset < length - i; offset++)
            {
                sen_x = resultList.get(i);
                sen_y = resultList.get(i + offset);
                index_buffer_x = sentenceList.indexOf(sen_x);
                index_buffer_y = sentenceList.indexOf(sen_y);
                // if the sentence order in sentenceList does not conform that is in resultList, reverse it
                if (index_buffer_x > index_buffer_y)
                {
                    resultList.set(i, sen_y);
                    resultList.set(i+offset, sen_x);
                }
            }

        return resultList;
    }

    public static List<String> pick_sentences(List<String> resultList, int max_length)
    {
        int length_counter = 0;
        int length_buffer;
        int length_jump;
        List<String> resultBuffer = new LinkedList<String>();
        for(int i = 0; i < resultList.size(); i++)
        {
            length_buffer = length_counter + resultList.get(i).length();
            if (length_buffer <= max_length)
            {
                resultBuffer.add(resultList.get(i));
                length_counter += resultList.get(i).length();
            }
            else if (i < (resultList.size()-1)) {
                length_jump = length_counter + resultList.get(i+1).length();
                if (length_jump <= max_length) {
                    resultBuffer.add(resultList.get(i + 1));
                    length_counter += resultList.get(i + 1).length();
                    i++;
                }
            }
        }
        return resultBuffer;
    }

    public static String mark_html_tag(String document)
    {
        String original = ">";
        String replaced = ">。";
        String new_doc = document.replace(original, replaced);
        return new_doc;
    }

    public static List[] strip_html_tag(List<String> sentenceList)
    {
        String pattern = "<.+?>";
        Pattern r = Pattern.compile(pattern);
        List html_tags = new ArrayList();
        String html_tag_buffer;
        for(int i = 0; i < sentenceList.size(); i++)
        {
            Matcher m = r.matcher(sentenceList.get(i));
            if(m.find())
            {
                html_tag_buffer = sentenceList.remove(i);
                html_tags.add(html_tag_buffer);
                i--;
            }
        }

        List[] result_lists = new List[2];
        result_lists[0] = html_tags;
        result_lists[1] = sentenceList;
        return result_lists;
    }

    public static List<String> restore_html_tagging(List<String> resultList, List<String> sentenceList, List<String> htmlTag)
    {
        int tagging_count = htmlTag.size();
        String tagging;
        String buffer;
        int tagging_index;
        int sentence_index;
        for(int i = 0; i < tagging_count; i++) {
            boolean unfinished_marking = true;
            tagging = htmlTag.get(i);
            tagging_index = sentenceList.indexOf(tagging);
            for (int j = 0; j < resultList.size(); j++)
            {
                buffer = resultList.get(j);
                sentence_index = sentenceList.indexOf(buffer);
                if(sentence_index > tagging_index)
                {
                    tagging = tagging.replace("。", "");
                    tagging = "<br>" + tagging;  // create a new line after each picture
                    resultList.add(j, tagging);
                    unfinished_marking = false;
                    break;
                }
            }
            if(unfinished_marking)
            {
                tagging = tagging.replace("。", "");
                tagging = "<br>" + tagging;   // create a new line after each picture
                resultList.add(tagging);
            }
        }
        return resultList;
    }



    public static List<String> deep_copy(List<String> list_src)
    {
        List<String> list_dst =new ArrayList<String>();
        for(String mystr : list_src)
        {
            list_dst.add(mystr);
        }
        return list_dst;
    }
}
