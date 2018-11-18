package org.orion.app.servlet;

import org.orion.app.entity.Account;
import org.orion.app.extractor.contract.IExtractor;
import org.orion.app.extractor.implementation.AccountExtractor;
import org.orion.app.model.RegistrationModel;
import org.orion.app.repository.contract.IAccountRepository;
import org.orion.app.repository.implementation.AccountRepository;
import org.orion.app.validator.contract.IModelValidator;
import org.orion.app.validator.implement.RegistrationValidator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")

public class RegistrationServlet extends HttpServlet {

    public static final String URL_JSP_REISTRATION = "WEB-INF/RegistrationModel.jsp";

    private IAccountRepository repository ;
    private IExtractor extractor ;
    private IModelValidator validator ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(URL_JSP_REISTRATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.repository = (AccountRepository) getServletContext().getAttribute("accountRepository");
        this.extractor = (AccountExtractor) getServletContext().getAttribute("accountExtractor");
        this.validator = (RegistrationValidator) getServletContext().getAttribute("registrationValidator");

        RegistrationModel model = (RegistrationModel) extractor.getModel(request.getParameterMap());

        validator.validate(model);

        if(validator.isValid()){

            Account account = new Account();

            account.setName(model.getName());
            account.setSurname(model.getSurname());
            account.setEmail(model.getEmail());
            account.setPasswordHash(model.getpasswordMatcher());

            repository.Save(account);

            response.sendRedirect("/login");
        }

        request.setAttribute("errors",validator.getErrors());
        request.getRequestDispatcher(URL_JSP_REISTRATION).forward(request,response);



    }
}
