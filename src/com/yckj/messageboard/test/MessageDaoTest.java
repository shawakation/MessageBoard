package com.yckj.messageboard.test;

import com.yckj.messageboard.dao.MessageDao;

/**
 * Copyright(c) 2018 英才汇硕信息科技有限公司. All rights reserved
 * 
 * 留言数据模型操作实体的测试类
 * 
 * @author zhoujy
 * @version 1.0
 * @date 2018-10-18
 */
public class MessageDaoTest {
	/**
	 * 主函数，测试留言信息的发布功能
	 * @param args
	 */
	public static void main(String[] args) {
		/*//创建dao对象
		MessageDao messageDao = new MessageDao();
		
		//创建数据模型对象
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setId((int)(Math.random() * 10000));
		messageInfo.setTitle("测试主题00001");
		messageInfo.setMessageInfo("测试内容0000001");
		messageInfo.setFromUser("zhangsan");
		messageInfo.setToUser("zhoujy123");
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = simpleDateFormat.format(date);
		System.out.println(date);
		System.out.println(dateStr);
		
		messageInfo.setFromdate(dateStr);
		
		//测试sql代码是否可以正常运行
		boolean result = messageDao.insertMessage(messageInfo);
		System.out.println(result);*/
		
		MessageDao messageDao = new MessageDao();
		boolean result = messageDao.queryUserByName("222222");
		System.out.println(result);
	}

}
