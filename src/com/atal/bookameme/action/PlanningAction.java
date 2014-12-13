package com.atal.bookameme.action;
import com.opensymphony.xwork2.ActionSupport;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;


/**
 * Action Struts pour la gestion du compte
 * @author carl
 *
 */
public class PlanningAction extends ActionSupport {
    private User user;
    
    /**
     * Méthode execute
     */
    public String execute() {
		user = UserServiceFactory.getUserService().getCurrentUser();
        return "success";
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}