package com.csuft.wxl.pojo;

public class Discuss {

	String id;
	String dis_auto;
	String dis_per;
	String dis_title;
	String dis_content;
	String dis_time;

	// 联合查询数据
	String author_name;
	String author_photo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDis_auto() {
		return dis_auto;
	}

	public void setDis_auto(String dis_auto) {
		this.dis_auto = dis_auto;
	}

	public String getDis_per() {
		return dis_per;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getAuthor_photo() {
		return author_photo;
	}

	public void setAuthor_photo(String author_photo) {
		this.author_photo = author_photo;
	}

	public void setDis_per(String dis_per) {
		this.dis_per = dis_per;
	}

	public String getDis_title() {
		return dis_title;
	}

	public void setDis_title(String dis_title) {
		this.dis_title = dis_title;
	}

	public String getDis_content() {
		return dis_content;
	}

	public void setDis_content(String dis_content) {
		this.dis_content = dis_content;
	}

	public String getDis_time() {
		return dis_time;
	}

	public void setDis_time(String dis_time) {
		this.dis_time = dis_time;
	}

	@Override
	public String toString() {
		return "Discuss [id=" + id + ", dis_auto=" + dis_auto + ", dis_per=" + dis_per + ", dis_title=" + dis_title
				+ ", dis_content=" + dis_content + ", dis_time=" + dis_time + ", author_name=" + author_name
				+ ", author_photo=" + author_photo + "]";
	}

}
