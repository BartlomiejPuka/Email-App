package emailapp;

public class Signature{
	private String signature;
	public Signature(String firstName, String lastName){
		this.signature = "Best Regards,\n"+firstName +" "+lastName;
	}
	public Signature() {
		// TODO Auto-generated constructor stub
	}
	public void Singauture(){
	}
	public void showSignature(){
		System.out.println(this.signature);
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
