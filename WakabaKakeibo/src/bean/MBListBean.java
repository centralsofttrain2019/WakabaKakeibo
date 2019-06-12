package bean;

import java.util.List;

public class MBListBean {

	private List<MBBean> bBeanList;
	private MBCommentListBean mbClb;

	public MBCommentListBean getMbClb() {
		return mbClb;
	}

	public void setMbClb(MBCommentListBean mbClb) {
		this.mbClb = mbClb;
	}

	public List<MBBean> getbBeanList() {
		return bBeanList;
	}

	public void setbBeanList(List<MBBean> bBeanList) {
		this.bBeanList = bBeanList;
	}

	@Override
	public String toString() {
		return "MBListBean [bBeanList=" + bBeanList + ", mbClb=" + mbClb + "]";
	}


}
