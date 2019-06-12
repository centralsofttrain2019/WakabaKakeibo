package bean;

import java.util.List;

public class MBListBean {

	private List<MBBean> bBeanList;

	public List<MBBean> getbBeanList() {
		return bBeanList;
	}

	public void setbBeanList(List<MBBean> bBeanList) {
		this.bBeanList = bBeanList;
	}

	@Override
	public String toString() {
		return "MBListBean [bBeanList=" + bBeanList + "]";
	}


}
