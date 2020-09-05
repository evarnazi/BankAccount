public class SalaryAccount extends Account{
	private static final long serialVersionUID = 1L;
	private boolean salaryAccount;
	public static final double minBalance = 10000;


	public SalaryAccount(int id, String name) {
        super(id, name);
    }

    public SalaryAccount(int id, String name, int balance) {
        super(id, name, balance);
    }

    public void SavingAccount() {
    }

    public void SavingAccount(double accountId, String accountHolderName, double accountBalance, boolean salaryAccount) {
    		this.salaryAccount = salaryAccount;
    }

    public boolean isSalaryAccount() {
    		return salaryAccount;
    }

   	public void setSalaryAccount(boolean salaryAccount) {
    	this.salaryAccount = salaryAccount;
    }
    
   	public double withdraw(double amount){
    		if (salaryAccount) {
    			return super.withdraw(amount);
    		} else {
    			if (getBalance() - amount >= minBalance)
    				setBalance(getBalance() - amount);
    			else
    				System.out.println("you don't have sufficient fund.");
    			return getBalance();
    		}
    }
    	
    
    public double deposit(double amount) {
    	return super.deposit(amount);
    }  
}

