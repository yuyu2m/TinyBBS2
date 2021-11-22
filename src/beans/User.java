package beans;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{ //implements Serializableが必要
	private String id;
	private String password;
	private String name;
	private Date entryDatetime;

	//カラのコンストラクタが必要
	public User() {
	}

	public User(String id, String password, String name, Date entryDatetime) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.entryDatetime = entryDatetime;
	}

	public User(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.entryDatetime = null;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEntryDatetime() {
		return entryDatetime;
	}

	public void setEntryDatetime(Date entryDatetime) {
		this.entryDatetime = entryDatetime;
	}

}
