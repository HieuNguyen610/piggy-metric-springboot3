package hieu.accountservice.service.impl;

import hieu.accountservice.entity.Account;
import hieu.accountservice.entity.Currency;
import hieu.accountservice.entity.Saving;
import hieu.accountservice.entity.User;
import hieu.accountservice.repository.AccountRepository;
import hieu.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account findByName(String name) {
        return accountRepository.findByName(name).orElseThrow(()-> new IllegalArgumentException("User not found"));
    }

    @Override
    public Account create(User user) {


        Saving saving = new Saving();
        saving.setAmount(new BigDecimal(0));
        saving.setCurrency(Currency.getDefault());
        saving.setInterest(new BigDecimal(0));
        saving.setDeposit(false);
        saving.setCapitalization(false);

        Account account = Account.builder()
                .name(user.getUsername())
                .saving(saving)
                .lastSeen(LocalDateTime.now())
                .build();

        accountRepository.save(account);

        log.info("Create account successfully");
        return account;
    }

    @Override
    public void saveChanges(String name, Account account) {
        Account updateAccount = findByName(name);
        updateAccount.setName(account.getName());
        updateAccount.setNote(account.getNote());
        updateAccount.setSaving(account.getSaving());
        updateAccount.setNote(account.getNote());
        updateAccount.setLastSeen(LocalDateTime.now());
        accountRepository.save(updateAccount);
        log.info("Saving changes successfully");
    }
}
