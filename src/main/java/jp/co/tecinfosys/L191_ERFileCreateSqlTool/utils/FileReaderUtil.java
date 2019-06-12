package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.ReaderFileBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.RelationBean;

public class FileReaderUtil {

    public static ReaderFileBean readerFileBean(String pathStr) {
        ReaderFileBean readerFileBean = new ReaderFileBean();

        if (StringUtils.isNotBlank(pathStr)) {
            Path path = Paths.get(pathStr);
            File file = path.toFile();

            boolean skip = true;

            String readerType = "";

            List<List<String>> entityInfo = new ArrayList<>();

            List<List<String>> relationInfo = new ArrayList<>();

//            try (BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(skipUTF8BOM(new FileInputStream(file)), StandardCharsets.UTF_8));) {

                String str;

                List<String> wkLines = new ArrayList<>();

                while ((str = reader.readLine()) != null) {


                    if (str.equals("[Entity]")) {

                        skip = false;

                        readerType = "Entity";

                    } else if (str.equals("[Relation]")) {

                        skip = false;
                        readerType = "Relation";

                    }

                    if (!skip && StringUtils.isNotBlank(str)) {

                        wkLines.add(str);

                    }

                    if (str.startsWith("ZOrder")) {

                        if (StringUtils.equals(readerType, "Entity") && wkLines.size() >0) {

                            entityInfo.add(wkLines);

                        } else if (StringUtils.equals(readerType, "Relation") && wkLines.size() >0){

                            relationInfo.add(wkLines);

                        }
                        skip = true;

                        readerType = "";

                        wkLines = new ArrayList<>();

                    }

                }

                readerFileBean.setError(false);
                readerFileBean.setEntityInfo(entityInfo);

                readerFileBean.setRelationInfo(relation(relationInfo));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            return readerFileBean;
        }

        return readerFileBean;

    }

    private static List<RelationBean> relation(List<List<String>> relationInfo) {

        List<RelationBean> relation = new ArrayList<RelationBean>();

        for (List<String> wkList : relationInfo) {
            RelationBean wkRelation = new RelationBean();

            for (String wkStr : wkList) {

                List<String> wkStrList = Arrays.asList(wkStr.split("="));

                switch (wkStrList.get(0)) {
                case "Entity1":
                    wkRelation.setEntity1(wkStrList.get(1));
                    break;
                case "Entity2":
                    wkRelation.setEntity2(wkStrList.get(1));
                    break;
                case "Fields1":
                    wkRelation.setFields1(wkStrList.get(1));
                    break;
                case "Fields2":
                    wkRelation.setFields2(wkStrList.get(1));
                    break;
                case "Caption":
                    wkRelation.setCaption(wkStrList.size() == 2 ? wkStrList.get(1) : "");
                    break;
                default:
                }
            }

            relation.add(wkRelation);

        }

        return relation;

    }

    /** UTF-8のBOMをスキップする */
    public static InputStream skipUTF8BOM(InputStream is)throws Exception{
       if( !is.markSupported() ){
          // マーク機能が無い場合BufferedInputStreamを被せる
          is= new BufferedInputStream(is);
       }
       is.mark(3); // 先頭にマークを付ける
       if( is.available()>=3 ){
          byte b[]={0,0,0};
          is.read(b,0,3);
          if( b[0]!=(byte)0xEF || b[1]!=(byte)0xBB || b[2]!=(byte)0xBF ){
             is.reset();// BOMでない場合は先頭まで巻き戻す
          }
       }
       return is;
    }

}
