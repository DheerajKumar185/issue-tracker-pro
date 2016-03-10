package com.tech.doks.it.util;

import java.util.ArrayList;
import java.util.List;

import com.tech.doks.it.model.Ticket;

public class NewTicketObject {

	public static List<Ticket> list = new ArrayList<Ticket>();

	public static String addTicketObject(Ticket ticket) {
		String status = "fail";
		try {
			list.add(ticket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}