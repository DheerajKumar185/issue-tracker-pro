package com.tech.doks.it.svcImpl;

import java.util.List;

import com.tech.doks.it.model.Ticket;
import com.tech.doks.it.svc.GetListOfTicket;
import com.tech.doks.it.util.NewTicketObject;

public class GetListOfTicketImpl implements GetListOfTicket{

	@Override
	public List<Ticket> getTicket() {		
		return NewTicketObject.list;
	}
}