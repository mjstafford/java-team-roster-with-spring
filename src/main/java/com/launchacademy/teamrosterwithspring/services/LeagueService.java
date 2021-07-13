package com.launchacademy.teamrosterwithspring.services;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Team;

public interface LeagueService {
  public League getLeague();
  public void addTeam(Team team);
}
