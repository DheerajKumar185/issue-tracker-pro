package com.tech.doks.it.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.doks.it.model.Ticket;
import com.tech.doks.it.svcImpl.GetListOfTicketImpl;

@Controller
public class GetTicketController {

	List<Ticket> list = null;
	GetListOfTicketImpl getListOfTicketImpl = null;

	@RequestMapping(value = "/getTicketDetails/", method = RequestMethod.POST)
	public @ResponseBody List<Ticket> getTicketDetails() {

		System.out.println("Calling getTicketDetails method");
		getListOfTicketImpl = new GetListOfTicketImpl();
		list = getListOfTicketImpl.getTicket();

		return list;
	}
}