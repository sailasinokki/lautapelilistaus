package fi.haagahelia.lautapelit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Käyttäjäluokka

@Entity

public class ApplicationUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String etunimi, sukunimi;
	private String role;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	

	public ApplicationUser() {
		super();
	}

	public ApplicationUser(String etunimi, String sukunimi, String role, String username, String passwordHash) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.role = role;
		this.username = username;
		this.passwordHash = passwordHash;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Override
	public String toString() {
		return "ApplicationUser [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", role=" + role
				+ ", username=" + username + ", passwordHash=" + passwordHash + "]";
	}

	
}