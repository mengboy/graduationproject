package com.bootdo;

import java.io.File;
import java.io.IOException;

class Test {

	private String id;
	private String pid;
	private String text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Test(String id, String pid, String text) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
	}

	public Test() {
		super();
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", pid=" + pid + ", text=" + text + "]";
	}

	public static void main(String[] args) throws IOException {
//		String path = "/Users/vector/IdeaProjects/bootdo/bootdo/target/classes/static/blog/9fd725d3a7b44a25b0da0b25dad379ab.jpg";
		String path = "/Users/vector/IdeaProjects/bootdo/bootdo/target/classes/static/blog/75e9c9966283423ab6173a2588bdf290.jpg";

		File file = new File(path);
		file.createNewFile();

		if(!file.exists()){

		}
	}

}
