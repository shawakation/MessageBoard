package com.yckj.messageboard.service;

import java.util.ArrayList;
import java.util.List;

import com.yckj.messageboard.dao.MessageDao;
import com.yckj.messageboard.vo.MessageInfo;

/**
 * Copyright(c) 2018 英才汇硕信息科技有限公司. All rights reserved
 * 
 * 发布留言业务实体
 * 
 * @author zhoujy
 * @version 1.0
 * @date 2018-10-18
 */
public class MessageService {
	
	/**
	 * 发布留言功能方法
	 * @param messageInfo
	 * @return
	 */
	public boolean sendMessageInfo(MessageInfo messageInfo) {
		boolean result = false;
		//操作MessageInfo数据的实体对象
		MessageDao messageDao = new MessageDao();
		
		//获取发件人信息
		String toUser = messageInfo.getToUser();
		boolean toUserResult = messageDao.queryUserByName(toUser);
		//toUserResult标识当前发件人是否存在，如果存在，则为true，进行发件操作
		if(toUserResult == true) {
			boolean sendMessageResult = messageDao.insertMessage(messageInfo);
			if(sendMessageResult == true) {
				result = true;
			}else {
				result = false;
			}
		}else {
			//如果toUserResult为false,意味着发件人不存在，不进行发件，返回发件失败
			result = false;
		}
		
		return result;
	}
	
	/**
	 * 通过收件人toUser查询该用户的收件信息
	 * @param toUser
	 * @return
	 */
	public List<MessageInfo> queryMessageByToUser(String toUser){
		List<MessageInfo> messageInfoList = new ArrayList<>();
		MessageDao messageDao = new MessageDao();
		messageInfoList = messageDao.queryMessageByToUser(toUser);
		return messageInfoList;
	}
	
	/**
	 * 通过id来删除对应的留言信息
	 * @param id
	 * @return
	 */
	public boolean deleteMessageById(int id) {
		/*boolean result = false;
		MessageDao messageDao = new MessageDao();
		result = messageDao.deleteMessageById(id);
		
		return result;*/
		
		return new MessageDao().deleteMessageById(id);
	}
	
	public static void main(String[] args) {
		MessageService messageService = new MessageService();
		List<MessageInfo> messageInfoList = messageService.queryMessageByToUser("lisi");
		System.out.println(messageInfoList.get(0).getMessageInfo());
		System.out.println(messageInfoList.get(1).getTitle());
	}

}
