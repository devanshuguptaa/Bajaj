package org.example.bfhlapplication.model;


import java.util.List;

public class BfhlRequest {
    private String fileB64;
    private List<String> data;

    public String getFileB64() {
        return fileB64;
    }

    public void setFileB64(String fileB64) {
        this.fileB64 = fileB64;
    }


    public BfhlRequest(String fileB64, List<String> data) {
        this.fileB64 = fileB64;
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

}
