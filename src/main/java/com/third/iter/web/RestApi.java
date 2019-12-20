package com.third.iter.web;

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
import com.third.iter.service.UserManagmentService;
import com.third.iter.service.entities.heroes.PlayerInfo;
import com.third.iter.service.entities.monsters.MonsterInfo;

@RestController
@RequestMapping
public class RestApi {
  @Autowired UserManagmentService userManagmentService;

  @GetMapping(value = "/roll-the-dice/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> rollingStones(@PathVariable Long playerId)
      throws IOException, ServletException {
    return ResponseEntity.ok(userManagmentService.battleCalculator(playerId));
  }

  @GetMapping(value = "/new-encounter", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MonsterInfo> checkEncounter() {
    Random rand = new Random();
    int encounter = rand.nextInt(49) + 1;
    return ResponseEntity.ok(userManagmentService.monsterEncounter(encounter));
  }

  @PostMapping(value = "/login-user", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PlayerInfo> login(@RequestParam String username) {

    return userManagmentService.login(username);
  }
}
