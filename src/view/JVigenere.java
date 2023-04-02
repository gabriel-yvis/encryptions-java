package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Vigenere;
import controle.ControleVigenere;

public class JVigenere extends JFrame{
	
	private JLabel lblNormal, lblCriptografado, lblChave;
	private JTextField txtDescriptografado, txtCriptografado, txtChave;
	private JButton btnCriptografar, btnDescriptografar, btnOk, btnCancelar;
	String botaoPresionado = "";
	
	public JVigenere(){
		setBounds(0, 0, 600, 500);
		setTitle("Vigenere");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(new java.awt.Color(255, 255, 255));
		
		lblNormal = new JLabel();
		lblNormal.setText("Texto Normal");
		lblNormal.setBounds(50, 50, 200, 20);
		add(lblNormal);
		lblNormal.setVisible(true);
		
		txtDescriptografado = new JTextField();
		txtDescriptografado.setBounds(50, 70, 430, 20);
		add(txtDescriptografado);
		txtDescriptografado.setVisible(true);
		txtDescriptografado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
		
		lblCriptografado = new JLabel();
		lblCriptografado.setText("Texto Criptografado");
		lblCriptografado.setBounds(50, 100, 200, 20);
		add(lblCriptografado);
		lblCriptografado.setVisible(true);

		txtCriptografado = new JTextField();
		txtCriptografado.setBounds(50, 120, 430, 20);
		add(txtCriptografado);
		txtCriptografado.setVisible(true);
		txtCriptografado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
		
		lblChave = new JLabel();
		lblChave.setText("Chave:");
		lblChave.setBounds(50, 150, 200, 20);
		add(lblChave);
		lblChave.setVisible(true);

		txtChave = new JTextField();
		txtChave.setBounds(50, 170, 430, 20);
		add(txtChave);
		txtChave.setVisible(true);
		txtChave.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		btnCriptografar = new JButton("Criptografar");
		btnCriptografar.setBounds(50, 200, 110, 30);
		add(btnCriptografar);
		btnCriptografar.setVisible(true);
		btnCriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ativaConfirmacao();
				botaoPresionado = "btnCriptografar";
				txtDescriptografado.setEnabled(true);
			}
		});

		btnDescriptografar = new JButton("Descriptografar");
		btnDescriptografar.setBounds(170, 200, 130, 30);
		add(btnDescriptografar);
		btnDescriptografar.setVisible(true);
		btnDescriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ativaConfirmacao();
				botaoPresionado = "btnDescriptografar";
				txtCriptografado.setEnabled(true);
			}
		});
		
		btnOk = new JButton("OK");
		btnOk.setBounds(310, 200, 60, 30);
		add(btnOk);
		btnOk.setVisible(true);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vigenere v = new Vigenere();
				ControleVigenere cv = new ControleVigenere();
				
				if(botaoPresionado == "btnCriptografar"){
					v.setDescriptografado(txtDescriptografado.getText().toUpperCase());
					v.setChave(txtChave.getText().toUpperCase());
					
					txtCriptografado.setText(cv.Criptografar(v));
					txtChave.setText(v.getChave());
					txtDescriptografado.setText(txtDescriptografado.getText().toUpperCase());
				}else if(botaoPresionado == "btnDescriptografar"){
					v.setCriptografado(txtCriptografado.getText().toUpperCase());
					v.setChave(txtChave.getText().toUpperCase());
					
					txtDescriptografado.setText(cv.Descriptografar(v));
					txtChave.setText(v.getChave());
					txtCriptografado.setText(txtCriptografado.getText().toUpperCase());
				}
				ativaOpcoes();
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(380, 200, 100, 30);
		add(btnCancelar);
		btnCancelar.setVisible(true);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ativaOpcoes();
			}
		});
		
		ativaOpcoes();
	}
	public void ativaOpcoes(){
		btnOk.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnCriptografar.setEnabled(true);
		btnDescriptografar.setEnabled(true);
		txtCriptografado.setEnabled(false);
		txtDescriptografado.setEnabled(false);
		txtChave.setEnabled(false);
	}
	public void ativaConfirmacao(){
		btnOk.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnCriptografar.setEnabled(false);
		btnDescriptografar.setEnabled(false);
		txtCriptografado.setText("");
		txtCriptografado.setEnabled(false);
		txtDescriptografado.setText("");
		txtDescriptografado.setEnabled(false);
		txtChave.setEnabled(true);
		txtChave.setText("");
	}
}
