package jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const;

public class ConstantCls {


    public final static String STR_EQUALS = "=";
    public final static String STR_COMMA = ",";
    public final static String STR_D_QUOTATION = "\"";

    public final static String STR_PNAME = "PName";
    public final static String STR_LNAME = "LName";
    public final static String STR_TABLE_OPTION = "TableOption";
    public final static String STR_FIELD = "Field";
    public final static String STR_NO_DDL = "NoDDL";
    public final static String STR_Index = "Index";

    public final static String STR_SQL_KEY_TABLEPNAME = "tablePName";
    public final static String STR_SQL_KEY_STRCOLUMNS = "strColumns";
    public final static String STR_SQL_KEY_STRINDEXS = "strIndexs";
    public final static String STR_SQL_KEY_TABLEOPTION = "tableOption";
    public final static String STR_SQL_KEY_INDEXPNAME = "indexPName";
    public final static String STR_SQL_KEY_STRINDEXTYPE = "strIndexType";
    public final static String STR_SQL_KEY_INDEXCOLUMN = "indexColumn";


    public final static String STR_TB_SQL_FORMAT = "IF NOT EXISTS(SELECT * FROM sysobjects WHERE name = '{tablePName}' AND type = 'U')\r\n" +
                                                         "BEGIN\r\n" +
                                                         "        create table [{tablePName}] (\r\n" +
                                                         "          {strColumns}\r\n" +
                                                         "        ) \r\n" +
                                                         "\r\n" +
                                                         "END\r\n" +
                                                         "GO\r\n" +
                                                         "\r\n" +
                                                         "{strIndexs}"+
                                                         "{tableOption}";

    public final static String STR_TB_INDEX_SQL_FORMAT = "IF NOT EXISTS(SELECT * FROM sys.indexes WHERE name = '{indexPName}')\r\n" +
                                                                "BEGIN\r\n" +
                                                                "        create {strIndexType} {indexPName}\r\n" +
                                                                "          on [{tablePName}]({indexColumn});\r\n" +
                                                                "END\r\n" +
                                                                "GO" +
                                                                "\r\n";




    public final static String STR_CA = "CA";
    public final static String STR_NA = "NA";
    public final static String RELATION_CA = "  on delete no action\r\n" + "  on update no action;\r\nEND\r\n" + "GO\r\n";
    public final static String RELATION_NA = "  on delete CASCADE\r\n" + "  on update CASCADE;\r\nEND\r\n" + "GO\r\n";





}
