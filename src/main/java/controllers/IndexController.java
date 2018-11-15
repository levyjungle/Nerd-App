package controllers;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class IndexController {
   
	@Public
    @Get("/")
    public void index(){
    }
	
	@Public
	@Get("/cadastro")
	public void register() {
		
	}
	
    
}
