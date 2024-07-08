package academy.prog;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*

	C-> 			S						List
				/add POST(JSON message) ->  0
				/get?from=3 GET				1
											2'
											3
 */

public class Message {
	private Date date = new Date();
	private String sender;
	private String receiver;
	private String text;

	public Message(String sender, String text, String receiver) {
		this.sender = sender;
		this.text = text;
		this.receiver = receiver;
	}

	public String toJSON() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(this);
	}
	
	public static Message fromJSON(String s) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.fromJson(s, Message.class);
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("[").append(date)
				.append(", Sender: ").append(sender).append(", Receiver: ").append(receiver)
				.append("] ").append(text)
                .toString();
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver () {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
