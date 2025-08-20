package application.emailEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(ContactRequest contato) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setFrom("SEU_EMAIL@gmail.com"); // precisa ser o mesmo do application.properties
        mensagem.setTo("SEU_EMAIL@gmail.com");   // para onde você quer receber
        mensagem.setSubject("Novo contato do portfólio - " + contato.getNome());
        mensagem.setText(
                "Nome: " + contato.getNome() + "\n" +
                        "E-mail: " + contato.getEmail() + "\n\n" +
                        "Mensagem:\n" + contato.getDescricao()
        );

        mailSender.send(mensagem);
    }
}
