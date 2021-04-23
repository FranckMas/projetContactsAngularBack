package com.example.contacts.web;

import com.example.contacts.Dao.ContactRepository;
import com.example.contacts.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
public class ContactRestService {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value="/contacts", method = RequestMethod.GET)
    public List<Contact> getContact(){
        return contactRepository.findAll();
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.GET)
    public Optional<Contact> getContact(@PathVariable Long id){
        return contactRepository.findById(id);
    }

    @RequestMapping(value="/contacts", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact c){
        return contactRepository.save(c);
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Long id){
        contactRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.PUT)
    public Contact save(@PathVariable("id") Long id, @RequestBody Contact c){
        c.setId(id);
        return contactRepository.save(c);
    }

    @RequestMapping(value="/chercher/{mc}&{size}&{page}", method = RequestMethod.GET)
    public Page<Contact> chercher(
            @PathVariable("mc") String mc,
            @PathVariable("page") int page,
            @PathVariable("size") int size){
        return contactRepository.chercher("%"+mc+"%", PageRequest.of(page, size));
    }
}
