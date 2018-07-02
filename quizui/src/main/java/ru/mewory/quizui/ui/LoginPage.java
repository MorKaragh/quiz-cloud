package ru.mewory.quizui.ui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class LoginPage extends VerticalLayout {

    public LoginPage() {
        TextField login = new TextField("логин");
        PasswordField password = new PasswordField("пароль");
        Button loginBtn = new Button("войти");
        loginBtn.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                authenticate(login.getValue(), password.getValue());
                login();
            }
        });

        add(login, password, loginBtn);
    }

    private void login() {
        getUI().ifPresent(ui -> ui.navigate("new"));
//TODO когда сделаю аутентификацию - тогда используем это
//        if ( SecurityContextHolder.getContext().getAuthentication() != null &&
//                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
//                //when Anonymous Authentication is enabled
//                !(SecurityContextHolder.getContext().getAuthentication()
//                        instanceof AnonymousAuthenticationToken) ) {
//            getUI().ifPresent(ui -> ui.navigate("new"));
//        }
    }

    private void authenticate(String user, String pass) {
//        UsernamePasswordAuthenticationToken authReq
//                = new UsernamePasswordAuthenticationToken(user, pass);
//        Authentication auth = authManager.authenticate(authReq);
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(auth);
    }

}
