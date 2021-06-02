package PhoneBook;

public class PhoneVO {
	private Long id;
	private String Name;
	private String Hp;
	private String Tel;
	
	public PhoneVO() {
		
	}
	public PhoneVO(Long id, String Name, String Hp, String Tel) {
		this.id = id;
		this.Name = Name;
		this.Hp = Hp;
		this.Tel = Tel;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getHp() {
		return Hp;
	}
	public void setHp(String hp) {
		this.Hp = hp;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String Tel) {
		this.Tel = Tel;
	}
	
	
}
