package controle;

import javax.swing.JOptionPane;

import model.Atbash;

public class ControleAtbash {
	String alf1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", alf2 = "ZYXWVUTSRQPONMLKJIHGFEDCBA",
			num = "0123456789", convertido = "", espaco = " ";
	public String Criptografar(Atbash a){

		try{
			for(int i = 0; i < a.getDescriptografado().length(); i++){
				if(a.getDescriptografado().charAt(i) == espaco.charAt(0)){
					convertido += " ";
				}
				for(int j = 0; j < num.length(); j++){
					if(a.getDescriptografado().charAt(i) == num.charAt(j)){
						convertido += num.charAt(j);
					}
				}
				for(int j = 0; j < alf1.length(); j++){
					if(a.getDescriptografado().charAt(i) == alf1.charAt(j)){
						convertido += alf2.charAt(j);
					} 
				}
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " Ocorreu um erro ao criptografar \n Erro: "+e);
		}
		return convertido;
	}
	
	public String Descriptografar(Atbash a){
		try{
			for(int i = 0; i < a.getCriptografado().length(); i++){
				if(a.getCriptografado().charAt(i) == espaco.charAt(0)){
					convertido += " ";
				}
				for(int j = 0; j < num.length(); j++){
					if(a.getCriptografado().charAt(i) == num.charAt(j)){
						convertido += num.charAt(j);
					}
				}
				for(int j = 0; j < alf2.length(); j++){
					if(a.getCriptografado().charAt(i) == alf2.charAt(j)){
						convertido += alf1.charAt(j);
					} 
				}
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " Ocorreu um erro ao descriptografar \n Erro: "+e);
		}
		return convertido;
	}
}
