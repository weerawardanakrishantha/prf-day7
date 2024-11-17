

import java.util.*;
class Example{
	public static String[] sizeArray={"XS","S","M","L","XL","XXL"};
	public static double[] priceArray={600.0,800.0,900.0,1000.0,1100.0,1200.0};
	
	public static String[] orderIdArray=new String[0];
	public static String[] customerIdArray=new String[0];
	public static String[] selectedSizeArray=new String[0];
	public static int[] quantityArray=new int[0];
	public static double[] amountArray=new double[0];
	public static int[] statusArray=new int[0];	
	public static int[] indexArray=new int[0];
	
	public static String[] arCustomerId=new String[0];
	public static int[] arQuantity=new int[0];
	public static double[] arAmount=new double[0];
	public static int[] brQuantity=new int[0];
	public static double[] brAmount=new double[0];	
	
	
	public static final int PROCESSING=0;
	public static final int DELIVERING=1;
	public static final int DELIVERED=2;
	
	public static Scanner input=new Scanner(System.in);
	
	public final static void clearConsole(){
		try{
			final String os=System.getProperty("os.name");
			if(os.contains("Windows")){
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}else{
				System.out.print("\033[H033[2J");
				System.out.flush();
			}
		}catch(final Exception e){
			e.printStackTrace();
		}
	}
	
