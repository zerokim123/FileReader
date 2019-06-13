package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const.ConstantCls;
import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.RelationBean;

public class CreateRelationSQLUtil {

    public static String body(RelationBean relationBean) {

        StringBuilder builder = new StringBuilder();

        String fkName = createName(relationBean.getEntity1(), relationBean.getEntity2(), relationBean.getSeq());

        builder.append("IF NOT EXISTS(SELECT * FROM sysobjects WHERE name = '");
        builder.append(fkName);
        builder.append("' AND type = 'F')\r\n");
        builder.append("BEGIN\r\n");
        builder.append("\r\n");
        builder.append("alter table [");
        builder.append(relationBean.getEntity2());
        builder.append("]\r\n");
        builder.append("  add constraint [");
        builder.append(fkName);
        builder.append("] foreign key (");

        builder.append(relationBean.getFields2());
        builder.append(") references [");
        builder.append(relationBean.getEntity1());
        builder.append("](");
        builder.append(relationBean.getFields1());
        builder.append(")\r\n");

        if (StringUtils.equals(ConstantCls.STR_C1CA, relationBean.getCaption())
                || StringUtils.equals(ConstantCls.STR_C2CA, relationBean.getCaption())) {

            builder.append(ConstantCls.RELATION_CA);

        } else if (StringUtils.equals(ConstantCls.STR_C1NA, relationBean.getCaption())
                || StringUtils.equals(ConstantCls.STR_C2NA, relationBean.getCaption())) {
            builder.append(ConstantCls.RELATION_NA);
        }

        builder.append("\r\n");

        return builder.toString();

    }

    private static String createName(String entity1, String entity2 , int seq) {

        List<String> wkStrentity1 = Arrays.asList(entity1.split("[$]"));
        List<String> wkStrentity2 = Arrays.asList(entity2.split("[$]"));
        StringBuilder builderName = new StringBuilder();
        builderName.append("FK$");
        builderName.append(wkStrentity2.get(0));
        builderName.append(wkStrentity2.get(1));
        builderName.append("_");
        builderName.append(wkStrentity1.get(0));
        builderName.append(wkStrentity1.get(1));
        builderName.append("_");
        builderName.append(String.format("%02d", seq));
        return builderName.toString();
    }

}
