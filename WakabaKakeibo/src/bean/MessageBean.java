package bean;

public class MessageBean {

	private MessageEnum mes;
	public String str = "hello";

	public MessageBean(MessageEnum mes) {
		super();
		this.mes = mes;
	}

	public MessageBean() {
		super();
	}

	public String say() {
		switch(this.mes) {
		case morning:
			return "おはよう";

		case noon:
			return "こんにちは";

		case night:
			return "こんばんわ";

		default:
			throw new RuntimeException("存在しません");
		}
	}



}
