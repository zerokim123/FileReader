package jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean;

public class Field {

	/** カラム物理名 */
	private String columnPName;

	/** カラム論理名 */
	private String columnLName;

	/** カラム型 */
	private String columnType;

	/** Null説明 */
	private String columnNULL;

	/** 主キー説明 */
	private String columnPriKey;

	/** デフォルト値 */
	private String columnDefaultValue;

	/** コメント説明 */
	private String columnComment;

	public String getColumnPName() {
		return columnPName;
	}

	public void setColumnPName(String columnPName) {
		this.columnPName = columnPName;
	}

	public String getColumnLName() {
		return columnLName;
	}

	public void setColumnLName(String columnLName) {
		this.columnLName = columnLName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnNULL() {
		return columnNULL;
	}

	public void setColumnNULL(String columnNULL) {
		this.columnNULL = columnNULL;
	}

	public String getColumnPriKey() {
		return columnPriKey;
	}

	public void setColumnPriKey(String columnPriKey) {
		this.columnPriKey = columnPriKey;
	}

	public String getColumnDefaultValue() {
		return columnDefaultValue;
	}

	public void setColumnDefaultValue(String columnDefaultValue) {
		this.columnDefaultValue = columnDefaultValue;
	}

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Field [");
        if (columnPName != null) {
            builder.append("columnPName=");
            builder.append(columnPName);
            builder.append(", ");
        }
        if (columnLName != null) {
            builder.append("columnLName=");
            builder.append(columnLName);
            builder.append(", ");
        }
        if (columnType != null) {
            builder.append("columnType=");
            builder.append(columnType);
            builder.append(", ");
        }
        if (columnNULL != null) {
            builder.append("columnNULL=");
            builder.append(columnNULL);
            builder.append(", ");
        }
        if (columnPriKey != null) {
            builder.append("columnPriKey=");
            builder.append(columnPriKey);
            builder.append(", ");
        }
        if (columnDefaultValue != null) {
            builder.append("columnDefaultValue=");
            builder.append(columnDefaultValue);
            builder.append(", ");
        }
        if (columnComment != null) {
            builder.append("columnComment=");
            builder.append(columnComment);
        }
        builder.append("]");
        return builder.toString();
    }

}
