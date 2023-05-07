package com.codingdojo.ninjagold.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {

	@SuppressWarnings("unchecked")
	@GetMapping("/")
	public String rNinjaGold(HttpSession session) {

		Integer goldAmount = (Integer) session.getAttribute("goldAmount");
		if (goldAmount == null) {
			session.setAttribute("goldAmount", 0);
		}

		ArrayList<String> allMessages = (ArrayList<String>) session.getAttribute("allMessages");
		if (allMessages == null) {
			ArrayList<String> newMessagesList = new ArrayList<String>();
			session.setAttribute("allMessages", newMessagesList);
		}

		return "ninjagold.jsp";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/find")
	public String fFindGold(@RequestParam("type") String type, HttpSession session) {

		Random rand = new Random();
		Date now = new Date();

		if (type.equals("farm")) {
			Integer goldAmount = (Integer) session.getAttribute("goldAmount");
			Integer randomGold = rand.nextInt(11) + 10;
			goldAmount += randomGold;
			session.setAttribute("goldAmount", goldAmount);
			String message = String.format("You entered a farm and earned %s gold at %s", randomGold, now);
			ArrayList<String> allMessages = (ArrayList<String>) session.getAttribute("allMessages");
			allMessages.add(message);
			session.setAttribute("allMessages", allMessages);

		}

		else if (type.equals("cave")) {
			Integer goldAmount = (Integer) session.getAttribute("goldAmount");
			Integer randomGold = rand.nextInt(6) + 5;
			goldAmount += randomGold;
			session.setAttribute("goldAmount", goldAmount);
			String message = String.format("You entered a farm and earned %s gold at %s", randomGold, now);
			ArrayList<String> allMessages = (ArrayList<String>) session.getAttribute("allMessages");
			allMessages.add(message);
			session.setAttribute("allMessages", allMessages);

		} else if (type.equals("house")) {
			Integer goldAmount = (Integer) session.getAttribute("goldAmount");
			Integer randomGold = rand.nextInt(4) + 2;
			goldAmount += randomGold;
			session.setAttribute("goldAmount", goldAmount);
			String message = String.format("You entered a farm and earned %s gold at %s", randomGold, now);
			ArrayList<String> allMessages = (ArrayList<String>) session.getAttribute("allMessages");
			allMessages.add(message);
			session.setAttribute("allMessages", allMessages);

		} else {
			Integer goldAmount = (Integer) session.getAttribute("goldAmount");
			Integer randomGold = rand.nextInt(101) - 50;
			goldAmount += randomGold;
			session.setAttribute("goldAmount", goldAmount);
			if (randomGold > 0) {
				String message = String.format("You completed a quest and earned %s gold at %s", randomGold, now);
				ArrayList<String> allMessages = (ArrayList<String>) session.getAttribute("allMessages");
				allMessages.add(message);
				session.setAttribute("allMessages", allMessages);

			} else {
				String message = String.format("You failed a quest and lost %s gold at %s", randomGold, now);
				ArrayList<String> allMessages = (ArrayList<String>) session.getAttribute("allMessages");
				allMessages.add(message);
				session.setAttribute("allMessages", allMessages);

			}
		}

		return "redirect:/";
	}
	
	@GetMapping("/clear")
	public String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
