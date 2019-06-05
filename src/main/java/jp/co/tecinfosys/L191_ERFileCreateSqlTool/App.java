package jp.co.tecinfosys.L191_ERFileCreateSqlTool;

import java.util.ArrayList;
import java.util.List;

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
public class App
{
    private static final String PATH = "C:\\Temp\\testFile\\MYA32240.10.85.00.Ｅ_会計2_L19.a5er";

    private static final String targetPath = "C:\\Temp\\outFile\\";

    public static void main( String[] args )
    {

//        String fromPath = args[0];
//        String toPath = args[1];

        ReaderFileBean bean = new ReaderFileBean();

        bean = FileReaderUtil.readerFileBean(PATH);

        List<EntityBean> entityList = new ArrayList<EntityBean>();
        List<RelationBean> relationBeanList = new ArrayList<RelationBean>();
        List<String> createTBList = new ArrayList<String>();

        entityList = BeanListCreateUtil.createTableList(bean.getEntityInfo());
        relationBeanList = bean.getRelationInfo();

        for(EntityBean e : entityList) {
            String fileName = StringUtils.replace(e.getTablePName(), ConstantCls.STR_DOLLAR_MARK, ConstantCls.STR_UNDERBAR) + ConstantCls.STR_SQL_EXTENSION;
            String creatTbSql = CreateTableSQLUtil.body(e);
            System.out.println(creatTbSql);
            WriteFileUtil.writeFile(targetPath+fileName, creatTbSql);
            createTBList.add(e.getTablePName());
        }

        for(RelationBean r : relationBeanList) {
            if(createTBList.indexOf(r.getEntity2()) != -1) {
                String fileName = "Relation_" + StringUtils.replace(r.getEntity2(), ConstantCls.STR_DOLLAR_MARK, ConstantCls.STR_UNDERBAR) + ConstantCls.STR_SQL_EXTENSION;
                String creatRelationSql = CreateRelationSQLUtil.body(r);
                System.out.println(creatRelationSql);
                WriteFileUtil.writeFile(targetPath+fileName, creatRelationSql);
            }
        }

        System.out.println(bean.toString());

        System.out.println(entityList.toString());

        System.out.println( "Hello World!" );
    }


}
