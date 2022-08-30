package com.football.match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.dto.TeamDto;

public class FootballScoreBoard{

	
	public static List<TeamDto> matchList = new ArrayList<>();
	private static TeamDto teamDto;

	/**
	 * Method to start game.
	 *
	 * @param homeTeam Home Team name.
	 * @param awayTeam Away Team name.
	 * @return
	 */
	public static String startGame(String homeTeam, String awayTeam) {
		teamDto = new TeamDto();
		teamDto.setHomeTeam(homeTeam);
		teamDto.setAwayTeam(awayTeam);
		teamDto.setHomeTeamScore(0);
		teamDto.setAwayTeamScore(0);


		return  teamDto.getHomeTeam() + " " + teamDto.getHomeTeamScore() + " - "
				+ teamDto.getAwayTeam() + " " + teamDto.getAwayTeamScore();
	}

	/**
	 * Method to finish game.
	 *
	 * @return
	 */
	public static String finishGame() {
		
		matchList.add(teamDto);
		return "Game finished.";
	}

	/**
	 * Method to update game. 
	 * 
	 * @param homeTeamScore Home Team score.
	 * @param awayTeamScore Away Team score.
	 * @return
	 */
	public static String updateGame(int homeTeamScore, int awayTeamScore) {
		teamDto.setHomeTeamScore(homeTeamScore);
		teamDto.setAwayTeamScore(awayTeamScore);

		return  teamDto.getHomeTeam() + " " + teamDto.getHomeTeamScore() + " - "
				+ teamDto.getAwayTeam() + " " + teamDto.getAwayTeamScore();
	}

	/**
	 * Method to get summary of the match. 
	 * Get the match list which holds the details of matches which is completed
	 * Reverse the list, since we need last completed match should come in the list first 
	 * Sort the list based on the total goal scored in the match 
	 * 
	 * @return
	 */
	public static List<TeamDto> getMatchSummary() {
		Collections.reverse(matchList);

		matchList.sort((o1, o2) -> {
			if ((o1.getHomeTeamScore() + o1.getAwayTeamScore()) < (o2.getHomeTeamScore() + o2.getAwayTeamScore())) {
				return 1;
			} else if ((o1.getHomeTeamScore() + o1.getAwayTeamScore()) > (o2.getHomeTeamScore()
					+ o2.getAwayTeamScore())) {
				return -1;
			}
			return 0;
		});
		
		return matchList;
	}
	/**
	 * Method to check the score value is valid or not. 
	 * 
	 * @return
	 */
	public static TeamDto checkTeamScore(){
		return teamDto;
		
	}
	
	
}
