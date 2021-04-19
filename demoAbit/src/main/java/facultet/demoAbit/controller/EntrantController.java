package facultet.demoAbit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import facultet.demoAbit.domain.Entrant;
import facultet.demoAbit.service.EntrantService;


@Controller
public class EntrantController {

	@Autowired
	private EntrantService entrantService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {

		model.addAttribute("userForm", new Entrant());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") Entrant userForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		entrantService.save(userForm);

		return "redirect:/home";
	}

	

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully");

		return "login";
	}

	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {
		
		ModelAndView map = new ModelAndView();
		map.addObject("entrants",entrantService.getAllEntrants());
		
		return map;

	}
	@RequestMapping(value = "/create-entrant", method = RequestMethod.GET)
	public ModelAndView createPeriodical() {
		return new ModelAndView("createEntrant", "entrant", new Entrant());

	}

}
