package com.example.clients_service;

import com.example.clients_service.models.Account;
import com.example.clients_service.models.Client;
import com.example.clients_service.models.Phone;
import com.example.clients_service.repositories.AccountRepository;
import com.example.clients_service.repositories.ClientRepository;
import com.example.clients_service.repositories.PhoneRepository;
import com.example.clients_service.services.data.AccountService;
import com.example.clients_service.services.data.ClientService;
import com.example.clients_service.services.data.PhoneService;
import com.example.clients_service.services.data.qualifiers.ClientServiceQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;

@SpringBootApplication
public class ClientsServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ClientsServiceApplication.class, args);
    }

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Qualifier("clientServiceDb")
    @Autowired
    //@ClientServiceQualifier
    private ClientService clientService;

//    @Qualifier("accountServiceDb")
    @Autowired
    //@ClientServiceQualifier
    private AccountService accountService;

    @Autowired
    private PhoneService phoneService;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReade() {
        // ----------------------------------
        /*System.out.println(clientRepository);
        List<Client> clients = Arrays.asList(
                new Client(0L, "Vasko", "Vova", "Vladimirovich",
                        LocalDate.of(1999, 12, 12), "email@gmail.com"),
                new Client(0L, "Basko", "Sasha", "Aleksandrovich",
                        LocalDate.of(1998, 12, 12), "email@gmail.com"),
                new Client(0L, "Rasko", "Dasha", "Dashovich",
                        LocalDate.of(1997, 12, 12), "email@gmail.com")
                );
        clientRepository.saveAll(clients);*/
        // ----------------------------------
        //
        /*clientRepository.findAll().forEach(System.err::println); // Получить все записи.
        System.out.println();*/
        //
        //System.out.println(clientRepository.findById(1L));
        //
        /*clientRepository.findAllBySurnameAndNameAndPatronymic(  // Получить выбраную запись.
                "A","N","P"
        ).forEach(System.err::println);*/

        //

        /*System.out.println(phoneRepository);
        // Добавление в Базу Данных.
        List<Phone> phones = Arrays.asList(
                new Phone(0L, "+380983659988"),
                new Phone(0L, "+380983654455"),
                new Phone(0L, "+380983651100"),
                new Phone(0L, "+380983657777")

        );*/
        /*phoneRepository.saveAll(phones);                        // Сохранить все запись в Базу Данных.
        phoneRepository.findAll().forEach(System.err::println); // Найти все записи.
        phoneRepository.findAllByPhone(                         // Найти выбраную запись.
                "+380983651100"
        ).forEach(System.err::println);
        System.out.println(phoneRepository.findById(1L)); */      // Найти запись по id.
        //phoneRepository.deleteById(4L);                         // Удалить запись по id.
        //phoneRepository.deleteAll(phones);                      // Удалить все записи.

        //

        /*System.out.println(accountRepository);
        List<Account> accounts = Arrays.asList(
                new Account(0L, 1000),
                new Account(0L, 2000),
                new Account(0L, 3000)
        );
        accountRepository.saveAll(accounts);*/

        Client c1 = new Client(0L, "S2", "N2", "P2",
                LocalDate.of(1900, 7, 7), "email222@gmail.com");
        clientService.save(c1);
        clientService.findAll().forEach(System.err::println);

        Account a1 = new Account(0L, 3000);
        accountService.save(a1);

        Phone phone1 = new Phone(0L, "099575111");
           phoneService.save(phone1);
        // phoneRepository.save(phone1);



    }

}
