package com.example.clients_service.services.data.service_json;

import com.example.clients_service.models.Client;
import com.example.clients_service.services.data.ClientService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceJson implements ClientService {
    public final String FILE_NAME = "clients.json";
    @Override
    public List<Client> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic) {
        return null;
    }

    @Override
    public Client save(Client client) {
        List<Client> clients = findAll();
        if (clients == null){
            clients = new ArrayList<>();
            clients.add(client);
            Gson gson = new Gson();
            String json = gson.toJson(clients);
            try {
                FileUtils.write(new File(FILE_NAME), json, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        Gson gson = new Gson();
        String json = null;
        try {
            json = FileUtils.readFileToString(new File(FILE_NAME), StandardCharsets.UTF_8);
            return gson.fromJson(json, new TypeToken<List<Client>>(){}.getType());
        } catch (IOException e) {
           /* e.printStackTrace();*/
        }
        return null;
    }

    @Override
    public Client findByEmail(String email) {
        return null;
    }
}
