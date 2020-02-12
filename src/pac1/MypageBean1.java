package pac1;

import java.io.Serializable;
import java.util.ArrayList;

public class MypageBean1 implements Serializable{

	private ArrayList<String> list;

	//constructor
	public MypageBean1() {

	}

	public void setValue(ArrayList<String> list) {
		this.list = list;
	}

	public ArrayList<String> getValue() {
		return list;
	}


}
