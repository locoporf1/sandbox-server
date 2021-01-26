package com.locoporf1.sandbox.sandboxserver.controllers;

import com.locoporf1.sandbox.sandboxserver.model.Sandbox;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private ConcurrentHashMap<Integer, Sandbox> sandboxes = new ConcurrentHashMap<>();

  @PostMapping("/init")
  public Collection<Sandbox> init() {
    sandboxes.clear();
    IntStream.range(1, 7).forEach( i -> {
      sandboxes.put(i, new Sandbox("Sandbox " + i, ""));
    });
    return sandboxes.values();
  }

  @PutMapping("/request")
  public Sandbox request(@RequestParam Integer sandbox, @RequestParam String name) {
    Sandbox result = sandboxes.get(sandbox);
    if (result != null) {
      if ("".equals(result.getOwner())) {
        // New assignation
        result.setOwner(name);
      } else if (name.equals(result.getOwner())) {
        // Remove assignation
        result.setName("");
      }
    }
    return result;
  }

  @GetMapping("/list")
  public Collection<Sandbox> list() {
    return sandboxes.values();
  }

}
