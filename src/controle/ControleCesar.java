package controle;

import javax.swing.JOptionPane;

import model.Cesar;

public class ControleCesar {
	String alf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", num = "0123456789",
			convertido = "", espaco = " ";
	int chave;
	
	public String Criptografar(Cesar c){
		try{
			chave = c.getChave();
			for(int i = 0; i < c.getDescriptografado().length(); i++){
				if(c.getDescriptografado().charAt(i) == espaco.charAt(0)){
					convertido += " ";
				} 
				for(int j = 0; j < num.length(); j++){
					if(c.getDescriptografado().charAt(i) == num.charAt(j)){
						convertido += num.charAt(j);
					}
				}
				for(int j = 0; j < alf.length(); j++){
					if((c.getDescriptografado().charAt(i) == alf.charAt(j) && j < chave)){
						convertido += alf.charAt(j+(26-chave));
					}else if(c.getDescriptografado().charAt(i) == alf.charAt(j)){
						convertido += alf.charAt(j-chave);
					}
				}
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " Ocorreu um erro ao criptografar \n Erro: "+e);
		}
		return convertido;		
	}
	
	public String Descriptografar(Cesar c){
		try{
			chave = c.getChave();
			for(int i = 0; i < c.getCriptografado().length(); i++){
				if(c.getCriptografado().charAt(i) == espaco.charAt(0)){
					convertido += " ";
				} 
				for(int j = 0; j < num.length(); j++){
					if(c.getCriptografado().charAt(i) == num.charAt(j)){
						convertido += num.charAt(j);
					}
				}
				for(int j = 0; j < alf.length(); j++){
					if((c.getCriptografado().charAt(i) == alf.charAt(j) && j > (25-chave))){
						convertido += alf.charAt(j-(26-chave));
					}else if(c.getCriptografado().charAt(i) == alf.charAt(j)){
						convertido += alf.charAt(j+chave);
					}
				}
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " Ocorreu um erro ao descriptografar \n Erro: "+e);
		}
		return convertido;
	}
}
