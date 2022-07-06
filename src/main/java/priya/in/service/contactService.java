package priya.in.service;

import java.util.List;
import java.util.Optional;

import priya.in.bind.contactDtls;

public interface contactService {

	boolean saveContact(contactDtls contact);

	List<contactDtls> getAllContact();

	List<contactDtls> deleteContactById(Integer id);

	contactDtls getContactById(Integer id);

}
