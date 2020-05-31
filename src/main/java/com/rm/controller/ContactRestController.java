package com.rm.controller;

import com.rm.entity.ContactEntity;
import com.rm.service.IContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactRestController {
    private IContactService contactService;
    //Constructor Injection service to RestController
    public ContactRestController(IContactService contactService){
        this.contactService=contactService;
    }

    //Rest call to insert one contact
    @PostMapping("/save")
    public ResponseEntity<String> saveOneContact(@RequestBody ContactEntity contact){
        contactService.insertContactDetails(contact);
        return ResponseEntity.ok(contact.getContactId()+" contact is successfully saved");
    }

    //Rest Call for get one contact based on Id
    @GetMapping("/oneContact/{id}")
    public ResponseEntity<ContactEntity> getOneContactById(@PathVariable Integer id){
        ContactEntity cont=contactService.getOneContactById(id);
        return ResponseEntity.ok(cont);
    }

    //Rest call for modify one contact based on Id
    @PutMapping("/edit")
    public ResponseEntity<String> modifyOneContactById(@RequestBody ContactEntity contact){
        contactService.updateById(contact);
        return ResponseEntity.ok("One contact is updated "+contact.getContactId());
    }

    //Rest call for get all the contact
    @GetMapping("/all")
    public ResponseEntity<List<ContactEntity>> getAllcontacts(){
       List<ContactEntity> list = contactService.getAllContacts();
        return ResponseEntity.ok(list);
    }

    //Rest call for delete one contact based on Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        contactService.deleteById(id);
        return ResponseEntity.ok(id+" Id is deleted");
    }

}
