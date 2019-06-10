package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;


import java.util.List;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const.ConstantCls;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.EntityBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.FieldBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.IndexBean;


public class CreateTableSQLUtil {

    public static String body(EntityBean e) {

        String strColumns = strColumns(e.getTablePName(), e.getFieldList());

        String strIndexs = strIndexs(e.getTablePName(), e.getIndexList());

        String strSqlLast = strSqlLast(e.getTableOption(), e.getTablePName(), e.getTableLName());

        StringBuilder builder = new StringBuilder();
        builder.append("IF NOT EXISTS(SELECT * FROM sysobjects WHERE name = '");
        builder.append(e.getTablePName());
        builder.append("' AND type = 'U')\r\n");
        builder.append("BEGIN\r\n\r\n");
        builder.append("create table [");
        builder.append(e.getTablePName());
        builder.append("] (\r\n");
        builder.append("  " + strColumns);
        builder.append(");\r\nEND\r\nGO\r\n\r\n");

        builder.append(StringUtils.isBlank(strIndexs)? "" : strIndexs);

        builder.append(strSqlLast);

        return builder.toString();
    }

    public static String strColumns(String tablePName, List<FieldBean> fieldList) {
        StringBuilder builder = new StringBuilder();
        TreeMap<Integer, String> priKeyMap = new TreeMap<Integer, String>();

        for (FieldBean f : fieldList) {
            builder.append(f.getColumnPName() + " ");
            builder.append(f.getColumnType() + " ");
            builder.append(StringUtils.isBlank(f.getColumnDefaultValue())? "" : "default " + (f.getColumnDefaultValue() + " "));
            builder.append(StringUtils.isBlank(f.getColumnNULL())? "" : f.getColumnNULL());
            builder.append("\r\n  , ");
            if (StringUtils.isNotBlank(f.getColumnPriKey())) {
                priKeyMap.put(Integer.parseInt(f.getColumnPriKey()), f.getColumnPName());
            }
        }

        if(priKeyMap != null && priKeyMap.size() > 0) {
            builder.append("constraint [PK");
            builder.append(tablePName);
            builder.append("] primary key (");
            for (int i=0; i<priKeyMap.size(); i++) {
                builder.append(priKeyMap.get(i) + (i == priKeyMap.size()-1? "" : ConstantCls.STR_COMMA));
            }
            builder.append(")\r\n");
            return builder.toString();
        } else {
            return StringUtils.substringBeforeLast(builder.toString(), ConstantCls.STR_COMMA);
        }
    }

    public static String strIndexs(String tablePName, List<IndexBean> indexList) {
        StringBuilder builder = new StringBuilder();

        if(indexList != null && indexList.size() > 0) {
            for(IndexBean i : indexList) {
                builder.append("IF NOT EXISTS(SELECT * FROM sys.indexes WHERE name = '");
                builder.append(i.getIndexPName());
                builder.append("')\r\nBEGIN\r\n\r\n");
                builder.append("create");
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
                builder.append("\r\n  on [");
                builder.append(tablePName);
                builder.append("](");
                builder.append(i.getIndexColumn());
                builder.append(");\r\n\r\n");
                builder.append("END\r\nGO\r\n\r\n");
            }
        }
        return builder.toString();
    }

    public static String strSqlLast(String tableOption, String tablePName, String tableLName) {
        StringBuilder builder = new StringBuilder();

        if(StringUtils.isNotBlank(tableOption)) {
            builder.append(StringUtils.replace(tableOption, "\\n", "\r\n").replace("\\q", ConstantCls.STR_S_QUOTATION));
            builder.append(";\r\nGO\r\n");
        }else {
            builder.append(ConstantCls.STR_TB_OPTION_START);
            builder.append("SELECT   @SchemaName        = N'dbo'        ,@TableName         = N'");
            builder.append(tablePName);
            builder.append("'        ,@TableLogicalName  = N'");
            builder.append(tableLName);
            builder.append("'\r\n");
            builder.append(ConstantCls.STR_TB_OPTION_END);
        }

        return builder.toString();
    }


}
