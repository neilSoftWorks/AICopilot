public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String registrationNumber;
    // Other vehicle details

    // Getters and setters
}