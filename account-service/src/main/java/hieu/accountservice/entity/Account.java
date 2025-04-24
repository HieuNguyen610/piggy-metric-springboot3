package hieu.accountservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime lastSeen;

    @OneToMany(mappedBy = "accounts")
    private List<Item> incomes;

    @OneToMany(mappedBy = "accounts")
    private List<Item> expenses;

    @OneToOne(mappedBy = "accounts", cascade = CascadeType.ALL)
    private Saving saving;

    private String note;

}
