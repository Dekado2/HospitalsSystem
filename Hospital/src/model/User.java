
package model;

import java.io.Serializable;

/**
 *
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String displayFirstName;
    private String displayLastName;
    private String type;
    private String secretQuestion;
    private String secretAnswer;
    
    /**
     * Constructor
     * @param username
     * @param password
     * @param type
     * @param secretQuestion
     * @param secretAnswer 
     */
  public User(String username,String password, String displayFirstName, String displayLastName, String type,String secretQuestion,String secretAnswer){
     setUsername(username);
     setPassword(password);
     this.displayFirstName=displayFirstName;
     this.displayLastName=displayLastName;
     this.type=type;
     this.secretQuestion=secretQuestion;
     setSecretAnswer(secretAnswer);
     }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        if (username.length()>=4)
        this.username = username;
    }
  
  public String getPassword() {
	return password;
}
  private void setPassword(String password) {
  	if (password.length()>=4)
            this.password=password;
     }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    private void setSecretAnswer(String secretAnswer) {
        if (secretAnswer.length()>=1)
        this.secretAnswer = secretAnswer;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public String getType() {
        return type;
    }
  
  public String getDisplayFirstName() {
		return displayFirstName;
	}

	public void setDisplayFirstName(String displayFirstName) {
		this.displayFirstName = displayFirstName;
	}

	public String getDisplayLastName() {
		return displayLastName;
	}

	public void setDisplayLastName(String displayLastName) {
		this.displayLastName = displayLastName;
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}
@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + ", type=" + type + ", secretQuestion="
			+ secretQuestion + ", secretAnswer=" + secretAnswer + "]";
}
}
