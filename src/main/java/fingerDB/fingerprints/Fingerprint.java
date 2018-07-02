package fingerDB.fingerprints;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(query = "select a from Fingerprint a", name = "Query_select_all_Fingerprint")
public class Fingerprint 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String setName;
	private String path;
	
	protected Fingerprint() {}
	
	public Fingerprint(String setName, String path)
	{
		super();
		this.setName = setName;
		this.path = path;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString()
	{
		return String.format("[%d] Set %s: %s", id, setName, path);
	}
}
