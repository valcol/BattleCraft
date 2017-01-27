package battlecraft;

public enum Teams {
  RED ("RED"),
  BLUE ("BLUE"),
  GREY ("GREY"),
  GREEN ("GREEN");
   
  private String path = "";
   
  Teams(String path){
    this.path = path;
  }
   
  public String toString(){
    return path;
  }
}
