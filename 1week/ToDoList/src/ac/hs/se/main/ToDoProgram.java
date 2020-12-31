
public class Program {
	
	public static void main(String[] args){
		
		try {
			List list = new List();
			list.init();
			
			boolean keepLoop = true;
			while(keepLoop) {
				int menu = list.menuInput();
				
				switch(menu) {
				case 1:
					list.add();
					break;
				case 2:
					list.update();
					break;
				case 3:
					list.delete();
					break;
				case 4:
					list.print();
					break;
				case 5:
					System.out.println(" ** END **");
					keepLoop = false;
					break;
				default:
					System.out.println(" ** ¿À·ù **");
				} 
			}
		} catch(Exception e) {e.printStackTrace();}
	}
}