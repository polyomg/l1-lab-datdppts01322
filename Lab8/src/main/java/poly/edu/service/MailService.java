package poly.edu.service;

import lombok.*;
import lombok.experimental.SuperBuilder;

public interface MailService {

    @Data
    @SuperBuilder
    @NoArgsConstructor   // ✅ thêm dòng này
    @AllArgsConstructor  // ✅ và dòng này
    class Mail {
        @Builder.Default
        private String from = "WebShop <web-shop@gmail.com>";
        private String to, cc, bcc, subject, body, filenames;
    }

    void send(Mail mail);

    default void send(String to, String subject, String body) {
        Mail mail = Mail.builder()
                .to(to)
                .subject(subject)
                .body(body)
                .build();
        this.send(mail);
    }

    void push(Mail mail);

    default void push(String to, String subject, String body) {
        this.push(Mail.builder()
                .to(to)
                .subject(subject)
                .body(body)
                .build());
    }
}
