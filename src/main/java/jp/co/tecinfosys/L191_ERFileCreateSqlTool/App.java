package jp.co.tecinfosys.L191_ERFileCreateSqlTool;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.ReaderFileBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils.FileReaderUtil;

/**
 * Hello world!
 *
 */
public class App
{
    private static final String PATH = "C:/Temp/testFile/MYA32240.10.85.00.Ｅ_会計2_L19.a5er";
    public static void main( String[] args )
    {


        ReaderFileBean bean = new ReaderFileBean();

        bean = FileReaderUtil.readerFileBean(PATH);

        System.out.println(bean.toString());

        System.out.println( "Hello World!" );
    }
    
    
}
