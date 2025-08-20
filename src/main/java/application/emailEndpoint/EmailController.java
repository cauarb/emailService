package application.emailEndpoint;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "http://localhost:4200") // permitir Angular
public class EmailController {


    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@Valid @RequestBody ContactRequest contato) {
        emailService.enviarEmail(contato);
        return ResponseEntity.ok("E-mail enviado com sucesso!");
    }
}
