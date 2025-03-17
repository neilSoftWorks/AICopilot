public class KafkaConsumerService {
    @Autowired
    private CustomerService customerService;

    @KafkaListener(topics = "applications-topic", groupId = "group_id")
    public void consume(String message) {
        // Parse the message and update the Customers domain
        // Example: Create a new Customer based on the message
        Customer customer = new Customer();
        customer.setName("Extracted Name from Message");
        customer.setEmail("Extracted Email from Message");
        customerService.saveCustomer(customer);
    }
}