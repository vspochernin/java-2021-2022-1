package lab2.exceptions;

import java.io.FileNotFoundException;

public class FileNotExistException extends FileNotFoundException {
    public FileNotExistException(String message) {
        super(message);
    }
}
