package model.user.booking_user.pojo;

import java.util.HashMap;

public class AvailableTickets {
	private static HashMap<Integer,Ticket>available_tickets=new HashMap<Integer,Ticket>();
	
	public static Ticket getTicket(int pnr_no) {
		return available_tickets.get(pnr_no);
	}

	public static void addTicket(Ticket ticket) {
		available_tickets.put(ticket.getPnr_no(), ticket);
	}
}
