package org.example.bfhlapplication.service;

import org.apache.tika.Tika;
import org.example.bfhlapplication.model.BfhlRequest;
import org.example.bfhlapplication.model.BfhlResponse;
import org.example.bfhlapplication.model.FileNotFoundResponse;
import org.example.bfhlapplication.model.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class BfhlService {

    public Response processRequest(BfhlRequest request) {
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        String highestLowercase = null;
        boolean isPrimeFound = false;

        // Extract numbers and alphabets
        for (String item : request.getData()) {
            if (item.matches("\\d+")) {
                numbers.add(item);
                if (isPrime(Integer.parseInt(item))) {
                    isPrimeFound = true;
                }
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (item.matches("[a-z]")) {
                    if (highestLowercase == null || item.compareTo(highestLowercase) > 0) {
                        highestLowercase = item;
                    }
                }
            }
        }

        boolean fileValid = false;
        String fileMimeType = null;
        double fileSizeKb = 0;

        // Process fileB64
        if (request.getFileB64() != null && !request.getFileB64().isEmpty()) {
            try {
                // Decode Base64 file
                byte[] fileBytes = Base64.getDecoder().decode(request.getFileB64());
                fileSizeKb = fileBytes.length / 1024.0;

                // Use Apache Tika to detect MIME type
                Tika tika = new Tika();
                fileMimeType = tika.detect(fileBytes);

                // Mark file as valid if decoding and MIME detection succeed
                fileValid = true;
            } catch (Exception e) {
                // Invalid Base64 or other file handling issues
                fileValid = false;
            }
        }

        // Handle case when no file is provided
        if (request.getFileB64() == null || request.getFileB64().isEmpty()) {
            FileNotFoundResponse response = new FileNotFoundResponse();
            response.setIs_success(true);
            response.setUser_id("krishna_bhawsar_22032004"); // Example user ID
            response.setEmail("krishnabhawsar210222@acropolis.in");
            response.setRoll_number("0827CS211128");
            response.setNumbers(numbers);
            response.setAlphabets(alphabets);
            response.setHighest_lowercase_alphabet(highestLowercase);
            response.setIs_prime_found(isPrimeFound);
            response.setFile_valid(fileValid);
            return response;
        }

        // Create response with file details
        BfhlResponse response = new BfhlResponse();
        response.setIs_success(true);
        response.setUser_id("krishna_bhawsar_22032004"); // Example user ID
        response.setEmail("krishnabhawsar210222@acropolis.in");
        response.setRoll_number("0827CS211128");
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighest_lowercase_alphabet(highestLowercase);
        response.setIs_prime_found(isPrimeFound);
        response.setFile_valid(fileValid);
        response.setFile_mime_type(fileMimeType);
        response.setFile_size_kb(fileSizeKb);

        return response;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
