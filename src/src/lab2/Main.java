package lab2;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Worker worker1 = new Worker.Builder().withSurname("Grod").withName("Eugen").withMiddleName("Volodumurovich").withPhoneNumber("0991234567").withDateOfBirth("05.12.1997").build();
        Worker worker2 = new Worker.Builder().withSurname("Petrov").withName("Ivan").withMiddleName("Stepanovuch").withPhoneNumber("0998412032").withDateOfBirth("07.23.2001").build();
        Worker worker3 = new Worker.Builder().withSurname("Matsuk").withName("Olexandre").withMiddleName("Muhaulovuch").withPhoneNumber("0952495192").withDateOfBirth("02.21.2000").build();
        SerializeTXT srzTxt = new SerializeTXT();
        SerializeJSON srzJson = new SerializeJSON();
        SerializeXML srzXml = new SerializeXML();
        File fTxt = new File("worker.txt");
        File fJson = new File("worker.json");
        File fXml = new File("worker.xml");
        try {
            srzTxt.serializer(worker1, fTxt);
            srzJson.serializer(worker2, fJson);
            srzXml.serializer(worker3, fXml);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Worker animalTxt = new Worker();
        Worker animalJson = new Worker();
        Worker animalXml = new Worker();

        try {
            animalTxt = srzTxt.deserializer(fTxt);
            animalJson = srzJson.deserializer(fJson);
            animalXml = srzXml.deserializer(fXml);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(animalTxt);
        System.out.println(animalJson);
        System.out.println(animalXml);
    }
}
