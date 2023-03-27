package helper;

public class Response {
  public Object message;
  public boolean error;

  public Response(Object message, boolean error) {
    this.message = message;
    this.error = error;
  }
}
