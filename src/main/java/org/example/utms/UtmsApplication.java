package org.example.utms;
import org.example.utms.model.Scooter;
import org.example.utms.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class UtmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtmsApplication.class, args);

		//User u1 = new User(2,"Marek","test","marek@gmail.com");
		//System.out.println(login("Marek","test"));
		//Scooter s1 = new Scooter(3,"Lime","scooter","Lime","LT-20","electric",2024,0,100,100,0,0);
		//System.out.println(s1.getName());


	}


}
