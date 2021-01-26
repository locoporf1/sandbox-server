package com.locoporf1.sandbox.sandboxserver.model;

public class Sandbox {

  private String name;
  private String owner;

  public Sandbox(String name, String owner) {
    this.name = name;
    this.owner = owner;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
}
