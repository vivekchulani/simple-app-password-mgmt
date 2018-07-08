package hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LockUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	@Column
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private long ssn;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="lockUser")
	private Set<LockInfo> lockinfo;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public Set<LockInfo> getLockinfo() {
		return lockinfo;
	}

	public void setLockinfo(Set<LockInfo> lockinfo) {
		this.lockinfo = lockinfo;
	}

	@Override
	public String toString() {
		return "LockUser [user_id=" + user_id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", ssn="
				+ ssn + "]";
	}

	
	
}
