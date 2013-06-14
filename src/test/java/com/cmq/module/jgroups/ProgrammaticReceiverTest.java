package com.cmq.module.jgroups;

import java.io.InputStream;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import com.cmq.module.domain.DomainEvent;

public class ProgrammaticReceiverTest extends ReceiverAdapter  {

	JChannel channel;


	private void start() throws Exception {
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("mudp.xml");
		channel = new JChannel(resourceAsStream);
		channel.setReceiver(this);
		channel.connect("ChatCluster");
	
	

	}
	

	public static void main(String[] args) throws Exception {

		new ProgrammaticReceiverTest().start();

	}
	
	@Override
	public void viewAccepted(View new_view) {
	    System.out.println("** view: " + new_view);
		List<Address> addresses=new_view.getMembers();
		for(Address ad:addresses){
			System.out.println("=====>>"+ad.toString());
		}
	}
	
	@Override
	public void receive(Message msg) {
		System.out.println("from:"+msg.getDest());
		DomainEvent object = (DomainEvent) msg.getObject();
			System.out.println(object.getCode()+","+object.getName());
		
	}
}