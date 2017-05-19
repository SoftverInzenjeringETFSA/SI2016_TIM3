package ba.eventTS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.eventTS.models.testModelUser;
import ba.eventTS.models.userTestDAO;

@Controller
@RequestMapping(value = "/user")
public class testUserController {

	@Autowired
	private userTestDAO _userDao;

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			testModelUser user = new testModelUser(id);
			_userDao.delete(user);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping(value = "/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId;
		try {
			testModelUser user = _userDao.getByEmail(email);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String create(String email, String name) {
		try {
			testModelUser user = new testModelUser(email, name);
			_userDao.save(user);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "User succesfully saved!";
	}



}