package developmentaid.model;

import java.util.Objects;

public class ErrorResponse {
    private Error error;

    public ErrorResponse(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponse errorResponse = (ErrorResponse) o;
        return Objects.equals(error, errorResponse.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error);
    }

    @Override
    public String toString() {
        return "Error: " + error;
    }
}
