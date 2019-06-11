package jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const;

public class ConstantCls {

    public final static String STR_EQUALS = "=";
    public final static String STR_COMMA = ",";
    public final static String STR_D_QUOTATION = "\"";
    public final static String STR_S_QUOTATION = "'";
    public final static String STR_DOLLAR_MARK = "$";
    public final static String STR_UNDERBAR = "_";
    public final static String STR_SQL_EXTENSION = ".sql";

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

    public final static String STR_CA = "CA";
    public final static String STR_NA = "NA";
    public final static String RELATION_CA = "  on delete cascade\r\n" + "  on update cascade;\r\n"+"\r\nEND\r\n" + "GO";
    public final static String RELATION_NA = "  on delete no action\r\n" + "  on update no action;\r\n"+"\r\nEND\r\n"
            + "GO";;

    public final static String STR_SQL_HEADER = "----------------------------------------------------------------------------------------\r\n"
            + "-- 開発履歴\r\n"
            + "----------------------------------------------------------------------------------------\r\n"
            + "-- [Create]\r\n" + "-- DATE:2019/06/11\r\n" + "-- NAME:C.Jin(MTT)\r\n"
            + "----------------------------------------------------------------------------------------\r\n"
            + "USE SX\r\n" + "GO\r\n" + "\r\n";

    public final static String STR_TB_OPTION_START = "------------------------------------------------------------------------\r\n"
            + "--変更箇所\r\n" + "------------------------------------------------------------------------\r\n";
    public final static String STR_TB_OPTION_END = "------------------------------------------------------------------------\r\n"
            + "\r\n" + "IF EXISTS(  SELECT  *\r\n" + "            FROM    sys.extended_properties AS S01\r\n"
            + "                    LEFT OUTER JOIN sys.tables AS S02\r\n"
            + "                     ON S01.major_id = S02.object_id\r\n"
            + "                    INNER JOIN sys.schemas AS S03\r\n"
            + "                     ON S02.schema_id = S03.schema_id\r\n" + "            WHERE   S01.class = 1\r\n"
            + "             AND    S01.minor_id = 0\r\n" + "             AND    S02.name = @TableName\r\n"
            + "             AND    S03.name = @SchemaName\r\n" + "             AND    S01.name = N'Name')\r\n"
            + " BEGIN\r\n"
            + "    EXECUTE sp_dropextendedproperty N'Name', N'SCHEMA', @SchemaName, N'TABLE', @TableName, NULL, NULL;\r\n"
            + " END\r\n" + "\r\n"
            + "EXECUTE sp_addextendedproperty N'Name', @TableLogicalName, N'SCHEMA', @SchemaName, N'TABLE', @TableName, NULL, NULL;\r\n"
            + ";\r\n" + "GO";

}
