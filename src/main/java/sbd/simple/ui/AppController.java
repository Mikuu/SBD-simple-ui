package sbd.simple.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	private MyConfig myConfig = new MyConfig();

	@Autowired
	public void setMyConfig(MyConfig myConfig) {
		this.myConfig = myConfig;
	}

	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("backendServer",myConfig.getHost()+":"+myConfig.getPort());
		return "index";
	}

}
