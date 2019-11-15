package com.csuft.wxl.pojo;

public class Notice {
	String id;
	String notice_courseid;
	String notice_time;
	String notice_content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNotice_courseid() {
		return notice_courseid;
	}

	public void setNotice_courseid(String notice_courseid) {
		this.notice_courseid = notice_courseid;
	}

	public String getNotice_time() {
		return notice_time;
	}

	public void setNotice_time(String notice_time) {
		this.notice_time = notice_time;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", notice_courseid=" + notice_courseid + ", notice_time=" + notice_time
				+ ", notice_content=" + notice_content + "]";
	}

}
