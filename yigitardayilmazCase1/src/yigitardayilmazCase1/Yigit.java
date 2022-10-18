package yigitardayilmazCase1;


public class Yigit {

	public static void main(String[] args) {
		 String isim = "Yigit A.YILMAZ";	//Rastgele tanımladığım çalışan bilgileri
			int maas=5000;			    	//Bunları kullanıcıdan giriş olarakta alabiliriz.
			int haftaliksaat=45;
			int baslangicyili=2012;

			Employee employee = new Employee(isim,maas,haftaliksaat,baslangicyili);  //Employee sınıfından nesne üretiyoruz.


	}

}
class Employee {

	// SINIF NİTELİKLERİ 
	 String name;
	 int salary,workHours,hireYear;
	 
	//1.METOT: KURUCU METOT(4 parametre alıyor)
	public Employee(String name, int salary, int workHours, int hireYear) {
											//main classtan gelen değişkenleri bu sınıftakilere eşliyoruz.
		this.name=name;
		this.salary=salary;
		this.workHours=workHours;
		this.hireYear=hireYear;
		
		toString();  						//Hesaplamaların yapılıp konsola yazdırılması için 5. metodumuzu çağırıyoruz.
			
		
	}

	//2.METOT: VERGİ HESABI
	 public int tax()
	 {
		 if(salary>1000) 					//Eğer alınan maaş 1000tl'den fazla ise maaşın %3'ü kadarını geri döndüyor.
		 {
			return salary*3/100;
			
		 }
		return 0;							//Değilse 0 geri dönüyor.
	

	 }
	 
	 //3.METOT: BONUS HESABI
	 public int bonus() 
	 {
		 if(workHours>40) 
		 {
			 return (workHours-40)*30*4;    //Eğer çalışma saati haftada 40 saatten fazla ise bonus geri döndürülüyor.
		 }									//(Haftalık bonus 4 ile çarpılarak aylık bonus hesaplanıyor)
		 									
		 return 0;							//Değilse 0 geri dönüyor.
	 }
	 
	 //4.METOT: MAAŞ ARTIŞI
	 public int raiseSalary() 
	 {
		 if(2021-hireYear<10)							 //Eğer 10 yıldan az çalışıldıysa 
		 {	
   			 return (salary*5/100)-tax()+bonus();		 // %5 artış yapılıyor. Artıştan vergi çıkarılıp bonus ekleniyor. Ve sonuç geri döndürülüyor. 
		 }
		 else if (20>2021-hireYear && 2021-hireYear>9)   //Eğer 9 ile 20 yıl arasıda bir süre çalışıldıysa
		 {
			 return (salary*10/100)-tax()+bonus(); 		 //%10 artış yapılıyor. Artıştan vergi çıkarılıp bonus ekleniyor. Ve sonuç geri döndürülüyor. 
		 }
		 else if ( 2021-hireYear>19) 					 //Eğer 19 yıldan fazla çalışıldysa
		 {
			 return (salary*15/100)-tax()+bonus();	   	 //%15 artış yapılıyor. Artıştan vergi çıkarılıp bonus ekleniyor. Ve sonuç geri döndürülüyor. 
		 }
		 return 0;
	 }

	 //5. METOT: KONSOLA YAZDIRMA
	 public String toString() {
		 
		 int tax = tax();					//Burada metotları tekrar tekrar çağırmamak için bir kez çağırıp geri dönen değerleri değişkenlere atıyorum.
		 int bonus = bonus();
		 int raiseSalary = raiseSalary();
		 int zam = raiseSalary+tax-bonus;  //raiseSalary() metodunda tax ve bonuslar dahil olduğu için bunları çıkarıyoruz geriye yapılan zam kalıyor.
		 
		 System.out.println("--------------------------------------");	
		 System.out.println("|          Calisan Bilgileri         |");
		 System.out.println("--------------------------------------");	
		 System.out.println("Isim                  :  "+name);						    //Çalışanın ismi konsola yazdırılıyor.
		 System.out.println("--------------------------------------");	
		 System.out.println("Calisma Saati         :  "+workHours+"   Saat");     		//Çalışanın haftalık çalışma saati konsola yazdırılıyor.
		 System.out.println("--------------------------------------");	
		 System.out.println("Baslangic Yili        :  "+hireYear);			     		//Çalışanın işe başlama tarihi konsola yazdırılıyor.(yıl olarak)
		 System.out.println("--------------------------------------");
		 System.out.println("Maas                  :  "+salary+" TL");	    	 		//Çalışanın maaşı konsola yazdırılıyor.
		 System.out.println("--------------------------------------");			
		 System.out.println("Maas Zammi            : +"+(zam)+"  TL");					//Çalışanın alacağı zam konsola yazdılıyor.
		 System.out.println("--------------------------------------");
		 System.out.println("Zamli Maas            : ="+(salary+zam)+" TL");			//Çalışanın zamlı maaşı konsola yazdırılıyor.
		 System.out.println("--------------------------------------");		 
		 System.out.println("Bonus                 : +"+bonus+"  TL");					//Çalışanın bonusu konsola yazdırılıyor.
		 System.out.println("--------------------------------------");
		 System.out.println("Toplam Maas           : ="+(salary+zam+bonus+" TL"));	    //Çalışanın yeni hesaplanan toplam maaşı konsola yazdırılıyor.
		 System.out.println("--------------------------------------");
		 System.out.println("Vergi                 : -"+tax+"  TL");		     		//Çalışanın vergisi konsola yazdırılıyor.
		 System.out.println("--------------------------------------");
		 System.out.println("Vergi ve Bonuslu Maas : ="+(salary+zam-tax+bonus)+" TL");  //Çalışanın bonuslu ve vergili maaşı konsola yazdırılıyor.
		 System.out.println("--------------------------------------");		
		 System.out.println("Maas Artisi           : +"+(raiseSalary)+"  TL");			//Çalışanın maaş artışı konsola yazdırılıyor.
		 System.out.println("--------------------------------------");

		 return "Program Sonu";
		}
}