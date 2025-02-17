package com.dnd.soap.web;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dnd.soap.service.UserManagmentService;
import com.dnd.soap.service.bean.PlayerInfoBean;
import com.dnd.soap.service.entities.heroes.PlayerInfo;
import com.dnd.soap.service.entities.monsters.MonsterInfo;

@Controller
public class UserController {

  @Autowired UserManagmentService userManagmentService;

  @ModelAttribute("playerInfo")
  public PlayerInfo getPlayerInfo() {
    return new PlayerInfo();
  }

  @ModelAttribute("monster")
  public MonsterInfo getMonsterInfo() {
    return new MonsterInfo();
  }

  @RequestMapping("/")
  public String homePage(Model springModel) {
    return "homePage";
  }

  @PostMapping("/createUser")
  public String createUser(
      Model theModel,
      @ModelAttribute("playerInfoBean") PlayerInfoBean playerBean,
      @Valid PlayerInfoBean playerInfo,
      BindingResult br)
      throws ServletException, IOException {

    if (br.hasErrors()) {
      return "registerPage";
    }

    PlayerInfo player = userManagmentService.transformToPlayerInfo(playerBean);
    PlayerInfo newPlayer = userManagmentService.createUser(player);
    theModel.addAttribute("playerInfo", newPlayer);

    return "redirect:/userInfo/" + newPlayer.getId();
  }

  @GetMapping("/registerPage")
  public String redirectToRegister(Model model) {
    model.addAttribute("playerInfoBean", new PlayerInfoBean());

    return "registerPage";
  }

  @GetMapping("/loginPage")
  public String redirectToLogin() {

    return "loginPage";
  }

  @GetMapping("/userInfo/{playerId}")
  public String userPanel(Model theModel, @PathVariable long playerId) {
    theModel.addAttribute("playerInfo", userManagmentService.getPlayer(playerId));

    return "characterPage";
  }

  @GetMapping("/deletePage/{userId}")
  protected String deleteUser(@PathVariable long userId, Model model)
      throws ServletException, IOException {
    userManagmentService.deleteUser(userId);
    model.addAttribute("playerInfoBean", new PlayerInfoBean());
    return "redirect:/registerPage";
  }

  @GetMapping("/fightPage/{user}")
  public String fightMethod(Model model, @PathVariable long user)
      throws ServletException, IOException {
    Random rand = new Random();
    int encounter = rand.nextInt(49) + 1;

    model.addAttribute("playerInfo", userManagmentService.getPlayer(user));
    model.addAttribute("monster", userManagmentService.monsterEncounter(encounter));

    return "fightPage";
  }

  @GetMapping("/modifyPage/{userId}")
  public String goToModifyPage(Model model, @PathVariable long userId) {
    model.addAttribute("playerInfo", userManagmentService.getPlayer(userId));

    return "modifyPage";
  }

  @PostMapping("/modifyPage/{userId}")
  public String modifyName(
      @PathVariable long userId, @ModelAttribute("playerInfo") PlayerInfo player, Model model) {
    player = userManagmentService.modifyName(userId, player.getUsername());

    model.addAttribute("playerInfo", player);

    return "characterPage";
  }
}
