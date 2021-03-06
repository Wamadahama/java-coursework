/**
 * Name: Elijah
 * Date: Thursday 13 2016
 * Description: Encapsulates pet information 
 * */
package Lab05;

public class Pet {

	//Class Private Data Members
	private String petName;
	private int petAge;
	private String petType; //Cat, Dog, Ferret, etc
	private String petOwner;

	//Constructor
	public Pet()
	{
		//System.out.println("A New Pet Instance was just created!");
	}

	//Public Methods
	public String getPetName() {
		return petName;
	}

	/**
	 * Prints out the pet information stored in this class to stdout
	 * */
	public void printPetInfo(){
		System.out.println("Pet Name: "  + this.petName);
		System.out.println("Pet Age: "   + this.petAge);
		System.out.println("Pet Type: "  + this.petType);
		System.out.println("Pet Owner: " + this.petOwner);
	}

	/**
	 * Set the value of pet name 
	 * */
	public void setPetName(String name) {
		petName = name;
	}

	/**
	 * Get the value of pet name 
	 * */
	public int getPetAge() {
		return petAge;
	}

	/**
	 * Set the age of the pet 
	 * */
	public void setPetAge(int age) {
		petAge = age;
	}

	/**
	 * Get the age of the pet 
	 * */
	public String getPetType() {
		return petType;
	}

	/**
	 * Set the type of the pet 
	 * */
	public void setPetType(String type) {
		petType = type;
	}

	/**
	 * get the owner of the pet 
	 * */
	public String getPetOwner() {
		return petOwner;
	}

	/**
	 * Set the owner of the pet 
	 * */
	public void setPetOwner(String owner) {
		petOwner = owner;
	}
}
