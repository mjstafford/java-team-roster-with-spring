package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Team;
import com.launchacademy.teamrosterwithspring.services.LeagueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TeamsController {

  @Autowired
  LeagueService leagueSessionServices;

//  @Autowired
//  public TeamsController(LeagueService leagueSessionServices) {
//    this.leagueSessionServices = leagueSessionServices;
//  }

  @GetMapping
  public String getAllTeams(Model model) {
    League league = League.getLeague();
    List<Team> teamList = league.getTeams();
    model.addAttribute("teamsList", teamList);
    return "teams/index";
  }

  @GetMapping("/team/{id}")
  public String getTeamShowPage(@PathVariable int id, Model model) {
    League league = League.getLeague();
    List<Team> teamList = league.getTeams();
    if (id <= teamList.size() && id > 0) {
      //get teams
      Team team = teamList.get(id);
      //get players
      List<Player> playersList = team.getPlayers();

      model.addAttribute("team", team);
      model.addAttribute("playersList", playersList);
      return "teams/show";
    } else {
      return "teams/error";
    }
  }

  @GetMapping("/fantasy/teams/new")
  public String getForm(@ModelAttribute Team team){
    return "teams/new";
  }

  @PostMapping("/fantasy/teams")
  public String createProduct(@ModelAttribute Team team) {
    leagueSessionServices.addTeam(team);
    return "redirect:/fantasy/teams";
  }

  @GetMapping("/fantasy/teams")
  public String getAllFantasyTeams(Model model) {
    League fantasyLeague = leagueSessionServices.getLeague();
    List<Team> teamList = fantasyLeague.getTeams();
    model.addAttribute("teamsList", teamList);
    return "teams/index";
  }
}
