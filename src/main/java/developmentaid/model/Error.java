package developmentaid.model;

import java.util.Objects;

public class Error {
    private int code;
    private String message;

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return code == error.code &&
                Objects.equals(message, error.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "code=" + code +
                ", message=" + message;
    }
}
