package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;


import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const.ConstantCls;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.Entity;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.Field;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.Index;


public class CreateTableSQLUtil {

    public static String body(Entity e) {

        String sql = ConstantCls.STR_TB_SQL_FORMAT;

        String strColumns = strColumns(e.getTablePName(), e.getFieldList());

        String strIndexs = strIndexs(e.getTablePName(), e.getIndexList());

        StringBuilder builder = new StringBuilder();
        builder.append("IF NOT EXISTS(SELECT * FROM sysobjects WHERE name = '");
        builder.append(e.getTablePName());
        builder.append("' AND type = 'U')\r\nBEGIN\r\n");
        builder.append("        create table [");
        builder.append(e.getTablePName());
        builder.append("] (\r\n");
        builder.append("          " + strColumns);
        builder.append("        )\r\nEND\r\nGO");

        builder.append(StringUtils.isBlank(strIndexs)? "" : strIndexs);

        builder.append(StringUtils.isBlank(e.getTableOption())? "" : e.getTableOption());

        return sql;
    }

    public static String strColumns(String tablePName, List<Field> fieldList) {
        StringBuilder builder = new StringBuilder();
        String priKeys = "";

        for (Field f : fieldList) {
            builder.append(f.getColumnPName() + " ");
            builder.append(f.getColumnType() + " ");
            builder.append(StringUtils.isBlank(f.getColumnDefaultValue())? "" : " default " + (f.getColumnDefaultValue() + " "));
            builder.append(StringUtils.isBlank(f.getColumnNULL())? "" : f.getColumnNULL());
            builder.append("\r\n      , ");
            priKeys = priKeys + (StringUtils.isBlank(f.getColumnPriKey())? "" : (f.getColumnPName() + ","));
        }

        if(!priKeys.contentEquals("")) {
            builder.append("constraint [PK");
            builder.append(tablePName);
            builder.append("] primary key (");
            builder.append(StringUtils.substringBeforeLast(priKeys, ConstantCls.STR_COMMA));
            builder.append(")\r\n");
            return builder.toString();
        } else {
            return StringUtils.substringBeforeLast(builder.toString(), ConstantCls.STR_COMMA);
        }
    }

    public static String strIndexs(String tablePName, List<Index> indexList) {
        StringBuilder builder = new StringBuilder();

        if(indexList != null && indexList.size() > 0) {
            for(Index i : indexList) {
                builder.append("IF NOT EXISTS(SELECT * FROM sys.indexes WHERE name = '");
                builder.append(i.getIndexPName());
                builder.append(")\r\nBEGIN\r\n");
                builder.append("    create");
                switch (i.getIndexType()) {
                case "0":
                    builder.append(" index ");
                    break;
                case "1":
                    builder.append(" unique index ");
                    break;
                case "2":
                    builder.append(" clustered index ");
                    break;
                }
                builder.append(i.getIndexPName());
                builder.append("\r\n    on [");
                builder.append(tablePName);
                builder.append("](");
                builder.append(i.getIndexColumn());
                builder.append(");\r\n");
                builder.append("END\r\nGO\r\n");
            }
        }
        return builder.toString();
    }


}
