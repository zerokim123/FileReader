package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const.ConstantCls;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.EntityBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.FieldBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.IndexBean;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.RelationBean;

public class BeanListCreateUtil {




    public static List<EntityBean> createTableList(List<List<String>> strList) {

        List<EntityBean> entityList = new ArrayList<EntityBean>();

        for (List<String> strListEntity : strList) {

            EntityBean entity = new EntityBean();
            List<FieldBean> fieldList = new ArrayList<FieldBean>();
            List<IndexBean> indexList = new ArrayList<IndexBean>();

            for (String str : strListEntity) {

                FieldBean field = new FieldBean();
                IndexBean index = new IndexBean();
                int indexEquals = StringUtils.indexOf(str, ConstantCls.STR_EQUALS);
                String key = StringUtils.substring(str, 0, indexEquals);
                String value = StringUtils.substring(str, indexEquals+1);

                switch (key) {
                case ConstantCls.STR_PNAME:
                    entity.setTablePName(value);
                    continue;
                case ConstantCls.STR_LNAME:
                    entity.setTableLName(value);
                    continue;
                case ConstantCls.STR_TABLE_OPTION:
                    entity.setTableOption(value);
                    continue;
                case ConstantCls.STR_FIELD:
                    String[] fields = createFiled(value);
                    field.setColumnLName(fields[0].replaceFirst(ConstantCls.STR_D_QUOTATION, ""));
                    field.setColumnPName(fields[1]);
                    field.setColumnType(fields[2]);
                    field.setColumnNULL(fields[3]);
                    field.setColumnPriKey(fields[4]);
                    field.setColumnDefaultValue(StringUtils.replace(fields[5], "\\q", ConstantCls.STR_S_QUOTATION));
                    field.setColumnComment(fields[6]);
                    fieldList.add(field);
                    continue;
                case ConstantCls.STR_Index:
                    int i = StringUtils.indexOf(value, ConstantCls.STR_EQUALS);
                    index.setIndexPName(StringUtils.substring(value, 0, i));
                    index.setIndexType(StringUtils.substring(value, i+1 , i+2));
                    index.setIndexColumn(StringUtils.substring(value, i+3));
                    indexList.add(index);
                    continue;
                case ConstantCls.STR_NO_DDL:
                    entity.setNoDDL(value);
                }

            }

            entity.setFieldList(fieldList);
            entity.setIndexList(indexList);

            if (StringUtils.isEmpty(entity.getNoDDL())) {
                entityList.add(entity);
            }

         }

        return entityList;
    }


    public static List<RelationBean> createEntityList(List<EntityBean> entityList, List<List<String>> strList) {


        return null;
    }


    public static String[] createFiled(String value) {
        String[] str = new String[9];

        for (int i=0; i<9; i++) {
            if(value.startsWith(ConstantCls.STR_D_QUOTATION)) {
                value = StringUtils.substring(value, 1);
                str[i] = StringUtils.substring(value, 0, value.indexOf(ConstantCls.STR_D_QUOTATION));
                value = StringUtils.substring(value, value.indexOf(ConstantCls.STR_D_QUOTATION) + 2);
            } else if (value.startsWith(ConstantCls.STR_COMMA)) {
                str[i] = "";
                value = StringUtils.substring(value, 1);
            } else {
                str[i] =StringUtils.substring(value, 0, value.indexOf(ConstantCls.STR_COMMA));
                value = StringUtils.substring(value, value.indexOf(ConstantCls.STR_COMMA)+1);
            }
        }

        return str;
    }

}
