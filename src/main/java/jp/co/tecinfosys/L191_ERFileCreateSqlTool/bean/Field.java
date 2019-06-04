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

}
