package jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean;

public class IndexBean {

	/** Index物理名 */
	private String indexPName;

	/** Index型 */
	private String indexType;

	/** Index項目 */
	private String indexColumn;

    public String getIndexPName() {
        return indexPName;
    }

    public void setIndexPName(String indexPName) {
        this.indexPName = indexPName;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public String getIndexColumn() {
        return indexColumn;
    }

    public void setIndexColumn(String indexColumn) {
        this.indexColumn = indexColumn;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Index [");
        if (indexPName != null) {
            builder.append("indexPName=");
            builder.append(indexPName);
            builder.append(", ");
        }
        if (indexType != null) {
            builder.append("indexType=");
            builder.append(indexType);
            builder.append(", ");
        }
        if (indexColumn != null) {
            builder.append("indexColumn=");
            builder.append(indexColumn);
            builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

}
