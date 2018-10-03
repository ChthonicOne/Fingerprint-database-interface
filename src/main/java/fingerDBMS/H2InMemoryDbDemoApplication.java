package fingerDBMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import fingerDBMS.fingerRest.FingerController;

@SpringBootApplication
public class H2InMemoryDbDemoApplication 
{
	public static void main(String[] args)
	{
		SpringApplication.run(H2InMemoryDbDemoApplication.class);
	}
}
