import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EachPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();
	}
	
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();
	}
	
	@Test
	public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("score incorrect", "player2 has advantage", score);
		
	}
	

	@Test
	public void testTennisGame_TestAllPoints_Player1Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "15 - love", score);
		
		game.player2Scored();
		game.player1Scored();
		String score1 = game.getScore();
		assertEquals("incorrect points", "30 - 15", score1);

		
		game.player1Scored();
		String score2 = game.getScore();
		assertEquals("incorrect points", "40 - 15", score2);

		game.player2Scored();
		game.player2Scored();
		String score3 = game.getScore();
		assertEquals("incorrect points", "deuce", score3);


		game.player2Scored();
		String score4 = game.getScore();
		assertEquals("incorrect points", "player2 has advantage", score4);
		
		game.player1Scored();
		game.player1Scored();
		String score5 = game.getScore();
		assertEquals("incorrect points", "player1 has advantage", score5);
		
		game.player1Scored();
		String score6 = game.getScore();
		assertEquals("incorrect points", "player1 wins", score6);
	}
	
	@Test
	public void testTennisGame_TestAllPoints_Player2Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "love - 15", score);

		game.player1Scored();
		game.player2Scored();
		String score1 = game.getScore();
		assertEquals("incorrect points", "15 - 30", score1);
		
		
		game.player2Scored();
		String score2 = game.getScore();
		assertEquals("incorrect points", "15 - 40", score2);

		game.player1Scored();
		game.player1Scored();
		String score3 = game.getScore();
		assertEquals("incorrect points", "deuce", score3);


		game.player1Scored();
		String score4 = game.getScore();
		assertEquals("incorrect points", "player1 has advantage", score4);
		
		game.player2Scored();
		game.player2Scored();
		String score5 = game.getScore();
		assertEquals("incorrect points", "player2 has advantage", score5);
		
		game.player2Scored();
		String score6 = game.getScore();
		assertEquals("incorrect points", "player2 wins", score6);
	}
	
}
