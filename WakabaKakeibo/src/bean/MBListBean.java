package bean;

import java.util.List;
import java.util.Map;

public class MBListBean {

	private List<MBBean> bBeanList;
	private MBCommentListBean mbClb;
	private Map<Integer, List<MBCommentBean>> cMap;
	private BLMapBean blMap;



	public MBListBean(List<MBBean> bBeanList, MBCommentListBean mbClb, Map<Integer, List<MBCommentBean>> cMap,
			BLMapBean blMap) {
		super();
		this.bBeanList = bBeanList;
		this.mbClb = mbClb;
		this.cMap = cMap;
		this.blMap = blMap;
	}



	public MBListBean() {
		super();
	}


	public BLMapBean getBlMap() {
		return blMap;
	}



	public void setBlMap(BLMapBean blMap) {
		this.blMap = blMap;
	}



	public Map<Integer, List<MBCommentBean>> getCmap() {
		return cMap;
	}

	public void setCmap(Map<Integer, List<MBCommentBean>> cMap) {
		this.cMap = cMap;
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
		return "MBListBean [bBeanList=" + bBeanList + ", mbClb=" + mbClb + ", cMap=" + cMap + ", blMap=" + blMap + "]";
	}


}
