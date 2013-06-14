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

public class ProgrammaticSender9006TEST extends ReceiverAdapter {

	JChannel channel;
    private String ip="192.168.2.10";

	private void start() throws Exception {
        int i=0;
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("mudp9006.xml");
		channel = new JChannel(resourceAsStream);
		channel.setReceiver(this);
		channel.connect("ChatCluster");
		View new_view=channel.getView();
		System.out.println(channel.getViewAsString());
		System.out.println("** view: " + new_view);
		List<Address> addresses=new_view.getMembers();
		for(Address ad:addresses){
			System.out.println("=====>>"+ad);
		}
		Thread.sleep(1000);
//		channel.close();
		while(true){
			Thread.sleep(1000);
			i++;
			User owner = new User("code"+i,"name"+i);
			String encode = JsonParser.encode(new DomainEvent("mudp9006.xml", "", owner));
			IpAddress ipAddress = new IpAddress(ip, 9005);
			channel.send(ipAddress,encode);
		}
		

	}

	public static void main(String[] args) throws Exception {

		new ProgrammaticSender9006TEST().start();

	}
	
	@Override
	public void viewAccepted(View view) {
		System.out.println("=====view==="+view.getViewId().getId()+" Members:"+view.getMembers().size());
	}
	
	@Override
	public void receive(Message msg) {
		System.out.println("comeback:"+msg.getObject().toString());
	}
	
}