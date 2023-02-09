package model.entities;

import java.time.LocalDateTime;
 

public class CarRental {

	private LocalDateTime start;
	private LocalDateTime  finish;
	
	private Invoice invoice;
	private Vehiche vehiche;
	
	public CarRental() {
		
	}

	public CarRental(LocalDateTime start, LocalDateTime finish, Vehiche vehiche) {
		super();
		this.start = start;
		this.finish = finish;
		this.invoice = invoice;
		this.vehiche = vehiche;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getFinish() {
		return finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Vehiche getVehiche() {
		return vehiche;
	}

	public void setVehiche(Vehiche vehiche) {
		this.vehiche = vehiche;
	}

	
}
