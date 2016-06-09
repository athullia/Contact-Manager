package projectFinal;


public class Contact{

	private String strFirstName;
	private String strMidName;
	private String strLastName;
	private String State = null;
	private String City = null;
	private String Street = null;
	private String ZIP = null;
	private String BirthDay = null;
	private String PhoneNumber = null;

	public String getPhoneNumber() {
		return this.PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return this.strFirstName;
	}

	public void setFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	public String getMidName() {
		return this.strMidName;
	}

	public void setMidName(String strMidName) {
		this.strMidName = strMidName;
	}

	public String getLastName() {
		return this.strLastName;
	}

	public void setLastName(String strLastName) {
		this.strLastName = strLastName;
	}

	public Contact() {
		//
	}

	public String getContactPhoneNumber() {
		return this.PhoneNumber;
	}

	public void setContactPhoneNumber(String dblContactPhoneNumber) {
		this.PhoneNumber = dblContactPhoneNumber;
	}
	
	public String getState() {
		return this.State;
	}

	public void setState(String dblContactPhoneNumber) {
		this.State = dblContactPhoneNumber;
	}
	
	public String getCity() {
		return this.City;
	}

	public void setCity(String Cit) {
		this.City = Cit;
	}
	
	public String getStreet() {
		return this.Street;
	}

	public void setStreet(String Cit) {
		this.Street = Cit;
	}
	
	public String getZIP() {
		return this.ZIP;
	}

	public void setZIP(String Zi) {
		this.ZIP = Zi;
	}
	
	public String getBirthDay() {
		return this.BirthDay;
	}

	public void setBirthDay(String bd) {
		this.BirthDay = bd;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.strFirstName == null) ? 0 : this.strFirstName.hashCode());
		result = prime * result
				+ ((this.strLastName == null) ? 0 : this.strLastName.hashCode());
		result = prime * result
				+ ((this.strMidName == null) ? 0 : this.strMidName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (this.strFirstName == null) {
			if (other.strFirstName != null)
				return false;
		} else if (!this.strFirstName.equals(other.strFirstName))
			return false;
		if (this.strLastName == null) {
			if (other.strLastName != null)
				return false;
		} else if (!this.strLastName.equals(other.strLastName))
			return false;
		if (this.strMidName == null) {
			if (other.strMidName != null)
				return false;
		} else if (!this.strMidName.equals(other.strMidName))
			return false;
		return true;
	}

	public String getAllDetails(){
		return( getFirstName() +"|"+ getMidName()+"|"+ getLastName() +"|"+ getStreet() +"|"+ getCity() +"|"+ getState() +"|"+ getZIP() +"|"+ getBirthDay() +"|"+ getContactPhoneNumber() );
	}

}
