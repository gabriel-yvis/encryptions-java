package controle;

import javax.swing.JOptionPane;

import model.Vigenere;

public class ControleVigenere {
	String alf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", num = "0123456789",
			convertido = "", espaco = " ", strChave1, strChave2 = "";
	String[] vetChave1;
	int intChave1, intChave2, intChave3;
	
	public String Criptografar(Vigenere v){
		try{
			strChave1 = v.getChave();
			intChave1 = Math.floorDiv(v.getDescriptografado().length(),v.getChave().length());
			intChave2 = Math.floorMod(v.getDescriptografado().length(),v.getChave().length());
			
			for(int i = 0; i < intChave1;i++){
				strChave2 += strChave1;
			}
			for(int i = 0; i < intChave2;i++){
				strChave2 += strChave1.charAt(i);
			}
			
			strChave1 = "";
			
			for(int i = 0; i < strChave2.length();i++){
				for(int j = 0; j < alf.length(); j++){
					if(strChave2.charAt(i) == alf.charAt(j)){
						strChave1 += j+1;
					}
				}
				if(i < strChave2.length()-1){
					strChave1 += "-";
				}
			}
			vetChave1 = strChave1.split("-");
			
			for(int i = 0; i < v.getDescriptografado().length(); i++){
				if(v.getDescriptografado().charAt(i) == espaco.charAt(0)){
					convertido += " ";
				} 
				for(int j = 0; j < num.length(); j++){
					if(v.getDescriptografado().charAt(i) == num.charAt(j)){
						convertido += num.charAt(j);
					}
				}
				for(int j = 0; j < alf.length(); j++){
					intChave3 = Integer.parseInt(vetChave1[i]);
					if((v.getDescriptografado().charAt(i) == alf.charAt(j))){
						if((j+intChave3-1)<26){
							convertido += alf.charAt(j+intChave3-1);
						}else{
							convertido += alf.charAt((j+intChave3-1)-26);
						}
					}
				}
			}
			
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " Ocorreu um erro ao criptografar \n Erro: "+e);
		}
		return convertido;
	}
	
	public String Descriptografar(Vigenere v){
		try{
			strChave1 = v.getChave();
			intChave1 = Math.floorDiv(v.getCriptografado().length(),v.getChave().length());
			intChave2 = Math.floorMod(v.getCriptografado().length(),v.getChave().length());
			
			for(int i = 0; i < intChave1;i++){
				strChave2 += strChave1;
			}
			for(int i = 0; i < intChave2;i++){
				strChave2 += strChave1.charAt(i);
			}
			
			strChave1 = "";
			
			for(int i = 0; i < strChave2.length();i++){
				for(int j = 0; j < alf.length(); j++){
					if(strChave2.charAt(i) == alf.charAt(j)){
						strChave1 += j+1;
					}
				}
				if(i < strChave2.length()-1){
					strChave1 += "-";
				}
			}
			vetChave1 = strChave1.split("-");
			
			for(int i = 0; i < v.getCriptografado().length(); i++){
				if(v.getCriptografado().charAt(i) == espaco.charAt(0)){
					convertido += " ";
				} 
				for(int j = 0; j < num.length(); j++){
					if(v.getCriptografado().charAt(i) == num.charAt(j)){
						convertido += num.charAt(j);
					}
				}
				for(int j = 0; j < alf.length(); j++){
					intChave3 = Integer.parseInt(vetChave1[i]);
					if((v.getCriptografado().charAt(i) == alf.charAt(j))){
						if((j-intChave3+1)>=0){
							convertido += alf.charAt(j-intChave3+1);
						}else{
							convertido += alf.charAt((j-intChave3+1)+26);
						}
					}
				}
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " Ocorreu um erro ao descriptografar \n Erro: "+e);
		}
		return convertido;
	}
}
