package start.Bonito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BonitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BonitoApplication.class, args);
		PrettyProcess pp = new PrettyProcess();
		pp.startProcess();
	}

}
