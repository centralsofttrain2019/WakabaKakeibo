package bean;

import domain.EventTypeEnum;
import domain.MessageTypeEnum;
import dto.MessageDto;

public class MessageBean {

	private int MessageId;
	private String SpeakerName;
	private String MessageContent;
	private MessageTypeEnum MessageType;
	private EventTypeEnum EventType;



	public MessageBean(int messageId, java.lang.String messageCount,
			MessageTypeEnum string,
			EventTypeEnum eventType) {
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
		this.SpeakerName = "わかば";
	}



	public String getSpeakerName()
	{
		return SpeakerName;
	}

	public void setSpeakerName(String speakerName)
	{
		SpeakerName = speakerName;
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
		return "MessageBean [MessageId=" + MessageId + ", MessageContent=" + MessageContent + ", MessageType=" + MessageType
				+ ", EventType=" + EventType + ", SpeakerName=" + SpeakerName + "]";
	}



}
