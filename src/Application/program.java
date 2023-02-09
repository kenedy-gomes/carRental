package Application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehiche;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.println("Modelo do carro");
		String carModel = sc.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine());
		System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine());
		
		CarRental carrental = new CarRental(start, finish, new Vehiche(carModel));
		
		System.out.println("Entre com o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		
		System.out.println("Entre com o preço por dia: ");
		double pricePerDays = sc.nextDouble();
		
		
		RentalService rentalService = new RentalService(pricePerDays, pricePerDays, new BrazilTaxService());
		
		rentalService.processInvoice(carrental);
		
		System.out.println("FATURA: ");
		
		System.out.println("Pagamento Básico: " + carrental.getInvoice().getBasicPayment());
		System.out.println("Imposto: " + carrental.getInvoice().getTax());
		System.out.println("Pagamento total: " + carrental.getInvoice().totalPayment());
		
		
	}

}
