package com.narcissus.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narcissus.api.entity.MessageEntity;
import com.narcissus.api.repository.MessageRepository;
import com.narcissus.api.service.exception.CustomException;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public void save(MessageEntity message) throws CustomException {
		messageRepository.save(message);
	}
}
