package com.cmq.module.domain;

public class DomainEventHandler {

	public static void handle(DomainEvent domainEvent){
		System.out.println(domainEvent.getName());
	}
}
