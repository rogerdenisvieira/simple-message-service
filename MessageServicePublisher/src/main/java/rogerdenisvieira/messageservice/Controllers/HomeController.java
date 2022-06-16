package rogerdenisvieira.messageservice.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rogerdenisvieira.messageservice.Requests.MessageRequest;
import rogerdenisvieira.messageservice.configuration.ApplicationConfiguration;

@RestController
public class HomeController {
    @Autowired
    private ApplicationConfiguration configuration;


    @PostMapping(value = "/publishMessage")
    public ResponseEntity publishMessage(@RequestBody MessageRequest message){
        // do something here

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getHome(){

        System.out.println(configuration.getExchangeName());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
