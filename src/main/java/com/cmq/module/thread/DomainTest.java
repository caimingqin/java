package com.cmq.module.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cmq.module.domain.DomainEvent;
import com.cmq.module.domain.DomainEventHandler;

public class DomainTest {

	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
		DomainEventGather domainEventGather = DomainEventGather.get();
		int i = 0;
		while(i <40) {
			i++;
			domainEventGather.gatherDomainEvent(new DomainEvent("code" + i,
					"name" + i));
		}
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("i====>>"+i);
		int j=0;
		while (true) {
			// newFixedThreadPool.execute(new Runnable() {
			//
			// @Override
			// public void run() {
			//
			//
			// }
			// });
			j++;
			final DomainEvent domainEvent = domainEventGather.takeDomainEvent();
			if (domainEvent != null) {
				newFixedThreadPool.execute(new Runnable() {

					@Override
					public void run() {
						DomainEventHandler.handle(domainEvent);

					}
				});
			}
			if(j==400000){
				
				System.out.println("need time:"+(System.currentTimeMillis()-currentTimeMillis));
			}

		}
		
		
	}
}
