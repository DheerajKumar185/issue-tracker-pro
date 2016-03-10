package com.tech.doks.it.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.doks.it.model.Ticket;
import com.tech.doks.it.util.NewTicketObject;

@Controller
public class NewTicketController {

	@RequestMapping(value = "/newTicketDetail/", method = RequestMethod.POST)
	public @ResponseBody List<Ticket> getTicketDetails(@ModelAttribute Ticket ticket) {

		NewTicketObject.addTicketObject(ticket);

		System.out.println("id : " + ticket.getId());
		System.out.println("summ : " + ticket.getSumm());
		System.out.println("desc : " + ticket.getDesc());
		System.out.println("assign : " + ticket.getAssign());

		return NewTicketObject.list;
	}
}