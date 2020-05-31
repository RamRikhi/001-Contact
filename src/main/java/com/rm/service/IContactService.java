package com.rm.service;

import com.rm.entity.ContactEntity;

import java.util.List;
import java.util.Optional;

public interface IContactService {
    Integer insertContactDetails(ContactEntity contact);
    ContactEntity getOneContactById(Integer id);
    List<ContactEntity> getAllContacts();
    void deleteById(Integer id);
    void updateById(ContactEntity contact);
}
