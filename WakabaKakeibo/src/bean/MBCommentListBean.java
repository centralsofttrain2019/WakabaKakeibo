package bean;

import java.util.List;

public class MBCommentListBean {

	private List<MBCommentBean> mbCList;

	public List<MBCommentBean> getMbCList() {
		return mbCList;
	}

	public void setMbCList(List<MBCommentBean> mbCList) {
		this.mbCList = mbCList;
	}

	@Override
	public String toString() {
		return "MBCommentListBean [mbCList=" + mbCList + "]";
	}

}
