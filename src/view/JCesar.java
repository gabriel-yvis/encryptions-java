package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Cesar;
import controle.ControleCesar;

public class JCesar extends JFrame{
	
	private JLabel lblNormal, lblCriptografado, lblChave;
	private JTextField txtDescriptografado, txtCriptografado, txtChave;
	private JButton btnCriptografar, btnDescriptografar, btnOk, btnCancelar;
	private JRadioButton rbPadrao, rbChave;
	private ButtonGroup grpChave;
	String botaoPresionado = "";
	
	public JCesar(){
		setBounds(0, 0, 600, 500);
		setTitle("Cesar");
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
				Cesar c = new Cesar();
				ControleCesar cc = new ControleCesar();
				
				if(rbPadrao.isSelected()){
					c.setChave(3);
				}else if(rbChave.isSelected()){
					try{
						c.setChave(Integer.parseInt(txtChave.getText()));
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, " digite apenas numeros na 'chave' \n Erro: "+e);
					}
				}
				
				if(botaoPresionado == "btnCriptografar"){
					c.setDescriptografado(txtDescriptografado.getText().toUpperCase());
					
					txtCriptografado.setText(cc.Criptografar(c));
					txtDescriptografado.setText(txtDescriptografado.getText().toUpperCase());
				}else if(botaoPresionado == "btnDescriptografar"){
					c.setCriptografado(txtCriptografado.getText().toUpperCase());
					
					txtDescriptografado.setText(cc.Descriptografar(c));
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
		
		grpChave = new ButtonGroup();

		rbPadrao = new JRadioButton("Padrao (chave 3)");
		rbPadrao.setBounds(50, 220, 225, 20);
		rbPadrao.setSelected(true);
		grpChave.add(rbPadrao);
		add(rbPadrao);
		rbPadrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtChave.setEnabled(false);
				txtChave.setText("");
			}
		});

		rbChave = new JRadioButton("Com Chave");
		rbChave.setBounds(275, 220, 225, 20);
		rbChave.setSelected(true);
		grpChave.add(rbChave);
		add(rbChave);
		rbChave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtChave.setEnabled(true);
			}
		});
		
		lblChave = new JLabel();
		lblChave.setText("Chave:");
		lblChave.setBounds(290, 240, 100, 20);
		add(lblChave);
		lblChave.setVisible(true);

		txtChave = new JTextField();
		txtChave.setBounds(480, 240, 20, 20);
		add(txtChave);
		txtChave.setVisible(true);
		txtChave.setEnabled(false);
		
		ativaOpcoes();
	}
	public void ativaOpcoes(){
		btnOk.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnCriptografar.setEnabled(true);
		btnDescriptografar.setEnabled(true);
		txtCriptografado.setEnabled(false);
		txtDescriptografado.setEnabled(false);
		rbChave.setEnabled(false);
		rbPadrao.setEnabled(false);
		rbPadrao.setSelected(true);
		txtChave.setEnabled(false);
		txtChave.setText("");
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
		rbChave.setEnabled(true);
		rbPadrao.setEnabled(true);
		rbPadrao.setSelected(true);
		txtChave.setEnabled(false);
		txtChave.setText("");
	}
}
