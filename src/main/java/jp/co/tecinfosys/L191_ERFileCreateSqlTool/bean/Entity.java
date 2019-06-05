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

	/** テーブルIndexリスト */
	private List<Index> indexList;

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

	public List<Index> getIndexList() {
	    return indexList;
	}

	public void setIndexList(List<Index> indexList) {
	    this.indexList = indexList;
	}

        public String getNoDDL() {
            return NoDDL;
        }

        public void setNoDDL(String noDDL) {
            NoDDL = noDDL;
        }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Entity [");
        if (tablePName != null) {
            builder.append("tablePName=");
            builder.append(tablePName);
            builder.append(", ");
        }
        if (tableLName != null) {
            builder.append("tableLName=");
            builder.append(tableLName);
            builder.append(", ");
        }
        if (tableOption != null) {
            builder.append("tableOption=");
            builder.append(tableOption);
            builder.append(", ");
        }
        if (fieldList != null) {
            builder.append("fieldList=");
            builder.append(fieldList);
            builder.append(", ");
        }
        if (indexList != null) {
            builder.append("indexList=");
            builder.append(indexList);
            builder.append(", ");
        }
        if (NoDDL != null) {
            builder.append("NoDDL=");
            builder.append(NoDDL);
        }
        builder.append("]");
        return builder.toString();
    }



}
