package com.atal.bookameme.action;


import com.opensymphony.xwork2.ActionSupport;


/**
 * Action Struts pour l'authentification
 * @author alexis
 *
 */
public class LoginAction extends ActionSupport {
    private String username;
    
    
    
    /**
     * Méthode execute
     */
    public String execute() {
        	return "success";
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}