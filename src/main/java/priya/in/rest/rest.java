package priya.in.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import priya.in.bind.contactDtls;
import priya.in.config.AppConstraints;
import priya.in.config.appconfig;
import priya.in.service.contactService;

@RestController
public class rest {

	@Autowired
	private contactService repo;

	@Autowired
	private appconfig apconfig;

	@CrossOrigin
	@GetMapping("/get-data")
	public List<contactDtls> getData() {
		return repo.getAllContact();
	}

	@CrossOrigin
	@PostMapping("/insert-data")
	public String insertData(@RequestBody contactDtls dtls) {
		boolean b = repo.saveContact(dtls);

		Map<String, String> messages = apconfig.getMessages();
		if (b)
			return messages.get(AppConstraints.CONTACT_SAVE_SUCC);
		// return messages.get("contactSaveFail");
		return messages.get(AppConstraints.CONTACT_SAVE_fAIL);

	}

	@CrossOrigin
	@DeleteMapping("/delete-data/{id}")
	public List<contactDtls> deleteData(@PathVariable Integer id) {
		return repo.deleteContactById(id);

	}

	@CrossOrigin
	@PutMapping("/update-data/{id}")
	public contactDtls updateData(@PathVariable Integer id) {
		return repo.getContactById(id);
	}

}
