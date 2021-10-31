package models;

public class Message {
	private int message_id;
	private String message_sent;
	private String message_time_sent;
	private int id;
	private String name;
	public Message() {
		super();
	}
	public Message(int message_id, String message_sent, String message_time_sent, int id, String name) {
		super();
		this.message_id = message_id;
		this.message_sent = message_sent;
		this.message_time_sent = message_time_sent;
		this.id = id;
		this.name = name;
	}
	public Message(int message_id, String message_sent, String message_time_sent, String name) {
		super();
		this.message_id = message_id;
		this.message_sent = message_sent;
		this.message_time_sent = message_time_sent;
		this.name = name;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getMessage_sent() {
		return message_sent;
	}
	public void setMessage_sent(String message_sent) {
		this.message_sent = message_sent;
	}
	public String getMessage_time_sent() {
		return message_time_sent;
	}
	public void setMessage_time_sent(String message_time_sent) {
		this.message_time_sent = message_time_sent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
