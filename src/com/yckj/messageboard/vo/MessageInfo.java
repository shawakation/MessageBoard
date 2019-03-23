package com.yckj.messageboard.vo;

/**
 * Copyright(c) 2018 英才汇硕信息科技有限公司. All rights reserved
 * 
 * 留言信息表数据模型
 * 
 * @author zhoujy
 * @version 1.0
 * @date 2018-10-18
 */
public class MessageInfo {
	
	public int id;
	
	public String title;
	
	public String messageInfo;
	
	public String fromUser;
	
	/**
	 * 发布留言时间，字符串类型，数据库中也为字符串类型
	 */
	public String fromdate;
	
	public String toUser;
	
	public String status;
	
	public String bak1;
	
	public String bak2;
	
	public String bak3;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBak1() {
		return bak1;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

	public String getBak2() {
		return bak2;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public String getBak3() {
		return bak3;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}
}
