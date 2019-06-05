package jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const;

public class ConstantCls {


    public final static String STR_EQUALS = "=";

    public final static String STR_PNAME = "PName";
    public final static String STR_LNAME = "LName";
    public final static String STR_TABLE_OPTION = "TableOption";
    public final static String STR_FIELD = "Field";
    public final static String STR_NO_DDL = "NoDDL";




    public final static String STR_CA = "CA";
    public final static String STR_NA = "NA";
    public final static String RELATION_CA = "  on delete no action\r\n" + "  on update no action;\r\nEND\r\n" + "GO\r\n";
    public final static String RELATION_NA = "  on delete CASCADE\r\n" + "  on update CASCADE;\r\nEND\r\n" + "GO\r\n";


    public final static String STR_SQL_HEADER =
            "----------------------------------------------------------------------------------------\r\n" +
            "-- 開発履歴\r\n" +
            "----------------------------------------------------------------------------------------\r\n" +
            "-- [Create]\r\n" +
            "-- DATE:2014/07/18\r\n" +
            "-- NAME:T.Sano(OFM)\r\n" +
            "----------------------------------------------------------------------------------------\r\n" +
            "USE SX\r\n" +
            "GO\r\n";

}