	public static void homePage(){
		System.out.println("\r\n       /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          \r\n      | $$_____/                | $$      |__/                           /$$__  $$| $$                          \r\n      | $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ \r\n      | $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$\r\n      | $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$\r\n      | $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$\r\n      | $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/\r\n      |__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ \r\n                                                                                                      | $$      \r\n                                                                                                      | $$      \r\n                                                                                                      |__/      \r\n");
		System.out.println("    _______________________________________________________________________________________________________________");
		System.out.println("\n");
		System.out.print("\t[1] Place Order");
		System.out.println("\t\t\t\t\t\t[2] Search Customer\n");
		System.out.print("\t[3] Search Order");
		System.out.println("\t\t\t\t\t[4] View Reports\n");
		System.out.print("\t[5] Set Order Status");
		System.out.println("\t\t\t\t\t[6] Delete Order\n\n");
		
		System.out.print("\tInput Option : ");
		int option=input.nextInt();
		clearConsole();
		
		switch(option){
			case 1: placeOrder();
			break;
			case 2: searchCustomer();
			break;
			case 3: searchOrder();
			break;
			case 4: viewReports();
			break;
			case 5: changeOrderStatus();			
			break;
			case 6: deleteOrder();
			break;
			default:
			System.out.println("\n");
			System.out.println("\t\tInvalid input..");
			break;
		}
		
	}	
	public static int searchString(String[] arr,String key){
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(key)){
				return i;
			}
		}
		return -1;
	}
	public static String[] arrExtend(String[] arr){
		String[] temp=new String[arr.length+1];
		for(int i=0;i<arr.length;i++){
			temp[i]=arr[i];
		}
		return temp;
	}
	public static int searchInt(int[] arr,int key){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key){
				return i;
			}
		}
		return -1;
	}
	public static int[] brExtend(int[] arr){
		int[] temp=new int[arr.length+1];
		for(int i=0;i<arr.length;i++){
			temp[i]=arr[i];
		}
		return temp;
	}
	public static int searchDouble(double[] arr,double key){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key){
				return i;
			}
		}
		return -1;
	}
	public static double[] crExtend(double[] arr){
		double[] temp=new double[arr.length+1];
		for(int i=0;i<arr.length;i++){
			temp[i]=arr[i];
		}
		return temp;
	}
	public static void extendIndexArray(){
		int[] tempIndexArray=new int[indexArray.length+1];
		for(int i=0;i<indexArray.length;i++){
			tempIndexArray[i]=indexArray[i];
		}
		indexArray=tempIndexArray;
	}
	
	public static void extendArrays(){
		String[] tempOrderIdArray=new String[orderIdArray.length+1];
		String[] tempCustomerIdArray=new String[customerIdArray.length+1];
		String[] tempSelectedSizeArray=new String[selectedSizeArray.length+1];
		int[] tempQuantityArray=new int[quantityArray.length+1];
		double[] tempAmountArray=new double[amountArray.length+1];
		int[] tempStatusArray=new int[statusArray.length+1];
		
		for(int i=0;i<orderIdArray.length;i++){
			tempOrderIdArray[i]=orderIdArray[i];
			tempCustomerIdArray[i]=customerIdArray[i];
			tempSelectedSizeArray[i]=selectedSizeArray[i];
			tempQuantityArray[i]=quantityArray[i];
			tempAmountArray[i]=amountArray[i];
			tempStatusArray[i]=statusArray[i];
		}
		orderIdArray=tempOrderIdArray;
		customerIdArray=tempCustomerIdArray;
		selectedSizeArray=tempSelectedSizeArray;
		quantityArray=tempQuantityArray;
		amountArray=tempAmountArray;
		statusArray=tempStatusArray;
	}		
	public static String generateId(){
		if(orderIdArray.length==0){
			return "ODR#00001";
		}
		String lastId=orderIdArray[orderIdArray.length-1];
		int lastNo=Integer.parseInt(lastId.substring(4));		
		return String.format("ODR#%05d",lastNo+1);
	}
	
	public static void main(String args[]){
		homePage();
	}
	public static void placeOrder(){
		do{
			System.out.println("\r\n      _____  _                   ____          _           \r\n     |  __ \\| |                 / __ \\        | |          \r\n     | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ \r\n     |  ___/| |/ _` |/ __/ _ \\ | |  | | \'__/ _` |/ _ \\ \'__|\r\n     | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   \r\n     |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   \r\n                                                           \r\n                                                           \r\n");
			System.out.println("    ________________________________________________________");
			System.out.println("\n");
			String orderId=generateId();
			System.out.println("\tEnter Order Id : "+orderId);
			System.out.println();
			String phoneNumber="";
			int index=0;
			
			L1:while(true){
				System.out.println("\n");
				System.out.print("\tEnter Customer Phone Number : ");
				phoneNumber=input.next();
				
				if((phoneNumber.length()==10)&&(phoneNumber.charAt(0)=='0')){
					phoneNumber=phoneNumber;
					break L1;
				}else{
					System.out.println("\n");
					System.out.println("\t\tInvalid Phone Number...Try again");
					System.out.println("\n");
					System.out.print("\tDo you want to enter phone number again (Y/N) : ");
					char ch=input.next().charAt(0);
					if(ch=='Y'||ch=='y'){
						continue L1;
					}else if(ch=='N'||ch=='n'){
						clearConsole();
						homePage();
					}
				}					
			}
			System.out.println("\n");
			System.out.print("\tEnter T-shirt Size (\"XS\"/\"S\"/\"M\"/\"L\"/\"XL\"/\"XXL\") : ");
			String size=input.next();
			
			if(size.equals("XS")){
				index=0;
			}else if(size.equals("S")){
				index=1;
			}else if(size.equals("M")){
				index=2;
			}else if(size.equals("L")){
				index=3;
			}else if(size.equals("XL")){
				index=4;
			}else if(size.equals("XXL")){
				index=5;
			}
			
			System.out.println("\n");
			System.out.print("\tEnter QTY : ");
			int qty=input.nextInt();
			
			double amount=priceArray[index]*qty;
			System.out.println("\n");
			System.out.println("\tAmount : "+amount);
			System.out.println("\n");
			System.out.print("Do you want to place this order (Y/N) : ");
			char ch=input.next().charAt(0);
			clearConsole();
			
			if(ch=='Y'||ch=='y'){
				extendArrays();				
				orderIdArray[orderIdArray.length-1]=orderId;
				customerIdArray[customerIdArray.length-1]=phoneNumber;
				selectedSizeArray[selectedSizeArray.length-1]=size;
				quantityArray[quantityArray.length-1]=qty;
				amountArray[amountArray.length-1]=amount;
				statusArray[statusArray.length-1]=PROCESSING;				
				
				System.out.println("\n\t\tOrder Placed..!");
				System.out.println("\n");
				System.out.print("Do you want to place another order (Y/N) : ");
				char cha=input.next().charAt(0);
				clearConsole();
				if(cha=='Y'||cha=='y'){
					continue;
				}else if(cha=='N'||cha=='n'){
					homePage();
				}
			}else if(ch=='N'||ch=='n'){
				System.out.println("\n");
				System.out.print("Do you want to place another order (Y/N) : ");
				char cha=input.next().charAt(0);
				clearConsole();
				if(cha=='Y'||cha=='y'){
					continue;
				}else if(cha=='N'||cha=='n'){
					homePage();
				}
			}					
			
		}while(true);
	}
	
	
	public static void searchCustomer(){
		L3:do{
			System.out.println("\r\n       _____                     _        _____          _                            \r\n      / ____|                   | |      / ____|        | |                           \r\n     | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ \r\n      \\___ \\ / _ \\/ _` | \'__/ __| \'_ \\  | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__|\r\n      ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   \r\n     |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   \r\n                                                                                      \r\n                                                                                      \r\n");
			System.out.println("     ________________________________________________________________________________");
			System.out.println("\n");
			String phoneNumber="";
			L2:while(true){
				System.out.println("\n");
				System.out.print("\tEnter Customer Phone Number : ");
				phoneNumber=input.next();
				
				if((phoneNumber.length()==10)&&(phoneNumber.charAt(0)=='0')){
					phoneNumber=phoneNumber;
					break L2;
				}else{
					System.out.println("\n");
					System.out.println("\t\tInvalid input..");
					System.out.println("\n");
					System.out.print("\tDo you want to search another customer report? (Y/N) : ");
					char ch=input.next().charAt(0);
					if(ch=='Y'||ch=='y'){
						continue L2;
					}else if(ch=='N'||ch=='n'){
						clearConsole();
						homePage();
					}
				}					
			}
			
			indexArray = new int[0];
			for(int i=0;i<customerIdArray.length;i++){
					
				if(phoneNumber.equals(customerIdArray[i])){	
					extendIndexArray();		
					indexArray[indexArray.length-1]=i;
				}				
				
			}
			
				if(indexArray.length==0){
					System.out.println("\t\tInvalid input..");
						System.out.println("\n");
						System.out.print("\tDo you want to search another customer report? (Y/N) : ");
						char ch=input.next().charAt(0);
						if(ch=='Y'||ch=='y'){
							continue L3;
						}else if(ch=='N'||ch=='n'){
							clearConsole();
							homePage();
						}
					}
		
			
			int[] totalQuantityArray=new int[indexArray.length];
			String[] totalSizeArray=new String[indexArray.length];
			for(int i=0;i<indexArray.length;i++){
				totalQuantityArray[i]=quantityArray[indexArray[i]];
				totalSizeArray[i]=selectedSizeArray[indexArray[i]];
			}
			int[] selectedQuantityArray=new int[6];
			for(int i=0;i<totalSizeArray.length;i++){
				switch(totalSizeArray[i]){
					case "SX":selectedQuantityArray[0]+=totalQuantityArray[i];
					break;
					case "S":selectedQuantityArray[1]+=totalQuantityArray[i];
					break;
					case "M":selectedQuantityArray[2]+=totalQuantityArray[i];
					break;
					case "L":selectedQuantityArray[3]+=totalQuantityArray[i];
					break;
					case "XL":selectedQuantityArray[4]+=totalQuantityArray[i];
					break;
					case "XXL":selectedQuantityArray[5]+=totalQuantityArray[i];
					break;
				}
			}
			
			double sum=0;
			
			double[] selectedAmountArray=new double[selectedQuantityArray.length];
			
			for(int i=0;i<selectedQuantityArray.length;i++){
				selectedAmountArray[i]=selectedQuantityArray[i]*priceArray[i];
				sum+=selectedAmountArray[i];
			}
			
			sizeArray=new String[]{"XS","S","M","L","XL","XXL"};
			
			for(int i=0;i<selectedQuantityArray.length;i++){
				for(int j=0;j<selectedQuantityArray.length;j++){
					if(i!=j){
						if(selectedAmountArray[i]>selectedAmountArray[j]){
							double temp=selectedAmountArray[i];
							selectedAmountArray[i]=selectedAmountArray[j];
							selectedAmountArray[j]=temp;
							
							String tem=sizeArray[i];
							sizeArray[i]=sizeArray[j];
							sizeArray[j]=tem;
							
							int t=selectedQuantityArray[i];
							selectedQuantityArray[i]=selectedQuantityArray[j];
							selectedQuantityArray[j]=t;
						}
					}
				}
			}
			System.out.println("\n");
			System.out.println("+--------------------------------------------------+");
			System.out.printf("| %15s | %15s | %12s | \n","Size","QTY","Amount");
			System.out.println("+--------------------------------------------------+");
			for(int i=0;i<sizeArray.length;i++){
				System.out.printf("| %15s | %15d | %12.2f | \n",sizeArray[i],selectedQuantityArray[i],selectedAmountArray[i]);
			}
			System.out.println("+--------------------------------------------------+");
			System.out.printf("| %33s | % 12.2f | \n","Total Amount",sum);
			System.out.println("+--------------------------------------------------+");	
			System.out.println("\n");		
			
			System.out.println("\n");
			System.out.print("\tDo you want to search another customer report? (Y/N) : ");
			char ch=input.next().charAt(0);
			if(ch=='Y'||ch=='y'){
				continue L3;
			}else if(ch=='N'||ch=='n'){
				clearConsole();
				homePage();
			}
			
			
		}while(true);
		
	}
	
	public static void searchOrder(){
		do{
			System.out.println("\r\n       \r\n       _____                     _        ____          _           \r\n      / ____|                   | |      / __ \\        | |          \r\n     | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ \r\n      \\___ \\ / _ \\/ _` | \'__/ __| \'_ \\  | |  | | \'__/ _` |/ _ \\ \'__|\r\n      ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   \r\n     |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   \r\n                                                                    \r\n                                                                    \r\n");
			System.out.println("     ______________________________________________________________");
			
			
			L4:while(true){
				System.out.println("\n");
				System.out.print("\tEnter order ID : ");
				String ordID=input.next();
				for(int i=0;i<orderIdArray.length;i++){
					if(ordID.equals(orderIdArray[i])){
						System.out.println("\n");
						System.out.println("\t\tPhone Number : "+customerIdArray[i]);
						System.out.println("\t\tSize : "+selectedSizeArray[i]);
						System.out.println("\t\tQTY : "+quantityArray[i]);
						System.out.printf("\t\tAmount : %.2f \n",amountArray[i]);
						if(statusArray[i]==0){
							System.out.println("\t\tStatus : PROCESSING");
						}else if(statusArray[i]==1){
							System.out.println("\t\tStatus : DELIVERING");
						}else if(statusArray[i]==2){
							System.out.println("\t\tStatus : DELIVERED");
						}							
						System.out.println("\n");
						System.out.print("\tDo you want to search another order? (Y/N) :");
						char ch=input.next().charAt(0);
						if(ch=='Y'||ch=='y'){
							continue L4;
						}else if(ch=='N'||ch=='n'){
							homePage();
						}					
						
					}
				}
				for(int i=0;i<orderIdArray.length;i++){
					if(!ordID.equals(orderIdArray[i])){
						System.out.println("\t\tInvalid ID...");
						System.out.println("\n");
						System.out.print("\tDo you want to search another order? (Y/N) :");
						char ch=input.next().charAt(0);
						if(ch=='Y'||ch=='y'){
							continue L4;
						}else if(ch=='N'||ch=='n'){
							homePage();
						}
					}
				}
				
			}
			
		}while(true);
	}
	
	public static void viewReports(){
		System.out.println("\r\n     _____                       _       \r\n    |  __ \\                     | |      \r\n    | |__) |___ _ __   ___  _ __| |_ ___ \r\n    |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n               | |                       \r\n               |_|                       \r\n");
		System.out.println("   _______________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Customer Reports \n");
		System.out.println("\t\t[2] Item Reports\n");
		System.out.println("\t\t[3] Orders Reports\n\n");
		System.out.print("\tEnter Option : ");
		int opt=input.nextInt();
		clearConsole();
		
		switch(opt){
			case 1: customerReports();
			break;
			case 2: itemReports();
			break;
			case 3: orderReports();
			break;
			default : 
			System.out.println("\t\tInvalid input..");
			break;
		}
	}
	
	public static void customerReports(){
		System.out.println("\r\n\r\n      _____          _                              _____                       _       \r\n     / ____|        | |                            |  __ \\                     | |      \r\n    | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ \r\n    | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n    | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n     \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n                                                              | |                       \r\n                                                              |_|                       \r\n");
		System.out.println("    _____________________________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Best in Customers\n");
		System.out.println("\t\t[2] View Customers\n");
		System.out.println("\t\t[3] All Customer Reports\n\n");
		System.out.print("\tEnter Option : ");
		int opt=input.nextInt();
		clearConsole();
		
		switch(opt){
			case 1: bestInCustomers();
			break;
			case 2: viewCustomers();
			break;
			case 3: allCustomerReports();
			break;
			default:
			System.out.println("\t\tInvalid input..");
			break;
		}
	}
	
	public static void itemReports(){
		System.out.println("\r\n     _____ _                   _____                       _       \r\n    |_   _| |                 |  __ \\                     | |      \r\n      | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ \r\n      | | | __/ _ \\ \'_ ` _ \\  |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n     _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n    |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n                                         | |                       \r\n                                         |_|                       \r\n");
		System.out.println("   _________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] Best Selling Categories Sorted by QTy\n");
		System.out.println("\t\t[2] Best Selling Categories Sorted by Amount\n\n");
		System.out.print("\tEnter Option : ");
		int opt=input.nextInt();
		clearConsole();
		
		switch(opt){
			case 1: sortedByQty();
			break;
			case 2: sortedByAmount();
			break;
			default:
			System.out.println("\t\tInvalid input..");
			break;
		}
	}
	
	public static void orderReports(){
		System.out.println("\r\n      ____          _             _____                       _       \r\n     / __ \\        | |           |  __ \\                     | |      \r\n    | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ \r\n    | |  | | \'__/ _` |/ _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n    | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n     \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n                                            | |                       \r\n                                            |_|                       \r\n");
		System.out.println("    ___________________________________________________________________");
		System.out.println("\n");
		System.out.println("\t\t[1] All Orders\n");
		System.out.println("\t\t[2] Orders by Amount\n\n");
		System.out.print("\tEnter option : ");
		int opt=input.nextInt();
		clearConsole();
		switch(opt){
			case 1: allOrders();
			break;
			case 2: oderByAmount();
			break;
			default:
			System.out.println("\t\tInvalid input..");
			break;
		}
	}
	
	public static void bestInCustomers(){
		System.out.println("\r\n     ____            _     _____          _____          _                                \r\n    |  _ \\          | |   |_   _|        / ____|        | |                               \r\n    | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ \r\n    |  _ < / _ \\/ __| __|   | | | \'_ \\  | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__/ __|\r\n    | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\\r\n    |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/\r\n                                                                                          \r\n                                                                                          \r\n\r\n");
		System.out.println("   ________________________________________________________________________________________");
		System.out.println("\n");
		
		arCustomerId=new String[0];
	    arQuantity=new int[0];
		arAmount=new double[0];
		brQuantity=new int[0];
		brAmount=new double[0];	
		
				
		for(int i=0;i<customerIdArray.length;i++){	
			arQuantity=brExtend(arQuantity);
			arAmount=crExtend(arAmount);							
			for(int j=0;j<customerIdArray.length;j++){			
				if(customerIdArray[i].equals(customerIdArray[j])){						
					arQuantity[arQuantity.length-1]+=quantityArray[j];											
					arAmount[arAmount.length-1]+=amountArray[j];
				}			
			}
		}
		
		
		for(int i=0;i<customerIdArray.length;i++){
			if(searchString(arCustomerId,customerIdArray[i])!=-1){
				continue;
			}
			arCustomerId=arrExtend(arCustomerId);
			arCustomerId[arCustomerId.length-1]=customerIdArray[i];
			brQuantity=brExtend(brQuantity);
			brQuantity[brQuantity.length-1]=arQuantity[i];
			brAmount=crExtend(brAmount);
			brAmount[brAmount.length-1]=arAmount[i];
		}
		
		for(int i=0;i<arCustomerId.length;i++){
			for(int j=0;j<arCustomerId.length;j++){
				if(i!=j){
					if(brAmount[i]>brAmount[j]){
						double r=brAmount[i];
						brAmount[i]=brAmount[j];
						brAmount[j]=r;
						
						String p=arCustomerId[i];
						arCustomerId[i]=arCustomerId[j];
						arCustomerId[j]=p;
						
						int q=brQuantity[i];
						brQuantity[i]=brQuantity[j];
						brQuantity[j]=q;
						
						
					}
				}
			}
		}
		System.out.println("+-----------------------------------------------------+");
		System.out.printf("| %15s | %15s | %15s |\n","Customer ID","All QTY","Total Amount");
		System.out.println("+-----------------------------------------------------+");
		for(int i=0;i<arCustomerId.length;i++){
			System.out.printf("| %15s | %15s | %15.2f |\n",arCustomerId[i],brQuantity[i],brAmount[i]);
		}
		System.out.println("+-----------------------------------------------------+");
		
		System.out.println("\n");			
		System.out.print("To access main menu, please enter 0 : ");
		char ch=input.next().charAt(0);
		if(ch=='0'){
			clearConsole();
			homePage();
			
		}
		
	}
	public static void viewCustomers(){
		System.out.println("\r\n    __      ___                  _____          _                                \r\n    \\ \\    / (_)                / ____|        | |                               \r\n     \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ \r\n      \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__/ __|\r\n       \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\\r\n        \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/\r\n                                                                                 \r\n                                                                                 \r\n");
		System.out.println("   _______________________________________________________________________________");
		System.out.println("\n");
		
		arCustomerId=new String[0];
	    arQuantity=new int[0];
		arAmount=new double[0];
		brQuantity=new int[0];
		brAmount=new double[0];	
		
		for(int i=0;i<customerIdArray.length;i++){	
			arQuantity=brExtend(arQuantity);
			arAmount=crExtend(arAmount);							
			for(int j=0;j<customerIdArray.length;j++){			
				if(customerIdArray[i].equals(customerIdArray[j])){						
					arQuantity[arQuantity.length-1]+=quantityArray[j];											
					arAmount[arAmount.length-1]+=amountArray[j];
				}			
			}
		}
		
		for(int i=0;i<customerIdArray.length;i++){
			if(searchString(arCustomerId,customerIdArray[i])!=-1){
				continue;
			}
			arCustomerId=arrExtend(arCustomerId);
			arCustomerId[arCustomerId.length-1]=customerIdArray[i];
			brQuantity=brExtend(brQuantity);
			brQuantity[brQuantity.length-1]=arQuantity[i];
			brAmount=crExtend(brAmount);
			brAmount[brAmount.length-1]=arAmount[i];
		}
		
		System.out.println("+-----------------------------------------------------+");
		System.out.printf("| %15s | %15s | %15s |\n","Customer ID","All QTY","Total Amount");
		System.out.println("+-----------------------------------------------------+");
		for(int i=0;i<arCustomerId.length;i++){
			System.out.printf("| %15s | %15s | %15.2f |\n",arCustomerId[i],brQuantity[i],brAmount[i]);
		}
		System.out.println("+-----------------------------------------------------+");
		
		System.out.println("\n");			
		System.out.print("To access main menu, please enter 0 : ");
		char ch=input.next().charAt(0);
		if(ch=='0'){
			clearConsole();
			homePage();
			
		}
		
	}
	public static void allCustomerReports(){
		System.out.println("\r\n              _ _    _____          _                              _____                       _   \r\n        /\\   | | |  / ____|        | |                            |  __ \\                     | |  \r\n       /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ \r\n      / /\\ \\ | | | | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __|\r\n     / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ \r\n    /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|\r\n                                                                             | |                   \r\n                                                                             |_|                   \r\n");
		System.out.println("   _________________________________________________________________________________________________");
		System.out.println("\n");
		
		arCustomerId=new String[0];
		int[] XS=new int[0];
		int[] S=new int[0];
		int[] M=new int[0];
		int[] L=new int[0];
		int[] XL=new int[0];
		int[] XXL=new int[0];
		
		int[] arxs=new int[0];
		int[] ars=new int[0];
		int[] arm=new int[0];
		int[] arl=new int[0];
		int[] arxl=new int[0];
		int[] arxxl=new int[0];
		
		for(int i=0;i<customerIdArray.length;i++){
			XS=brExtend(XS);
			S=brExtend(S);
			M=brExtend(M);
			L=brExtend(L);
			XL=brExtend(XL);
			XXL=brExtend(XXL);
			for(int j=0;j<customerIdArray.length;j++){
				if(customerIdArray[i].equals(customerIdArray[j])){
					switch(selectedSizeArray[j]){
						case "XS": XS[XS.length-1]+=quantityArray[j];
						break;
						case "S": S[S.length-1]+=quantityArray[j];
						break;
						case "M": M[M.length-1]+=quantityArray[j];
						break;
						case "L": L[L.length-1]+=quantityArray[j];
						break;
						case "XL": XL[XL.length-1]+=quantityArray[j];
						break;
						case "XXL": XXL[XXL.length-1]+=quantityArray[j];
					}
				}
			}
		} 
		
		for(int i=0;i<customerIdArray.length;i++){
			if(searchString(arCustomerId,customerIdArray[i])!=-1){
				continue;
			}
			arCustomerId=arrExtend(arCustomerId);
			arCustomerId[arCustomerId.length-1]=customerIdArray[i];
			arxs=brExtend(arxs);
			arxs[arxs.length-1]=XS[i];
			ars=brExtend(ars);
			ars[ars.length-1]=S[i];
			arm=brExtend(arm);
			arm[arm.length-1]=M[i];
			arl=brExtend(arl);
			arl[arl.length-1]=L[i];
			arxl=brExtend(arxl);
			arxl[arxl.length-1]=XL[i];
			arxxl=brExtend(arxxl);
			arxxl[arxxl.length-1]=XXL[i];
		}
		double[] arTotal=new double[arCustomerId.length];
		for(int i=0;i<arTotal.length;i++){
			arTotal[i]=arxs[i]*priceArray[0]+ars[i]*priceArray[1]+arm[i]*priceArray[2]+arl[i]*priceArray[3]+arxl[i]*priceArray[4]+arxxl[i]*priceArray[5];
		}
		
		System.out.println("+-------------------------------------------------------------------------------+");
		System.out.printf("| %16s | %5s | %5s | %5s | %5s | %5s | %5s | %10s |\n","Phone Number","XS","S","M","L","XL","XXl","Total");
		System.out.println("+-------------------------------------------------------------------------------+");
		for(int i=0;i<arCustomerId.length;i++){
			System.out.printf("|  %15s | %5d | %5d | %5d | %5d | %5d | %5d | %10.2f |\n",arCustomerId[i],arxs[i],ars[i],arm[i],arl[i],arxl[i],arxxl[i],arTotal[i]);
		}
		System.out.println("+-------------------------------------------------------------------------------+");
		System.out.println("\n");			
		System.out.print("To access main menu, please enter 0 : ");
		char ch=input.next().charAt(0);
		if(ch=='0'){
			clearConsole();
			homePage();
			
		}
		
	}
	public static void sortedByQty(){
		System.out.println("\r\n      _____            _           _   ____           ____ _________     __\r\n     / ____|          | |         | | |  _ \\         / __ \\__   __\\ \\   / /\r\n    | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | | |   \\ \\_/ / \r\n     \\___ \\ / _ \\| \'__| __/ _ \\/ _` | |  _ <| | | | | |  | | | |    \\   /  \r\n     ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   \r\n    |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\ |_|     |_|   \r\n                                              __/ |                        \r\n                                             |___/                         \r\n");
		System.out.println("    ______________________________________________________________________");
		System.out.println("\n");
		
		sizeArray=new String[]{"XS","S","M","L","XL","XXL"};
		int[] drQuantityArray=new int[6];
		double[] drAmountArray=new double[6];
		
		for(int i=0;i<quantityArray.length;i++){
			switch(selectedSizeArray[i]){
				case "XS": drQuantityArray[0]+=quantityArray[i];
				break;
				case "S": drQuantityArray[1]+=quantityArray[i];
				break;
				case "M": drQuantityArray[2]+=quantityArray[i];
				break;
				case "L": drQuantityArray[3]+=quantityArray[i];
				break;
				case "XL":drQuantityArray[4]+=quantityArray[i];
				break;
				case "XXL":drQuantityArray[5]+=quantityArray[i];
			}
		}
		
		for(int i=0;i<6;i++){
			drAmountArray[i]=drQuantityArray[i]*priceArray[i];
		}
		
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				if(i!=j){
					if(drQuantityArray[i]>drQuantityArray[j]){
						int t=drQuantityArray[i];
						drQuantityArray[i]=drQuantityArray[j];
						drQuantityArray[j]=t;
						
						String r=sizeArray[i];
						sizeArray[i]=sizeArray[j];
						sizeArray[j]=r;
						
						double s=drAmountArray[i];
						drAmountArray[i]=drAmountArray[j];
						drAmountArray[j]=s;
					}
				}
			}
		}
		
		System.out.println("+-----------------------------------+");
		System.out.printf("| %7s | %5s | %15s |\n","Size","QTY","Total Amount");
		System.out.println("+-----------------------------------+");
		
		for(int i=0;i<drQuantityArray.length;i++){
			System.out.printf("| %7s | %5d | %15.2f |\n",sizeArray[i],drQuantityArray[i],drAmountArray[i]);
		}
		System.out.println("+-----------------------------------+");	
		
		System.out.println("\n");			
		System.out.print("To access main menu, please enter 0 : ");
		char ch=input.next().charAt(0);
		if(ch=='0'){
			clearConsole();
			homePage();
			
		}	
		
	}
	public static void sortedByAmount(){
		System.out.println("\r\n      _____            _           _   ____                                               _   \r\n     / ____|          | |         | | |  _ \\            /\\                               | |  \r\n    | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ \r\n     \\___ \\ / _ \\| \'__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | \'_ ` _ \\ / _ \\| | | | \'_ \\| __|\r\n     ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ \r\n    |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|\r\n                                              __/ |                                           \r\n                                             |___/                                            \r\n");
		System.out.println("    __________________________________________________________________________________________");
		System.out.println("\n");
		
		sizeArray=new String[]{"XS","S","M","L","XL","XXL"};
		int[] drQuantityArray=new int[6];
		double[] drAmountArray=new double[6];
		
		for(int i=0;i<quantityArray.length;i++){
			switch(selectedSizeArray[i]){
				case "XS": drQuantityArray[0]+=quantityArray[i];
				break;
				case "S": drQuantityArray[1]+=quantityArray[i];
				break;
				case "M": drQuantityArray[2]+=quantityArray[i];
				break;
				case "L": drQuantityArray[3]+=quantityArray[i];
				break;
				case "XL":drQuantityArray[4]+=quantityArray[i];
				break;
				case "XXL":drQuantityArray[5]+=quantityArray[i];
			}
		}
		
		for(int i=0;i<6;i++){
			drAmountArray[i]=drQuantityArray[i]*priceArray[i];
		}
		
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				if(i!=j){
					if(drAmountArray[i]>drAmountArray[j]){
						int t=drQuantityArray[i];
						drQuantityArray[i]=drQuantityArray[j];
						drQuantityArray[j]=t;
						
						String r=sizeArray[i];
						sizeArray[i]=sizeArray[j];
						sizeArray[j]=r;
						
						double s=drAmountArray[i];
						drAmountArray[i]=drAmountArray[j];
						drAmountArray[j]=s;
					}
				}
			}
		}
		
		System.out.println("+-----------------------------------+");
		System.out.printf("| %7s | %5s | %15s |\n","Size","QTY","Total Amount");
		System.out.println("+-----------------------------------+");
		
		for(int i=0;i<drQuantityArray.length;i++){
			System.out.printf("| %7s | %5d | %15.2f |\n",sizeArray[i],drQuantityArray[i],drAmountArray[i]);
		}
		System.out.println("+-----------------------------------+");	
		
		System.out.println("\n");			
		System.out.print("To access main menu, please enter 0 : ");
		char ch=input.next().charAt(0);
		if(ch=='0'){
			clearConsole();
			homePage();
			
		}	
		
		
	}
	public static void allOrders(){
		System.out.println("\r\n    __      ___                  ____          _               \r\n    \\ \\    / (_)                / __ \\        | |              \r\n     \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ \r\n      \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | \'__/ _` |/ _ \\ \'__/ __|\r\n       \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\\r\n        \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/\r\n                                                               \r\n                                                               \r\n");
		System.out.println("   ____________________________________________________________");
		System.out.println("\n");
		
		String[] arr=new String[orderIdArray.length];
		String[] brr=new String[customerIdArray.length];
		String[] crr=new String[selectedSizeArray.length];
		int[] drr=new int[quantityArray.length];
		double[] err=new double[amountArray.length];
		int[] frr=new int[statusArray.length];
		
		for(int i=0;i<arr.length;i++){
			arr[i]=orderIdArray[i];
			brr[i]=customerIdArray[i];
			crr[i]=selectedSizeArray[i];
			drr[i]=quantityArray[i];
			err[i]=amountArray[i];
			frr[i]=statusArray[i];
		}	
		
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(i!=j){
					if(Integer.parseInt(arr[i].substring(4))>Integer.parseInt(arr[j].substring(4))){
						String a=arr[i];
						arr[i]=arr[j];
						arr[j]=a;
						
						String b=brr[i];
						brr[i]=brr[j];
						brr[j]=b;
						
						String c=crr[i];
						crr[i]=crr[j];
						crr[j]=c;
						
						int d=drr[i];
						drr[i]=drr[j];
						drr[j]=d;
						
						double e=err[i];
						err[i]=err[j];
						err[j]=e;
						
						int f=frr[i];
						frr[i]=frr[j];
						frr[j]=f;
					}
				}
			}
		}
		
		String str="";
		for(int i=0;i<frr.length;i++){
			switch(frr[i]){
				case 0: str="PROCESSING";
				break;
				case 1: str="DELIVERING";
				break;
				case 2: str="DELIVERED";
				break;
			}
		}
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %10s | %10s | %5s | %5s | %10s | %10s |\n","Order ID","Customer ID","Size","QTY","Amount","Status");
		System.out.println("+--------------------------------------------------------------------+");
		for(int i=0;i<orderIdArray.length;i++){
			System.out.printf("| %10s | %11s | %5s | %5d | %10.2f | %10s |\n",arr[i],brr[i],crr[i],drr[i],err[i],str);
		}
		System.out.println("+--------------------------------------------------------------------+");
		
		
		
		System.out.println("\n");			
		System.out.print("To access main menu, please enter 0 : ");
		char ch=input.next().charAt(0);
		if(ch=='0'){
			clearConsole();
			homePage();
			
		}	
	}
	public static void oderByAmount(){
		System.out.println("\r\n \r\n      ____          _                 ____                                               _   \r\n     / __ \\        | |               |  _ \\            /\\                               | |  \r\n    | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ \r\n    | |  | | \'__/ _` |/ _ \\ \'__/ __| |  _ <| | | |   / /\\ \\ | \'_ ` _ \\ / _ \\| | | | \'_ \\| __|\r\n    | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ \r\n     \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|\r\n                                             __/ |                                           \r\n                                            |___/                                            \r\n");
		System.out.println("   __________________________________________________________________________________________");
		System.out.println("\n");
		
		String[] arr=new String[orderIdArray.length];
		String[] brr=new String[customerIdArray.length];
		String[] crr=new String[selectedSizeArray.length];
		int[] drr=new int[quantityArray.length];
		double[] err=new double[amountArray.length];
		int[] frr=new int[statusArray.length];
		
		for(int i=0;i<arr.length;i++){
			arr[i]=orderIdArray[i];
			brr[i]=customerIdArray[i];
			crr[i]=selectedSizeArray[i];
			drr[i]=quantityArray[i];
			err[i]=amountArray[i];
			frr[i]=statusArray[i];
		}
		
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(i!=j){
					if(err[i]>err[j]){
						String a=arr[i];
						arr[i]=arr[j];
						arr[j]=a;
						
						String b=brr[i];
						brr[i]=brr[j];
						brr[j]=b;
						
						String c=crr[i];
						crr[i]=crr[j];
						crr[j]=c;
						
						int d=drr[i];
						drr[i]=drr[j];
						drr[j]=d;
						
						double e=err[i];
						err[i]=err[j];
						err[j]=e;
						
						int f=frr[i];
						frr[i]=frr[j];
						frr[j]=f;
					}
				}
			}
		}
		
		String str="";
		for(int i=0;i<frr.length;i++){
			switch(frr[i]){
				case 0: str="PROCESSING";
				break;
				case 1: str="DELIVERING";
				break;
				case 2: str="DELIVERED";
				break;
			}
		}
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %10s | %10s | %5s | %5s | %10s | %10s |\n","Order ID","Customer ID","Size","QTY","Amount","Status");
		System.out.println("+--------------------------------------------------------------------+");
		for(int i=0;i<orderIdArray.length;i++){
			System.out.printf("| %10s | %11s | %5s | %5d | %10.2f | %10s |\n",arr[i],brr[i],crr[i],drr[i],err[i],str);
		}
		System.out.println("+--------------------------------------------------------------------+");		
		
				
		System.out.println("\n");			
		System.out.print("To access main menu, please enter 0 : ");
		char ch=input.next().charAt(0);
		if(ch=='0'){
			clearConsole();
			homePage();
			
		}	
	}	

	
	public static void changeOrderStatus(){
		do{
			System.out.println("\r\n      ____          _              _____ _        _             \r\n     / __ \\        | |            / ____| |      | |            \r\n    | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ \r\n    | |  | | \'__/ _` |/ _ \\ \'__|  \\___ \\| __/ _` | __| | | / __|\r\n    | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\\r\n     \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/\r\n                                                                \r\n                                                                \r\n");
			System.out.println("   ______________________________________________________________");
			System.out.println("\n");
			String ordID="";	
			
			L5:while(true){
				System.out.println("\n");
				System.out.print("\tEnter order ID : ");
				ordID=input.next();
				for(int i=0;i<orderIdArray.length;i++){
					if(ordID.equals(orderIdArray[i])){
						System.out.println("\n");
						System.out.println("\t\tPhone Number : "+customerIdArray[i]);
						System.out.println("\t\tSize : "+selectedSizeArray[i]);
						System.out.println("\t\tQTY : "+quantityArray[i]);
						System.out.printf("\t\tAmount : %.2f \n",amountArray[i]);
						if(statusArray[i]==0){
							System.out.println("\t\tStatus : PROCESSING");
						}else if(statusArray[i]==1){
							System.out.println("\t\tStatus : DELIVERING");
						}else if(statusArray[i]==2){
							System.out.println("\t\tStatus : DELIVERED");
						}
						switch(statusArray[i]){
							case 0:
							System.out.println("\n");
							System.out.print("Do you want to change this order status? (Y/N) : ");
							char ch=input.next().charAt(0);
							System.out.println("\n");
							if(ch=='Y'||ch=='y'){
								System.out.println("\t\t[1] Order Delivering\n");
								System.out.println("\t\t[2] Order Deleivered\n");
								System.out.print("Enter Option : ");
								int op=input.nextInt();
								System.out.println("\n");
								switch(op){
									case 1:
									statusArray[i]=1;
									System.out.println("\n");
									System.out.println("\t\tStatus updated..\n");
									System.out.print("Do you want to update another order status? (Y/N) : ");
									char c=input.next().charAt(0);
									if(c=='Y'||c=='y'){
										clearConsole();
										continue L5;
									}else if(c=='N'||c=='n'){
										clearConsole();
										homePage();
									}
									break;
									case 2:
									statusArray[i]=2;
									System.out.println("\n");
									System.out.println("\t\tStatus updated..\n");
									System.out.print("Do you want to update another order status? (Y/N) : ");
									char a=input.next().charAt(0);
									if(a=='Y'||a=='y'){
										clearConsole();
										continue L5;
									}else if(a=='N'||a=='n'){
										clearConsole();
										homePage();
									}
									break;
									default: System.out.println("\t\tInvalid input..\n");
									System.out.print("Do you want to update another order status? (Y/N) : ");
									char b=input.next().charAt(0);
									if(b=='Y'||b=='y'){
										clearConsole();
										continue L5;
									}else if(b=='N'||b=='n'){
										clearConsole();
										homePage();
									}
									break;
								}
							}else if(ch=='N'||ch=='n'){
								System.out.print("Do you want to update another order status? (Y/N) : ");
								char cha=input.next().charAt(0);
								if(cha=='Y'||cha=='y'){
									clearConsole();
									continue L5;
								}else if(cha=='N'||cha=='n'){
									clearConsole();
									homePage();
								}
							}
							break;							
							case 1:
							System.out.println("\n"); 
							System.out.print("Do you want to change this order status? (Y/N) : ");	
							char chi=input.next().charAt(0);
							if(chi=='Y'||chi=='y'){	
								System.out.println("\n");					
								System.out.println("\t\t[1] Order Deleivered\n");
								System.out.print("Enter Option : ");
								int op=input.nextInt();
								switch(op){
									case 1:
									statusArray[i]=2;
									System.out.println("\n");
									System.out.println("\t\tStatus updated..\n");
									System.out.print("Do you want to update another order status? (Y/N) : ");
									char c=input.next().charAt(0);
									if(c=='Y'||c=='y'){
										clearConsole();
										continue L5;
									}else if(c=='N'||c=='n'){
										clearConsole();
										homePage();
									}
									break;
									default: 
									System.out.println("\n");
									System.out.println("\t\tInvalid input..\n");									
									System.out.print("Do you want to update another order status? (Y/N) : ");
									char d=input.next().charAt(0);
									if(d=='Y'||d=='y'){
										clearConsole();
										continue L5;
									}else if(d=='N'||d=='n'){
										clearConsole();
										homePage();
									}
									break;
								}
							}
							else if(chi=='N'||chi=='n'){
								System.out.println("\n");
								System.out.print("Do you want to update another order status? (Y/N) : ");
								char cha=input.next().charAt(0);
								if(cha=='Y'||cha=='y'){
									clearConsole();
									continue L5;
								}else if(cha=='N'||cha=='n'){
									clearConsole();
									homePage();
								}
							}
							break;
							case 2: 
							System.out.println("\n");
							System.out.println("\t\tCan't change this order status, Order already delivered..!\n");
							System.out.print("Do you want to change another order status? (Y/N) : ");
							char cha=input.next().charAt(0);
								if(cha=='Y'||cha=='y'){
									clearConsole();
									continue L5;
								}else if(cha=='N'||cha=='n'){
									clearConsole();
									homePage();
								}
							break;
							default: 
							System.out.println("\n");
							System.out.println("\t\tInvalid input..\n");
							System.out.print("Do you want to chant another order status? (Y/N) : ");
								char e=input.next().charAt(0);
								if(e=='Y'||e=='y'){
									clearConsole();
									continue L5;
								}else if(e=='N'||e=='n'){
									clearConsole();
									homePage();
								}
							break;							
						}			
						
					}			
						
				}
				
				
				for(int i=0;i<orderIdArray.length;i++){
					if(!ordID.equals(orderIdArray[i])){
						System.out.println("\n");
						System.out.println("\t\tInvalid ID...\n");
						System.out.println("\n");
						System.out.print("\tDo you want to change another order status? (Y/N) :");
						char ch=input.next().charAt(0);
						if(ch=='Y'||ch=='y'){
							clearConsole();
							continue L5;
						}else if(ch=='N'||ch=='n'){
							clearConsole();
							homePage();
						}
					}
				}
			}		
		}while(true);
	}
	public static void removeOrder(int index){
		String[] ar=new String[orderIdArray.length-1];
		String[] br=new String[customerIdArray.length-1];
		String[] cr=new String[selectedSizeArray.length-1];
		int[] dr=new int[quantityArray.length-1];
		double[] er=new double[amountArray.length-1];
		int[] fr=new int[statusArray.length-1];
		
		for(int i=index;i<ar.length;i++){
			ar[i]=orderIdArray[i+1];
			br[i]=customerIdArray[i+1];
			cr[i]=selectedSizeArray[i+1];
			dr[i]=quantityArray[i+1];
			er[i]=amountArray[i+1];
			fr[i]=statusArray[i+1];
		}
		for(int i=0;i<index;i++){
			ar[i]=orderIdArray[i];
			br[i]=customerIdArray[i];
			cr[i]=selectedSizeArray[i];
			dr[i]=quantityArray[i];
			er[i]=amountArray[i];
			fr[i]=statusArray[i];
		}
		
		orderIdArray=ar;
		customerIdArray=br;
		selectedSizeArray=cr;
		quantityArray=dr;
		amountArray=er;
		statusArray=fr;
			
	}	
	
	public static void deleteOrder(){
		do{
			System.out.println("\r\n     _____       _      _          ____          _           \r\n    |  __ \\     | |    | |        / __ \\        | |          \r\n    | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ \r\n    | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | \'__/ _` |/ _ \\ \'__|\r\n    | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   \r\n    |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   \r\n                                                             \r\n                                                             \r\n");
			System.out.println("    ________________________________________________________");
			
			L6:while(true){
				System.out.println("\n");
				System.out.print("\tEnter order ID : ");
				String ordID=input.next();
				for(int i=0;i<orderIdArray.length;i++){
					if(ordID.equals(orderIdArray[i])){
						System.out.println("\n");
						System.out.println("\t\tPhone Number : "+customerIdArray[i]);
						System.out.println("\t\tSize : "+selectedSizeArray[i]);
						System.out.println("\t\tQTY : "+quantityArray[i]);
						System.out.printf("\t\tAmount : %.2f \n",amountArray[i]);
						if(statusArray[i]==0){
							System.out.println("\t\tStatus : PROCESSING");
						}else if(statusArray[i]==1){
							System.out.println("\t\tStatus : DELIVERING");
						}else if(statusArray[i]==2){
							System.out.println("\t\tStatus : DELIVERED");
						}							
						System.out.println("\n");
						System.out.print("\tDo you want to delete this order? (Y/N) :");
						char ch=input.next().charAt(0);
						System.out.println("\n");
						if(ch=='y'||ch=='y'){
							removeOrder(i);
							System.out.println("\t\tOrder Deleted..!\n");
							System.out.print("Do you want to delete anther order? (Y/N) : ");
							char a=input.next().charAt(0);
							if(a=='Y'||a=='y'){
								clearConsole();
								continue L6;
							}else if(a=='N'||a=='n'){
								clearConsole();
								homePage();
							}
						}								
						
					}
				}
				for(int i=0;i<orderIdArray.length;i++){
					if(!ordID.equals(orderIdArray[i])){
						System.out.println("\n");
						System.out.println("\t\tInvalid ID...");
						System.out.println("\n");
						System.out.print("\tDo you want to delete another order? (Y/N) :");
						char ch=input.next().charAt(0);
						if(ch=='Y'||ch=='y'){
							clearConsole();
							continue L6;
						}else if(ch=='N'||ch=='n'){
							clearConsole();
							homePage();
						}
					}
				}
				
			}
			
		}while(true);
		
	}
	
}
