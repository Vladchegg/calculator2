package pro.sky.course2.calculator2.Сontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.calculator2.Service.CalculatorService;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorСontroller {

    private final CalculatorService service;

    public CalculatorСontroller(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String showWelcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String showSum(@RequestParam(required = false) Float num1,
                          @RequestParam (required = false) Float num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Неверно переданы параметры";
        }
        return num1 + " + " + num2 + " = " + service.getSum(num1, num2);
    }

    @GetMapping("/minus")
    public String showMinus(@RequestParam (required = false) Float num1,
                            @RequestParam (required = false) Float num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Неверно переданы параметры";
        }
        return num1 + " - " + num2 + " = " + service.getMinus(num1, num2);
    }

    @GetMapping("/multiply")
    public String showMultiply(@RequestParam (required = false) Float num1,
                               @RequestParam (required = false) Float num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Неверно переданы параметры";
        }
        return num1 + " * " + num2 + " = " + service.getMultiply(num1, num2);
    }

    @GetMapping("/divide")
    public String showDivide(@RequestParam (required = false) Float num1,
                             @RequestParam (required = false) Float num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Неверно переданы параметры";
        } else if (num2 == 0) {
            return "Делить на ноль нельзя";
        }
        return num1 + " / " + num2 + " = " + service.getDivide(num1, num2);
    }
}

