package jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean;

public class Relation {

	/** 関連テーブル１ */
	private String Entity1;

	/** 関連テーブル２ */
	private String Entity2;

	/** 関連キー１ */
	private String Fields1;

	/** 関連キー２ */
	private String Fields2;

	/** 関連関係 */
	private String Caption;

	public String getEntity1() {
		return Entity1;
	}

	public void setEntity1(String entity1) {
		Entity1 = entity1;
	}

	public String getEntity2() {
		return Entity2;
	}

	public void setEntity2(String entity2) {
		Entity2 = entity2;
	}

	public String getFields1() {
		return Fields1;
	}

	public void setFields1(String fields1) {
		Fields1 = fields1;
	}

	public String getFields2() {
		return Fields2;
	}

	public void setFields2(String fields2) {
		Fields2 = fields2;
	}

	public String getCaption() {
		return Caption;
	}

	public void setCaption(String caption) {
		Caption = caption;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Relation [");
        if (Entity1 != null) {
            builder.append("Entity1=");
            builder.append(Entity1);
            builder.append(", ");
        }
        if (Entity2 != null) {
            builder.append("Entity2=");
            builder.append(Entity2);
            builder.append(", ");
        }
        if (Fields1 != null) {
            builder.append("Fields1=");
            builder.append(Fields1);
            builder.append(", ");
        }
        if (Fields2 != null) {
            builder.append("Fields2=");
            builder.append(Fields2);
            builder.append(", ");
        }
        if (Caption != null) {
            builder.append("Caption=");
            builder.append(Caption);
        }
        builder.append("]");
        return builder.toString();
    }

}
