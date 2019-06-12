package bean;
import domain.EventTypeEnum;
import domain.MessageTypeEnum;

public class MessageBean2 {

	private EventTypeEnum mes;
	private MessageTypeEnum type;

	public MessageBean2(EventTypeEnum mes, MessageTypeEnum type) {
		super();
		this.mes = mes;
		this.type = type;
	}

	public MessageBean2() {
		super();
	}

	public String say() {
		switch(this.mes) {
		case MORNING:

			switch(this.type) {
			case LIKE:
				return "おはよう すき";
			case NORMAL:
				return "おはよう";
			case DISLIKE:
				return "おはよう　きらい";
			}


		case NOON:
			return "こんにちは";

		case NIGHT:
			switch(this.type) {
			case LIKE:
				return "こんばんわ すき";
			case NORMAL:
				return "こんばんわ";
			case DISLIKE:
				return "こんばんわ　きらい";
			}

		default:
			throw new RuntimeException("存在しません");
		}
	}



}
