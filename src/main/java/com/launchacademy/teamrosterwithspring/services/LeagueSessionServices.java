package com.launchacademy.teamrosterwithspring.services;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

//@Service says 'this holds business logic'
//@SessionScope says 'this is going to use a session'
@Service
@SessionScope
public class LeagueSessionServices implements LeagueService{
    League league;

    @Autowired
    public LeagueSessionServices(League league) {
      this.league = league;
    }

    public League getLeague() {
      return league;
    }

    public void addTeam(Team team) {
      this.league.addTeam(team);
    }

}
