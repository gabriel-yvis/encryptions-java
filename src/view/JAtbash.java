package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Atbash;
import controle.ControleAtbash;

public class JAtbash extends JFrame{
	
	private JLabel lblNormal, lblCriptografado;
	private JTextField txtDescriptografado, txtCriptografado;
	private JButton btnCriptografar, btnDescriptografar, btnOk, btnCancelar;
	String botaoPresionado = "";
	
	public JAtbash(){
		setBounds(0, 0, 600, 500);
		setTitle("Atbash");
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
		
		lblCriptografado = new JLabel();
		lblCriptografado.setText("Texto Criptografado");
		lblCriptografado.setBounds(50, 100, 200, 20);
		add(lblCriptografado);
		lblCriptografado.setVisible(true);

		txtDescriptografado = new JTextField();
		txtDescriptografado.setBounds(50, 70, 430, 20);
		add(txtDescriptografado);
		txtDescriptografado.setVisible(true);
		txtDescriptografado.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		txtCriptografado = new JTextField();
		txtCriptografado.setBounds(50, 120, 430, 20);
		add(txtCriptografado);
		txtCriptografado.setVisible(true);
		txtCriptografado.setDisabledTextColor(new java.awt.Color(0, 0, 0));

		btnCriptografar = new JButton("Criptografar");
		btnCriptografar.setBounds(50, 150, 110, 30);
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
		btnDescriptografar.setBounds(170, 150, 130, 30);
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
		btnOk.setBounds(310, 150, 60, 30);
		add(btnOk);
		btnOk.setVisible(true);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Atbash a = new Atbash();
				ControleAtbash ca = new ControleAtbash();
				
				if(botaoPresionado == "btnCriptografar"){
					a.setDescriptografado(txtDescriptografado.getText().toUpperCase());
					
					txtCriptografado.setText(ca.Criptografar(a));
					txtDescriptografado.setText(txtDescriptografado.getText().toUpperCase());
				}else if(botaoPresionado == "btnDescriptografar"){
					a.setCriptografado(txtCriptografado.getText().toUpperCase());
					
					txtDescriptografado.setText(ca.Descriptografar(a));
					txtCriptografado.setText(txtCriptografado.getText().toUpperCase());
				}
				ativaOpcoes();
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(380, 150, 100, 30);
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
	}
}
