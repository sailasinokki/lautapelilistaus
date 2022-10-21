package fi.haagahelia.lautapelit.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Tyyppi {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long tyyppiid;
private String tnimi;

@OneToMany (cascade = CascadeType.ALL, mappedBy = "tyyppi")
private List<Lautapeli> lautapelit;

public Tyyppi() {}

public Tyyppi(String tnimi) {
	super();
	this.tnimi = tnimi;
}

public Long getTyyppiid() {
	return tyyppiid;
}

public void setTyyppiid(Long tyyppiid) {
	this.tyyppiid = tyyppiid;
}

public String getTnimi() {
	return tnimi;
}

public void setTnimi(String tnimi) {
	this.tnimi = tnimi;
}

public List<Lautapeli> getLautapelit() {
	return lautapelit;
}

public void setLautapelit(List<Lautapeli> lautapelit) {
	this.lautapelit = lautapelit;
}

@Override
public String toString() {
	return "Tyyppi [tyyppiid=" + tyyppiid + ", tnimi=" + tnimi + "]";
}


}
