package cn.com.tanan.boot.model;

public class Greeting {
  private final long id;

  /* Greeting contents. */
  private String content;

  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
