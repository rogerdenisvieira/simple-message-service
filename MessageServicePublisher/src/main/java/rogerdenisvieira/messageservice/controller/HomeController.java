package rogerdenisvieira.messageservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rogerdenisvieira.messageservice.publisher.MessagePublisher;
import rogerdenisvieira.messageservice.request.MessageRequest;

@RestController
public class HomeController {

//    private final ApplicationConfiguration configuration;

    private final MessagePublisher publisher;

    @Autowired
    public HomeController(MessagePublisher publisher){
        this.publisher = publisher;

    }



    @PostMapping(value = "/publishMessage")
    public ResponseEntity publishMessage(@RequestBody MessageRequest message){
        // do something here

        try {
            this.publisher.sendMessage(message.getPayload());
            return ResponseEntity.ok(HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error has been occurred.");
        }

    }

    @GetMapping("/")
    public ResponseEntity getHome(){


        return ResponseEntity.ok("Request has been sent successfully.");
    }
}
