package jp.co.tecinfosys.L191_ERFileCreateSqlTool;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.ReaderFileBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils.BeanListCreateUtil;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils.FileReaderUtil;

/**
 * Hello world!
 *
 */
public class App
{
    private static final String PATH = "C:\\Users\\MTT190501\\Desktop\\Test\\MYA32240.10.85.00.Ｅ_会計1_L19.a5er";
    public static void main( String[] args )
    {


        ReaderFileBean bean = new ReaderFileBean();

        bean = FileReaderUtil.readerFileBean(PATH);

        BeanListCreateUtil.createRelationList(bean.getEntityInfo());

        System.out.println(bean.toString());

        System.out.println( "Hello World!" );
    }


}
