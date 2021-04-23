package com.example.contacts;

import com.example.contacts.Dao.ContactRepository;
import com.example.contacts.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {

    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(ContactsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

//        contactRepository.save(new Contact("LeMinou","Fred",df.parse("12/01/1928"),"fred@leminou.fr", "0321840362",""));
//        contactRepository.save(new Contact("LeMatou","Lorant",df.parse("12/01/1998"),"lorant@leminou.fr", "0321840362",""));
//        contactRepository.save(new Contact("titi","oiseau",df.parse("12/01/1988"),"franck@leminou.fr", "0321840362",""));

        contactRepository.findAll().forEach(c->{
            System.out.println(c.getNom());
        });
    }
}
