package sogo;

import java.io.Serializable;

public class ShohinBean implements Serializable {
	private String id;
	private String name;
	private int kakaku;
	
	public ShohinBean() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKakaku() {
		return kakaku;
	}

	public void setKakaku(int kakaku) {
		this.kakaku = kakaku;
	}

	
	
}
