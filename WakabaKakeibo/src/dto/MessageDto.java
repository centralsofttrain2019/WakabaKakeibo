package dto;

import domain.EventTypeEnum;
import domain.MessageTypeEnum;

public class MessageDto {
	private int MessageId;
	private String MessageCount;
	private MessageTypeEnum MessageType;
	private EventTypeEnum EventType;



	public MessageDto(int messageId, java.lang.String messageCount,
			MessageTypeEnum string,
			EventTypeEnum eventType) {
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


	public MessageTypeEnum getMessageType()
	{
		return MessageType;
	}

	public void setMessageType(MessageTypeEnum messageType)
	{
		MessageType = messageType;
	}

	public EventTypeEnum getEventType()
	{
		return EventType;
	}

	public void setEventType(EventTypeEnum eventType)
	{
		EventType = eventType;
	}

	@Override
	public String toString() {
		return "MessageDto [MessageId=" + MessageId + ", MessageCount=" + MessageCount + ", MessageType=" + MessageType
				+ ", EventType=" + EventType + "]";
	}



}
