package com.cmq.module.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.cmq.module.domain.DomainEvent;

public class DomainEventGather {

	private BlockingQueue<DomainEvent> queues = new LinkedBlockingQueue<DomainEvent>(
			1000000);
	private static final DomainEventGather DOMAIN_EVENT_GATHER = new DomainEventGather();

	public static DomainEventGather get() {
		return DOMAIN_EVENT_GATHER;
	}

	public void gatherDomainEvent(DomainEvent domainEvent) {
		try {
			this.queues.put(domainEvent);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException==>>" + e.getMessage());
		}
	}

	public DomainEvent takeDomainEvent() {
		try {
			DomainEvent domainEvent = this.queues.take();
			return domainEvent;
		} catch (InterruptedException e) {
			System.out.println("InterruptedException==>>" + e.getMessage());
		}
		return null;
	}
	
	public boolean hasNext(){
		if(this.queues.isEmpty()){
			return false;
		}
		return true;
	}
}
