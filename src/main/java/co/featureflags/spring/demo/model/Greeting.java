package co.featureflags.spring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public final class Greeting {
    private String greeting;
    private String flagValue;
}
