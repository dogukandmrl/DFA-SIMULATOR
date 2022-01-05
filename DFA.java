import java.util.Scanner;

public class DFA {
    
    static char DFATablo[][];
    static int durumNumarasi;
    static int terminalNumarasi;
    static String[] finalDurumu;
    
    public static void DFATablosunuAl() {
    
    	// Yerel giris
    	
        Scanner DFAGiris = new Scanner(System.in);
        Scanner degerleriAl = new Scanner(System.in);
        Scanner finalDurumGiris = new Scanner(System.in);
        
        // Diziyi baslatmak için DFA durumlarını  alma
        
        System.out.println("DFA durumunun numarasını  girin: ");
        durumNumarasi = degerleriAl.nextInt()+1;
        System.out.println("DFA terminal'lerinin numarasını  girin: ");
        terminalNumarasi = degerleriAl.nextInt()+1;
        
        DFATablo = new char[durumNumarasi][terminalNumarasi];
        
        //   Değereleri DFA tablosundan alma
        
        System.out.println("DFA tablosundaki bütün   değerleri girin: ");
        
        for(int i=0;i<durumNumarasi;i++){
            for(int j=0;j<terminalNumarasi;j++){
                if(i==0 && j==0){DFATablo[0][0] = ' ';continue;}
                DFATablo[i][j] = DFAGiris.next().charAt(0);
            }
        }
        
        System.out.println("Boşluk ile ayrılmış tüm son durumları  giriniz: ");
        finalDurumu = finalDurumGiris.nextLine().split(" ");
        // finalDurumu = DFAGiris.nextLine();
        
    }
    
    public static char BaslangicDurumu() {
        return DFATablo[1][0];
    }
    
    public static char SiradakiDurum(char guncelDurum,char guncelKarakter){
        for(int i=1;i<durumNumarasi;i++){
            if(guncelDurum == DFATablo[i][0]){
                for(int j=1;j<terminalNumarasi;j++){
                    if(guncelKarakter == DFATablo[0][j]){
                        return DFATablo[i][j];
                    }
                }
            }
        }
        return '$';
    }

//        return DFATablo[durumNumarasi-1][0];
    
    public static boolean FinalDurumu(char guncelDurum) {
        for(String deger : finalDurumu){
            char karakterDegeri = deger.charAt(0);
            if(karakterDegeri == guncelDurum){
                return true;
            }
        }
        return false;
    }
}
