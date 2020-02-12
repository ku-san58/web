package pac1;

import java.io.Serializable;

public class MypageBean2 implements Serializable{

	private String title;
	private String day;

	//constructor
	public MypageBean2() {

	}

	public void settitle(String title) {
		this.title = title;
	}

	public String gettitle() {
		return this.title;
	}

	public void setday(String day){
			this.day=day;
		}

	public String getday(String day) {
		return this.day;
	}

}
