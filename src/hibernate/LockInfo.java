package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LockInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long info_id;
	@Column
	private String title;
	private String url;
	private String username;
	private String password;
	private String Category;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private LockUser lockUser;

	public long getInfo_id() {
		return info_id;
	}

	public void setInfo_id(long info_id) {
		this.info_id = info_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public LockUser getLockUser() {
		return lockUser;
	}

	public void setLockUser(LockUser lockUser) {
		this.lockUser = lockUser;
	}

	@Override
	public String toString() {
		return "LockInfo [info_id=" + info_id + ", title=" + title + ", url="
				+ url + ", username=" + username + ", password=" + password
				+ ", Category=" + Category + ", lockUser=" + lockUser + "]";
	}

	
	
}
