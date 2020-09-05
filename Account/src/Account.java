import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
 	private String name;
 	private double accountBalance;
 	
 	public Account(int id, String name, double accountBalance){
 		this.id=id;
 		this.name=name;
 		this.accountBalance=accountBalance;
 	}
 	
 	public double getBalance() {
		return accountBalance;
	}
 	
 	public void setBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
   
 	public Account(int id, String name) {
       this.id = id;
       this.name = name;
    }

    public int getId() {
       return id;
    }

    public String getName() {
        return name;
    }

    public double credit(double amount){
        return accountBalance += amount;
    }

    public double debit(double amount){
         if (amount <= accountBalance){
         return accountBalance -= amount;
    }else{
        System.out.println("amount exceeded");
    }
        return accountBalance;
    }

    public double transferTo(Account another, double amount){
        if(amount <= accountBalance)
          another.credit(amount);
        else
          System.out.println("amount exceeded");
        return accountBalance;
    }
 
    public String toString(){
		return this.id +"-"+this.name+"-"+this.accountBalance;
	}

    public double withdraw(double amount){
	   if (accountBalance >= amount) {
		  accountBalance = accountBalance - amount;
	   }else{
		System.out.print("You don't have sufficient amount");
	   }
	   return accountBalance;
    }

    public double deposit(double amount) {
	  accountBalance = accountBalance + amount;
	  return accountBalance;
    }
}