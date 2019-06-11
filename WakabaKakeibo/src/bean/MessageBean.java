package bean;

import dto.MessageDto;

public class MessageBean {

	private int MessageId;
	private String MessageContent;
	private String MessageType;
	private String EventType;



	public MessageBean(int messageId, java.lang.String messageCount, java.lang.String string,
			java.lang.String eventType) {
		super();
		this.MessageId = messageId;
		MessageContent = messageCount;
		MessageType = string;
		EventType = eventType;
	}

	//Dtoの値をBeanに移す
	public void setDto(MessageDto mDto) {
		this.MessageId = mDto.getMessageId();
		this.MessageContent = mDto.getMessageCount();
		this.MessageType = mDto.getMessageType();
		this.EventType = mDto.getEventType();
	}

	public MessageBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getMessageId() {
		return MessageId;
	}
	public void setMessageId(int messageId) {
		this.MessageId = messageId;
	}
	public String getMessageContent() {
		return MessageContent;
	}
	public void setMessageContent(String messageCount) {
		MessageContent = messageCount;
	}
	public String getMessageType() {
		return MessageType;
	}
	public void setMessageType(String string) {
		MessageType = string;
	}
	public String getEventType() {
		return EventType;
	}
	public void setEventType(String eventType) {
		EventType = eventType;
	}

	@Override
	public String toString() {
		return "MessageBean [MessageId=" + MessageId + ", MessageContent=" + MessageContent + ", MessageType=" + MessageType
				+ ", EventType=" + EventType + "]";
	}



}
