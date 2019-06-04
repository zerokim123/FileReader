package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.Entity;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.Field;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.Relation;

public class BeanListCreateUtil {




    public List<Entity> createRelationList(List<List<String>> strList) {

        List<Entity> entityList = new ArrayList<Entity>();

        for (List<String> strListEntity : strList) {
            Entity entity = new Entity();
            List<Field> fieldList = new ArrayList<Field>();
            for (String str : strListEntity) {
                Field field = new Field();
                int indx = StringUtils.indexOf(str, "=");
                String key = StringUtils.substring(str, 0, indx);
                String value = StringUtils.substring(str, indx);

                switch (key) {
                case "PName":
                    entity.setTablePName(value);
                    continue;
                case "LName":
                    entity.setTableLName(value);
                    continue;
                case "TableOption":
                    entity.setTableOption(value);
                    continue;
                case "Field":
                    String[] fields = value.split(",");
                    field.setColumnLName(fields[0]);
                    field.setColumnPName(fields[1]);
                    field.setColumnType(fields[2]);
                    field.setColumnNULL(fields[3]);
                    field.setColumnPriKey(fields[4]);
                    field.setColumnDefaultValue(fields[5]);
                    field.setColumnComment(fields[6]);
                    fieldList.add(field);
                    continue;
                case "NoDDL":
                    // TODO
                }

                break;
            }


         }

        return entityList;
    }


    public List<Relation> createEntityList(List<Entity> entityList, List<List<String>> strList) {


        return null;
    }

}
