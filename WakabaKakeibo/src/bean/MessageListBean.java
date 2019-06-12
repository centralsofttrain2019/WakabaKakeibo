package bean;

import java.util.List;

import dto.MessageDto;

public class MessageListBean {
	private List<MessageDto> mDtoList;
	private List<MessageBean> mBeanList;



	public List<MessageBean> getmBeanList() {
		return mBeanList;
	}

	public void setmBeanList(List<MessageBean> mBeanList) {
		this.mBeanList = mBeanList;
	}

	public List<MessageDto> getmDtoList() {
		return mDtoList;
	}

	public void setmDtoList(List<MessageDto> mDtoList) {
		this.mDtoList = mDtoList;
	}

	public MessageListBean(List<MessageDto> mDtoList) {
		super();
		this.mDtoList = mDtoList;
	}

	public MessageListBean() {
		super();

	}

	@Override
	public String toString() {
		return "MessageListBean [mDtoList=" + mDtoList + ", mBeanList=" + mBeanList + "]";
	}



}
