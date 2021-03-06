package jp.co.tecinfosys.L191_ERFileCreateSqlTool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const.ConstantCls;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.EntityBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.ReaderFileBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.RelationBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils.BeanListCreateUtil;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils.CreateRelationSQLUtil;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils.CreateTableSQLUtil;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils.FileReaderUtil;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils.WriteFileUtil;

/**
 * Hello world!
 *
 */
public class App {
//    private static final String PATH = "C:\\Temp\\testFile\\MYA32240.10.85.00.Ｅ_会計1_L19.a5er";
//
//    private static final String targetPath = "C:\\Temp\\outFile\\";

    public static void main(String[] args) {

        String fromPath = args[0];
        String toPath = args[1];

        List<String> fileList = getFileList(fromPath);

        for (String f : fileList) {
            ReaderFileBean bean = new ReaderFileBean();

            bean = FileReaderUtil.readerFileBean(f);

            List<EntityBean> entityList = new ArrayList<EntityBean>();
            List<RelationBean> relationBeanList = new ArrayList<RelationBean>();
            List<String> createTBList = new ArrayList<String>();

            entityList = BeanListCreateUtil.createTableList(bean.getEntityInfo());
            relationBeanList = bean.getRelationInfo();

            for (EntityBean e : entityList) {
                String fileName = StringUtils.replace(e.getTablePName(), ConstantCls.STR_DOLLAR_MARK,
                        ConstantCls.STR_UNDERBAR) + ConstantCls.STR_SQL_EXTENSION;
                String creatTbSql = CreateTableSQLUtil.body(e);
//                System.out.println(creatTbSql);
                WriteFileUtil.writeFile(toPath + fileName, creatTbSql);
                createTBList.add(e.getTablePName());
            }


            List<String> relationTargetName = new ArrayList<String>();
            List<RelationBean> wk_TargetRelationBeanList = new ArrayList<RelationBean>();
            for (RelationBean r : relationBeanList) {
                if (createTBList.indexOf(r.getEntity2()) != -1) {
                    relationTargetName.add(r.getEntity2().concat(r.getEntity1()));
                    wk_TargetRelationBeanList.add(r);
                }
            }

            relationTargetName = relationTargetName.stream().distinct().collect(Collectors.toList());

            List<RelationBean> targetRelationBeanList = new ArrayList<RelationBean>();

            if (relationTargetName.size() > 0) {

                for (String targetName : relationTargetName) {

                    int i = 1;

                    for (RelationBean wkRelationBean : wk_TargetRelationBeanList) {
                        if (StringUtils.equals(targetName, wkRelationBean.getEntity2().concat(wkRelationBean.getEntity1()))) {
                            wkRelationBean.setSeq(i);
                            i++;
                            targetRelationBeanList.add(wkRelationBean);
                        }
                    }
                }
            }

            for (RelationBean r : targetRelationBeanList) {
                String fileName = "Relation_"
                        + StringUtils.replace(r.getEntity2(), ConstantCls.STR_DOLLAR_MARK, ConstantCls.STR_UNDERBAR)
                        + ConstantCls.STR_SQL_EXTENSION;
                String creatRelationSql = CreateRelationSQLUtil.body(r);
//                    System.out.println(creatRelationSql);
                WriteFileUtil.writeFile(toPath + fileName, creatRelationSql);
            }

//            System.out.println(bean.toString());

//            System.out.println(entityList.toString());
        }

    }

    public static List<String> getFileList(String fromPath) {
        List<String> fileList = new ArrayList<>();

        if (StringUtils.isNotBlank(fromPath)) {
            // Fileクラスのオブジェクトを生成する
            File dir = new File(fromPath);
            if (dir.isFile()) {
                fileList.add(fromPath);
            } else {
                // listFilesメソッドを使用して一覧を取得する
                File[] files = dir.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].isFile()) {
                            fileList.add(files[i].toString());
                        }
                    }
                }
            }

        }
        return fileList;
    }

}
