package yzwTax.itcast.nsfw.complain.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ComplainReply implements Serializable {

	private String replyId;
	private Complain complain;
	private String replyer;
	private String replyDept;
	private Timestamp replyTime;
	private String replyContent;

	public ComplainReply() {

	}

	public ComplainReply(Complain complain) {

		this.complain = complain;
	}

	public ComplainReply(String replyId, Complain complain, String replyer,
			String replyDept, Timestamp replyTime, String replyContent) {

		this.replyId = replyId;
		this.complain = complain;
		this.replyer = replyer;
		this.replyDept = replyDept;
		this.replyTime = replyTime;
		this.replyContent = replyContent;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public Complain getComplain() {
		return complain;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public String getReplyDept() {
		return replyDept;
	}

	public void setReplyDept(String replyDept) {
		this.replyDept = replyDept;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}
