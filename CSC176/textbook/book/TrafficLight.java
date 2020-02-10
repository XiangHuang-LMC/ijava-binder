public enum TrafficLight {
  RED ("Please stop"), GREEN ("Please go"), 
  YELLOW ("Please caution");
  
  private String description;
  
  private TrafficLight(String description) {
    this.description = description;
  }
  
  public String getDescription() {
    return description;
  }
}
