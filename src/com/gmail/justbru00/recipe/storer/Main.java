package com.gmail.justbru00.recipe.storer;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Main {

	private JFrame frmRecipeSorter;
	private JButton editButton;
	private JButton saveButton;
	private JButton searchButton;
	private JButton closeButton;
	private JTextField recipeNameBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmRecipeSorter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private void initialize() {
		
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    JOptionPane.showMessageDialog(null, "Error: Numbus theme is not installed. Will now use system default.", "Error!", JOptionPane.ERROR_MESSAGE);
		    try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e1) {				
				e1.printStackTrace();
			}
		
		}		
		
		
		
		frmRecipeSorter = new JFrame();
		frmRecipeSorter.setTitle("Recipe Sorter");
		frmRecipeSorter.setBounds(100, 100, 450, 300);
		frmRecipeSorter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	



		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmRecipeSorter.getContentPane().add(menuPanel, BorderLayout.NORTH);

		JPanel searchButtonPanel = new JPanel();
		menuPanel.add(searchButtonPanel);

		searchButton = new JButton("Search");
		searchButtonPanel.add(searchButton);

		JPanel saveButtonPanel = new JPanel();
		menuPanel.add(saveButtonPanel);

		saveButton = new JButton("Save");
		saveButtonPanel.add(saveButton);

		JPanel editButtonPanel = new JPanel();
		menuPanel.add(editButtonPanel);

		editButton = new JButton("Edit");
		editButtonPanel.add(editButton);

		JPanel closeButtonPanel = new JPanel();
		menuPanel.add(closeButtonPanel);

		closeButton = new JButton("Close");
		closeButtonPanel.add(closeButton);

		JPanel recipeDisplayAndEdit = new JPanel();
		frmRecipeSorter.getContentPane().add(recipeDisplayAndEdit, BorderLayout.CENTER);
		
		JPanel displayPanel = new JPanel();
		recipeDisplayAndEdit.add(displayPanel);
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
		
		JPanel categoryDisplayPanel = new JPanel();
		displayPanel.add(categoryDisplayPanel);
		
		JLabel categoryLabel = new JLabel("Category:");
		categoryDisplayPanel.add(categoryLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Soups", "Quick Meals", "Deserts"}));
		categoryDisplayPanel.add(comboBox);
		
		JPanel nameBoxPanel = new JPanel();
		displayPanel.add(nameBoxPanel);
		
		JLabel recipeNameBoxLabel = new JLabel("Recipe Name: ");
		nameBoxPanel.add(recipeNameBoxLabel);
		
		recipeNameBox = new JTextField();
		nameBoxPanel.add(recipeNameBox);
		recipeNameBox.setColumns(10);
		
		JPanel recipeIngredientsPanel = new JPanel();
		displayPanel.add(recipeIngredientsPanel);
		
		JLabel ingredientsLabel = new JLabel("Ingredients: ");
		recipeIngredientsPanel.add(ingredientsLabel);
		
		JScrollPane ingredientsScrollPane = new JScrollPane();
		recipeIngredientsPanel.add(ingredientsScrollPane);
		
		JTextPane ingredientsTextPane = new JTextPane();
		ingredientsTextPane.setText("Random Thing Here: Amount here");
		recipeIngredientsPanel.add(ingredientsTextPane);
		
		JPanel allRecipesDisplay = new JPanel();
		allRecipesDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmRecipeSorter.getContentPane().add(allRecipesDisplay, BorderLayout.WEST);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Recipes") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Folder 1");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Folder 2");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Folder 3");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		allRecipesDisplay.add(tree);

	}

}
