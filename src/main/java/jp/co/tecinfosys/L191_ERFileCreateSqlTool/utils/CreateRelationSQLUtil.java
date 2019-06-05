package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.util.Arrays;
import java.util.List;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const.ConstantCls;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.RelationBean;

public class CreateRelationSQLUtil {

    public static String body (RelationBean relationBean) {

        StringBuilder builder = new StringBuilder();

        String fkName = createName(relationBean.getEntity1(), relationBean.getEntity2());

        builder.append("IF NOT EXISTS(SELECT * FROM sysobjects WHERE name = '");
        builder.append(fkName);
        builder.append("' AND type = 'F')");
        builder.append("alter table [");
        builder.append(relationBean.getEntity2());
        builder.append("]\r\n");
        builder.append("  add constraint [");
        builder.append(fkName);
        builder.append("] foreign key (");

        builder.append(relationBean.getFields2());
        builder.append(") references [");
        builder.append(relationBean.getEntity1());
        builder.append("] (");
        builder.append(relationBean.getFields1());
        builder.append(")\r\n");

        if (ConstantCls.STR_NA.equals(relationBean.getCaption().substring(2, 3))) {

            builder.append(ConstantCls.RELATION_NA);

        } else {
            builder.append(ConstantCls.RELATION_CA);
        }

        return builder.toString();

    }

    private static String createName (String entity1, String entity2) {

        List<String> wkStrentity1 = Arrays.asList(entity1.split("$"));
        List<String> wkStrentity2 = Arrays.asList(entity2.split("$"));
        StringBuilder builderName = new StringBuilder();
        builderName.append("FK$");
        builderName.append(wkStrentity2.get(0));
        builderName.append(wkStrentity2.get(1));
        builderName.append("_");
        builderName.append(wkStrentity1.get(0));
        builderName.append(wkStrentity1.get(1));
        builderName.append("_01");
        return builderName.toString();
    }

}
