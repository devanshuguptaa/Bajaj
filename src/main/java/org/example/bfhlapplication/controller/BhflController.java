package org.example.bfhlapplication.controller;

import org.example.bfhlapplication.model.BfhlRequest;
import org.example.bfhlapplication.model.BfhlResponse;
import org.example.bfhlapplication.model.Response;
import org.example.bfhlapplication.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BhflController {
    @Autowired
    BfhlService bfhlService;

    @PostMapping
    public ResponseEntity<Response> handlePost(@RequestBody BfhlRequest request) {
        Response response = bfhlService.processRequest(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<String> handleGet() {
        return ResponseEntity.ok("OK");
    }
}
