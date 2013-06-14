package com.cmq.module.jgroups;

import java.io.InputStream;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.stack.IpAddress;

import com.cmq.module.domain.DomainEvent;
import com.cmq.module.util.JsonParser;

public class ProgrammaticSenderTest extends ReceiverAdapter  {

	JChannel channel;


	private void start() throws Exception {
       int i=0;
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("mudp.xml");
		channel = new JChannel(resourceAsStream);
		channel.connect("ChatCluster");
		View new_view=channel.getView();
		System.out.println(channel.getViewAsString());
		System.out.println("** view: " + new_view);
		List<Address> addresses=new_view.getMembers();
		for(Address ad:addresses){
			System.out.println("=====>>"+ad);
		}
		
		while(true){
			Thread.sleep(1000);
			i++;
			User owner = new User("code"+i,"name"+i);
			String encode = JsonParser.encode(new DomainEvent("mudp.xml", "", owner));
			IpAddress ipAddress = new IpAddress("192.168.213.136", 9005);
			Message message = new Message(ipAddress, encode);
			channel.send(message);
		}
		

	}

	public static void main(String[] args) throws Exception {

		new ProgrammaticSenderTest().start();

	}
	
	@Override
	public void receive(Message msg) {
		System.out.println(msg.getObject());
	}
	
	
}