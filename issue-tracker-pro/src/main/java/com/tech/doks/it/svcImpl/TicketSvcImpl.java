package com.tech.doks.it.svcImpl;

import com.tech.doks.it.model.Ticket;
import com.tech.doks.it.svc.TicketSvc;
import com.tech.doks.it.util.NewTicketObject;

public class TicketSvcImpl implements TicketSvc {

	String status = null;

	@Override
	public String insertTicket() {
		try {
			Ticket t1 = new Ticket();
			t1.setId(101);
			t1.setSumm("UI not responsive");
			t1.setDesc("UI not responsive : In dashboard page.");
			t1.setAssign("Priyanka");
			Ticket t2 = new Ticket();
			t2.setId(102);
			t2.setSumm("Login page not proper");
			t2.setDesc("Login page not proper : Set the length of input field.");
			t2.setAssign("Ashish");
			Ticket t3 = new Ticket();
			t3.setId(103);
			t3.setSumm("Database not updated");
			t3.setDesc("Database not updated : Incorrect data comming from the server.");
			t3.setAssign("Dheeraj");
			NewTicketObject.addTicketObject(t1);
			NewTicketObject.addTicketObject(t2);
			NewTicketObject.addTicketObject(t3);
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
}