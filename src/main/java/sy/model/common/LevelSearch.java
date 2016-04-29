package sy.model.common;

import java.io.Serializable;

/**
 * Created by lyq on 2016/4/26.
 */
public class LevelSearch implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String accreditId = "";// 授权编号
	protected int productType = 0;// 类型(0:标准版;1:通用版(有流程);2:通用版(无流程))
	protected String beginTime = "";// 开始时间
	protected String endTime = "";// 结束时间
	protected int departmentId = 0;// 分公司编号
	protected String followMan = "";// 跟单员

	public String getAccreditId() {
		return accreditId;
	}

	public void setAccreditId(String accreditId) {
		this.accreditId = accreditId;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getFollowMan() {
		return followMan;
	}

	public void setFollowMan(String followMan) {
		this.followMan = followMan;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public void clone(LevelSearch obj) {
		if (obj != null) {
			obj.accreditId = accreditId;
			obj.productType = productType;
			obj.beginTime = beginTime;
			obj.endTime = endTime;
			obj.departmentId = departmentId;
			obj.followMan = followMan;
		}
	}

}
