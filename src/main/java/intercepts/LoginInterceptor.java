package intercepts;

import javax.inject.Inject;

import annotations.Public;
import components.UserSession;
import controllers.HomeController;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;

@Intercepts
public class LoginInterceptor implements Interceptor{

	@Inject
	private UserSession userSession;
	@Inject
	private Result result;
	
	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method, Object controllerInstance)
			throws InterceptionException {
		if(userSession.isLogged()) {
			stack.next(method, controllerInstance);
		} else {
			result.redirectTo(HomeController.class).home();
		}
		
	}

	@Override
	public boolean accepts(ControllerMethod method) {
		
		return !method.containsAnnotation(Public.class);
	}
	
}
