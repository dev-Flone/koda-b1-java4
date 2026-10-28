package koda;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String employeeId;
    private String owner;
    private Long balance;

    public static Employee employee(String employeeId, String owner, Long balance) {
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Owner wajib diisi");
        }
        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException("Balance wajib diisi");
        }
        return new Employee(employeeId, owner, balance);
    }

    public void deposit(Long amount) {
        if (amount <= 0 || !Double.isFinite(amount)) {
            throw new IllegalArgumentException("Deposit harus positif");
        }
        balance += amount;
    }
}
