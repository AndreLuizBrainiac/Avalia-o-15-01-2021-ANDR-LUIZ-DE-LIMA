package br.edu.ifsp.view;

import javax.swing.JOptionPane;

public class JanelaMessage {

	public static void InvalidNameMessage(String message) {

		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void InvalidAgeMessage(String message) {

		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void insertSuccessful(String message) {

		JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void removedSuccessful(String message) {

		JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void idQuerySuccess(String message) {

		JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void updateSuccess(String message) {

		JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void invalidIDMessage(String message) {

		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void sqlError(String message) {

		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
