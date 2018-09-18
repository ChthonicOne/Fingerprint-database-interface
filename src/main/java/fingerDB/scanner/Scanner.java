package fingerDB.scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "scanner")
@Table(name = "scanner")
public class Scanner
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "scanner_id", nullable = false)
	private Long id;
	private String name,
				   path,
				   desc;
	
	public Scanner(String name, String path, String desc)
	{
		super();
		this.name = name;
		this.path = path;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString()
	{
		return String.format("[%d] Scanner %s: %s: %s", id, name, desc, path);
	}
}
