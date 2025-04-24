package hieu.accountservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BigDecimal amount;

    private Currency currency;

    private TimePeriod timePeriod;

    @ManyToOne
    @JoinColumn(name = "account_id") // tên cột trong bảng item
    private Account accounts;
}
