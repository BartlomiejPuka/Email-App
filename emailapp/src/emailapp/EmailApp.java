package emailapp;

public class EmailApp {
	public static void main(String[] args){
		Email em1 = new Email("Gordon","Freeman");
		em1.mailboxCapacity();
		em1.changePassword();
		em1.showSummary();
	}
}
