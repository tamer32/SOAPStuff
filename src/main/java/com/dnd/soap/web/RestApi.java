package com.dnd.soap.web;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dnd.soap.service.UserManagmentService;
import com.dnd.soap.service.entities.heroes.PlayerInfo;
import com.dnd.soap.service.entities.monsters.MonsterInfo;

@RestController
@RequestMapping
public class RestApi {
  @Autowired UserManagmentService userManagmentService;

  @GetMapping(value = "/rollTheDice/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> rollingStones(@PathVariable Long playerId)
      throws IOException, ServletException {
    return ResponseEntity.ok(userManagmentService.battleCalculator(playerId));
  }

  @GetMapping(value = "/newEncounter", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MonsterInfo> checkEncounter() {
    Random rand = new Random();
    int encounter = rand.nextInt(49) + 1;
    return ResponseEntity.ok(userManagmentService.monsterEncounter(encounter));
  }

  @PostMapping(value = "/loginUser", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PlayerInfo> login(@RequestParam String username) {

    return userManagmentService.login(username);
  }
}
