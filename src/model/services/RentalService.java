package model.services;

import model.entities.CarRental;

public class RentalService {

		private Double pricePerHour;
		private Double pricePerDays;
		
		
		private BrazilTaxService  braziltaxservice;
		
		public RentalService(Double pricePerHour, Double pricePerDays, BrazilTaxService braziltaxservice) {
			this.pricePerHour = pricePerHour;
			this.pricePerDays = pricePerDays;
			this.braziltaxservice = braziltaxservice;
		}

		public void processInvoice(CarRental carRental) {
			carRental.setInvoice(null);
		}
		
		
		
		
}
