class CurrentAccount extends Account
{
	private static final long serialVersionUID = 1L;
	private int cashCredit;
	public CurrentAccount(int id, String name,int balance, int cashCredit)
{
	super(id,name,balance);
	this.cashCredit=cashCredit;
}
    public double getBalance(){
		return super.getBalance()+this.cashCredit;
	}

    public String toString(){
		return super.toString()+"-"+this.cashCredit;
	}
}
