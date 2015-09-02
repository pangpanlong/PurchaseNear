package cn.purchasenear.v1.goods.consts;

public enum ElasticSearchTypeEnum {
	
	GOODS("purchasenear", "goods");
	//索引库
	private String index;
	//索引类型（表）
	private String type;
	
	
	private ElasticSearchTypeEnum(String index, String type) {
		this.index = index;
		this.type = type;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


}