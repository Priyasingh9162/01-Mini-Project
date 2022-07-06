package priya.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import priya.in.bind.contactDtls;
import priya.in.bind.repo;

@Service
public class contactserviceImp implements contactService {
	@Autowired
	private repo repo;

	@Override
	public boolean saveContact(contactDtls contact) {
		contact.setActivesw("Y");
		repo.save(contact);
		if (contact.getId() != null)
			return true;
		return false;
	}

	@Override
	public List<contactDtls> getAllContact() {
		contactDtls ct = new contactDtls();
		ct.setActivesw("Y");
		return repo.findAll(Example.of(ct));
	}

	@Override
	public List<contactDtls> deleteContactById(Integer id) {
		Optional<contactDtls> ct = repo.findById(id);
		if (ct.isPresent()) {
			contactDtls temp = ct.get();
			temp.setActivesw("N");
			repo.save(temp);
		}

		return getAllContact();
	}

	@Override
	public contactDtls getContactById(Integer id) {
		Optional<contactDtls> op = repo.findById(id);
		if (op.isPresent())
			return op.get();
		return null;
	}

}
