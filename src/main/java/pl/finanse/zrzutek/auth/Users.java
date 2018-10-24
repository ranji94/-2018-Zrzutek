package pl.finanse.zrzutek.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="USERS")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private long id;
	@NotNull
	@Size(min=4, max=32)
	@Column(name="USERNAME", nullable =false, unique = true)
	private String username;
	@Column(name="PASSWORD")
	@NotNull
	@Size(min=6, max=32)
	private String password;
	@Transient
	private String confirmpassword;
	
	@AssertTrue(message="Obydwa podane hasła muszą być zgodne!")
	private boolean isValid()
	{
		return this.password.equals(this.confirmpassword);
	}
	
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
