package com.demomodel.utils.httpHelp.WebMagic.simhash;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import com.google.common.collect.Lists;


/**
 * IKAnalyzer分词工具
 * @author wgz
 * @date 创建时间：2020年7月16日 下午8:52:19
 */
public class IKAnalyzerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(IKAnalyzerSupport.class);
    public static void main(String[] args) throws Exception {
        String str="http://www.relaxheart.cn 是王琦同学的个人兴趣分享网站";
        System.out.println(iKSegmenterToList(str));
    }
    /**
     * IK分词
     * @param target
     * @return
     */
    public static List<String> iKSegmenterToList(String target) throws Exception {
        if (StringUtils.isEmpty(target)){
            return Lists.newArrayList();
        }
        List<String> result = new ArrayList<>();
        StringReader sr = new StringReader(target);
        // 关闭智能分词 (对分词的精度影响较大)
        IKSegmenter ik = new IKSegmenter(sr, false);
        Lexeme lex;
        while((lex=ik.next())!=null) {
            String lexemeText = lex.getLexemeText();
            result.add(lexemeText);
        }

        //LOGGER.info("company:{}, iKSegmenterToList:{}", target, JSON.toJSON(result));
        return result;
    }
}
//<!-- ikanalyzer 中文分词器  -->
//<dependency>
//    <groupId>com.janeluo</groupId>
//    <artifactId>ikanalyzer</artifactId>
//    <version>2012_u6</version>
//    <exclusions>
//        <exclusion>
//            <groupId>org.apache.lucene</groupId>
//            <artifactId>lucene-core</artifactId>
//        </exclusion>
//        <exclusion>
//            <groupId>org.apache.lucene</groupId>
//            <artifactId>lucene-queryparser</artifactId>
//        </exclusion>
//        <exclusion>
//            <groupId>org.apache.lucene</groupId>
//            <artifactId>lucene-analyzers-common</artifactId>
//        </exclusion>
//    </exclusions>
//</dependency>
//<!--  lucene-queryparser 查询分析器模块 -->
//<dependency>
//    <groupId>org.apache.lucene</groupId>
//    <artifactId>lucene-queryparser</artifactId>
//    <version>7.3.0</version>
//</dependency>