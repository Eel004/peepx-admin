package com.luonguc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luonguc.dto.Player;
import com.luonguc.dto.Position;
import com.luonguc.dto.Team;
import com.luonguc.service.PlayerService;
import com.luonguc.service.PositionService;
import com.luonguc.service.TeamService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired private PlayerService playerService;
	@Autowired private TeamService teamService;
	@Autowired private PositionService positionService;
	
	// home - index 1
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json",
			headers = "Accept=application/json")
	public String home(Model model) {
		List<Team> teams = new ArrayList<Team>();
		List<Position> positions = new ArrayList<Position>();
		teams = teamService.getAllTeam();
		positions = positionService.getAllPosition();
		model.addAttribute("listPlayer", playerService.getAllPlayer());
		model.addAttribute("teams", teams);
		model.addAttribute("player", new Player());
		model.addAttribute("positions",positions);
		return "home";
	}

	// add player
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ModelAndView add(
			@ModelAttribute("player") Player player,
			Model model) {
		logger.info("add player ----------------------------");
		playerService.addPlayer(player);
		List<Team> teams = new ArrayList<Team>();
		teams = teamService.getAllTeam();
		List<Position> positions = new ArrayList<Position>();
		positions = positionService.getAllPosition();
		model.addAttribute("teams", teams);
		model.addAttribute("listPlayer", playerService.getAllPlayer());
		model.addAttribute("positions", positions);
		model.addAttribute("player", new Player());
		return new ModelAndView("home");
	}

	// json find player
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json",
			headers = "Accept=application/json")
	public @ResponseBody Player find(@PathVariable int id) {
		logger.info("find player -----------------------------");
		Player player = playerService.getPlayerByID(id);
		/*
		 * model.addAttribute("findResult", emp); model.addAttribute("listEmpl",
		 * employeeService.getAllEmp()); return new ModelAndView("home");
		 */
		return player;
	}

	// show update view
	@RequestMapping(value = "/update/{playerId}")
	public ModelAndView showUpdateView(@PathVariable int playerId,
			ModelMap model) {
		logger.info("show update player view -----------------------------");
		/*List<Team> teams = new ArrayList<Team>();
		teams = teamService.getAllTeam();
		model.addAttribute("teams", teams);*/
		Player player = playerService.getPlayerByID(playerId);
		model.addAttribute("player", player);
		return new ModelAndView("update");
	}

	// update
	@RequestMapping(value = "/doUpdate/{playerId}", method = RequestMethod.POST)
	public String update(@ModelAttribute("player") Player player,
			@PathVariable int playerId) {
		logger.info("update player ----------------------------- ");
		boolean rs = playerService.update(playerId, player);
		if (rs) {
			return "redirect:/";
		}
		return "error";
	}

	// find employee
	@RequestMapping(value = "/findPlayer", method = RequestMethod.GET)
	public ModelAndView findEmpById(@RequestParam int id, Model model) {
		logger.info("find player ----------------------------------");
		model.addAttribute("findResult", playerService.getPlayerByID(id));
		model.addAttribute("listPlayer", playerService.getAllPlayer());
		return new ModelAndView("home");
	}

	// delete employee
	@RequestMapping(value = "/delete/{playerId}")
	public String deleteEmployee(@PathVariable("playerId") Integer playerId,
			Model model) {
		logger.info("delte player ---------------------------- ");
		boolean rs = playerService.deletePlayer(playerId);
		if (rs) {
			// model.addAttribute("listEmpl", employeeService.getAllEmp());
			return "redirect:/";
		}
		return "error";
	}

	@RequestMapping(value = "/{playerId}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable int playerId, ModelMap model) {
		Player player = playerService.getPlayerByID(playerId);
		model.addAttribute("player", player);
		model.addAttribute("findResult", player);
		model.addAttribute("listPlayer", playerService.getAllPlayer());
		return new ModelAndView("home");
	}
}
