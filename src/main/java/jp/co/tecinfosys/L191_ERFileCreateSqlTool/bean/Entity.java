package jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean;

import java.util.List;

public class Entity {

	/** テーブル物理名 */
	private String tablePName;

	/** テーブル論理名 */
	private String tableLName;

	/** 拡張プロパティ */
	private String tableOption;

	/** テーブルカラムリスト */
	private List<Field> fieldList;

	/** DDL作成不要フラグ */
	private String NoDDL;

	public String getTablePName() {
		return tablePName;
	}

	public void setTablePName(String tablePName) {
		this.tablePName = tablePName;
	}

	public String getTableLName() {
		return tableLName;
	}

	public void setTableLName(String tableLName) {
		this.tableLName = tableLName;
	}

	public String getTableOption() {
		return tableOption;
	}

	public void setTableOption(String tableOption) {
		this.tableOption = tableOption;
	}

	public List<Field> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}

    public String getNoDDL() {
        return NoDDL;
    }

    public void setNoDDL(String noDDL) {
        NoDDL = noDDL;
    }

}
