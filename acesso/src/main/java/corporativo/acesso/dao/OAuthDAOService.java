package corporativo.acesso.dao;

import corporativo.acesso.model.UserEntity;

public interface OAuthDAOService {

	public UserEntity getUserDetails(String emailId);
}
