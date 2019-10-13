/**
Java program solving the problem #18 of the Euler Project

Tuomas Taimi 
email: tuomas.taimi@gmail.com
**/


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Euler18 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Euler18 frame = new Euler18();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Euler18() {
		setTitle("Project Euler 18");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 363, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLink = new JLabel("Link to Project Euler web page (problem #18)");
		lblLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://projecteuler.net/problem=18"));
					lblLink.setForeground(Color.BLUE.darker());
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblLink.setForeground(Color.BLUE);
		lblLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));;
		
		
		GridBagConstraints gbc_lblLink = new GridBagConstraints();
		gbc_lblLink.insets = new Insets(0, 0, 5, 0);
		gbc_lblLink.gridx = 1;
		gbc_lblLink.gridy = 0;
		contentPane.add(lblLink, gbc_lblLink);
		
				
		
		JLabel lblMaximum = new JLabel("Maximum route");
		lblMaximum.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		GridBagConstraints gbc_lblMaximum = new GridBagConstraints();
		gbc_lblMaximum.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaximum.gridx = 1;
		gbc_lblMaximum.gridy = 3;
		contentPane.add(lblMaximum, gbc_lblMaximum);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JTextPane txtpnExplanation = new JTextPane();
		txtpnExplanation.setEditable(false);
		txtpnExplanation.setText("Press Calculate");
		scrollPane.setViewportView(txtpnExplanation);
		
		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = findMaximum();
				lblMaximum.setText("Maximum sum is: " + Integer.toString(answer));
				txtpnExplanation.setText("Explanation \nInstead of starting from the top and calculating every possible route we can start from the bottom of the triangle "
						+ "(much like those maze puzzles we used to do as children)."
						+ " Starting from the bottom left corner and moving right"
						+ " always comparing two adjacent numbers and adding the bigger number"
						+ " to higher \"floor\" of the pyramid. When we reach the top we have found the maximum total route.");
			}
		});
		
		GridBagConstraints gbc_btnCalc = new GridBagConstraints();
		gbc_btnCalc.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalc.gridx = 1;
		gbc_btnCalc.gridy = 1;
		contentPane.add(btnCalc, gbc_btnCalc);
		
		
	}
	
	//Method that finds the maximum route, starts calculating from the bottom.
	public int findMaximum() {
		  //The pyramid of numbers
			int numbers [][]= {
					{75},
					{95,64},
					{17,47,82},
					{18,35,87,10},
					{20,04,82,47,65},
					{19,01,23,75,03,34},
					{88,02,77,73,07,63,67},
					{99,65,04,28,06,16,70,92},
					{41,41,26,56,83,40,80,70,33},
					{41,48,72,33,37,32,37,16,94,29},
					{53,71,44,65,25,43,91,52,97,51,14},
					{70,11,33,28,77,73,17,78,39,68,17,57},
					{91,71,52,38,17,41,91,43,58,50,27,29,48},
					{63,66,4,68,89,53,67,30,73,16,69,87,40,31},
					{4,62,98,27,23,9,70,98,73,93,38,53,60,4,23}
			};
			
			//"height of the triangle"
			int h=numbers.length;

			//Start from the bottom and add the bigger number to the higher "floor" of the pyramid
			for(int i = h-1; i>-1; i--) {
				for (int j = 1; j<numbers[i].length; j++) {
					if (numbers[i][j]>numbers[i][j-1]) {
						numbers[i-1][j-1]=numbers[i-1][j-1] + numbers[i][j];
					}
					else {
						numbers[i-1][j-1]=numbers[i-1][j-1]+numbers[i][j-1];
					}
				}
			}
			return numbers[0][0];
	}

}
