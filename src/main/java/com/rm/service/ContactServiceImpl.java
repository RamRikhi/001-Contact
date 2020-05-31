package com.rm.service;

import com.rm.dao.ContactRepository;
import com.rm.entity.ContactEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {
    private ContactRepository contactRepo;

    //Constructor Injection
    public ContactServiceImpl(ContactRepository contactRepo){
        this.contactRepo=contactRepo;
    }

    //To save one contact details
    @Override
    public Integer insertContactDetails(ContactEntity contact) {
        return contactRepo.save(contact).getContactId();
    }
    //Get one Contact by id
    @Override
    public ContactEntity getOneContactById(Integer id) {
          Optional<ContactEntity> cont= contactRepo.findById(id);
          if(cont.isPresent())
              return cont.get();
        return null;
    }
    //Get all contacts
    @Override
    public List<ContactEntity> getAllContacts() {
        return contactRepo.findAll();
    }
    //Delete contact based on Id
    @Override
    public void deleteById(Integer id) {
        contactRepo.deleteById(id);
    }
    //Modify contact based on Id
    @Override
    public void updateById(ContactEntity contact) {
        contactRepo.save(contact);
    }
}
