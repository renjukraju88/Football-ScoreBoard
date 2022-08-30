package com.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.dto.TeamDto;
import com.football.match.FootballScoreBoard;

/**
 * User can enter the details through the UI.
 *
 *	1. To start the game :- Click the 'Start Game' button
 *	2. To update the score of the game :- Click the 'Update Game' button
 *	3. To finish the game :- Click the 'Finish Game' button
 *	4. To get the summary of game :- Click the 'Match Summary' button
 *	5. To quit the game :- Click the 'Quit Game' button
 */
public class ScoreBoardApplication {

	private JFrame frame;
	private JTextField hometextField;
	private JTextField awaytextField;
	private JTextField homeTeamScoreTxt;
	private JTextField awayTeamScoreTxt;	
	private String summary;
	private boolean statusStart=true;	
	private String regexChar = "^[a-zA-Z]+$";
	private String regexNumber = "^[0-9]+$";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreBoardApplication window = new ScoreBoardApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScoreBoardApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("FootBall Match ScoreBoard");
		frame.setBounds(100, 100, 750, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel homeTeamLabel = new JLabel("Enter Home Team ");
		homeTeamLabel.setBounds(61, 178, 120, 13);
		frame.getContentPane().add(homeTeamLabel);
		
		hometextField = new JTextField();
		hometextField.setBounds(188, 170, 143, 29);
		frame.getContentPane().add(hometextField);
		hometextField.setColumns(10);
		
		JLabel awayTeamLabel = new JLabel("Enter Away Team");
		awayTeamLabel.setBounds(61, 225, 120, 13);
		frame.getContentPane().add(awayTeamLabel);
		
		awaytextField = new JTextField();
		awaytextField.setBounds(188, 217, 143, 29);
		frame.getContentPane().add(awaytextField);
		awaytextField.setColumns(10);
		
		JTextArea scoreBoardTextArea = new JTextArea(10,10);
		scoreBoardTextArea.setEditable(false);
		scoreBoardTextArea.setBounds(125, 10, 428, 150);
		frame.getContentPane().add(scoreBoardTextArea);
		
		JLabel lblNewLabel = new JLabel("Enter Home Team Score");
		lblNewLabel.setBounds(381, 170, 172, 29);
		frame.getContentPane().add(lblNewLabel);
		
		homeTeamScoreTxt = new JTextField();
		homeTeamScoreTxt.setBounds(562, 170, 109, 29);
		frame.getContentPane().add(homeTeamScoreTxt);
		homeTeamScoreTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Away Team Score");
		lblNewLabel_1.setBounds(380, 214, 172, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		awayTeamScoreTxt = new JTextField();
		awayTeamScoreTxt.setBounds(562, 217, 109, 29);
		frame.getContentPane().add(awayTeamScoreTxt);
		awayTeamScoreTxt.setColumns(10);
		
		JButton resultBtn = new JButton("Match Summary");
		resultBtn.setEnabled(false);
		
		JButton startBtn = new JButton("Start Game");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == startBtn) {
					if(hometextField.getText().matches(regexNumber) || awaytextField.getText().matches(regexNumber)) {
						JOptionPane.showMessageDialog(frame,
                                "Please Enter Valid Input");
					}
					else if(hometextField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,
                                "Must Enter Home Team Name");
					}else if(awaytextField.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,
                                "Must Enter Away Team Name");
					}else {
					String homeTeam = hometextField.getText();
					String awayTeam = awaytextField.getText();
					
					String liveScore = FootballScoreBoard.startGame(homeTeam, awayTeam);
					scoreBoardTextArea.setText(liveScore);
					startBtn.setEnabled(false);
					}
					
				}
			}
			
		});
		startBtn.setBounds(205, 258, 109, 34);
		frame.getContentPane().add(startBtn);
		
		JButton updateBtn = new JButton("Update Game");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				if(e.getSource() == updateBtn) {
					TeamDto matchSummary = FootballScoreBoard.checkTeamScore();				
					if(homeTeamScoreTxt.getText().matches(regexChar) || awayTeamScoreTxt.getText().matches(regexChar)) {
						JOptionPane.showMessageDialog(frame,
                                "Please Enter Valid Input");
					}
					else if(homeTeamScoreTxt.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,
                                "Must Enter Home Team Score");
					}else if(awayTeamScoreTxt.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,
                                "Must Enter Away Team Score");
					}else if(startBtn.isEnabled()) {
						JOptionPane.showMessageDialog(frame,
                                "Please Start The Game");
					}
					else if(Integer.parseInt(homeTeamScoreTxt.getText()) < matchSummary.getHomeTeamScore() || Integer.parseInt(awayTeamScoreTxt.getText()) < matchSummary.getAwayTeamScore()) {
						JOptionPane.showMessageDialog(frame,
                                "Please Enter Valid Score");
					}
					else {
					String homeTeamScore = homeTeamScoreTxt.getText();
					String awayTeamScore = awayTeamScoreTxt.getText();	
					
					String liveScoreUpdate = FootballScoreBoard.updateGame(Integer.parseInt(homeTeamScore), Integer.parseInt(awayTeamScore));
					
					scoreBoardTextArea.removeAll();
					scoreBoardTextArea.setText(liveScoreUpdate);
					homeTeamScoreTxt.setText("");
					awayTeamScoreTxt.setText("");
					
					}
					
				}
			}
		});
		updateBtn.setBounds(559, 258, 133, 34);
		frame.getContentPane().add(updateBtn);
		
		JButton finishBtn = new JButton("Finish Game");
		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == finishBtn) {
					statusStart=false;					
					if(startBtn.isEnabled()) {
						JOptionPane.showMessageDialog(frame,
                                "Please Start The Game");
					}else {
					
					FootballScoreBoard.finishGame();					
					scoreBoardTextArea.setText("");
					startBtn.setEnabled(true);
					updateBtn.setEnabled(true);
					resultBtn.setEnabled(true);
					
					JOptionPane.showMessageDialog(frame,
                            "Game Finished, Please click 'Start Game' for new game or Click 'Match Summary' for the results");
					
					hometextField.setText("");
					awaytextField.setText("");
					homeTeamScoreTxt.setText("");
					awayTeamScoreTxt.setText("");
					
				}
			}
			}
		});
		finishBtn.setBounds(61, 324, 143, 34);
		frame.getContentPane().add(finishBtn);
		
		
		
		resultBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == resultBtn) {
					if(startBtn.isEnabled() && statusStart) {
						JOptionPane.showMessageDialog(frame,
                                "Please Start The Game");
					}

					else {
					scoreBoardTextArea.setText(null);	
					
					List<TeamDto> matchSummary = FootballScoreBoard.getMatchSummary();
					 matchSummary.stream().forEach(o -> {					 
						  
						   summary = "" + o.getHomeTeam() + " " + o.getHomeTeamScore() + " - "
									+ o.getAwayTeam() + " " + o.getAwayTeamScore() + "\n";				  
						  
							 scoreBoardTextArea.append(summary);
					 });
					 resultBtn.setEnabled(false);
					}				
					
				}
			}
		});
		resultBtn.setBounds(289, 324, 163, 34);
		frame.getContentPane().add(resultBtn);
		
		JButton quitBtn = new JButton("Quit Game");
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitBtn.setBounds(538, 324, 133, 34);
		frame.getContentPane().add(quitBtn);
		
	}
}
