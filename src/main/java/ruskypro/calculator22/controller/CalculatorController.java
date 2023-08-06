package ruskypro.calculator22.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ruskypro.calculator22.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String greeting(){
        return "Добро пожаллвать в калькулятор!";
    }
    @GetMapping("/plus")
   public String plus(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.sum(num1, num2);
        return buildResponse(num1, num2, result, '+');
    }
    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.minus(num1, num2);
        return buildResponse(num1, num2, result, '+');
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiply(num1, num2);
        return buildResponse(num1, num2, result, '+');
    }
    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.divide(num1, num2);
        return buildResponse(num1, num2, result, '+');
    }
    private String buildResponse(int num1, int num2, int result, char action){
        return String.format("%d %c %d = %d", num1, action, num2, result);
    }
}