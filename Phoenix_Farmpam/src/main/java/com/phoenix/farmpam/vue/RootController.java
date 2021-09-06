package com.phoenix.farmpam.vue;

import org.apache.catalina.tribes.ChannelException;
import org.apache.catalina.tribes.ErrorHandler;
import org.apache.catalina.tribes.UniqueId;
import org.springframework.stereotype.Controller;

@Controller
public class RootController implements ErrorHandler{
	@Override
	public void handleCompletion(UniqueId id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleError(ChannelException x, UniqueId id) {
		// TODO Auto-generated method stub
		
	}
	
}
