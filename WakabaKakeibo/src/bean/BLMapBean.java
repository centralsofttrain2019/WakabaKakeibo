package bean;

import java.util.List;
import java.util.Map;

public class BLMapBean {

	private Map<Integer, List<BLBean>> map;

	public Map<Integer, List<BLBean>> getMap() {
		return map;
	}

	public void setMap(Map<Integer, List<BLBean>> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "BLMapBean [map=" + map + "]";
	}


	public int getLikeCount(int BlogID) {

		if(this.map.containsKey(BlogID)) {
			return this.map.get(BlogID).size();
		}
			return 0;
	}

	public boolean isCheckedLike(int BlogID, int UserID) {

		if(this.map.containsKey(BlogID)) {

			for(BLBean blb : this.map.get(BlogID)) {
				if(blb.getUserID() == UserID) {
					return true;
				}
			}

		}

		return false;
	}




}
