package com.csuft.wxl.pojo;

public class Notice {
//	消息的id
	String id;
	//消息的来源
	String notice_courseid;
	
	String notice_time;
	
	String notice_content;

	String student_id;
	String notice_read;
	
	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getNotice_read() {
		return notice_read;
	}

	public void setNotice_read(String notice_read) {
		this.notice_read = notice_read;
	}

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
				+ ", notice_content=" + notice_content + ", student_id=" + student_id + ", notice_read=" + notice_read
				+ "]";
	}

}
