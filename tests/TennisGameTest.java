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
	public void testTennisGame_Player2WinsOver4() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("score incorrect", "player2 wins", score);
		
	}
	
	@Test
	public void testTennisGame_Player1WinsOver4() throws TennisGameException {
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
		game.player1Scored();
		
		String score = game.getScore();
		assertEquals("score incorrect", "player1 wins", score);
		
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
		game.player2Scored();
		game.player1Scored();
		String score5 = game.getScore();
		assertEquals("incorrect points", "deuce", score5);
		
		game.player1Scored();
		String score6 = game.getScore();
		assertEquals("incorrect points", "player1 has advantage", score6);
		
		game.player1Scored();
		String score7 = game.getScore();
		assertEquals("incorrect points", "player1 wins", score7);
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
		game.player1Scored();
		game.player2Scored();
		String score5 = game.getScore();
		assertEquals("incorrect points", "deuce", score5);
		
		game.player2Scored();
		String score6 = game.getScore();
		assertEquals("incorrect points", "player2 has advantage", score6);
		
		game.player2Scored();
		String score7 = game.getScore();
		assertEquals("incorrect points", "player2 wins", score7);
	}
	
	
	@Test
	public void testTennisGame_Player1_40_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "40 - 30", score);
	}
	
	@Test
	public void testTennisGame_Player1_40_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "40 - love", score);
	}
	
	@Test
	public void testTennisGame_Player1_40_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "40 - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1_15_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_Player1_30_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "30 - love", score);
	}
	
	@Test
	public void testTennisGame_Player1_30_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "30 - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1_Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		assertEquals("incorrect points", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2_40_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "love - 40", score);
	}
	
	@Test
	public void testTennisGame_Player2_40_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "30 - 40", score);
	}
	
	@Test
	public void testTennisGame_Player2_40_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		String score = game.getScore();
		assertEquals("incorrect points", "15 - 40", score);
	}
	
	@Test
	public void testTennisGame_Player2_15_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();

		String score = game.getScore();
		assertEquals("incorrect points", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_Player2_30_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();

		String score = game.getScore();
		assertEquals("incorrect points", "love - 30", score);
	}
	
	@Test
	public void testTennisGame_Player2_30_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();

		String score = game.getScore();
		assertEquals("incorrect points", "15 - 30", score);
	}
	
	@Test
	public void testTennisGame_Player2_Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("incorrect points", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player1_Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		String score = game.getScore();
		assertEquals("incorrect points", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2_Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
	
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("incorrect points", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Both2Points() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
	
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		assertEquals("incorrect points", "30 - 30", score);
	}
	
	@Test
	public void testTennisGame_DeuceOver4Points() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
	
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		String score = game.getScore();
		assertEquals("incorrect points", "deuce", score);
	}
	
	@Test
	public void testTennisGame_Deuce3Points() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
	
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		assertEquals("incorrect points", "deuce", score);
	}
	
}
