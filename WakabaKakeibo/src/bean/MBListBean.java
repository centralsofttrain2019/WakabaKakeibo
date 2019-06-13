package bean;

import java.util.List;
import java.util.Map;

public class MBListBean {

	private List<MBBean> bBeanList;
	private MBCommentListBean mbClb;
	private Map<Integer, List<MBCommentBean>> map;



	public MBListBean(List<MBBean> bBeanList, MBCommentListBean mbClb, Map<Integer, List<MBCommentBean>> map) {
		super();
		this.bBeanList = bBeanList;
		this.mbClb = mbClb;
		this.map = map;
	}



	public MBListBean() {
		super();
	}



	public Map<Integer, List<MBCommentBean>> getMap() {
		return map;
	}

	public void setMap(Map<Integer, List<MBCommentBean>> map) {
		this.map = map;
	}

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
		return "MBListBean [bBeanList=" + bBeanList + ", mbClb=" + mbClb + ", map=" + map + "]";
	}


}
