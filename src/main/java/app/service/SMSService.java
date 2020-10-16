package app.service;

import app.entity.SMS;
import app.exception.InvalidSMSRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
@AllArgsConstructor
public class SMSService {
    private final RestTemplate rest;


    public String createSMSRequest(String phoneNumber, int token){

        String mes = String.format("Təsdiq kodu: %d", token);
        String url = String.format(
                "http://api.msm.az/sendsms?user=%s&password=%s&gsm=%s&from=%s&text=%s","ibatechapi","YY5AU5Am",phoneNumber, "IBA Tech", mes);
        try{
            String respSms = rest.getForObject(url, String.class);
//            String errno = respSms.substring(6, 9);
//            String errtext = respSms.substring(18,20);
//            String
            System.err.println(respSms);
            return respSms;
        } catch (RuntimeException ex){
            throw new InvalidSMSRequestException();
        }


    }

    public int createSMSToken(){
        return new Random().ints(10000, 99999).findFirst().getAsInt();
    }




}
