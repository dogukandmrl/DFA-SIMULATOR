import java.util.Scanner;

public class Eslesme {
	
	static char guncelKarakter;
	static char guncelDurum;
	static char[] KarakterDizisiSatir;
	static int KarakterDizisiSatirAdet = 0;
	    
	    public static void main(String[] args) {
	        
	        // Scanner objesi
	    	
	        Scanner giris = new Scanner(System.in);
	        
	        // Girişin alınması  
	        
	        DFA.DFATablosunuAl();
	        
	        boolean kullaniciDurumu = false;
	        
	        while(!kullaniciDurumu){
	        	
	            System.out.println(" İstenen giriş  String'i giriniz: ");
	            String stringGiris = giris.nextLine();
	            if(stringGiris.contentEquals("son"))
	                break;
	            else{
	            	
	                // Okunabilir formata  çevirilmesi
	            	
	                KarakterDizisiSatir = stringGiris.toCharArray();
	                KarakterDizisiSatirAdet = 0;
	                
	                // Geçişlerin başlaması
                        
	                
	                Algoritma();    // String eşleşme algoritması 
	            }
	        }
	    }
	    
	    private static void Algoritma() {
	           
	    	// DFA Tablosunu bir String ile eşleştirmek için kullanılan algoritma
	        
	    	guncelDurum = DFA.BaslangicDurumu();     //Mevcut Durumu Gösterir
	        guncelKarakter = SiradakiKarakter();       //giriş dizesindeki geçerli karakter



	        while(guncelKarakter != '$'){
	            guncelDurum = Degistir(guncelDurum,guncelKarakter);
	            guncelKarakter = SiradakiKarakter();
	        }
	        // Girişin doğru olup olmadığının kontrolü  
	        
	        System.out.println(FinalDurumuKontrol());
	    }
	    
	    private static char SiradakiKarakter() {
	        if(KarakterDizisiSatir == null || KarakterDizisiSatirAdet  == KarakterDizisiSatir.length){
	            return '$';
	        }else{
	            return KarakterDizisiSatir[KarakterDizisiSatirAdet++];
	        }
	    }
	    
	    private static char Degistir(char guncelDurum,char guncelKarakter) {
	        return DFA.SiradakiDurum(guncelDurum,guncelKarakter);
	    }

	    private static String FinalDurumuKontrol() {
	            if(DFA.FinalDurumu(guncelDurum)) {
	                return "evet";
	            }else {
	                return "hayir";
	            }
	        }
	}	
