package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

		private Double pricePerHour;
		private Double pricePerDays;
		
		private texService  taxservice;
		
		public RentalService(Double pricePerHour, Double pricePerDays, BrazilTaxService braziltaxservice) {
			this.pricePerHour = pricePerHour;
			this.pricePerDays = pricePerDays;
			this.taxservice = braziltaxservice;
		}
		
		public void processInvoice(CarRental carRental) {
			
			double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
			double hours = minutes / 60.0;
			
			double basicPayment;
			if(hours <= 12 ) {
				basicPayment = pricePerHour * Math.ceil(hours) ;
			}else {
				basicPayment = pricePerDays * Math.ceil(hours / 24);
			}
			double tax = taxservice.tax(basicPayment);
			
			carRental.setInvoice(new Invoice(basicPayment, tax));
		}
		
		
		
		
}
