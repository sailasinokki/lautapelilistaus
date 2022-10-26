package fi.haagahelia.lautapelit.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Tyyppi {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name ="tyyppi_id")
private long tyyppiId;
private String tnimi;

@JsonIgnore //Ehkaistaan clientin pyynnosta aiheutuvaa lautapeli/tyyppi solmua.
@OneToMany (cascade = CascadeType.ALL, mappedBy = "tyyppi")
private List<Lautapeli> lautapelit;

public Tyyppi() {}

public Tyyppi(String tnimi) {
	super();
	this.tnimi = tnimi;
}

public Long getTyyppiId() {
	return tyyppiId;
}

public void setTyyppiid(Long tyyppiid) {
	this.tyyppiId = tyyppiId;
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
	return "Tyyppi [tyyppiId=" + tyyppiId + ", tnimi=" + tnimi + "]";
}


}
