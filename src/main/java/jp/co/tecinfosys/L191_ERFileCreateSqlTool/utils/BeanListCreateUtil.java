package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const.ConstantCls;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.Entity;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.Field;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.RelationBean;

public class BeanListCreateUtil {




    public static List<Entity> createRelationList(List<List<String>> strList) {

        List<Entity> entityList = new ArrayList<Entity>();

        for (List<String> strListEntity : strList) {

            Entity entity = new Entity();
            List<Field> fieldList = new ArrayList<Field>();

            for (String str : strListEntity) {

                Field field = new Field();
                int indx = StringUtils.indexOf(str, ConstantCls.STR_EQUALS);
                String key = StringUtils.substring(str, 0, indx);
                String value = StringUtils.substring(str, indx+1);

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
                    field.setColumnLName(fields[0].replaceFirst("\"", ""));
                    field.setColumnPName(fields[1]);
                    field.setColumnType(fields[2]);
                    field.setColumnNULL(fields[3]);
                    field.setColumnPriKey(fields[4]);
                    field.setColumnDefaultValue(fields[5]);
                    field.setColumnComment(fields[6]);
                    fieldList.add(field);
                    entity.setFieldList(fieldList);
                    continue;
                case ConstantCls.STR_NO_DDL:
                    entity.setNoDDL(value);
                }

            }

            if (StringUtils.isEmpty(entity.getNoDDL())) {
                entityList.add(entity);
            }

         }

        return entityList;
    }


    public static List<RelationBean> createEntityList(List<Entity> entityList, List<List<String>> strList) {


        return null;
    }


    public static String[] createFiled(String value) {
        String[] str = new String[9];

        for (int i=0; i<9; i++) {
            if(value.startsWith("\"")) {
                value = StringUtils.substring(value, 1);
                str[i] = StringUtils.substring(value, 0, value.indexOf("\""));
                value = StringUtils.substring(value, value.indexOf("\"") + 2);
            } else if (value.startsWith(",")) {
                str[i] = "";
                value = StringUtils.substring(value, 1);
            } else {
                str[i] =StringUtils.substring(value, 0, value.indexOf(","));
                value = StringUtils.substring(value, value.indexOf(",")+1);
            }
        }

        return str;
    }

}
