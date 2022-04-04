package co.featureflags.spring.demo.controller;

import co.featureflags.spring.FeatureGate;
import co.featureflags.spring.RouteMapping;
import co.featureflags.spring.demo.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @FeatureGate(feature = "featureA", value = "eng", others = {
            @RouteMapping(value = "fr", path = "/hello/fr"),
            @RouteMapping(value = "cn", path = "/hello/cn"),
    })
    public ResponseEntity<Greeting> hello() {
        return new ResponseEntity<>(new Greeting("Hello", "eng"), HttpStatus.OK);
    }

    @GetMapping("/hello/fr")
    public ResponseEntity<Greeting> helloInFrench() {
        return new ResponseEntity<>(new Greeting("Bonjour", "fr"), HttpStatus.OK);
    }

    @GetMapping("/hello/cn")
    public ResponseEntity<Greeting> helloInChinese() {
        return new ResponseEntity<>(new Greeting("你好", "cn"), HttpStatus.OK);
    }
}
