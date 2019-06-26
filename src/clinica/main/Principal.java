package clinica.main;

import clinica.model.dados.Repositorio;
import clinica.model.login.Login;
import clinica.view.LoginView;

public class Principal {

	public static void main(String[] args) {
		Repositorio repo = new Repositorio();
		Login login = new Login("admin@admin.com", "123456", "ROLE_GERENTE");
		
		LoginView frame = new LoginView(repo, login);
		frame.setVisible(true);
	}

}
