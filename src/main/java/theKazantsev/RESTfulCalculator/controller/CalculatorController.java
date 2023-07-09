package theKazantsev.RESTfulCalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import theKazantsev.RESTfulCalculator.json.addJSON;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculatorController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/add")
    public addJSON add(@RequestParam(name = "param1", defaultValue = "1") int param1,
                       @RequestParam(name = "param2", defaultValue = "1") int param2) {

        return new addJSON(counter.incrementAndGet(), param1, param2);
    }
}
