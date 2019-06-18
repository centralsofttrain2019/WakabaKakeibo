package bean;

import java.util.ArrayList;
import java.util.List;

import dto.DepositDto;

public class SimulationListBean {

	private List<SimulationBean> list = new ArrayList<SimulationBean>();
	private int targetAmount;

	public List<SimulationBean> getSimList() {
		return list;
	}

	public void add(DepositDto depositDto, String hiddenName) {

		//isRealをStringに変換
		String strIsReal = String.valueOf(depositDto.isReal());

		SimulationBean bean = new SimulationBean(depositDto.getDate(), depositDto.getBalance(), strIsReal, hiddenName);

		//リストに追加
		list.add(bean);

	}

	public int getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}



}