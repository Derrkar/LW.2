package lab2;

import java.io.*;

public class SerializeTXT {
    public void serializer(Worker obj, File file) throws IOException {
        try(FileWriter fw = new FileWriter(file)){
            String str = "Surname = " + obj.getSurName() + ", Name = " + obj.getName() + ", Middlename = " + obj.getMiddleName() + ", PhoneNumber = " + obj.getPhoneNumber() + ", DateOfBirth = " + obj.getDateOfBirth();
            fw.write(str);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Worker deserializer(File file) throws IOException {
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            String[] fields = fr.readLine().split(", ");
            Worker.Builder a = new Worker.Builder();
            a.withSurname(fields[0].split(" ")[2]);
            a.withName(fields[1].split(" ")[2]);
            a.withMiddleName(fields[2].split(" ")[2]);
            a.withPhoneNumber(fields[3].split(" ")[2]);
            a.withDateOfBirth(fields[4].split(" ")[2]);
            return a.build();
        }
        catch (IOException e) {
            throw new RuntimeException("File is empty");
        }
    }
}
