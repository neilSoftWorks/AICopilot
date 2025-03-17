public class BalanceService {
    @Autowired
    private BalanceRepository balanceRepository;

    public Balance saveBalance(Balance balance) {
        return balanceRepository.save(balance);
    }

    // Other service methods
}