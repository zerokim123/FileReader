package jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean;

import java.util.List;

public class ReaderFileBean implements java.io.Serializable {

    private boolean isError = true;

    private List<List<String>> entityInfo = null;

    private List<List<String>>  relationInfo = null;

    public ReaderFileBean() {

    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    public List<List<String>>  getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(List<List<String>>  entityInfo) {
        this.entityInfo = entityInfo;
    }

    public List<List<String>> getRelationInfo() {
        return relationInfo;
    }

    public void setRelationInfo(List<List<String>>  relationInfo) {
        this.relationInfo = relationInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ReaderFileBean [isError=");
        builder.append(isError);
        builder.append(", entityInfo=");
        builder.append(entityInfo);
        builder.append(", relationInfo=");
        builder.append(relationInfo);
        builder.append("]");
        return builder.toString();
    }

}
