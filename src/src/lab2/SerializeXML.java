package lab2;

import com.fasterxml.jackson.dataformat.xml.*;

import java.io.File;
import java.io.IOException;

public class SerializeXML {
    XmlMapper mapper;

    public SerializeXML() {
        mapper = new XmlMapper();
    }

    public void serializer(Worker obj, File file) throws IOException {
        try {
            mapper.writeValue(file, obj);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Worker deserializer(File file) throws RuntimeException {
        try {
            return mapper.readValue(file, Worker.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
