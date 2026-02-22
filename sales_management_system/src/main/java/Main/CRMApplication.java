package Main;
import java.util.Arrays;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sales_management_system.Address;
import com.services.CustomerService;
import com.services.LeadService;
import com.services.OrderService;
import com.services.ProductService;
import com.services.ReportService;
import com.services.SalesEmployeeService;
import com.services.TicketService;

public class CRMApplication {
    public static void main(String[] args) { 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        // Initialize all services
        CustomerService cs = new CustomerService(em);
        LeadService ls = new LeadService(em);
        ProductService ps = new ProductService(em);
        OrderService os = new OrderService(em);
        TicketService ts = new TicketService(em);
        ReportService rs = new ReportService(em);
        SalesEmployeeService ses = new SalesEmployeeService(em); 

        boolean running = true;
        while (running) {
            System.out.println("\n--- CRM Menu ---");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address To Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead To Employee");
            System.out.println("5. Convert Lead To Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Support Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");
            System.out.println("11. Add Sales Employee");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt(); 
            scanner.nextLine();

            switch (choice) {
                case 1: cs.registerCustomer("Alice", "alice@example.com", "9876543210"); break; 
                case 2: 
                    Address addr = new Address();
                    addr.setCity("New York");
                    cs.addAddressToCustomer(1L, addr); 
                    break; 
                case 3: ls.createLead("Bob", "Website", "bob@example.com"); break; 
                case 4: ls.assignLeadToEmployee(1L, 1L); break; 
                case 5: ls.convertLeadToCustomer(1L); break; 
                case 6: ps.addProduct("Enterprise Software", 1200.0); break; 
                case 7: os.placeOrder(1L, Arrays.asList(1L)); break; 
                case 8: ts.raiseTicket(1L, "Payment failed"); break; 
                case 9: rs.getEmployeePerformance(1L); break; 
                case 10: running = false; break; 
                case 11: 
                    // Adding a default employee so Option 4 works
                    ses.addEmployee("Jacob Collins", "Enterprise Sales"); 
                    break;
                default: System.out.println("Invalid option.");
            }
        }
        em.close();
        emf.close();
        scanner.close();
    }
}