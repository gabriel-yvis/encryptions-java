package controle;

import javax.swing.JOptionPane;

import model.A1Z26;

public class ControleA1Z26 {
	String alf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", convertido = "", espaco = " ";
	String[] criptografado1, criptografado2;
	
	public String Criptografar(A1Z26 a){
		try{
			//Vector<String> criptografado = new Vector<String>();
			//criptografado.add("14")
			//criptografado.size
			
			for(int i = 0; i < a.getDescriptografado().length(); i++){
				for(int j = 0; j < alf.length(); j++){
					if(a.getDescriptografado().charAt(i) == alf.charAt(j)){
						convertido += j+1;
					}
				}
				if(i < a.getDescriptografado().length()-1){
					convertido += "-";
				}
			}				
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " Ocorreu um erro ao criptografar \n Erro: "+e);
		}
		return convertido = convertido.replace("--", " ");
	}
	
	public String Descriptografar(A1Z26 a){
		try{
			criptografado1 = a.getCriptografado().split(" ");
			for(int i = 0; i < criptografado1.length; i++){
				criptografado2 = criptografado1[i].split("-");
				for(int j = 0; j < criptografado2.length; j++){
					convertido += alf.charAt(Integer.parseInt(criptografado2[j])-1);
				}
				convertido += " ";
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " Ocorreu um erro ao descriptografar \n Erro: "+e);
		}
		return convertido;
	}
}
