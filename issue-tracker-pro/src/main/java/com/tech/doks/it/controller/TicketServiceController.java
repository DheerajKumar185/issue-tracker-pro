package com.tech.doks.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.doks.it.svcImpl.TicketSvcImpl;

@Controller
public class TicketServiceController {

	TicketSvcImpl ticketSvcImpl = null;
	String status = "fail";

	@RequestMapping(value = "/initializeTicketDetails/", method = RequestMethod.POST)
	public @ResponseBody String initialize() {

		ticketSvcImpl = new TicketSvcImpl();
		status = ticketSvcImpl.insertTicket();

		return status;
	}

}