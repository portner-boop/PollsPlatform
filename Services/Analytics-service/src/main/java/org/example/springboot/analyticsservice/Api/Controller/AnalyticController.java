package org.example.springboot.analyticsservice.Api.Controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.TestAnalyticResponse;
import org.example.springboot.analyticsservice.Api.Service.AnalyticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/v1/analytic")
public class AnalyticController {

    AnalyticService analyticService;

    @GetMapping("/analytic_for_test/{poll_id}")
    public ResponseEntity<TestAnalyticResponse> getAnalyticForTest(
            @PathVariable  Long poll_id
    ){
        return ResponseEntity.ok(analyticService.getAnalyticForTest(poll_id));
    }


}
