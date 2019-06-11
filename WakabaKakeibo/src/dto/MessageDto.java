package dto;

public class MessageDto {
	private int MessageId;
	private String MessageCount;
	private String MessageType;
	private String EventType;



	public MessageDto(int messageId, java.lang.String messageCount, java.lang.String string,
			java.lang.String eventType) {
		super();
		this.MessageId = messageId;
		MessageCount = messageCount;
		MessageType = string;
		EventType = eventType;
	}

	public MessageDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getMessageId() {
		return MessageId;
	}
	public void setMessageId(int messageId) {
		this.MessageId = messageId;
	}
	public String getMessageCount() {
		return MessageCount;
	}
	public void setMessageCount(String messageCount) {
		MessageCount = messageCount;
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
		return "MessageDto [MessageId=" + MessageId + ", MessageCount=" + MessageCount + ", MessageType=" + MessageType
				+ ", EventType=" + EventType + "]";
	}



}
