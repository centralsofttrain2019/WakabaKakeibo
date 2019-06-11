package bean;
import domain.MessageEnum;
import domain.MessageTypeEnum;

public class MessageBean2 {

	private MessageEnum mes;
	private MessageTypeEnum type;

	public MessageBean2(MessageEnum mes, MessageTypeEnum type) {
		super();
		this.mes = mes;
		this.type = type;
	}

	public MessageBean2() {
		super();
	}

	public String say() {
		switch(this.mes) {
		case morning:

			switch(this.type) {
			case like:
				return "おはよう すき";
			case normal:
				return "おはよう";
			case unlike:
				return "おはよう　きらい";
			}


		case noon:
			return "こんにちは";

		case night:
			switch(this.type) {
			case like:
				return "こんばんわ すき";
			case normal:
				return "こんばんわ";
			case unlike:
				return "こんばんわ　きらい";
			}

		default:
			throw new RuntimeException("存在しません");
		}
	}



}
